package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException.IotHubService;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import l.f.c;

public class MqttDeviceMethod
  extends Mqtt
{
  public static final l.f.b log = c.a(MqttDeviceMethod.class);
  public final String BACKSLASH = "/";
  public final String METHOD = "$iothub/methods/";
  public final int METHOD_TOKEN = 3;
  public final String POST = "$iothub/methods/POST";
  public final int POST_TOKEN = 2;
  public final String POUND = "#";
  public final String QUESTION = "?";
  public final int REQID_TOKEN = 4;
  public final String REQ_ID = "?$rid=";
  public final String RES = "$iothub/methods/res";
  public boolean isStarted = false;
  public final Map<String, DeviceOperations> requestMap = new HashMap();
  public String responseTopic = "$iothub/methods/res";
  public String subscribeTopic = "$iothub/methods/POST/#";
  
  public MqttDeviceMethod(MqttConnection paramMqttConnection, String paramString, Map<Integer, Message> paramMap)
  {
    super(paramMqttConnection, null, null, paramString, paramMap);
  }
  
  private void throwMethodsTransportException(Exception paramException)
  {
    paramException = new TransportException(paramException);
    paramException.setIotHubService(TransportException.IotHubService.METHODS);
    throw paramException;
  }
  
  private void throwMethodsTransportException(String paramString)
  {
    paramString = new TransportException(paramString);
    paramString.setIotHubService(TransportException.IotHubService.METHODS);
    throw paramString;
  }
  
  public IotHubTransportMessage receive()
  {
    Object localObject1 = incomingLock;
    Object localObject2 = null;
    try
    {
      Object localObject3 = peekMessage();
      Object localObject4 = localObject2;
      if (localObject3 != null)
      {
        String str = (String)((l.a.a.b.e.b)localObject3).getKey();
        localObject4 = localObject2;
        if (str != null)
        {
          localObject4 = localObject2;
          if (str.length() > 0)
          {
            localObject3 = (byte[])((l.a.a.b.e.b)localObject3).getValue();
            localObject4 = localObject2;
            if (str.length() > 16)
            {
              localObject4 = localObject2;
              if (str.startsWith("$iothub/methods/"))
              {
                localObject4 = localObject2;
                if (str.length() > 20)
                {
                  localObject4 = localObject2;
                  if (str.startsWith("$iothub/methods/POST"))
                  {
                    allReceivedMessages.poll();
                    localObject2 = new com/microsoft/azure/sdk/iot/device/transport/mqtt/TopicParser;
                    ((TopicParser)localObject2).<init>(str);
                    if ((localObject3 != null) && (localObject3.length > 0))
                    {
                      localObject4 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
                      ((IotHubTransportMessage)localObject4).<init>((byte[])localObject3, MessageType.DEVICE_METHODS);
                    }
                    else
                    {
                      localObject4 = MessageType.DEVICE_METHODS;
                      localObject4 = new IotHubTransportMessage(new byte[0], (MessageType)localObject4);
                    }
                    ((IotHubTransportMessage)localObject4).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_UNKNOWN);
                    ((IotHubTransportMessage)localObject4).setMethodName(((TopicParser)localObject2).getMethodName(3));
                    localObject2 = ((TopicParser)localObject2).getRequestId(4);
                    if (localObject2 != null)
                    {
                      ((IotHubTransportMessage)localObject4).setRequestId((String)localObject2);
                      ((IotHubTransportMessage)localObject4).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_METHOD_RECEIVE_REQUEST);
                      requestMap.put(localObject2, DeviceOperations.DEVICE_OPERATION_METHOD_RECEIVE_REQUEST);
                    }
                    else
                    {
                      throwMethodsTransportException("Request ID cannot be null");
                    }
                  }
                }
              }
            }
          }
        }
      }
      return (IotHubTransportMessage)localObject4;
    }
    finally {}
  }
  
  public void send(IotHubTransportMessage paramIotHubTransportMessage)
  {
    if ((paramIotHubTransportMessage != null) && (paramIotHubTransportMessage.getBytes() != null))
    {
      if (!isStarted) {
        throwMethodsTransportException("Start device method before using send");
      }
      if (paramIotHubTransportMessage.getMessageType() != MessageType.DEVICE_METHODS) {
        return;
      }
      int i = paramIotHubTransportMessage.getDeviceOperationType().ordinal();
      if (i != 8)
      {
        if (i != 11)
        {
          throwMethodsTransportException("Mismatched device method operation");
        }
        else if ((paramIotHubTransportMessage.getRequestId() != null) && (!paramIotHubTransportMessage.getRequestId().isEmpty()))
        {
          if (requestMap.containsKey(paramIotHubTransportMessage.getRequestId()))
          {
            if (((DeviceOperations)requestMap.remove(paramIotHubTransportMessage.getRequestId())).ordinal() != 10) {
              throwMethodsTransportException("Mismatched request and response operation");
            }
          }
          else {
            throwMethodsTransportException("Sending a response for the method that was never invoked");
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(responseTopic);
          localStringBuilder.append("/");
          localStringBuilder.append(paramIotHubTransportMessage.getStatus());
          localStringBuilder.append("/");
          localStringBuilder.append("?$rid=");
          localStringBuilder.append(paramIotHubTransportMessage.getRequestId());
          publish(localStringBuilder.toString(), paramIotHubTransportMessage);
        }
        else
        {
          throw new IllegalArgumentException("Request id cannot be null or empty");
        }
      }
      else {
        subscribe(subscribeTopic);
      }
      return;
    }
    throw new IllegalArgumentException("Message cannot be null");
  }
  
  public void start()
  {
    if (!isStarted) {
      isStarted = true;
    }
  }
  
  public void stop()
  {
    isStarted = false;
    if (!requestMap.isEmpty()) {
      log.d("Pending {} responses to be sent to IotHub yet unsubscribed", Integer.valueOf(requestMap.size()));
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.MqttDeviceMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */