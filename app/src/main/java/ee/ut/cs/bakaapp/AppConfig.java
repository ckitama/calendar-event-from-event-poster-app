package ee.ut.cs.bakaapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import io.swagger.client.ApiClient;

public class AppConfig {

    private final ApiClient apiClient;

    public AppConfig(Context context) {
        String basePath = "";
        try {
            basePath = loadProperty("basePath", context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.apiClient = new ApiClient().setBasePath(basePath);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    private static String loadProperty(String key, Context context) throws IOException {
        Properties properties = new Properties();;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("config.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }

}
