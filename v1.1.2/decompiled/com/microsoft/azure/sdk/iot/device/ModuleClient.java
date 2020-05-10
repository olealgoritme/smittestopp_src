package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.PropertyCallBack;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.TwinPropertyCallBack;
import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.SignatureProvider;
import com.microsoft.azure.sdk.iot.device.edge.HttpsHsmTrustBundleProvider;
import com.microsoft.azure.sdk.iot.device.edge.MethodRequest;
import com.microsoft.azure.sdk.iot.device.edge.MethodResult;
import com.microsoft.azure.sdk.iot.device.edge.TrustBundleProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.ModuleClientException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.hsm.HsmException;
import com.microsoft.azure.sdk.iot.device.hsm.HttpHsmSignatureProvider;
import com.microsoft.azure.sdk.iot.device.hsm.IotHubSasTokenHsmAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsTransportManager;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.SSLContext;
import l.f.b;
import l.f.c;

public class ModuleClient
  extends InternalClient
{
  public static final String AuthSchemeVariableName = "IOTEDGE_AUTHSCHEME";
  public static final String DEFAULT_API_VERSION = "2018-06-28";
  public static int DEFAULT_SAS_TOKEN_BUFFER_PERCENTAGE = 85;
  public static int DEFAULT_SAS_TOKEN_TIME_TO_LIVE_SECONDS = 0;
  public static final String DeviceIdVariableName = "IOTEDGE_DEVICEID";
  public static final String EdgeCaCertificateFileVariableName = "EdgeModuleCACertificateFile";
  public static final String EdgehubConnectionstringVariableName = "EdgeHubConnectionString";
  public static final String GatewayHostnameVariableName = "IOTEDGE_GATEWAYHOSTNAME";
  public static final String IotEdgedUriVariableName = "IOTEDGE_WORKLOADURI";
  public static final String IotHubHostnameVariableName = "IOTEDGE_IOTHUBHOSTNAME";
  public static final String IothubConnectionstringVariableName = "IotHubConnectionString";
  public static final String ModuleGenerationIdVariableName = "IOTEDGE_MODULEGENERATIONID";
  public static final String ModuleIdVariableName = "IOTEDGE_MODULEID";
  public static long RECEIVE_PERIOD_MILLIS_AMQPS = 0L;
  public static long RECEIVE_PERIOD_MILLIS_HTTPS = 0L;
  public static long RECEIVE_PERIOD_MILLIS_MQTT = 0L;
  public static long SEND_PERIOD_MILLIS = 0L;
  public static final String SasTokenAuthScheme = "sasToken";
  public static final b log = c.a(ModuleClient.class);
  
  static
  {
    SEND_PERIOD_MILLIS = 10L;
    RECEIVE_PERIOD_MILLIS_AMQPS = 10L;
    RECEIVE_PERIOD_MILLIS_MQTT = 10L;
    RECEIVE_PERIOD_MILLIS_HTTPS = 1500000L;
    DEFAULT_SAS_TOKEN_TIME_TO_LIVE_SECONDS = 3600;
  }
  
  public ModuleClient(IotHubAuthenticationProvider paramIotHubAuthenticationProvider, IotHubClientProtocol paramIotHubClientProtocol, long paramLong1, long paramLong2)
  {
    super(paramIotHubAuthenticationProvider, paramIotHubClientProtocol, paramLong1, paramLong2);
  }
  
  public ModuleClient(String paramString, IotHubClientProtocol paramIotHubClientProtocol)
  {
    super(new IotHubConnectionString(paramString), paramIotHubClientProtocol, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
    commonConstructorVerifications(paramIotHubClientProtocol, config);
  }
  
  public ModuleClient(String paramString1, IotHubClientProtocol paramIotHubClientProtocol, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2)
  {
    super(new IotHubConnectionString(paramString1), paramIotHubClientProtocol, paramString2, paramBoolean1, paramString3, paramBoolean2, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
    commonConstructorVerifications(paramIotHubClientProtocol, getConfig());
  }
  
  public ModuleClient(String paramString, IotHubClientProtocol paramIotHubClientProtocol, SSLContext paramSSLContext)
  {
    super(new IotHubConnectionString(paramString), paramIotHubClientProtocol, paramSSLContext, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
    commonConstructorVerifications(paramIotHubClientProtocol, getConfig());
  }
  
  public static void commonConstructorVerifications(IotHubClientProtocol paramIotHubClientProtocol, DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramIotHubClientProtocol != IotHubClientProtocol.HTTPS)
    {
      if ((paramDeviceClientConfig.getModuleId() != null) && (!paramDeviceClientConfig.getModuleId().isEmpty())) {
        return;
      }
      throw new IllegalArgumentException("Connection string must contain field for ModuleId");
    }
    throw new UnsupportedOperationException("Only MQTT, MQTT_WS, AMQPS and AMQPS_WS are supported for ModuleClient.");
  }
  
  public static ModuleClient createFromEnvironment()
  {
    return createFromEnvironment(IotHubClientProtocol.AMQPS);
  }
  
  public static ModuleClient createFromEnvironment(IotHubClientProtocol paramIotHubClientProtocol)
  {
    log.b("Creating module client from environment with protocol {}...", paramIotHubClientProtocol);
    Object localObject1 = System.getenv();
    log.e("Checking for an edgehub connection string...");
    String str1 = (String)((Map)localObject1).get("EdgeHubConnectionString");
    String str2 = str1;
    if (str1 == null)
    {
      log.e("No edgehub connection string was configured, checking for an IoThub connection string...");
      str2 = (String)((Map)localObject1).get("IotHubConnectionString");
    }
    if (str2 != null)
    {
      log.e("Creating module client with the provided connection string");
      try
      {
        paramIotHubClientProtocol = new ModuleClient(str2, paramIotHubClientProtocol);
        str2 = (String)((Map)localObject1).get("EdgeModuleCACertificateFile");
        if ((str2 != null) && (!str2.isEmpty()))
        {
          log.e("Configuring module client to use the configured alternative trusted certificate");
          paramIotHubClientProtocol.setOption_SetCertificatePath(str2);
        }
        return paramIotHubClientProtocol;
      }
      catch (URISyntaxException paramIotHubClientProtocol)
      {
        throw new ModuleClientException("Could not create module client", paramIotHubClientProtocol);
      }
    }
    log.b("No connection string was configured for this module, so it will get its credentials from the edgelet");
    str2 = (String)((Map)localObject1).get("IOTEDGE_WORKLOADURI");
    Object localObject2 = (String)((Map)localObject1).get("IOTEDGE_DEVICEID");
    String str3 = (String)((Map)localObject1).get("IOTEDGE_MODULEID");
    String str4 = (String)((Map)localObject1).get("IOTEDGE_IOTHUBHOSTNAME");
    Object localObject3 = (String)((Map)localObject1).get("IOTEDGE_AUTHSCHEME");
    str1 = (String)((Map)localObject1).get("IOTEDGE_GATEWAYHOSTNAME");
    localObject1 = (String)((Map)localObject1).get("IOTEDGE_MODULEGENERATIONID");
    if (str2 != null)
    {
      if (localObject2 != null)
      {
        if (str3 != null)
        {
          if (str4 != null)
          {
            if (localObject3 != null)
            {
              if (localObject1 != null)
              {
                if (((String)localObject3).equalsIgnoreCase("sasToken"))
                {
                  try
                  {
                    localObject3 = new HttpHsmSignatureProvider(str2, "2018-06-28");
                    try
                    {
                      localObject2 = IotHubSasTokenHsmAuthenticationProvider.create((SignatureProvider)localObject3, (String)localObject2, str3, str4, str1, (String)localObject1, DEFAULT_SAS_TOKEN_TIME_TO_LIVE_SECONDS, DEFAULT_SAS_TOKEN_BUFFER_PERCENTAGE);
                      localObject1 = new com/microsoft/azure/sdk/iot/device/ModuleClient;
                      ((ModuleClient)localObject1).<init>((IotHubAuthenticationProvider)localObject2, paramIotHubClientProtocol, SEND_PERIOD_MILLIS, getReceivePeriod(paramIotHubClientProtocol));
                      if ((str1 != null) && (!str1.isEmpty()))
                      {
                        paramIotHubClientProtocol = new com/microsoft/azure/sdk/iot/device/edge/HttpsHsmTrustBundleProvider;
                        paramIotHubClientProtocol.<init>();
                        ((InternalClient)localObject1).setTrustedCertificates(paramIotHubClientProtocol.getTrustBundleCerts(str2, "2018-06-28"));
                      }
                      return (ModuleClient)localObject1;
                    }
                    catch (URISyntaxException paramIotHubClientProtocol) {}catch (HsmException paramIotHubClientProtocol) {}catch (TransportException paramIotHubClientProtocol) {}catch (IOException paramIotHubClientProtocol) {}
                    throw new ModuleClientException(paramIotHubClientProtocol);
                  }
                  catch (URISyntaxException paramIotHubClientProtocol) {}catch (NoSuchAlgorithmException paramIotHubClientProtocol) {}
                  throw new ModuleClientException("Could not use Hsm Signature Provider", paramIotHubClientProtocol);
                }
                throw new ModuleClientException("Unsupported authentication scheme. Supported scheme is sasToken.");
              }
              throw new ModuleClientException("Environment variable IOTEDGE_MODULEGENERATIONID is required");
            }
            throw new ModuleClientException("Environment variable IOTEDGE_AUTHSCHEME is required.");
          }
          throw new ModuleClientException("Environment variable IOTEDGE_IOTHUBHOSTNAME is required.");
        }
        throw new ModuleClientException("Environment variable IOTEDGE_MODULEID is required.");
      }
      throw new ModuleClientException("Environment variable IOTEDGE_DEVICEID is required.");
    }
    throw new ModuleClientException("Environment variable IOTEDGE_WORKLOADURI is required.");
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
            break label47;
          }
          if (i != 4) {
            throw new IllegalStateException("Invalid client protocol specified.");
          }
        }
        return RECEIVE_PERIOD_MILLIS_MQTT;
      }
      label47:
      return RECEIVE_PERIOD_MILLIS_AMQPS;
    }
    return RECEIVE_PERIOD_MILLIS_HTTPS;
  }
  
  public void getTwin()
  {
    getTwinInternal();
  }
  
  public MethodResult invokeMethod(String paramString, MethodRequest paramMethodRequest)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      try
      {
        HttpsTransportManager localHttpsTransportManager = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsTransportManager;
        localHttpsTransportManager.<init>(config);
        localHttpsTransportManager.open();
        paramString = localHttpsTransportManager.invokeMethod(paramMethodRequest, paramString, "");
        return paramString;
      }
      catch (TransportException paramString) {}catch (IOException paramString) {}catch (URISyntaxException paramString) {}
      throw new ModuleClientException("Could not invoke method", paramString);
    }
    throw new IllegalArgumentException("DeviceId cannot be null or empty");
  }
  
  public MethodResult invokeMethod(String paramString1, String paramString2, MethodRequest paramMethodRequest)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        try
        {
          HttpsTransportManager localHttpsTransportManager = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsTransportManager;
          localHttpsTransportManager.<init>(config);
          localHttpsTransportManager.open();
          paramString1 = localHttpsTransportManager.invokeMethod(paramMethodRequest, paramString1, paramString2);
          return paramString1;
        }
        catch (TransportException paramString1) {}catch (IOException paramString1) {}catch (URISyntaxException paramString1) {}
        throw new ModuleClientException("Could not invoke method", paramString1);
      }
      throw new IllegalArgumentException("DeviceId cannot be null or empty");
    }
    throw new IllegalArgumentException("DeviceId cannot be null or empty");
  }
  
  public void sendEventAsync(Message paramMessage, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    paramMessage.setConnectionModuleId(config.getModuleId());
    super.sendEventAsync(paramMessage, paramIotHubEventCallback, paramObject);
  }
  
  public void sendEventAsync(Message paramMessage, IotHubEventCallback paramIotHubEventCallback, Object paramObject, String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramMessage.setOutputName(paramString);
      sendEventAsync(paramMessage, paramIotHubEventCallback, paramObject);
      return;
    }
    throw new IllegalArgumentException("outputName cannot be null or empty");
  }
  
  public ModuleClient setMessageCallback(MessageCallback paramMessageCallback, Object paramObject)
  {
    setMessageCallbackInternal(paramMessageCallback, paramObject);
    return this;
  }
  
  public ModuleClient setMessageCallback(String paramString, MessageCallback paramMessageCallback, Object paramObject)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if ((paramMessageCallback == null) && (paramObject != null)) {
        throw new IllegalArgumentException("Cannot give non-null context for a null callback.");
      }
      config.setMessageCallback(paramString, paramMessageCallback, paramObject);
      return this;
    }
    throw new IllegalArgumentException("InputName must not be null or empty");
  }
  
  public void startTwin(IotHubEventCallback paramIotHubEventCallback, Object paramObject1, PropertyCallBack paramPropertyCallBack, Object paramObject2)
  {
    startTwinInternal(paramIotHubEventCallback, paramObject1, paramPropertyCallBack, paramObject2);
  }
  
  public void startTwin(IotHubEventCallback paramIotHubEventCallback, Object paramObject1, TwinPropertyCallBack paramTwinPropertyCallBack, Object paramObject2)
  {
    startTwinInternal(paramIotHubEventCallback, paramObject1, paramTwinPropertyCallBack, paramObject2);
  }
  
  public void subscribeToMethod(DeviceMethodCallback paramDeviceMethodCallback, Object paramObject1, IotHubEventCallback paramIotHubEventCallback, Object paramObject2)
  {
    subscribeToMethodsInternal(paramDeviceMethodCallback, paramObject1, paramIotHubEventCallback, paramObject2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.ModuleClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */