package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException.IotHubService;
import e.a.a.a.a;

public class TransportUtils
{
  public static final String CLIENT_VERSION = "1.20.2";
  public static String IOTHUB_API_VERSION = "2018-06-30";
  public static final String JAVA_DEVICE_CLIENT_IDENTIFIER = "com.microsoft.azure.sdk.iot.iot-device-client";
  public static String JAVA_RUNTIME = System.getProperty("java.version");
  public static String OPERATING_SYSTEM;
  public static String PROCESSOR_ARCHITECTURE;
  public static final String USER_AGENT_STRING;
  
  static
  {
    if (System.getProperty("java.runtime.name").toLowerCase().contains("android")) {
      localObject = "Android";
    } else {
      localObject = System.getProperty("os.name");
    }
    OPERATING_SYSTEM = (String)localObject;
    PROCESSOR_ARCHITECTURE = System.getProperty("os.arch");
    Object localObject = a.a("com.microsoft.azure.sdk.iot.iot-device-client/1.20.2 (");
    ((StringBuilder)localObject).append(JAVA_RUNTIME);
    ((StringBuilder)localObject).append("; ");
    ((StringBuilder)localObject).append(OPERATING_SYSTEM);
    ((StringBuilder)localObject).append("; ");
    USER_AGENT_STRING = a.a((StringBuilder)localObject, PROCESSOR_ARCHITECTURE, ")");
  }
  
  public static void throwTransportExceptionWithIotHubServiceType(Exception paramException, TransportException.IotHubService paramIotHubService)
  {
    paramException = new TransportException(paramException);
    paramException.setIotHubService(paramIotHubService);
    throw paramException;
  }
  
  public static void throwTransportExceptionWithIotHubServiceType(String paramString, TransportException.IotHubService paramIotHubService)
  {
    paramString = new TransportException(paramString);
    paramString.setIotHubService(paramIotHubService);
    throw paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.TransportUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */