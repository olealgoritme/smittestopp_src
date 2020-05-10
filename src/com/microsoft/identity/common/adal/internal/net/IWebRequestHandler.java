package com.microsoft.identity.common.adal.internal.net;

import java.net.URL;
import java.util.Map;
import java.util.UUID;

public abstract interface IWebRequestHandler
{
  public abstract HttpWebResponse sendGet(URL paramURL, Map<String, String> paramMap);
  
  public abstract HttpWebResponse sendPost(URL paramURL, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString);
  
  public abstract void setClientVersion(String paramString);
  
  public abstract void setRequestCorrelationId(UUID paramUUID);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.net.IWebRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */