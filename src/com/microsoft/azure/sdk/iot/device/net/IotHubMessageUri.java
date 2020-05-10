package com.microsoft.azure.sdk.iot.device.net;

public final class IotHubMessageUri
{
  public static final String MESSAGE_PATH = "/messages/devicebound";
  public final IotHubUri uri;
  
  public IotHubMessageUri()
  {
    uri = null;
  }
  
  public IotHubMessageUri(String paramString1, String paramString2, String paramString3)
  {
    uri = new IotHubUri(paramString1, paramString2, "/messages/devicebound", paramString3);
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
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.net.IotHubMessageUri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */