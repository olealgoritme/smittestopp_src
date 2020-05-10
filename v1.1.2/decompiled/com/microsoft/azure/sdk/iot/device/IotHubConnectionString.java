package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.auth.IotHubSasToken;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import l.f.b;
import l.f.c;

public class IotHubConnectionString
{
  public static final Charset CONNECTION_STRING_CHARSET = StandardCharsets.UTF_8;
  public static final String DEVICE_ID_ATTRIBUTE = "DeviceId=";
  public static final String GATEWAY_HOST_NAME_ATTRIBUTE = "GatewayHostName=";
  public static final String HOSTNAME_ATTRIBUTE = "HostName=";
  public static final String MODULE_ID_ATTRIBUTE = "ModuleId=";
  public static final String SHARED_ACCESS_KEY_ATTRIBUTE = "SharedAccessKey=";
  public static final String SHARED_ACCESS_TOKEN_ATTRIBUTE = "SharedAccessSignature=";
  public static final String X509_ENABLED_ATTRIBUTE = "x509=true";
  public static final b log = c.a(IotHubConnectionString.class);
  public String deviceId = null;
  public String gatewayHostName;
  public String hostName = null;
  public String hubName = null;
  public boolean isUsingX509;
  public String moduleId = null;
  public String sharedAccessKey = null;
  public String sharedAccessToken = null;
  
  public IotHubConnectionString(String paramString)
  {
    int i = 0;
    isUsingX509 = false;
    gatewayHostName = null;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String[] arrayOfString = paramString.split(";");
      int j = arrayOfString.length;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str.toLowerCase().startsWith("HostName=".toLowerCase()))
        {
          hostName = str.substring(9);
        }
        else if (str.toLowerCase().startsWith("DeviceId=".toLowerCase()))
        {
          str = str.substring(9);
          try
          {
            deviceId = URLDecoder.decode(str, CONNECTION_STRING_CHARSET.name());
          }
          catch (UnsupportedEncodingException paramString)
          {
            throw new IllegalStateException(paramString);
          }
        }
        else if (str.toLowerCase().startsWith("SharedAccessKey=".toLowerCase()))
        {
          sharedAccessKey = str.substring(16);
        }
        else if (str.toLowerCase().startsWith("SharedAccessSignature=".toLowerCase()))
        {
          str = str.substring(22);
          sharedAccessToken = str;
          if (IotHubSasToken.isExpired(str)) {
            throw new SecurityException("Your SAS Token has expired");
          }
        }
        else if (str.toLowerCase().startsWith("ModuleId=".toLowerCase()))
        {
          moduleId = str.substring(9);
        }
        else if (str.toLowerCase().startsWith("GatewayHostName=".toLowerCase()))
        {
          gatewayHostName = str.substring(16);
        }
        i++;
      }
      boolean bool = paramString.contains("x509=true");
      isUsingX509 = bool;
      validateTerms(hostName, deviceId, sharedAccessKey, sharedAccessToken, bool);
      hubName = parseHubName(hostName);
      return;
    }
    throw new IllegalArgumentException("The connection string cannot be null or empty.");
  }
  
  public IotHubConnectionString(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramString4, null);
  }
  
  public IotHubConnectionString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool1 = false;
    isUsingX509 = false;
    gatewayHostName = null;
    boolean bool2 = bool1;
    if (paramString3 == null)
    {
      bool2 = bool1;
      if (paramString4 == null) {
        bool2 = true;
      }
    }
    isUsingX509 = bool2;
    validateTerms(paramString1, paramString2, paramString3, paramString4, bool2);
    hostName = paramString1;
    hubName = parseHubName(paramString1);
    deviceId = paramString2;
    sharedAccessKey = paramString3;
    sharedAccessToken = paramString4;
    if ((paramString4 != null) && (IotHubSasToken.isExpired(paramString4))) {
      throw new SecurityException("Your SAS Token has expired");
    }
    gatewayHostName = paramString5;
    if ((paramString5 != null) && (!paramString5.isEmpty())) {
      hostName = paramString5;
    }
  }
  
  public static String parseHubName(String paramString)
  {
    int i = paramString.indexOf(".");
    if (i != -1) {
      return paramString.substring(0, i);
    }
    throw new IllegalArgumentException(String.format("Provided hostname did not include a valid IoT Hub name as its prefix. An IoT Hub hostname has the following format: [iotHubName].[valid URI chars]", new Object[0]));
  }
  
  public static void validateTerms(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      new URI(paramString1);
      parseHubName(paramString1);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if ((paramString3 != null) && (paramString4 != null)) {
          throw new IllegalArgumentException("Either of device key or Shared Access Signature should be provided, but not both.");
        }
        if ((!paramBoolean) && ((paramString3 == null) || (paramString3.isEmpty())) && ((paramString4 == null) || (paramString4.isEmpty()))) {
          throw new IllegalArgumentException("Device key and Shared Access Signature both cannot be null unless using x509 authentication.");
        }
        return;
      }
      throw new IllegalArgumentException("Device ID cannot be null.");
    }
    throw new IllegalArgumentException("IoT Hub hostName cannot be null.");
  }
  
  public String getDeviceId()
  {
    return deviceId;
  }
  
  public String getGatewayHostName()
  {
    return gatewayHostName;
  }
  
  public String getHostName()
  {
    return hostName;
  }
  
  public String getHubName()
  {
    return hubName;
  }
  
  public String getModuleId()
  {
    return moduleId;
  }
  
  public String getSharedAccessKey()
  {
    return sharedAccessKey;
  }
  
  public String getSharedAccessToken()
  {
    return sharedAccessToken;
  }
  
  public boolean isUsingX509()
  {
    return isUsingX509;
  }
  
  public void setSharedAccessToken(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      sharedAccessToken = paramString;
      return;
    }
    throw new IllegalArgumentException("Shared access token cannot be set to null or empty");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.IotHubConnectionString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */