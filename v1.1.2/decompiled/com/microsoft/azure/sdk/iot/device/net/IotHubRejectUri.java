package com.microsoft.azure.sdk.iot.device.net;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class IotHubRejectUri
{
  public static final String REJECT_PATH_FORMAT = "/messages/devicebound/%s";
  public static final Map<String, String> REJECT_QUERY_PARAM;
  public final IotHubUri uri;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("?reject", "true");
    REJECT_QUERY_PARAM = Collections.unmodifiableMap(localHashMap);
  }
  
  public IotHubRejectUri()
  {
    uri = null;
  }
  
  public IotHubRejectUri(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    uri = new IotHubUri(paramString1, paramString2, String.format("/messages/devicebound/%s", new Object[] { paramString3 }), REJECT_QUERY_PARAM, paramString4);
  }
  
  public String getHostname()
  {
    return uri.getHostname();
  }
  
  public String getPath()
  {
    return uri.getPath();
  }
  
  public String toString()
  {
    return uri.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.net.IotHubRejectUri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */