package com.microsoft.appcenter.http;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse
{
  public final Map<String, String> headers;
  public final String payload;
  public final int statusCode;
  
  public HttpResponse(int paramInt)
  {
    this(paramInt, "");
  }
  
  public HttpResponse(int paramInt, String paramString)
  {
    this(paramInt, paramString, new HashMap());
  }
  
  public HttpResponse(int paramInt, String paramString, Map<String, String> paramMap)
  {
    payload = paramString;
    statusCode = paramInt;
    headers = paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (HttpResponse.class == paramObject.getClass()))
    {
      paramObject = (HttpResponse)paramObject;
      if ((statusCode != statusCode) || (!payload.equals(payload)) || (!headers.equals(headers))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Map<String, String> getHeaders()
  {
    return headers;
  }
  
  public String getPayload()
  {
    return payload;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public int hashCode()
  {
    int i = statusCode;
    int j = payload.hashCode();
    return headers.hashCode() + (j + i * 31) * 31;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.HttpResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */