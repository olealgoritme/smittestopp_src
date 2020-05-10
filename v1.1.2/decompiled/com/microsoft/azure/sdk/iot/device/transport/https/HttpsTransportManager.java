package com.microsoft.azure.sdk.iot.device.transport.https;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.IotHubMethod;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.ResponseMessage;
import com.microsoft.azure.sdk.iot.device.edge.MethodRequest;
import com.microsoft.azure.sdk.iot.device.edge.MethodResult;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.net.IotHubUri;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportManager;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import e.a.a.a.a;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpsTransportManager
  implements IotHubTransportManager
{
  public static final String DeviceMethodUriFormat = "/twins/%s/methods";
  public static final String MODULE_ID = "x-ms-edge-moduleId";
  public static final String ModuleMethodUriFormat = "/twins/%s/modules/%s/methods";
  public static final String PATH_FILES_STRING = "/files";
  public static final String PATH_NOTIFICATIONS_STRING = "/files/notifications";
  public DeviceClientConfig config;
  public HttpsIotHubConnection httpsIotHubConnection;
  
  public HttpsTransportManager(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      config = paramDeviceClientConfig;
      return;
    }
    throw new IllegalArgumentException("config is null");
  }
  
  public static URI getDeviceMethodUri(String paramString)
  {
    return new URI(String.format("/twins/%s/methods", new Object[] { URLEncoder.encode(paramString, "UTF-8") }));
  }
  
  public static URI getModuleMethodUri(String paramString1, String paramString2)
  {
    return new URI(String.format("/twins/%s/modules/%s/methods", new Object[] { URLEncoder.encode(paramString1, "UTF-8"), URLEncoder.encode(paramString2, "UTF-8") }));
  }
  
  private MethodResult invokeMethod(MethodRequest paramMethodRequest, URI paramURI)
  {
    if (paramMethodRequest != null)
    {
      if ((paramURI != null) && (!paramURI.toString().isEmpty()))
      {
        paramMethodRequest = new IotHubTransportMessage(paramMethodRequest.toJson());
        paramMethodRequest.setIotHubMethod(IotHubMethod.POST);
        paramMethodRequest.setUriPath(paramURI.toString());
        HashMap localHashMap = new HashMap();
        paramURI = new StringBuilder();
        paramURI.append(config.getDeviceId());
        paramURI.append("/");
        paramURI.append(config.getModuleId());
        localHashMap.put("x-ms-edge-moduleId", paramURI.toString());
        paramMethodRequest = send(paramMethodRequest, localHashMap);
        if ((paramMethodRequest.getStatus() != IotHubStatusCode.OK) && (paramMethodRequest.getStatus() != IotHubStatusCode.OK_EMPTY)) {
          throw IotHubStatusCode.getConnectionStatusException(paramMethodRequest.getStatus(), new String(paramMethodRequest.getBytes()));
        }
        return new MethodResult(new String(paramMethodRequest.getBytes()));
      }
      throw new IllegalArgumentException("uri cannot be null or be an empty path");
    }
    throw new IllegalArgumentException("direct method request cannot be null");
  }
  
  public void close()
  {
    httpsIotHubConnection = null;
  }
  
  public MethodResult invokeMethod(MethodRequest paramMethodRequest, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      paramString1 = getModuleMethodUri(paramString1, paramString2);
    } else {
      paramString1 = getDeviceMethodUri(paramString1);
    }
    return invokeMethod(paramMethodRequest, paramString1);
  }
  
  public void open()
  {
    httpsIotHubConnection = new HttpsIotHubConnection(config);
  }
  
  public void open(String[] paramArrayOfString)
  {
    httpsIotHubConnection = new HttpsIotHubConnection(config);
  }
  
  public Message receive()
  {
    try
    {
      IotHubTransportMessage localIotHubTransportMessage = httpsIotHubConnection.receiveMessage();
      return localIotHubTransportMessage;
    }
    catch (TransportException localTransportException)
    {
      throw new IOException(localTransportException);
    }
  }
  
  public ResponseMessage send(IotHubTransportMessage paramIotHubTransportMessage, Map<String, String> paramMap)
  {
    HttpsSingleMessage localHttpsSingleMessage = HttpsSingleMessage.parseHttpsJsonMessage(paramIotHubTransportMessage);
    if ((paramIotHubTransportMessage.getIotHubMethod() != null) && (paramIotHubTransportMessage.getUriPath() != null))
    {
      int i = paramIotHubTransportMessage.getIotHubMethod().ordinal();
      HttpsMethod localHttpsMethod;
      if (i != 0)
      {
        if (i == 1)
        {
          localHttpsMethod = HttpsMethod.POST;
        }
        else
        {
          paramMap = a.a("Unknown IoT Hub type ");
          paramMap.append(paramIotHubTransportMessage.getIotHubMethod().toString());
          throw new IllegalArgumentException(paramMap.toString());
        }
      }
      else {
        localHttpsMethod = HttpsMethod.GET;
      }
      paramIotHubTransportMessage = paramIotHubTransportMessage.getUriPath();
      try
      {
        paramIotHubTransportMessage = httpsIotHubConnection.sendHttpsMessage(localHttpsSingleMessage, localHttpsMethod, paramIotHubTransportMessage, paramMap);
        return paramIotHubTransportMessage;
      }
      catch (TransportException paramIotHubTransportMessage)
      {
        throw new IOException(paramIotHubTransportMessage);
      }
    }
    throw new IllegalArgumentException("method or path is null");
  }
  
  public ResponseMessage sendFileUploadMessage(IotHubTransportMessage paramIotHubTransportMessage)
  {
    paramIotHubTransportMessage.setUriPath(new IotHubUri("", config.getDeviceId(), "/files", config.getModuleId()).toStringWithoutApiVersion());
    return send(paramIotHubTransportMessage, new HashMap());
  }
  
  public ResponseMessage sendFileUploadNotification(IotHubTransportMessage paramIotHubTransportMessage)
  {
    paramIotHubTransportMessage.setUriPath(new IotHubUri("", config.getDeviceId(), "/files/notifications", config.getModuleId()).toStringWithoutApiVersion());
    return send(paramIotHubTransportMessage, new HashMap());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.https.HttpsTransportManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */