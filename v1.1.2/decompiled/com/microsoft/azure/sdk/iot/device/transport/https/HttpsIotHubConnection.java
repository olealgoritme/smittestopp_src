package com.microsoft.azure.sdk.iot.device.transport.https;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig.AuthType;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageProperty;
import com.microsoft.azure.sdk.iot.device.ProductInfo;
import com.microsoft.azure.sdk.iot.device.ProxySettings;
import com.microsoft.azure.sdk.iot.device.ResponseMessage;
import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubServiceException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.net.IotHubAbandonUri;
import com.microsoft.azure.sdk.iot.device.net.IotHubCompleteUri;
import com.microsoft.azure.sdk.iot.device.net.IotHubEventUri;
import com.microsoft.azure.sdk.iot.device.net.IotHubMessageUri;
import com.microsoft.azure.sdk.iot.device.net.IotHubRejectUri;
import com.microsoft.azure.sdk.iot.device.net.IotHubUri;
import com.microsoft.azure.sdk.iot.device.transport.IotHubListener;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportConnection;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLContext;
import l.f.b;
import l.f.c;

public class HttpsIotHubConnection
  implements IotHubTransportConnection
{
  public static final String HTTPS_HEAD_TAG = "https://";
  public static final String HTTPS_PROPERTY_AUTHORIZATION_TAG = "authorization";
  public static final String HTTPS_PROPERTY_CONTENT_TYPE_TAG = "content-type";
  public static final String HTTPS_PROPERTY_ETAG_TAG = "etag";
  public static final String HTTPS_PROPERTY_IF_MATCH_TAG = "if-match";
  public static final String HTTPS_PROPERTY_IOTHUB_MESSAGELOCKTIMEOUT_TAG = "iothub-messagelocktimeout";
  public static final String HTTPS_PROPERTY_IOTHUB_TO_TAG = "iothub-to";
  public static final b log = c.a(HttpsIotHubConnection.class);
  public final Object HTTPS_CONNECTION_LOCK = new Object();
  public final DeviceClientConfig config;
  public IotHubListener listener;
  public Map<Message, String> messageToETagMap = new HashMap();
  
  public HttpsIotHubConnection(DeviceClientConfig paramDeviceClientConfig)
  {
    synchronized (HTTPS_CONNECTION_LOCK)
    {
      config = paramDeviceClientConfig;
      return;
    }
  }
  
  private URL buildUrlFromString(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new TransportException("Could not build HTTP url", paramString);
    }
  }
  
  private String getHostName()
  {
    String str1 = config.getGatewayHostname();
    String str2;
    if (str1 != null)
    {
      str2 = str1;
      if (!str1.isEmpty()) {}
    }
    else
    {
      str2 = config.getIotHubHostname();
    }
    return str2;
  }
  
  private SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext = config.getAuthenticationProvider().getSSLContext();
      return localSSLContext;
    }
    catch (IOException localIOException)
    {
      throw new TransportException(localIOException);
    }
  }
  
  private String getSasToken()
  {
    try
    {
      String str = config.getSasTokenAuthentication().getRenewedSasToken(false, false);
      return str;
    }
    catch (IOException localIOException)
    {
      throw new TransportException(localIOException);
    }
  }
  
  public static String sanitizeEtag(String paramString)
  {
    return paramString.replace("\"", "");
  }
  
  private HttpsResponse sendRequest(HttpsRequest paramHttpsRequest)
  {
    paramHttpsRequest.setReadTimeoutMillis(config.getReadTimeoutMillis());
    if (config.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN) {
      paramHttpsRequest.setHeaderField("authorization", getSasToken());
    }
    paramHttpsRequest.setSSLContext(getSSLContext());
    return paramHttpsRequest.send();
  }
  
  public void close() {}
  
  public String getConnectionId()
  {
    return "";
  }
  
  public void open(Queue<DeviceClientConfig> paramQueue, ScheduledExecutorService paramScheduledExecutorService) {}
  
  public IotHubTransportMessage receiveMessage()
  {
    synchronized (HTTPS_CONNECTION_LOCK)
    {
      Object localObject2 = new com/microsoft/azure/sdk/iot/device/net/IotHubMessageUri;
      ((IotHubMessageUri)localObject2).<init>(getHostName(), config.getDeviceId(), config.getModuleId());
      Object localObject4 = new java/lang/StringBuilder;
      ((StringBuilder)localObject4).<init>();
      ((StringBuilder)localObject4).append("https://");
      ((StringBuilder)localObject4).append(((IotHubMessageUri)localObject2).toString());
      URL localURL = buildUrlFromString(((StringBuilder)localObject4).toString());
      localObject4 = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;
      HttpsMethod localHttpsMethod = HttpsMethod.GET;
      Object localObject5 = config.getProductInfo().getUserAgentString();
      ProxySettings localProxySettings = config.getProxySettings();
      ((HttpsRequest)localObject4).<init>(localURL, localHttpsMethod, new byte[0], (String)localObject5, localProxySettings);
      localObject2 = ((HttpsRequest)localObject4).setHeaderField("iothub-to", ((IotHubMessageUri)localObject2).getPath()).setHeaderField("iothub-messagelocktimeout", Integer.toString(config.getMessageLockTimeoutSecs()));
      log.d("Sending http request to check if any messages are ready to be received...");
      localObject5 = sendRequest((HttpsRequest)localObject2);
      localObject2 = null;
      if (IotHubStatusCode.getIotHubStatusCode(((HttpsResponse)localObject5).getStatus()) == IotHubStatusCode.OK)
      {
        localObject4 = sanitizeEtag(((HttpsResponse)localObject5).getHeaderField("etag"));
        localObject5 = HttpsSingleMessage.parseHttpsMessage((HttpsResponse)localObject5).toMessage();
        localObject2 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
        ((IotHubTransportMessage)localObject2).<init>(((Message)localObject5).getBytes(), ((Message)localObject5).getMessageType(), ((Message)localObject5).getMessageId(), ((Message)localObject5).getCorrelationId(), ((Message)localObject5).getProperties());
        ((IotHubTransportMessage)localObject2).setMessageCallback(config.getDeviceTelemetryMessageCallback(((Message)localObject5).getInputName()));
        ((IotHubTransportMessage)localObject2).setMessageCallbackContext(config.getDeviceTelemetryMessageContext(((Message)localObject5).getInputName()));
        log.b("Received http message with etag {} in transport message ({})", localObject4, localObject2);
        messageToETagMap.put(localObject2, localObject4);
      }
      return (IotHubTransportMessage)localObject2;
    }
  }
  
  public ResponseMessage sendHttpsMessage(HttpsMessage paramHttpsMessage, HttpsMethod paramHttpsMethod, String paramString, Map<String, String> paramMap)
  {
    synchronized (HTTPS_CONNECTION_LOCK)
    {
      Object localObject2 = getHostName();
      Object localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      ((StringBuilder)localObject3).append("https://");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("?");
      ((StringBuilder)localObject3).append(IotHubUri.API_VERSION);
      localObject3 = buildUrlFromString(((StringBuilder)localObject3).toString());
      localObject2 = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;
      ((HttpsRequest)localObject2).<init>((URL)localObject3, paramHttpsMethod, paramHttpsMessage.getBody(), config.getProductInfo().getUserAgentString(), config.getProxySettings());
      for (paramHttpsMethod : paramHttpsMessage.getProperties()) {
        ((HttpsRequest)localObject2).setHeaderField(paramHttpsMethod.getName(), paramHttpsMethod.getValue());
      }
      ((HttpsRequest)localObject2).setHeaderField("iothub-to", paramString).setHeaderField("content-type", paramHttpsMessage.getContentType());
      paramHttpsMethod = paramMap.keySet().iterator();
      while (paramHttpsMethod.hasNext())
      {
        paramHttpsMessage = (String)paramHttpsMethod.next();
        ((HttpsRequest)localObject2).setHeaderField(paramHttpsMessage, (String)paramMap.get(paramHttpsMessage));
      }
      paramHttpsMethod = sendRequest((HttpsRequest)localObject2);
      paramHttpsMessage = IotHubStatusCode.getIotHubStatusCode(paramHttpsMethod.getStatus());
      paramString = paramHttpsMethod.getBody();
      paramHttpsMethod = new com/microsoft/azure/sdk/iot/device/ResponseMessage;
      paramHttpsMethod.<init>(paramString, paramHttpsMessage);
      return paramHttpsMethod;
    }
  }
  
  public IotHubStatusCode sendMessage(Message paramMessage)
  {
    synchronized (HTTPS_CONNECTION_LOCK)
    {
      Object localObject2 = HttpsSingleMessage.parseHttpsMessage(paramMessage);
      Object localObject3 = getHostName();
      Object localObject4 = config.getDeviceId();
      Object localObject5 = config.getModuleId();
      Object localObject6 = new com/microsoft/azure/sdk/iot/device/net/IotHubEventUri;
      ((IotHubEventUri)localObject6).<init>((String)localObject3, (String)localObject4, (String)localObject5);
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      ((StringBuilder)localObject3).append("https://");
      ((StringBuilder)localObject3).append(((IotHubEventUri)localObject6).toString());
      localObject5 = buildUrlFromString(((StringBuilder)localObject3).toString());
      localObject3 = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;
      ((HttpsRequest)localObject3).<init>((URL)localObject5, HttpsMethod.POST, ((HttpsMessage)localObject2).getBody(), config.getProductInfo().getUserAgentString(), config.getProxySettings());
      for (localObject4 : ((HttpsMessage)localObject2).getProperties()) {
        ((HttpsRequest)localObject3).setHeaderField(((MessageProperty)localObject4).getName(), ((MessageProperty)localObject4).getValue());
      }
      if (paramMessage.getContentEncoding() != null) {
        ((HttpsRequest)localObject3).setHeaderField("iothub-contentencoding", paramMessage.getContentEncoding());
      }
      if (paramMessage.getContentType() != null) {
        ((HttpsRequest)localObject3).setHeaderField("iothub-contenttype", paramMessage.getContentType());
      }
      if (paramMessage.getCreationTimeUTC() != null) {
        ((HttpsRequest)localObject3).setHeaderField("iothub-creation-time-utc", paramMessage.getCreationTimeUTCString());
      }
      if (paramMessage.isSecurityMessage()) {
        ((HttpsRequest)localObject3).setHeaderField("iothub-interface-id", "urn:azureiot:Security:SecurityAgent:1");
      }
      localObject4 = ((HttpsMessage)localObject2).getSystemProperties();
      localObject5 = ((Map)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        ((HttpsRequest)localObject3).setHeaderField(str, (String)((Map)localObject4).get(str));
      }
      ((HttpsRequest)localObject3).setHeaderField("iothub-to", ((IotHubEventUri)localObject6).getPath()).setHeaderField("content-type", ((HttpsMessage)localObject2).getContentType());
      log.d("Sending message using http request ({})", paramMessage);
      localObject2 = IotHubStatusCode.getIotHubStatusCode(sendRequest((HttpsRequest)localObject3).getStatus());
      log.b("Iot Hub responded to http message for iot hub message ({}) with status code {}", paramMessage, localObject2);
      localObject6 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
      ((IotHubTransportMessage)localObject6).<init>(paramMessage.getBytes(), paramMessage.getMessageType(), paramMessage.getMessageId(), paramMessage.getCorrelationId(), paramMessage.getProperties());
      if ((localObject2 != IotHubStatusCode.OK) && (localObject2 != IotHubStatusCode.OK_EMPTY)) {
        listener.onMessageSent((Message)localObject6, IotHubStatusCode.getConnectionStatusException((IotHubStatusCode)localObject2, ""));
      } else {
        listener.onMessageSent((Message)localObject6, null);
      }
      return (IotHubStatusCode)localObject2;
    }
  }
  
  public boolean sendMessageResult(Message paramMessage, IotHubMessageResult paramIotHubMessageResult)
  {
    synchronized (HTTPS_CONNECTION_LOCK)
    {
      log.d("Checking if http layer can correlate the received iot hub message to a received etag {}", paramMessage);
      String str1 = (String)messageToETagMap.get(paramMessage);
      if (str1 != null)
      {
        log.b("Http layer correlated the received iot hub message ({}) to etag {}", paramMessage, str1);
        log.b("Sending ACK with result {} for etag {}", paramIotHubMessageResult, str1);
        Object localObject2 = getHostName();
        Object localObject3 = config.getDeviceId();
        int i = paramIotHubMessageResult.ordinal();
        String str2;
        Object localObject4;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              paramIotHubMessageResult = new com/microsoft/azure/sdk/iot/device/net/IotHubRejectUri;
              paramIotHubMessageResult.<init>((String)localObject2, (String)localObject3, str1, config.getModuleId());
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              ((StringBuilder)localObject2).append("https://");
              ((StringBuilder)localObject2).append(paramIotHubMessageResult.toString());
              localObject3 = ((StringBuilder)localObject2).toString();
              localObject2 = paramIotHubMessageResult.getPath();
              URL localURL = buildUrlFromString((String)localObject3);
              paramIotHubMessageResult = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;
              localObject3 = HttpsMethod.DELETE;
              str2 = config.getProductInfo().getUserAgentString();
              localObject4 = config.getProxySettings();
              paramIotHubMessageResult.<init>(localURL, (HttpsMethod)localObject3, new byte[0], str2, (ProxySettings)localObject4);
            }
            else
            {
              paramMessage = new java/lang/IllegalStateException;
              paramMessage.<init>("Invalid message result specified.");
              throw paramMessage;
            }
          }
          else
          {
            paramIotHubMessageResult = new com/microsoft/azure/sdk/iot/device/net/IotHubAbandonUri;
            paramIotHubMessageResult.<init>((String)localObject2, (String)localObject3, str1, config.getModuleId());
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append("https://");
            ((StringBuilder)localObject2).append(paramIotHubMessageResult.toString());
            localObject3 = ((StringBuilder)localObject2).toString();
            localObject2 = paramIotHubMessageResult.getPath();
            paramIotHubMessageResult = new HttpsRequest(buildUrlFromString((String)localObject3), HttpsMethod.POST, new byte[1], config.getProductInfo().getUserAgentString(), config.getProxySettings());
          }
        }
        else
        {
          paramIotHubMessageResult = new com/microsoft/azure/sdk/iot/device/net/IotHubCompleteUri;
          paramIotHubMessageResult.<init>((String)localObject2, (String)localObject3, str1, config.getModuleId());
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          ((StringBuilder)localObject2).append("https://");
          ((StringBuilder)localObject2).append(paramIotHubMessageResult.toString());
          localObject3 = ((StringBuilder)localObject2).toString();
          localObject2 = paramIotHubMessageResult.getPath();
          localObject4 = buildUrlFromString((String)localObject3);
          localObject3 = HttpsMethod.DELETE;
          str2 = config.getProductInfo().getUserAgentString();
          paramIotHubMessageResult = config.getProxySettings();
          paramIotHubMessageResult = new HttpsRequest((URL)localObject4, (HttpsMethod)localObject3, new byte[0], str2, paramIotHubMessageResult);
        }
        paramIotHubMessageResult.setHeaderField("iothub-to", (String)localObject2).setHeaderField("if-match", str1);
        paramIotHubMessageResult = IotHubStatusCode.getIotHubStatusCode(sendRequest(paramIotHubMessageResult).getStatus());
        if ((paramIotHubMessageResult != IotHubStatusCode.OK_EMPTY) && (paramIotHubMessageResult != IotHubStatusCode.OK))
        {
          paramIotHubMessageResult = String.format("Sending message result failed with status %s.%n", new Object[] { paramIotHubMessageResult.name() });
          paramMessage = new com/microsoft/azure/sdk/iot/device/exceptions/IotHubServiceException;
          paramMessage.<init>(paramIotHubMessageResult);
          throw paramMessage;
        }
        log.d("Successfully sent ack for http message with etag {}. Removing it from saved list of outstanding messages to acknowledge", str1);
        messageToETagMap.remove(paramMessage);
        return true;
      }
      paramMessage = new java/lang/IllegalStateException;
      paramMessage.<init>("Cannot send a message result before a message is received or if the result was already sent");
      throw paramMessage;
    }
  }
  
  public void setListener(IotHubListener paramIotHubListener)
  {
    if (paramIotHubListener != null)
    {
      listener = paramIotHubListener;
      return;
    }
    throw new IllegalArgumentException("Listener cannot be null");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.https.HttpsIotHubConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */