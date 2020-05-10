package com.microsoft.azure.sdk.iot.device.transport.https;

import com.microsoft.azure.sdk.iot.device.MessageProperty;
import java.util.Map;

public abstract interface HttpsMessage
{
  public static final String HTTPS_APP_PROPERTY_PREFIX = "iothub-app-";
  public static final String HTTPS_SYSTEM_PROPERTY_PREFIX = "iothub-";
  
  public abstract byte[] getBody();
  
  public abstract String getContentType();
  
  public abstract MessageProperty[] getProperties();
  
  public abstract Map<String, String> getSystemProperties();
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.https.HttpsMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */