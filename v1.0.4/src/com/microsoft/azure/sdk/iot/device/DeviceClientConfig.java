package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.Pair;
import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenHardwareAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenSoftwareAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubX509HardwareAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubX509SoftwareAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.transport.ExponentialBackoffWithJitter;
import com.microsoft.azure.sdk.iot.device.transport.RetryPolicy;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProvider;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderSymmetricKey;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderTpm;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderX509;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import k.f.b;
import k.f.c;

public final class DeviceClientConfig
{
  public static final int DEFAULT_MESSAGE_LOCK_TIMEOUT_SECS = 180;
  public static final long DEFAULT_OPERATION_TIMEOUT = 240000L;
  public static final int DEFAULT_READ_TIMEOUT_MILLIS = 240000;
  public static final b log = c.a(DeviceClientConfig.class);
  public IotHubAuthenticationProvider authenticationProvider;
  public MessageCallback defaultDeviceTelemetryMessageCallback;
  public Object defaultDeviceTelemetryMessageContext;
  public MessageCallback deviceMethodsMessageCallback;
  public Object deviceMethodsMessageContext;
  public MessageCallback deviceTwinMessageCallback;
  public Object deviceTwinMessageContext;
  public Map<String, Pair<MessageCallback, Object>> inputChannelMessageCallbacks = new HashMap();
  public long operationTimeout = 240000L;
  public ProductInfo productInfo;
  public IotHubClientProtocol protocol;
  public ProxySettings proxySettings;
  public RetryPolicy retryPolicy = new ExponentialBackoffWithJitter();
  public boolean useWebsocket;
  
  public DeviceClientConfig()
  {
    authenticationProvider = null;
    deviceMethodsMessageCallback = null;
    defaultDeviceTelemetryMessageCallback = null;
    deviceTwinMessageCallback = null;
    deviceMethodsMessageContext = null;
    defaultDeviceTelemetryMessageContext = null;
    deviceTwinMessageContext = null;
    useWebsocket = false;
  }
  
  public DeviceClientConfig(IotHubConnectionString paramIotHubConnectionString)
  {
    commonConstructorSetup(paramIotHubConnectionString);
    assertConnectionStringIsNotX509(paramIotHubConnectionString);
    authenticationProvider = new IotHubSasTokenSoftwareAuthenticationProvider(paramIotHubConnectionString.getHostName(), paramIotHubConnectionString.getGatewayHostName(), paramIotHubConnectionString.getDeviceId(), paramIotHubConnectionString.getModuleId(), paramIotHubConnectionString.getSharedAccessKey(), paramIotHubConnectionString.getSharedAccessToken());
    log.b("Device configured to use software based SAS authentication provider");
  }
  
  public DeviceClientConfig(IotHubConnectionString paramIotHubConnectionString, SecurityProvider paramSecurityProvider)
  {
    commonConstructorSetup(paramIotHubConnectionString);
    if (paramSecurityProvider != null)
    {
      if ((paramSecurityProvider instanceof SecurityProviderTpm))
      {
        authenticationProvider = new IotHubSasTokenHardwareAuthenticationProvider(paramIotHubConnectionString.getHostName(), paramIotHubConnectionString.getGatewayHostName(), paramIotHubConnectionString.getDeviceId(), paramIotHubConnectionString.getModuleId(), paramSecurityProvider);
      }
      else if ((paramSecurityProvider instanceof SecurityProviderSymmetricKey))
      {
        authenticationProvider = new IotHubSasTokenSoftwareAuthenticationProvider(paramIotHubConnectionString.getHostName(), paramIotHubConnectionString.getGatewayHostName(), paramIotHubConnectionString.getDeviceId(), paramIotHubConnectionString.getModuleId(), new String(((SecurityProviderSymmetricKey)paramSecurityProvider).getSymmetricKey()), null);
      }
      else
      {
        if (!(paramSecurityProvider instanceof SecurityProviderX509)) {
          break label168;
        }
        authenticationProvider = new IotHubX509HardwareAuthenticationProvider(paramIotHubConnectionString.getHostName(), paramIotHubConnectionString.getGatewayHostName(), paramIotHubConnectionString.getDeviceId(), paramIotHubConnectionString.getModuleId(), paramSecurityProvider);
      }
      return;
      label168:
      throw new UnsupportedOperationException("The provided security provider is not supported.");
    }
    throw new IllegalArgumentException("security provider cannot be null");
  }
  
  public DeviceClientConfig(IotHubConnectionString paramIotHubConnectionString, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    commonConstructorSetup(paramIotHubConnectionString);
    assertConnectionStringIsX509(paramIotHubConnectionString);
    authenticationProvider = new IotHubX509SoftwareAuthenticationProvider(paramIotHubConnectionString.getHostName(), paramIotHubConnectionString.getGatewayHostName(), paramIotHubConnectionString.getDeviceId(), paramIotHubConnectionString.getModuleId(), paramString1, paramBoolean1, paramString2, paramBoolean2);
    log.b("Device configured to use software based x509 authentication provider");
  }
  
  public DeviceClientConfig(IotHubConnectionString paramIotHubConnectionString, SSLContext paramSSLContext)
  {
    commonConstructorSetup(paramIotHubConnectionString);
    if (paramIotHubConnectionString.isUsingX509())
    {
      authenticationProvider = new IotHubX509SoftwareAuthenticationProvider(paramIotHubConnectionString.getHostName(), paramIotHubConnectionString.getGatewayHostName(), paramIotHubConnectionString.getDeviceId(), paramIotHubConnectionString.getModuleId(), paramSSLContext);
      log.b("Device configured to use software based x509 authentication provider with custom SSLContext");
    }
    else
    {
      authenticationProvider = new IotHubSasTokenSoftwareAuthenticationProvider(paramIotHubConnectionString.getHostName(), paramIotHubConnectionString.getGatewayHostName(), paramIotHubConnectionString.getDeviceId(), paramIotHubConnectionString.getModuleId(), paramIotHubConnectionString.getSharedAccessKey(), paramIotHubConnectionString.getSharedAccessToken(), paramSSLContext);
      log.b("Device configured to use software based SAS authentication provider with custom SSLContext");
    }
  }
  
  public DeviceClientConfig(IotHubAuthenticationProvider paramIotHubAuthenticationProvider)
  {
    if ((paramIotHubAuthenticationProvider instanceof IotHubSasTokenAuthenticationProvider))
    {
      authenticationProvider = paramIotHubAuthenticationProvider;
      useWebsocket = false;
      productInfo = new ProductInfo();
      return;
    }
    throw new UnsupportedOperationException("This constructor only support sas token authentication currently");
  }
  
  private void assertConnectionStringIsNotX509(IotHubConnectionString paramIotHubConnectionString)
  {
    if (!paramIotHubConnectionString.isUsingX509()) {
      return;
    }
    throw new IllegalArgumentException("Cannot use this constructor for x509 connection strings. Use constructor that takes public key certificate and private key or takes an SSLContext instance instead");
  }
  
  private void assertConnectionStringIsX509(IotHubConnectionString paramIotHubConnectionString)
  {
    if (paramIotHubConnectionString.isUsingX509()) {
      return;
    }
    throw new IllegalArgumentException("Cannot use this constructor for connection strings that don't use x509 authentication.");
  }
  
  private void commonConstructorSetup(IotHubConnectionString paramIotHubConnectionString)
  {
    if (paramIotHubConnectionString != null)
    {
      productInfo = new ProductInfo();
      useWebsocket = false;
      return;
    }
    throw new IllegalArgumentException("connection string cannot be null");
  }
  
  public IotHubAuthenticationProvider getAuthenticationProvider()
  {
    return authenticationProvider;
  }
  
  public DeviceClientConfig.AuthType getAuthenticationType()
  {
    if ((authenticationProvider instanceof IotHubSasTokenAuthenticationProvider)) {
      return DeviceClientConfig.AuthType.SAS_TOKEN;
    }
    return DeviceClientConfig.AuthType.X509_CERTIFICATE;
  }
  
  public String getDeviceId()
  {
    return authenticationProvider.getDeviceId();
  }
  
  public MessageCallback getDeviceMethodsMessageCallback()
  {
    return deviceMethodsMessageCallback;
  }
  
  public Object getDeviceMethodsMessageContext()
  {
    return deviceMethodsMessageContext;
  }
  
  public MessageCallback getDeviceTelemetryMessageCallback(String paramString)
  {
    if ((paramString != null) && (inputChannelMessageCallbacks.containsKey(paramString))) {
      return (MessageCallback)((Pair)inputChannelMessageCallbacks.get(paramString)).getKey();
    }
    return defaultDeviceTelemetryMessageCallback;
  }
  
  public Object getDeviceTelemetryMessageContext(String paramString)
  {
    if ((paramString != null) && (inputChannelMessageCallbacks.containsKey(paramString))) {
      return ((Pair)inputChannelMessageCallbacks.get(paramString)).getValue();
    }
    return defaultDeviceTelemetryMessageContext;
  }
  
  public MessageCallback getDeviceTwinMessageCallback()
  {
    return deviceTwinMessageCallback;
  }
  
  public Object getDeviceTwinMessageContext()
  {
    return deviceTwinMessageContext;
  }
  
  public String getGatewayHostname()
  {
    return authenticationProvider.getGatewayHostname();
  }
  
  public String getIotHubHostname()
  {
    return authenticationProvider.getHostname();
  }
  
  public String getIotHubName()
  {
    return IotHubConnectionString.parseHubName(authenticationProvider.getHostname());
  }
  
  public int getMessageLockTimeoutSecs()
  {
    return 180;
  }
  
  public String getModuleId()
  {
    return authenticationProvider.getModuleId();
  }
  
  public long getOperationTimeout()
  {
    return operationTimeout;
  }
  
  public ProductInfo getProductInfo()
  {
    return productInfo;
  }
  
  public IotHubClientProtocol getProtocol()
  {
    return protocol;
  }
  
  public ProxySettings getProxySettings()
  {
    return proxySettings;
  }
  
  public int getReadTimeoutMillis()
  {
    return 240000;
  }
  
  public RetryPolicy getRetryPolicy()
  {
    return retryPolicy;
  }
  
  public IotHubSasTokenAuthenticationProvider getSasTokenAuthentication()
  {
    IotHubAuthenticationProvider localIotHubAuthenticationProvider = authenticationProvider;
    if ((localIotHubAuthenticationProvider instanceof IotHubSasTokenAuthenticationProvider)) {
      return (IotHubSasTokenAuthenticationProvider)localIotHubAuthenticationProvider;
    }
    return null;
  }
  
  public boolean isUseWebsocket()
  {
    return useWebsocket;
  }
  
  public void setDeviceMethodsMessageCallback(MessageCallback paramMessageCallback, Object paramObject)
  {
    deviceMethodsMessageCallback = paramMessageCallback;
    deviceMethodsMessageContext = paramObject;
  }
  
  public void setDeviceTwinMessageCallback(MessageCallback paramMessageCallback, Object paramObject)
  {
    deviceTwinMessageCallback = paramMessageCallback;
    deviceTwinMessageContext = paramObject;
  }
  
  public void setMessageCallback(MessageCallback paramMessageCallback, Object paramObject)
  {
    defaultDeviceTelemetryMessageCallback = paramMessageCallback;
    defaultDeviceTelemetryMessageContext = paramObject;
  }
  
  public void setMessageCallback(String paramString, MessageCallback paramMessageCallback, Object paramObject)
  {
    if ((inputChannelMessageCallbacks.containsKey(paramString)) && (paramMessageCallback == null)) {
      inputChannelMessageCallbacks.remove(paramString);
    } else {
      inputChannelMessageCallbacks.put(paramString, new Pair(paramMessageCallback, paramObject));
    }
  }
  
  public void setOperationTimeout(long paramLong)
  {
    if (paramLong >= 1L)
    {
      operationTimeout = paramLong;
      return;
    }
    throw new IllegalArgumentException("Operation timeout cannot be 0 or negative");
  }
  
  public void setProtocol(IotHubClientProtocol paramIotHubClientProtocol)
  {
    protocol = paramIotHubClientProtocol;
  }
  
  public void setProxy(ProxySettings paramProxySettings)
  {
    proxySettings = paramProxySettings;
  }
  
  public void setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    if (paramRetryPolicy != null)
    {
      retryPolicy = paramRetryPolicy;
      return;
    }
    throw new IllegalArgumentException("Retry Policy cannot be null.");
  }
  
  public void setUseWebsocket(boolean paramBoolean)
  {
    useWebsocket = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceClientConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */