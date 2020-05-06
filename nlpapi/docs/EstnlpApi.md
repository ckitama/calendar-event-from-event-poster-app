# EstnlpApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**estNer**](EstnlpApi.md#estNer) | **POST** /estnlp/ner | Helps with named entity recognition using estnltk. Extended to also include temporal info.

<a name="estNer"></a>
# **estNer**
> EstNerResultDto estNer(body)

Helps with named entity recognition using estnltk. Extended to also include temporal info.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EstnlpApi;


EstnlpApi apiInstance = new EstnlpApi();
List<String> body = Arrays.asList("body_example"); // List<String> | Input text in Estonian
try {
    EstNerResultDto result = apiInstance.estNer(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EstnlpApi#estNer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;String&gt;**](String.md)| Input text in Estonian |

### Return type

[**EstNerResultDto**](EstNerResultDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

