# AutonlpApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autoNer**](AutonlpApi.md#autoNer) | **POST** /autonlp/ner | Convenience endpoint that delegates work to either estnlp or genericnlp tools based on input language.

<a name="autoNer"></a>
# **autoNer**
> AutoNerResultDto autoNer(body)

Convenience endpoint that delegates work to either estnlp or genericnlp tools based on input language.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AutonlpApi;


AutonlpApi apiInstance = new AutonlpApi();
List<String> body = Arrays.asList("body_example"); // List<String> | Input text in any language
try {
    AutoNerResultDto result = apiInstance.autoNer(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AutonlpApi#autoNer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;String&gt;**](String.md)| Input text in any language |

### Return type

[**AutoNerResultDto**](AutoNerResultDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

