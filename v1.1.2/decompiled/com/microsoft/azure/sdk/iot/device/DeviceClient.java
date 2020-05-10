package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.deps.serializer.ParserUtility;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.PropertyCallBack;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.TwinPropertyCallBack;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.fileupload.FileUpload;
import com.microsoft.azure.sdk.iot.device.transport.amqps.IoTHubConnectionType;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProvider;
import e.a.a.a.a;
import java.io.Closeable;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.SSLContext;
import l.f.b;
import l.f.c;

public final class DeviceClient
  extends InternalClient
  implements Closeable
{
  @Deprecated
  public static final Charset CONNECTION_STRING_CHARSET;
  @Deprecated
  public static final String DEVICE_ID_ATTRIBUTE = "DeviceId=";
  @Deprecated
  public static final String HOSTNAME_ATTRIBUTE = "HostName=";
  @Deprecated
  public static long RECEIVE_PERIOD_MILLIS_AMQPS = 0L;
  @Deprecated
  public static long RECEIVE_PERIOD_MILLIS_HTTPS = 1500000L;
  @Deprecated
  public static long RECEIVE_PERIOD_MILLIS_MQTT = 0L;
  @Deprecated
  public static long SEND_PERIOD_MILLIS = 0L;
  @Deprecated
  public static final String SHARED_ACCESS_KEY_ATTRIBUTE = "SharedAccessKey=";
  @Deprecated
  public static final String SHARED_ACCESS_TOKEN_ATTRIBUTE = "SharedAccessSignature=";
  public static final b log = c.a(DeviceClient.class);
  public long RECEIVE_PERIOD_MILLIS;
  public FileUpload fileUpload;
  public IoTHubConnectionType ioTHubConnectionType = IoTHubConnectionType.UNKNOWN;
  public TransportClient transportClient;
  
  static
  {
    CONNECTION_STRING_CHARSET = StandardCharsets.UTF_8;
    SEND_PERIOD_MILLIS = 10L;
    RECEIVE_PERIOD_MILLIS_AMQPS = 10L;
    RECEIVE_PERIOD_MILLIS_MQTT = 10L;
  }
  
  public DeviceClient()
  {
    transportClient = null;
  }
  
  public DeviceClient(String paramString, IotHubClientProtocol paramIotHubClientProtocol)
  {
    super(new IotHubConnectionString(paramString), paramIotHubClientProtocol, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
    commonConstructorVerifications();
    commonConstructorSetup();
  }
  
  public DeviceClient(String paramString1, IotHubClientProtocol paramIotHubClientProtocol, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2)
  {
    super(new IotHubConnectionString(paramString1), paramIotHubClientProtocol, paramString2, paramBoolean1, paramString3, paramBoolean2, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
    commonConstructorVerifications();
    commonConstructorSetup();
  }
  
  public DeviceClient(String paramString, IotHubClientProtocol paramIotHubClientProtocol, SSLContext paramSSLContext)
  {
    super(new IotHubConnectionString(paramString), paramIotHubClientProtocol, paramSSLContext, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
    commonConstructorVerifications();
    commonConstructorSetup();
  }
  
  public DeviceClient(String paramString, TransportClient paramTransportClient)
  {
    config = new DeviceClientConfig(new IotHubConnectionString(paramString));
    deviceIO = null;
    if (paramTransportClient != null)
    {
      ioTHubConnectionType = IoTHubConnectionType.USE_TRANSPORTCLIENT;
      transportClient = paramTransportClient;
      paramString = getConfig().getModuleId();
      if ((paramString != null) && (!paramString.isEmpty())) {
        throw new UnsupportedOperationException("Multiplexing with module connection strings is not supported");
      }
      getConfig().setProtocol(transportClient.getIotHubClientProtocol());
      transportClient.registerDeviceClient(this);
      return;
    }
    throw new IllegalArgumentException("Transport client cannot be null.");
  }
  
  public DeviceClient(String paramString1, String paramString2, SecurityProvider paramSecurityProvider, IotHubClientProtocol paramIotHubClientProtocol)
  {
    super(paramString1, paramString2, paramSecurityProvider, paramIotHubClientProtocol, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
    commonConstructorSetup();
  }
  
  private void commonConstructorSetup()
  {
    ioTHubConnectionType = IoTHubConnectionType.SINGLE_CLIENT;
    transportClient = null;
  }
  
  private void commonConstructorVerifications()
  {
    if ((getConfig().getModuleId() != null) && (!getConfig().getModuleId().isEmpty())) {
      throw new UnsupportedOperationException("DeviceClient connection string cannot contain module id. Use ModuleClient instead.");
    }
  }
  
  public static DeviceClient createFromSecurityProvider(String paramString1, String paramString2, SecurityProvider paramSecurityProvider, IotHubClientProtocol paramIotHubClientProtocol)
  {
    return new DeviceClient(paramString1, paramString2, paramSecurityProvider, paramIotHubClientProtocol);
  }
  
  public static long getReceivePeriod(IotHubClientProtocol paramIotHubClientProtocol)
  {
    int i = paramIotHubClientProtocol.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            break label46;
          }
          if (i != 4) {
            throw new IllegalStateException("Invalid client protocol specified.");
          }
        }
        return RECEIVE_PERIOD_MILLIS_MQTT;
      }
      label46:
      return RECEIVE_PERIOD_MILLIS_AMQPS;
    }
    return RECEIVE_PERIOD_MILLIS_HTTPS;
  }
  
  @Deprecated
  public void close()
  {
    if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT)
    {
      if (transportClient.getTransportClientState() != TransportClient.TransportClientState.OPENED) {
        log.b("Connection already closed by TransportClient.");
      } else {
        throw new IOException("Calling closeNow() when using TransportClient is not supported. Use TransportClient.closeNow() instead.");
      }
    }
    else
    {
      log.b("Closing device client...");
      super.close();
    }
    log.b("Device client closed successfully");
  }
  
  public void closeFileUpload()
  {
    FileUpload localFileUpload = fileUpload;
    if (localFileUpload != null) {
      localFileUpload.closeNow();
    }
  }
  
  public void closeNow()
  {
    if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT)
    {
      if (transportClient.getTransportClientState() != TransportClient.TransportClientState.OPENED) {
        log.b("Connection already closed by TransportClient.");
      } else {
        throw new IOException("Calling closeNow() when using TransportClient is not supported. Use TransportClient.closeNow() instead.");
      }
    }
    else
    {
      log.b("Closing device client...");
      super.closeNow();
      closeFileUpload();
    }
    log.b("Device client closed successfully");
  }
  
  public void getDeviceTwin()
  {
    getTwinInternal();
  }
  
  public void open()
  {
    if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT)
    {
      if (transportClient.getTransportClientState() != TransportClient.TransportClientState.CLOSED) {
        log.e("Connection already opened by TransportClient.");
      } else {
        throw new IOException("Calling open() when using the TransportClient is not supported. Use TransportClient.open() instead.");
      }
    }
    else {
      super.open();
    }
    log.b("Device client opened successfully");
  }
  
  @Deprecated
  public void registerConnectionStateCallback(IotHubConnectionStateCallback paramIotHubConnectionStateCallback, Object paramObject)
  {
    if (paramIotHubConnectionStateCallback != null)
    {
      deviceIO.registerConnectionStateCallback(paramIotHubConnectionStateCallback, paramObject);
      return;
    }
    throw new IllegalArgumentException("Callback object cannot be null");
  }
  
  public DeviceClient setMessageCallback(MessageCallback paramMessageCallback, Object paramObject)
  {
    setMessageCallbackInternal(paramMessageCallback, paramObject);
    return this;
  }
  
  public void setOption(String paramString, Object paramObject)
  {
    if (paramString != null)
    {
      if (paramObject != null)
      {
        int i = -1;
        switch (paramString.hashCode())
        {
        default: 
          break;
        case 1960673998: 
          if (paramString.equals("SetCertificateAuthority")) {
            i = 3;
          }
          break;
        case 1741746870: 
          if (paramString.equals("SetSASTokenExpiryTime")) {
            i = 4;
          }
          break;
        case 1380490682: 
          if (paramString.equals("SetCertificatePath")) {
            i = 2;
          }
          break;
        case -1112537444: 
          if (paramString.equals("SetMinimumPollingInterval")) {
            i = 0;
          }
          break;
        case -1761978929: 
          if (paramString.equals("SetSendInterval")) {
            i = 1;
          }
          break;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4)
                {
                  if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT)
                  {
                    if (transportClient.getTransportClientState() != TransportClient.TransportClientState.OPENED)
                    {
                      setOption_SetSASTokenExpiryTime(paramObject);
                      return;
                    }
                    throw new IllegalStateException("setOption SetSASTokenExpiryTime with TransportClient only works when the transport client is closed");
                  }
                  setOption_SetSASTokenExpiryTime(paramObject);
                  return;
                }
                throw new IllegalArgumentException(a.b("optionName is unknown = ", paramString));
              }
              if ((ioTHubConnectionType != IoTHubConnectionType.USE_TRANSPORTCLIENT) || (transportClient.getTransportClientState() != TransportClient.TransportClientState.OPENED)) {
                break label332;
              }
              throw new IllegalStateException("setOption SetCertificatePath only works when the transport is closed");
            }
          }
          else {
            if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT) {
              break label311;
            }
          }
          if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT)
          {
            if (transportClient.getTransportClientState() != TransportClient.TransportClientState.OPENED)
            {
              setOption_SetCertificatePath(paramObject);
              return;
            }
            throw new IllegalStateException("setOption SetCertificatePath only works when the transport is closed");
            label311:
            throw new IllegalStateException("Setting send interval is not supported for single client if using TransportClient. Use TransportClient.setSendInterval() instead.");
          }
        }
        else
        {
          if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT) {
            break label339;
          }
        }
        label332:
        super.setOption(paramString, paramObject);
        return;
        label339:
        throw new IllegalStateException("setOption SetMinimumPollingIntervalonly works with HTTP protocol");
      }
      throw new IllegalArgumentException("optionName is null");
    }
    throw new IllegalArgumentException("optionName is null");
  }
  
  public void setOption_SetSASTokenExpiryTime(Object paramObject)
  {
    log.e("Setting SASTokenExpiryTime as {} seconds", paramObject);
    if (getConfig().getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN)
    {
      if (paramObject != null) {
        if ((paramObject instanceof Long))
        {
          long l = ((Long)paramObject).longValue();
          getConfig().getSasTokenAuthentication().setTokenValidSecs(l);
          if ((getDeviceIO() != null) && (getDeviceIO().isOpen())) {
            try
            {
              if (!getConfig().getSasTokenAuthentication().canRefreshToken()) {
                break label177;
              }
              if (ioTHubConnectionType == IoTHubConnectionType.USE_TRANSPORTCLIENT)
              {
                transportClient.closeNow();
                transportClient.open();
              }
              else
              {
                getDeviceIO().close();
                getDeviceIO().open();
              }
            }
            catch (IOException paramObject)
            {
              throw new IOError((Throwable)paramObject);
            }
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("value is not long = ");
          localStringBuilder.append(paramObject);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      label177:
      return;
    }
    throw new IllegalStateException("Cannot set sas token validity time when not using sas token authentication");
  }
  
  public void startDeviceTwin(IotHubEventCallback paramIotHubEventCallback, Object paramObject1, PropertyCallBack paramPropertyCallBack, Object paramObject2)
  {
    startTwinInternal(paramIotHubEventCallback, paramObject1, paramPropertyCallBack, paramObject2);
  }
  
  public void startDeviceTwin(IotHubEventCallback paramIotHubEventCallback, Object paramObject1, TwinPropertyCallBack paramTwinPropertyCallBack, Object paramObject2)
  {
    startTwinInternal(paramIotHubEventCallback, paramObject1, paramTwinPropertyCallBack, paramObject2);
  }
  
  public void subscribeToDeviceMethod(DeviceMethodCallback paramDeviceMethodCallback, Object paramObject1, IotHubEventCallback paramIotHubEventCallback, Object paramObject2)
  {
    subscribeToMethodsInternal(paramDeviceMethodCallback, paramObject1, paramIotHubEventCallback, paramObject2);
  }
  
  public void uploadToBlobAsync(String paramString, InputStream paramInputStream, long paramLong, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    if (paramIotHubEventCallback != null)
    {
      if (paramInputStream != null)
      {
        if (paramLong >= 0L)
        {
          ParserUtility.validateBlobName(paramString);
          if (fileUpload == null) {
            fileUpload = new FileUpload(config);
          }
          fileUpload.uploadToBlobAsync(paramString, paramInputStream, paramLong, paramIotHubEventCallback, paramObject);
          return;
        }
        throw new IllegalArgumentException("Invalid stream size.");
      }
      throw new IllegalArgumentException("The input stream cannot be null.");
    }
    throw new IllegalArgumentException("Callback is null");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */