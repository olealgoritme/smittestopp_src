package com.microsoft.azure.sdk.iot.device.net;

public final class IotHubEventUri
{
  public static final String EVENT_PATH = "/messages/events";
  public final IotHubUri uri;
  
  public IotHubEventUri()
  {
    uri = null;
  }
  
  public IotHubEventUri(String paramString1, String paramString2, String paramString3)
  {
    uri = new IotHubUri(paramString1, paramString2, "/messages/events", paramString3);
  }
  
  public String getHostname()
  {
    Object localObject = uri;
    if (localObject != null) {
      localObject = ((IotHubUri)localObject).getHostname();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getPath()
  {
    Object localObject = uri;
    if (localObject != null) {
      localObject = ((IotHubUri)localObject).getPath();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String toString()
  {
    Object localObject = uri;
    if (localObject != null) {
      localObject = ((IotHubUri)localObject).toString();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.net.IotHubEventUri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */