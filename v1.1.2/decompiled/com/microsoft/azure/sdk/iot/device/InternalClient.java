package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethod;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceTwin;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.Pair;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.Property;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.PropertyCallBack;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.TwinPropertyCallBack;
import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.transport.RetryPolicy;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProvider;
import e.a.a.a.a;
import java.io.IOError;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLContext;
import l.f.b;
import l.f.c;

public class InternalClient
{
  public static final String SET_CERTIFICATE_AUTHORITY = "SetCertificateAuthority";
  public static final String SET_CERTIFICATE_PATH = "SetCertificatePath";
  public static final String SET_MINIMUM_POLLING_INTERVAL = "SetMinimumPollingInterval";
  public static final String SET_SAS_TOKEN_EXPIRY_TIME = "SetSASTokenExpiryTime";
  public static final String SET_SEND_INTERVAL = "SetSendInterval";
  public static final b log = c.a(InternalClient.class);
  public DeviceClientConfig config;
  public DeviceIO deviceIO;
  public DeviceMethod method;
  public DeviceTwin twin;
  
  public InternalClient()
  {
    config = null;
    deviceIO = null;
  }
  
  public InternalClient(IotHubConnectionString paramIotHubConnectionString, IotHubClientProtocol paramIotHubClientProtocol, long paramLong1, long paramLong2)
  {
    commonConstructorVerification(paramIotHubConnectionString, paramIotHubClientProtocol);
    paramIotHubConnectionString = new DeviceClientConfig(paramIotHubConnectionString);
    config = paramIotHubConnectionString;
    paramIotHubConnectionString.setProtocol(paramIotHubClientProtocol);
    deviceIO = new DeviceIO(config, paramLong1, paramLong2);
  }
  
  public InternalClient(IotHubConnectionString paramIotHubConnectionString, IotHubClientProtocol paramIotHubClientProtocol, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    commonConstructorVerification(paramIotHubConnectionString, paramIotHubClientProtocol);
    paramIotHubConnectionString = new DeviceClientConfig(paramIotHubConnectionString, paramString1, paramBoolean1, paramString2, paramBoolean2);
    config = paramIotHubConnectionString;
    paramIotHubConnectionString.setProtocol(paramIotHubClientProtocol);
    deviceIO = new DeviceIO(config, paramLong1, paramLong2);
  }
  
  public InternalClient(IotHubConnectionString paramIotHubConnectionString, IotHubClientProtocol paramIotHubClientProtocol, SSLContext paramSSLContext, long paramLong1, long paramLong2)
  {
    commonConstructorVerification(paramIotHubConnectionString, paramIotHubClientProtocol);
    paramIotHubConnectionString = new DeviceClientConfig(paramIotHubConnectionString, paramSSLContext);
    config = paramIotHubConnectionString;
    paramIotHubConnectionString.setProtocol(paramIotHubClientProtocol);
    deviceIO = new DeviceIO(config, paramLong1, paramLong2);
  }
  
  public InternalClient(IotHubAuthenticationProvider paramIotHubAuthenticationProvider, IotHubClientProtocol paramIotHubClientProtocol, long paramLong1, long paramLong2)
  {
    paramIotHubAuthenticationProvider = new DeviceClientConfig(paramIotHubAuthenticationProvider);
    config = paramIotHubAuthenticationProvider;
    paramIotHubAuthenticationProvider.setProtocol(paramIotHubClientProtocol);
    deviceIO = new DeviceIO(config, paramLong1, paramLong2);
  }
  
