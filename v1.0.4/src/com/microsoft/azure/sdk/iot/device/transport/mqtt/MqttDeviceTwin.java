package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubServiceException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException.IotHubService;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;
import k.f.c;

public class MqttDeviceTwin
  extends Mqtt
{
  public static final k.f.b log = c.a(MqttDeviceTwin.class);
  public final String AND = "&";
  public final String BACKSLASH = "/";
  public final String DESIRED = "desired";
  public final int DESIRED_TOKEN = 4;
  public final String GET = "$iothub/twin/GET";
  public final String PATCH = "$iothub/twin/PATCH";
  public final int PATCH_TOKEN = 2;
  public final int PATCH_VERSION_TOKEN = 5;
  public final String POUND = "#";
  public final String PROPERTIES = "properties";
  public final int PROPERTIES_TOKEN = 3;
  public final String QUESTION = "?";
  public final String REPORTED = "reported";
  public final int REQID_TOKEN = 4;
  public final String REQ_ID = "?$rid=";
  public final String RES = "$iothub/twin/res";
  public final int RES_TOKEN = 2;
  public final int STATUS_TOKEN = 3;
  public final String TWIN = "$iothub/twin";
  public final String VERSION = "$version=";
  public final int VERSION_TOKEN = 4;
  public boolean isStarted = false;
  public final Map<String, DeviceOperations> requestMap = new HashMap();
  public String subscribeTopic = "$iothub/twin/res/#";
  
  public MqttDeviceTwin(MqttConnection paramMqttConnection, String paramString, Map<Integer, Message> paramMap)
  {
    super(paramMqttConnection, null, null, paramString, paramMap);
  }
  
  private String buildTopic(IotHubTransportMessage paramIotHubTransportMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramIotHubTransportMessage.getDeviceOperationType().ordinal();
    if (i != 0)
    {
      if (i != 2)
      {
        if (i == 4)
        {
          localStringBuilder.append("$iothub/twin/PATCH");
          localStringBuilder.append("/");
          localStringBuilder.append("properties");
          localStringBuilder.append("/");
          localStringBuilder.append("desired");
          paramIotHubTransportMessage = paramIotHubTransportMessage.getVersion();
          if (paramIotHubTransportMessage != null)
          {
            localStringBuilder.append("/");
            localStringBuilder.append("?");
            localStringBuilder.append("$version=");
            localStringBuilder.append(paramIotHubTransportMessage);
          }
        }
        else
        {
          localStringBuilder = a.a("Device Twin Operation is not supported - ");
          localStringBuilder.append(paramIotHubTransportMessage.getDeviceOperationType());
          throw new UnsupportedOperationException(localStringBuilder.toString());
        }
      }
      else
      {
        localStringBuilder.append("$iothub/twin/PATCH");
        localStringBuilder.append("/");
        localStringBuilder.append("properties");
        localStringBuilder.append("/");
        localStringBuilder.append("reported");
        String str = paramIotHubTransportMessage.getRequestId();
        if ((str != null) && (str.length() > 0))
        {
          localStringBuilder.append("/");
          localStringBuilder.append("?$rid=");
          localStringBuilder.append(paramIotHubTransportMessage.getRequestId());
          paramIotHubTransportMessage = paramIotHubTransportMessage.getVersion();
          if (paramIotHubTransportMessage != null)
          {
            localStringBuilder.append("&");
            localStringBuilder.append("$version=");
            localStringBuilder.append(paramIotHubTransportMessage);
          }
        }
        else
        {
          throw new IllegalArgumentException("Request Id is Mandatory");
        }
      }
    }
    else
    {
      localStringBuilder.append("$iothub/twin/GET");
      paramIotHubTransportMessage = paramIotHubTransportMessage.getRequestId();
      if ((paramIotHubTransportMessage == null) || (paramIotHubTransportMessage.length() <= 0)) {
        break label298;
      }
      localStringBuilder.append("/");
      localStringBuilder.append("?$rid=");
      localStringBuilder.append(paramIotHubTransportMessage);
    }
    return localStringBuilder.toString();
    label298:
    throw new IllegalArgumentException("Request Id is Mandatory");
  }
  
  private String getRequestId(String paramString)
  {
    if (paramString.contains("?$rid="))
    {
      int i = paramString.indexOf("?$rid=");
      int j = paramString.length();
      if (paramString.contains("$version=")) {
        j = paramString.indexOf("$version=") - 1;
      }
      paramString = paramString.substring(i + 6, j);
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
  
  private String getStatus(String paramString)
  {
    if ((paramString == null) || (!paramString.matches("\\d{3}")))
    {
      throwDeviceTwinTransportException("Status could not be parsed");
      paramString = null;
    }
    return paramString;
  }
  
  private String getVersion(String paramString)
  {
    if (paramString.contains("$version=")) {
      paramString = paramString.substring(paramString.indexOf("$version=") + 9, paramString.length());
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  private void throwDeviceTwinTransportException(Exception paramException)
  {
    paramException = new TransportException(paramException);
    paramException.setIotHubService(TransportException.IotHubService.TWIN);
    throw paramException;
  }
  
  private void throwDeviceTwinTransportException(String paramString)
  {
    paramString = new TransportException(paramString);
    paramString.setIotHubService(TransportException.IotHubService.TWIN);
    throw paramString;
  }
  
  public IotHubTransportMessage receive()
  {
    Object localObject1 = incomingLock;
    Object localObject2 = null;
    Object localObject3 = null;
    try
    {
      Object localObject4 = peekMessage();
      Object localObject5 = localObject2;
      if (localObject4 != null)
      {
        String str = (String)((k.a.a.b.e.b)localObject4).getKey();
        localObject5 = localObject2;
        if (str != null)
        {
          localObject5 = localObject2;
          if (str.length() > 0)
          {
            localObject5 = localObject2;
            if (str.length() > 12)
            {
              localObject5 = localObject2;
              if (str.startsWith("$iothub/twin"))
              {
                localObject4 = (byte[])((k.a.a.b.e.b)localObject4).getValue();
                allReceivedMessages.poll();
                if ((str.length() > 16) && (str.startsWith("$iothub/twin/res")))
                {
                  localObject2 = str.split(Pattern.quote("/"));
                  if ((localObject4 != null) && (localObject4.length > 0))
                  {
                    localObject5 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
                    ((IotHubTransportMessage)localObject5).<init>((byte[])localObject4, MessageType.DEVICE_TWIN);
                    ((IotHubTransportMessage)localObject5).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_UNKNOWN);
                  }
                  else
                  {
                    localObject5 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
                    localObject3 = MessageType.DEVICE_TWIN;
                    ((IotHubTransportMessage)localObject5).<init>(new byte[0], (MessageType)localObject3);
                    ((IotHubTransportMessage)localObject5).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_UNKNOWN);
                  }
                  if (localObject2.length > 3)
                  {
                    ((IotHubTransportMessage)localObject5).setStatus(getStatus(localObject2[3]));
                  }
                  else
                  {
                    localObject3 = new com/microsoft/azure/sdk/iot/device/exceptions/IotHubServiceException;
                    ((IotHubServiceException)localObject3).<init>("Message received without status");
                    throwDeviceTwinTransportException((Exception)localObject3);
                  }
                  if (localObject2.length > 4)
                  {
                    localObject3 = getRequestId(localObject2[4]);
                    ((IotHubTransportMessage)localObject5).setRequestId((String)localObject3);
                    if (requestMap.containsKey(localObject3))
                    {
                      int i = ((DeviceOperations)requestMap.remove(localObject3)).ordinal();
                      if (i != 0)
                      {
                        if (i != 2) {
                          ((IotHubTransportMessage)localObject5).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_UNKNOWN);
                        } else {
                          ((IotHubTransportMessage)localObject5).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_UPDATE_REPORTED_PROPERTIES_RESPONSE);
                        }
                      }
                      else {
                        ((IotHubTransportMessage)localObject5).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_GET_RESPONSE);
                      }
                    }
                    else
                    {
                      localObject3 = new java/lang/UnsupportedOperationException;
                      ((UnsupportedOperationException)localObject3).<init>("Request Id is mandatory");
                      throwDeviceTwinTransportException((Exception)localObject3);
                    }
                  }
                  if (localObject2.length > 4) {
                    ((IotHubTransportMessage)localObject5).setVersion(getVersion(localObject2[4]));
                  }
                }
                else if ((str.length() > 18) && (str.startsWith("$iothub/twin/PATCH")))
                {
                  if (str.startsWith("$iothub/twin/PATCH/properties/desired"))
                  {
                    if (localObject4 != null)
                    {
                      localObject2 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
                      ((IotHubTransportMessage)localObject2).<init>((byte[])localObject4, MessageType.DEVICE_TWIN);
                      ((IotHubTransportMessage)localObject2).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_RESPONSE);
                    }
                    else
                    {
                      localObject5 = new java/lang/UnsupportedOperationException;
                      ((UnsupportedOperationException)localObject5).<init>();
                      throwDeviceTwinTransportException((Exception)localObject5);
                      localObject2 = localObject3;
                    }
                    localObject3 = str.split(Pattern.quote("/"));
                    localObject5 = localObject2;
                    if (localObject3.length > 5)
                    {
                      localObject5 = localObject2;
                      if (localObject2 != null)
                      {
                        ((IotHubTransportMessage)localObject2).setVersion(getVersion(localObject3[5]));
                        localObject5 = localObject2;
                      }
                    }
                  }
                  else
                  {
                    localObject5 = new java/lang/UnsupportedOperationException;
                    ((UnsupportedOperationException)localObject5).<init>();
                    throwDeviceTwinTransportException((Exception)localObject5);
                    localObject5 = localObject2;
                  }
                }
                else
                {
                  localObject5 = new java/lang/UnsupportedOperationException;
                  ((UnsupportedOperationException)localObject5).<init>();
                  throwDeviceTwinTransportException((Exception)localObject5);
                  localObject5 = localObject2;
                }
              }
            }
          }
        }
      }
      return (IotHubTransportMessage)localObject5;
    }
    finally {}
  }
  
  public void send(IotHubTransportMessage paramIotHubTransportMessage)
  {
    if ((paramIotHubTransportMessage != null) && (paramIotHubTransportMessage.getBytes() != null))
    {
      if (isStarted)
      {
        if (paramIotHubTransportMessage.getMessageType() != MessageType.DEVICE_TWIN) {
          return;
        }
        String str = buildTopic(paramIotHubTransportMessage);
        requestMap.put(paramIotHubTransportMessage.getRequestId(), paramIotHubTransportMessage.getDeviceOperationType());
        if (paramIotHubTransportMessage.getDeviceOperationType() == DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST) {
          subscribe("$iothub/twin/PATCH/properties/desired/#");
        } else {
          publish(str, paramIotHubTransportMessage);
        }
        return;
      }
      throw new IllegalStateException("Start device twin before using it");
    }
    throw new IllegalArgumentException("Message cannot be null");
  }
  
  public void start()
  {
    if (!isStarted)
    {
      subscribe(subscribeTopic);
      isStarted = true;
    }
  }
  
  public void stop()
  {
    isStarted = false;
    if (!requestMap.isEmpty()) {
      log.d("Pending {} responses from IotHub yet unsubscribed", Integer.valueOf(requestMap.size()));
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.MqttDeviceTwin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */