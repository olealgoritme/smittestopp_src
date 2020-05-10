package com.microsoft.identity.common.adal.internal.net;

import java.util.List;
import java.util.Map;

public class HttpWebResponse
{
  public final String mResponseBody;
  public final Map<String, List<String>> mResponseHeaders;
  public final int mStatusCode;
  
  public HttpWebResponse(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    mStatusCode = paramInt;
    mResponseBody = paramString;
    mResponseHeaders = paramMap;
  }
  
  public String getBody()
  {
    return mResponseBody;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    return mResponseHeaders;
  }
  
  public int getStatusCode()
  {
    return mStatusCode;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.net.HttpWebResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */