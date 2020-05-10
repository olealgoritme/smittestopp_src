package com.microsoft.azure.sdk.iot.device.net;

public final class IotHubCompleteUri
{
  public static final String COMPLETE_PATH_FORMAT = "/messages/devicebound/%s";
  public final IotHubUri uri;
  
  public IotHubCompleteUri()
  {
    uri = null;
  }
  
  public IotHubCompleteUri(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    uri = new IotHubUri(paramString1, paramString2, String.format("/messages/devicebound/%s", new Object[] { paramString3 }), paramString4);
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
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.net.IotHubCompleteUri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */