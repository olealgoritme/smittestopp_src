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
import k.f.b;
import k.f.c;

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
      HttpsRequest localHttpsRequest = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;
      Object localObject5 = HttpsMethod.GET;
      String str = config.getProductInfo().getUserAgentString();
      localObject4 = config.getProxySettings();
      localHttpsRequest.<init>(localURL, (HttpsMethod)localObject5, new byte[0], str, (ProxySettings)localObject4);
      localObject2 = localHttpsRequest.setHeaderField("iothub-to", ((IotHubMessageUri)localObject2).getPath()).setHeaderField("iothub-messagelocktimeout", Integer.toString(config.getMessageLockTimeoutSecs()));
      log.e("Sending http request to check if any messages are ready to be received...");
      localObject4 = sendRequest((HttpsRequest)localObject2);
      localObject2 = null;
      if (IotHubStatusCode.getIotHubStatusCode(((HttpsResponse)localObject4).getStatus()) == IotHubStatusCode.OK)
      {
        localObject5 = sanitizeEtag(((HttpsResponse)localObject4).getHeaderField("etag"));
        localObject4 = HttpsSingleMessage.parseHttpsMessage((HttpsResponse)localObject4).toMessage();
        localObject2 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
        ((IotHubTransportMessage)localObject2).<init>(((Message)localObject4).getBytes(), ((Message)localObject4).getMessageType(), ((Message)localObject4).getMessageId(), ((Message)localObject4).getCorrelationId(), ((Message)localObject4).getProperties());
        ((IotHubTransportMessage)localObject2).setMessageCallback(config.getDeviceTelemetryMessageCallback(((Message)localObject4).getInputName()));
        ((IotHubTransportMessage)localObject2).setMessageCallbackContext(config.getDeviceTelemetryMessageContext(((Message)localObject4).getInputName()));
        log.e("Received http message with etag {} in transport message ({})", localObject5, localObject2);
        messageToETagMap.put(localObject2, localObject5);
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
      localObject2 = buildUrlFromString(((StringBuilder)localObject3).toString());
      localObject3 = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;
      ((HttpsRequest)localObject3).<init>((URL)localObject2, paramHttpsMethod, paramHttpsMessage.getBody(), config.getProductInfo().getUserAgentString(), config.getProxySettings());
      for (paramHttpsMethod : paramHttpsMessage.getProperties()) {
        ((HttpsRequest)localObject3).setHeaderField(paramHttpsMethod.getName(), paramHttpsMethod.getValue());
      }
      ((HttpsRequest)localObject3).setHeaderField("iothub-to", paramString).setHeaderField("content-type", paramHttpsMessage.getContentType());
      paramHttpsMessage = paramMap.keySet().iterator();
      while (paramHttpsMessage.hasNext())
      {
        paramHttpsMethod = (String)paramHttpsMessage.next();
        ((HttpsRequest)localObject3).setHeaderField(paramHttpsMethod, (String)paramMap.get(paramHttpsMethod));
      }
      paramHttpsMethod = sendRequest((HttpsRequest)localObject3);
      paramHttpsMessage = IotHubStatusCode.getIotHubStatusCode(paramHttpsMethod.getStatus());
      paramHttpsMethod = paramHttpsMethod.getBody();
      paramString = new com/microsoft/azure/sdk/iot/device/ResponseMessage;
      paramString.<init>(paramHttpsMethod, paramHttpsMessage);
      return paramString;
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
      for (localObject5 : ((HttpsMessage)localObject2).getProperties()) {
        ((HttpsRequest)localObject3).setHeaderField(((MessageProperty)localObject5).getName(), ((MessageProperty)localObject5).getValue());
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
      localObject5 = ((HttpsMessage)localObject2).getSystemProperties();
      Iterator localIterator = ((Map)localObject5).keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (String)localIterator.next();
        ((HttpsRequest)localObject3).setHeaderField((String)localObject4, (String)((Map)localObject5).get(localObject4));
      }
      ((HttpsRequest)localObject3).setHeaderField("iothub-to", ((IotHubEventUri)localObject6).getPath()).setHeaderField("content-type", ((HttpsMessage)localObject2).getContentType());
      log.d("Sending message using http request ({})", paramMessage);
      localObject2 = IotHubStatusCode.getIotHubStatusCode(sendRequest((HttpsRequest)localObject3).getStatus());
      log.e("Iot Hub responded to http message for iot hub message ({}) with status code {}", paramMessage, localObject2);
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
        log.e("Http layer correlated the received iot hub message ({}) to etag {}", paramMessage, str1);
        log.e("Sending ACK with result {} for etag {}", paramIotHubMessageResult, str1);
        Object localObject2 = getHostName();
        Object localObject3 = config.getDeviceId();
        int i = paramIotHubMessageResult.ordinal();
        URL localURL;
        ProxySettings localProxySettings;
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
              localURL = buildUrlFromString((String)localObject3);
              paramIotHubMessageResult = new com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;
              localObject3 = HttpsMethod.DELETE;
              String str2 = config.getProductInfo().getUserAgentString();
              localProxySettings = config.getProxySettings();
              paramIotHubMessageResult.<init>(localURL, (HttpsMethod)localObject3, new byte[0], str2, localProxySettings);
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
          localURL = buildUrlFromString((String)localObject3);
          paramIotHubMessageResult = HttpsMethod.DELETE;
          localObject3 = config.getProductInfo().getUserAgentString();
          localProxySettings = config.getProxySettings();
          paramIotHubMessageResult = new HttpsRequest(localURL, paramIotHubMessageResult, new byte[0], (String)localObject3, localProxySettings);
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
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.https.HttpsIotHubConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */