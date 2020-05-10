package com.microsoft.identity.common.internal.net;

import e.a.a.a.a;
import java.util.List;
import java.util.Map;

public final class HttpResponse
{
  public final String mResponseBody;
  public final Map<String, List<String>> mResponseHeaders;
  public final int mStatusCode;
  
  public HttpResponse(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    mStatusCode = paramInt;
    mResponseBody = paramString;
    mResponseHeaders = paramMap;
  }
  
  public String getBody()
  {
    return mResponseBody;
  }
  
  public Map<String, List<String>> getHeaders()
  {
    return mResponseHeaders;
  }
  
  public int getStatusCode()
  {
    return mStatusCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("HttpResponse{mStatusCode=");
    localStringBuilder.append(mStatusCode);
    localStringBuilder.append(", mResponseBody='");
    a.a(localStringBuilder, mResponseBody, '\'', ", mResponseHeaders=");
    localStringBuilder.append(mResponseHeaders);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.net.HttpResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */