# GenericnlpApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**genericNer**](GenericnlpApi.md#genericNer) | **POST** /genericnlp/ner | Helps with named entity recognition using spaCy. Additionaly uses TextBlob to detect input text&#x27;s language and translate it to English if necessary (as spaCy works best in English).

<a name="genericNer"></a>
# **genericNer**
> GenericNerResultDto genericNer(body)

Helps with named entity recognition using spaCy. Additionaly uses TextBlob to detect input text&#x27;s language and translate it to English if necessary (as spaCy works best in English).

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GenericnlpApi;


GenericnlpApi apiInstance = new GenericnlpApi();
List<String> body = Arrays.asList("body_example"); // List<String> | Input text in any language
try {
    GenericNerResultDto result = apiInstance.genericNer(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GenericnlpApi#genericNer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;String&gt;**](String.md)| Input text in any language |

### Return type

[**GenericNerResultDto**](GenericNerResultDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