  public InternalClient(String paramString1, String paramString2, SecurityProvider paramSecurityProvider, IotHubClientProtocol paramIotHubClientProtocol, long paramLong1, long paramLong2)
  {
    if (paramIotHubClientProtocol != null)
    {
      if (paramSecurityProvider != null)
      {
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if ((paramString2 != null) && (!paramString2.isEmpty()))
          {
            paramString1 = new DeviceClientConfig(new IotHubConnectionString(paramString1, paramString2, null, null), paramSecurityProvider);
            config = paramString1;
            paramString1.setProtocol(paramIotHubClientProtocol);
            deviceIO = new DeviceIO(config, paramLong1, paramLong2);
            return;
          }
          throw new IllegalArgumentException("deviceId cannot be null or empty");
        }
        throw new IllegalArgumentException("URI cannot be null or empty");
      }
      throw new IllegalArgumentException("securityProvider cannot be null");
    }
    throw new IllegalArgumentException("The transport protocol cannot be null");
  }
  
  private void commonConstructorVerification(IotHubConnectionString paramIotHubConnectionString, IotHubClientProtocol paramIotHubClientProtocol)
  {
    if (paramIotHubConnectionString != null)
    {
      if (paramIotHubClientProtocol != null)
      {
        paramIotHubConnectionString = paramIotHubConnectionString.getGatewayHostName();
        if ((paramIotHubConnectionString != null) && (!paramIotHubConnectionString.isEmpty()) && (paramIotHubClientProtocol == IotHubClientProtocol.HTTPS)) {
          throw new UnsupportedOperationException("Communication with edgehub only supported by MQTT/MQTT_WS and AMQPS/AMQPS_WS");
        }
        return;
      }
      throw new IllegalArgumentException("Protocol cannot be null.");
    }
    throw new IllegalArgumentException("Connection string cannot be null");
  }
  
  public void close()
  {
    while (!deviceIO.isEmpty()) {}
    deviceIO.close();
  }
  
  public void closeNow()
  {
    deviceIO.close();
  }
  
  public DeviceClientConfig getConfig()
  {
    return config;
  }
  
  public DeviceIO getDeviceIO()
  {
    return deviceIO;
  }
  
  public ProductInfo getProductInfo()
  {
    return config.getProductInfo();
  }
  
  public void getTwinInternal()
  {
    if (twin != null)
    {
      if (deviceIO.isOpen())
      {
        twin.getDeviceTwin();
        return;
      }
      throw new IOException("Open the client connection before using it.");
    }
    throw new IOException("Start twin before using it");
  }
  
  public void open()
  {
    if ((config.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN) && (config.getSasTokenAuthentication().isRenewalNecessary())) {
      throw new SecurityException("Your SasToken is expired");
    }
    deviceIO.open();
  }
  
  public void registerConnectionStatusChangeCallback(IotHubConnectionStatusChangeCallback paramIotHubConnectionStatusChangeCallback, Object paramObject)
  {
    deviceIO.registerConnectionStatusChangeCallback(paramIotHubConnectionStatusChangeCallback, paramObject);
  }
  
  public void sendEventAsync(Message paramMessage, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    paramMessage.setConnectionDeviceId(config.getDeviceId());
    deviceIO.sendEventAsync(paramMessage, paramIotHubEventCallback, paramObject, config.getDeviceId());
  }
  
  public void sendReportedProperties(Set<Property> paramSet)
  {
    if (twin != null)
    {
      if (deviceIO.isOpen())
      {
        if ((paramSet != null) && (!paramSet.isEmpty()))
        {
          twin.updateReportedProperties(paramSet);
          return;
        }
        throw new IllegalArgumentException("Reported properties set cannot be null or empty.");
      }
      throw new IOException("Open the client connection before using it.");
    }
    throw new IOException("Start twin before using it");
  }
  
  public void sendReportedProperties(Set<Property> paramSet, int paramInt)
  {
    if (twin != null)
    {
      if (deviceIO.isOpen())
      {
        if ((paramSet != null) && (!paramSet.isEmpty()))
        {
          if (paramInt >= 0)
          {
            twin.updateReportedProperties(paramSet, Integer.valueOf(paramInt));
            return;
          }
          throw new IllegalArgumentException("Version cannot be null.");
        }
        throw new IllegalArgumentException("Reported properties set cannot be null or empty.");
      }
      throw new IOException("Open the client connection before using it.");
    }
    throw new IOException("Start twin before using it");
  }
  
  public void setDeviceIO(DeviceIO paramDeviceIO)
  {
    deviceIO = paramDeviceIO;
  }
  
  public void setMessageCallbackInternal(MessageCallback paramMessageCallback, Object paramObject)
  {
    if ((paramMessageCallback == null) && (paramObject != null)) {
      throw new IllegalArgumentException("Cannot give non-null context for a null callback.");
    }
    config.setMessageCallback(paramMessageCallback, paramObject);
  }
  
  public void setOperationTimeout(long paramLong)
  {
    config.setOperationTimeout(paramLong);
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
                if (i == 4) {
                  setOption_SetSASTokenExpiryTime(paramObject);
                } else {
                  throw new IllegalArgumentException(a.b("optionName is unknown = ", paramString));
                }
              }
              else
              {
                paramString = deviceIO;
                if ((paramString != null) && (paramString.isOpen())) {
                  throw new IllegalStateException("setOption SetCertificatePath only works when the transport is closed");
                }
                setTrustedCertificates((String)paramObject);
              }
            }
            else
            {
              paramString = deviceIO;
              if ((paramString != null) && (paramString.isOpen())) {
                throw new IllegalStateException("setOption SetCertificatePath only works when the transport is closed");
              }
              if (deviceIO.getProtocol() != IotHubClientProtocol.HTTPS) {
                setOption_SetCertificatePath(paramObject);
              } else {
                throw new IllegalArgumentException("option SetCertificatePath cannot be invoked when using HTTPS protocol");
              }
            }
          }
          else {
            setOption_SetSendInterval(paramObject);
          }
        }
        else
        {
          if (deviceIO.isOpen()) {
            break label376;
          }
          if (deviceIO.getProtocol() != IotHubClientProtocol.HTTPS) {
            break label320;
          }
          setOption_SetMinimumPollingInterval(paramObject);
        }
        return;
        label320:
        paramObject = new StringBuilder();
        ((StringBuilder)paramObject).append("optionName is unknown = ");
        ((StringBuilder)paramObject).append(paramString);
        ((StringBuilder)paramObject).append(" for ");
        ((StringBuilder)paramObject).append(deviceIO.getProtocol().toString());
        throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        label376:
        throw new IllegalStateException("setOption SetMinimumPollingIntervalonly works when the transport is closed");
      }
      throw new IllegalArgumentException("optionName is null");
    }
    throw new IllegalArgumentException("optionName is null");
  }
  
  public void setOption_SetCertificatePath(Object paramObject)
  {
    if (paramObject != null) {
      config.getAuthenticationProvider().setPathToIotHubTrustedCert((String)paramObject);
    }
  }
  
  public void setOption_SetMinimumPollingInterval(Object paramObject)
  {
    if (paramObject != null) {
      if ((paramObject instanceof Long))
      {
        try
        {
          deviceIO.setReceivePeriodInMilliseconds(((Long)paramObject).longValue());
        }
        catch (IOException paramObject)
        {
          throw new IOError((Throwable)paramObject);
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
  }
  
  public void setOption_SetSASTokenExpiryTime(Object paramObject)
  {
    if (config.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN)
    {
      if (paramObject != null) {
        if ((paramObject instanceof Long))
        {
          long l = ((Long)paramObject).longValue();
          config.getSasTokenAuthentication().setTokenValidSecs(l);
          paramObject = deviceIO;
          if ((paramObject != null) && (((DeviceIO)paramObject).isOpen())) {
            try
            {
              if (!config.getSasTokenAuthentication().canRefreshToken()) {
                break label137;
              }
              deviceIO.close();
              deviceIO.open();
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
      label137:
      return;
    }
    throw new IllegalStateException("Cannot set sas token validity time when not using sas token authentication");
  }
  
  public void setOption_SetSendInterval(Object paramObject)
  {
    if (paramObject != null) {
      if ((paramObject instanceof Long))
      {
        try
        {
          deviceIO.setSendPeriodInMilliseconds(((Long)paramObject).longValue());
        }
        catch (IOException paramObject)
        {
          throw new IOError((Throwable)paramObject);
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
  }
  
  public void setProxySettings(ProxySettings paramProxySettings)
  {
    if (!deviceIO.isOpen())
    {
      IotHubClientProtocol localIotHubClientProtocol = deviceIO.getProtocol();
      if ((localIotHubClientProtocol != IotHubClientProtocol.HTTPS) && (localIotHubClientProtocol != IotHubClientProtocol.AMQPS_WS) && (localIotHubClientProtocol != IotHubClientProtocol.MQTT_WS)) {
        throw new IllegalArgumentException("Use of proxies is unsupported unless using HTTPS, MQTT_WS or AMQPS_WS");
      }
      config.setProxy(paramProxySettings);
      return;
    }
    throw new IllegalStateException("Cannot set proxy after connection was already opened");
  }
  
  public void setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    config.setRetryPolicy(paramRetryPolicy);
  }
  
  public void setTrustedCertificates(String paramString)
  {
    config.getAuthenticationProvider().setIotHubTrustedCert(paramString);
  }
  
  public void startTwinInternal(IotHubEventCallback paramIotHubEventCallback, Object paramObject1, PropertyCallBack paramPropertyCallBack, Object paramObject2)
  {
    if (deviceIO.isOpen())
    {
      if ((paramIotHubEventCallback != null) && (paramPropertyCallBack != null))
      {
        if (twin == null)
        {
          paramIotHubEventCallback = new DeviceTwin(deviceIO, config, paramIotHubEventCallback, paramObject1, paramPropertyCallBack, paramObject2);
          twin = paramIotHubEventCallback;
          paramIotHubEventCallback.getDeviceTwin();
          return;
        }
        throw new UnsupportedOperationException("You have already initialised twin");
      }
      throw new IllegalArgumentException("Callback cannot be null");
    }
    throw new IOException("Open the client connection before using it.");
  }
  
  public void startTwinInternal(IotHubEventCallback paramIotHubEventCallback, Object paramObject1, TwinPropertyCallBack paramTwinPropertyCallBack, Object paramObject2)
  {
    if (deviceIO.isOpen())
    {
      if ((paramIotHubEventCallback != null) && (paramTwinPropertyCallBack != null))
      {
        if (twin == null)
        {
          paramIotHubEventCallback = new DeviceTwin(deviceIO, config, paramIotHubEventCallback, paramObject1, paramTwinPropertyCallBack, paramObject2);
          twin = paramIotHubEventCallback;
          paramIotHubEventCallback.getDeviceTwin();
          return;
        }
        throw new UnsupportedOperationException("You have already initialised twin");
      }
      throw new IllegalArgumentException("Callback cannot be null");
    }
    throw new IOException("Open the client connection before using it.");
  }
  
  public void subscribeToDesiredProperties(Map<Property, Pair<PropertyCallBack<String, Object>, Object>> paramMap)
  {
    if (twin != null)
    {
      if (deviceIO.isOpen())
      {
        twin.subscribeDesiredPropertiesNotification(paramMap);
        return;
      }
      throw new IOException("Open the client connection before using it.");
    }
    throw new IOException("Start twin before using it");
  }
  
  public void subscribeToMethodsInternal(DeviceMethodCallback paramDeviceMethodCallback, Object paramObject1, IotHubEventCallback paramIotHubEventCallback, Object paramObject2)
  {
    if (deviceIO.isOpen())
    {
      if ((paramDeviceMethodCallback != null) && (paramIotHubEventCallback != null))
      {
        if (method == null) {
          method = new DeviceMethod(deviceIO, config, paramIotHubEventCallback, paramObject2);
        }
        method.subscribeToDeviceMethod(paramDeviceMethodCallback, paramObject1);
        return;
      }
      throw new IllegalArgumentException("Callback cannot be null");
    }
    throw new IOException("Open the client connection before using it.");
  }
  
  public void subscribeToTwinDesiredProperties(Map<Property, Pair<TwinPropertyCallBack, Object>> paramMap)
  {
    if (twin != null)
    {
      if (deviceIO.isOpen())
      {
        twin.subscribeDesiredPropertiesTwinPropertyNotification(paramMap);
        return;
      }
      throw new IOException("Open the client connection before using it.");
    }
    throw new IOException("Start twin before using it");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.InternalClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */