package com.android.volley.toolbox;

import com.android.volley.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

@Deprecated
public class HttpClientStack
  implements HttpStack
{
  public static final String HEADER_CONTENT_TYPE = "Content-Type";
  public final HttpClient mClient;
  
  public HttpClientStack(HttpClient paramHttpClient)
  {
    mClient = paramHttpClient;
  }
  
  public static HttpUriRequest createHttpRequest(Request<?> paramRequest, Map<String, String> paramMap)
  {
    switch (paramRequest.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case 7: 
      paramMap = new HttpClientStack.HttpPatch(paramRequest.getUrl());
      paramMap.addHeader("Content-Type", paramRequest.getBodyContentType());
      setEntityIfNonEmptyBody(paramMap, paramRequest);
      return paramMap;
    case 6: 
      return new HttpTrace(paramRequest.getUrl());
    case 5: 
      return new HttpOptions(paramRequest.getUrl());
    case 4: 
      return new HttpHead(paramRequest.getUrl());
    case 3: 
      return new HttpDelete(paramRequest.getUrl());
    case 2: 
      paramMap = new HttpPut(paramRequest.getUrl());
      paramMap.addHeader("Content-Type", paramRequest.getBodyContentType());
      setEntityIfNonEmptyBody(paramMap, paramRequest);
      return paramMap;
    case 1: 
      paramMap = new HttpPost(paramRequest.getUrl());
      paramMap.addHeader("Content-Type", paramRequest.getBodyContentType());
      setEntityIfNonEmptyBody(paramMap, paramRequest);
      return paramMap;
    case 0: 
      return new HttpGet(paramRequest.getUrl());
    }
    paramMap = paramRequest.getPostBody();
    if (paramMap != null)
    {
      HttpPost localHttpPost = new HttpPost(paramRequest.getUrl());
      localHttpPost.addHeader("Content-Type", paramRequest.getPostBodyContentType());
      localHttpPost.setEntity(new ByteArrayEntity(paramMap));
      return localHttpPost;
    }
    return new HttpGet(paramRequest.getUrl());
  }
  
  public static List<NameValuePair> getPostParameterPairs(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramMap.get(str)));
    }
    return localArrayList;
  }
  
  public static void setEntityIfNonEmptyBody(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, Request<?> paramRequest)
  {
    paramRequest = paramRequest.getBody();
    if (paramRequest != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(paramRequest));
    }
  }
  
  public static void setHeaders(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  public void onPrepareRequest(HttpUriRequest paramHttpUriRequest) {}
  
  public HttpResponse performRequest(Request<?> paramRequest, Map<String, String> paramMap)
  {
    HttpUriRequest localHttpUriRequest = createHttpRequest(paramRequest, paramMap);
    setHeaders(localHttpUriRequest, paramMap);
    setHeaders(localHttpUriRequest, paramRequest.getHeaders());
    onPrepareRequest(localHttpUriRequest);
    paramMap = localHttpUriRequest.getParams();
    int i = paramRequest.getTimeoutMs();
    HttpConnectionParams.setConnectionTimeout(paramMap, 5000);
    HttpConnectionParams.setSoTimeout(paramMap, i);
    return mClient.execute(localHttpUriRequest);
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.HttpClientStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */