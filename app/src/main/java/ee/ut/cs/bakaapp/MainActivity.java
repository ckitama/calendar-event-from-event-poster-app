package ee.ut.cs.bakaapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.tooltip.Tooltip;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.swagger.client.ApiException;
import io.swagger.client.api.AutonlpApi;
import io.swagger.client.model.AutoNerResultDto;


/*
Camera and Text Recognition API integration inspired by the following tutorial
https://github.com/komamitsu/Android-OCRSample
 */
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_GALLERY = 0;
    private static final int REQUEST_CAMERA = 1;
    private static final int MY_PERMISSIONS_REQUESTS = 0;

    private static final String TAG = MainActivity.class.getSimpleName();

    private boolean gotPermissions = false;
    private boolean isLoading = false;

    private AppConfig appConfig;
    private Uri imageUri;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appConfig = new AppConfig(getApplicationContext());
        this.progressBar = findViewById(R.id.progressBar);

        requestPermissions();

        findViewById(R.id.choose_from_gallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLoading) {
                    Toast.makeText(getApplicationContext(),"Still loading...", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_GALLERY);
            }
        });

        findViewById(R.id.take_a_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLoading) {
                    Toast.makeText(getApplicationContext(),"Still loading...", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!gotPermissions) {
                    requestPermissions();
                    return;
                }

                String filename = System.currentTimeMillis() + ".jpg";

                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, filename);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        });

        View mainView = getWindow().findViewById(R.id.activity_main);
        ImageButton infoButton = findViewById(R.id.info_button);
        mainView.post(new Runnable() {
            @Override
            public void run() {
                Tooltip tooltip = getInfoTooltip();
                infoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tooltip.isShowing()) {
                            tooltip.dismiss();
                        } else {
                            tooltip.show();
                        }
                    }
                });
            }

            private Tooltip getInfoTooltip() {
                return new Tooltip.Builder(infoButton)
                        .setText("This app uses OCR to automatically detect " +
                                "all the relevant information from an EVENT POSTER " +
                                "and then helps you add it to the calendar.\n" +
                                "-> Just snap a photo or choose one from your gallery!")
                        .setBackgroundColor(Color.parseColor("#e6bd559c"))
                        .setTextColor(Color.WHITE)
                        .setGravity(Gravity.START)
                        .setMargin(15L)
                        .setPadding(35)
                        .setMaxWidth(mainView.getWidth() - infoButton.getWidth() * 4)
                        .setCornerRadius(20L)
                        .setCancelable(true)
                        .setTextSize(16L)
                        .build();
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUESTS) {
            if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                new AlertDialog.Builder(this)
                        .setTitle("Permissions not granted")
                        .setMessage("These permissions are needed for the app to work properly")
                        .setCancelable(false)
                        .setPositiveButton("Give permissions", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                requestPermissions();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            } else {
                gotPermissions = true;
            }
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("Requesting necessary permissions failed")
                    .show();
        }
    }

    private void requestPermissions() {
        List<String> requiredPermissions = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requiredPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requiredPermissions.add(Manifest.permission.CAMERA);
        }

        if (!requiredPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    requiredPermissions.toArray(new String[]{}),
                    MY_PERMISSIONS_REQUESTS);
        } else {
            gotPermissions = true;
        }
    }

    private void inspectFromBitmap(Bitmap bitmap) {
        switchToLoadingUI(true);

        TextRecognizer textRecognizer = new TextRecognizer.Builder(this).build();
        try {
            if (!textRecognizer.isOperational()) {
                switchToLoadingUI(false);
                new AlertDialog.Builder(this)
                        .setTitle("System error")
                        .setMessage("OCR engine could not be set up on your device. Trying again...")
                        .show();
                return;
            }

            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> origTextBlocks = textRecognizer.detect(frame);
            List<TextBlock> textBlocks = new ArrayList<>();
            for (int i = 0; i < origTextBlocks.size(); i++) {
                TextBlock textBlock = origTextBlocks.valueAt(i);
                textBlocks.add(textBlock);
            }
            Collections.sort(textBlocks, new Comparator<TextBlock>() {
                @Override
                public int compare(TextBlock o1, TextBlock o2) {
                    int diffOfTops = o1.getBoundingBox().top - o2.getBoundingBox().top;
                    int diffOfLefts = o1.getBoundingBox().left - o2.getBoundingBox().left;
                    if (diffOfTops != 0) {
                        return diffOfTops;
                    }
                    return diffOfLefts;
                }
            });

            String biggestText = "";
            int biggest = 0;
            StringBuilder detectedText = new StringBuilder();
            for (TextBlock textBlock : textBlocks) {
                if (textBlock != null && textBlock.getValue() != null) {
                    detectedText.append(textBlock.getValue());
                    detectedText.append("\n");

                    Point[] cornerPoints = textBlock.getCornerPoints();
                    int difference = cornerPoints[3].y - cornerPoints[0].y;
                    if (difference > biggest) {
                        biggestText = textBlock.getValue();
                        biggest = difference;
                    } else if (difference >= biggest - 20) {
                        biggestText += textBlock.getValue();
                    }
                }
            }
            biggestText = biggestText.replace("\n", " ");
            System.out.println("biggestText: " + biggestText);

            String cleanInputForApiCall = cleanInputForApiCall(detectedText.toString());

            AccessAutonlpApiTask task = new AccessAutonlpApiTask();
            task.execute(cleanInputForApiCall, biggestText);

        } catch (Exception e) {
            switchToLoadingUI(false);
            new AlertDialog.Builder(this)
                    .setTitle("System error")
                    .setMessage("An unexpected error has occured: " + e.getMessage())
                    .show();
        } finally {
            textRecognizer.release();
        }
    }

    private void switchToLoadingUI(boolean startLoading) {
        if (startLoading) {
            progressBar.setVisibility(View.VISIBLE);
            isLoading = true;
        } else {
            progressBar.setVisibility(View.GONE);
            isLoading = false;
        }
    }

    private void inspect(Uri uri) {
        InputStream is = null;
        Bitmap bitmap = null;
        try {
            is = getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inSampleSize = 2;
            options.inScreenDensity = DisplayMetrics.DENSITY_LOW;
            bitmap = BitmapFactory.decodeStream(is, null, options);
            inspectFromBitmap(bitmap);
        } catch (FileNotFoundException e) {
            Log.w(TAG, "Failed to find the file: " + uri, e);
        } finally {
            if (bitmap != null) {
                bitmap.recycle();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.w(TAG, "Failed to close InputStream", e);
                }
            }
        }
    }

    private String cleanInputForApiCall(String detectedText) {
        String[] splitted = detectedText.replace('\n', ' ').replace('/', '.').split(" ");
        for (int i = 0; i < splitted.length; i++) {
            String word = splitted[i];
            boolean hasUppercase = !word.equals(word.toLowerCase());
            boolean hasLowercase = !word.equals(word.toUpperCase());
            if (hasUppercase && hasLowercase) {
                splitted[i] = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            } else {
                splitted[i] = word.toLowerCase();
            }
        }
        return TextUtils.join(" ", splitted);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_GALLERY:
                if (resultCode == RESULT_OK) {
                    inspect(data.getData());
                }
                break;
            case REQUEST_CAMERA:
                if (resultCode == RESULT_OK) {
                    if (imageUri != null) {
                        inspect(imageUri);
                    }
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    private class AccessAutonlpApiTask extends AsyncTask<String, Void, AutoNerResultDto> {
        @Override
        protected AutoNerResultDto doInBackground(String... detectedTexts) {
            AutonlpApi autonlpApi = new AutonlpApi(appConfig.getApiClient());
            AutoNerResultDto autoNerResultDto;
            try {
                System.out.println("detected text: " + detectedTexts[0]);
                autoNerResultDto = autonlpApi.autoNer(Collections.singletonList(detectedTexts[0]));
                autoNerResultDto.setPer(Collections.singletonList(detectedTexts[1]));
            } catch (ApiException e) {
                autoNerResultDto = new AutoNerResultDto();
            }
            autoNerResultDto.setPer(Collections.singletonList(detectedTexts[1]));
            return autoNerResultDto;
        }

        @Override
        protected void onPostExecute(AutoNerResultDto result) {
            System.out.println(result);
            switchToLoadingUI(false);

            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setData(CalendarContract.Events.CONTENT_URI);

            String title = getTitle(result);
            String location = getLocation(result);
            long beginTimeInMillis = getBeginTimeInMillis(result, intent);
            long endTimeInMillis = getEndTimeInMillis(result, intent);

            intent.putExtra(CalendarContract.Events.TITLE, title);
            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTimeInMillis);
            intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTimeInMillis);
            intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location);
            startActivity(intent);
        }

        private long getBeginTimeInMillis(AutoNerResultDto result, Intent intent) {
            String beginTime = result.getStart() == null ? "" : result.getStart();
            return getTimeInMillis(intent, beginTime);
        }

        private long getEndTimeInMillis(AutoNerResultDto result, Intent intent) {
            String endTime = result.getEnd() == null ? "" : result.getEnd();
            return getTimeInMillis(intent, endTime);
        }

        private String getLocation(AutoNerResultDto result) {
            String location = "";
            if (result.getOrg() != null) {
                location += result.getOrg().get(0);
            }
            if (result.getLoc() != null) {
                location += result.getLoc().get(0);
            }
            return location;
        }

        private String getTitle(AutoNerResultDto result) {
            return result.getPer() == null ? "" : result.getPer().get(0);
        }

    }

    private long getTimeInMillis(Intent intent, String time) {
        long beginTimeInMillis;
        try {
            LocalDate localDate = LocalDate.parse(time);
            Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
            beginTimeInMillis = instant.toEpochMilli() + 1;
            intent.putExtra(CalendarContract.Events.ALL_DAY, true);
        } catch (Exception e) {
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(time);
                Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
                beginTimeInMillis = instant.toEpochMilli();
            } catch (Exception e1) {
                Instant instant = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
                beginTimeInMillis = instant.toEpochMilli();
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
            }
        }
        return beginTimeInMillis;
    }

}
