package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import k.a.b.a.b.f;
import k.a.b.a.b.k.d;
import k.a.b.a.b.k.m;
import k.a.b.a.f.d.a;

public final class AmqpsDeviceTelemetry
  extends AmqpsDeviceOperations
{
  public static final String CORRELATION_ID_KEY = "com.microsoft:channel-correlation-id";
  public static final String RECEIVER_LINK_ENDPOINT_PATH_DEVICES = "/devices/%s/messages/devicebound";
  public static final String RECEIVER_LINK_ENDPOINT_PATH_MODULES = "/devices/%s/modules/%s/messages/devicebound";
  public static final String RECEIVER_LINK_ENDPOINT_PATH_MODULES_EDGEHUB = "/devices/%s/modules/%s/messages/events";
  public static final String RECEIVER_LINK_TAG_PREFIX = "receiver_link_telemetry-";
  public static final String SENDER_LINK_ENDPOINT_PATH_DEVICES = "/devices/%s/messages/events";
  public static final String SENDER_LINK_ENDPOINT_PATH_MODULES = "/devices/%s/modules/%s/messages/events";
  public static final String SENDER_LINK_TAG_PREFIX = "sender_link_telemetry-";
  public DeviceClientConfig deviceClientConfig;
  
  public AmqpsDeviceTelemetry(DeviceClientConfig paramDeviceClientConfig)
  {
    super(paramDeviceClientConfig, "/devices/%s/messages/events", "/devices/%s/messages/devicebound", "/devices/%s/modules/%s/messages/events", (String)localObject, "sender_link_telemetry-", "receiver_link_telemetry-");
    deviceClientConfig = paramDeviceClientConfig;
    String str = paramDeviceClientConfig.getModuleId();
    if ((str != null) && (!str.isEmpty()))
    {
      localObject = amqpProperties;
      f localf = f.a("com.microsoft:channel-correlation-id");
      paramDeviceClientConfig = new StringBuilder();
      paramDeviceClientConfig.append(deviceClientConfig.getDeviceId());
      paramDeviceClientConfig.append("/");
      paramDeviceClientConfig.append(str);
      ((Map)localObject).put(localf, f.a(paramDeviceClientConfig.toString()));
    }
    else
    {
      amqpProperties.put(f.a("com.microsoft:channel-correlation-id"), f.a(deviceClientConfig.getDeviceId()));
    }
  }
  
  public AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig)
  {
    if (((paramAmqpsMessage.getAmqpsMessageType() == null) || (paramAmqpsMessage.getAmqpsMessageType() == MessageType.DEVICE_TELEMETRY)) && (deviceClientConfig.getDeviceId().equals(paramDeviceClientConfig.getDeviceId())))
    {
      paramAmqpsMessage = protonMessageToIoTHubMessage(paramAmqpsMessage);
      return new AmqpsConvertFromProtonReturnValue(paramAmqpsMessage, paramDeviceClientConfig.getDeviceTelemetryMessageCallback(paramAmqpsMessage.getInputName()), paramDeviceClientConfig.getDeviceTelemetryMessageContext(paramAmqpsMessage.getInputName()));
    }
    return null;
  }
  
  public AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage)
  {
    if ((paramMessage.getMessageType() != null) && (paramMessage.getMessageType() != MessageType.DEVICE_TELEMETRY)) {
      return null;
    }
    return new AmqpsConvertToProtonReturnValue(iotHubMessageToProtonMessage(paramMessage), MessageType.DEVICE_TELEMETRY);
  }
  
  public String getLinkInstanceType()
  {
    return "telemetry";
  }
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    paramString = super.getMessageFromReceiverLink(paramString);
    if (paramString != null)
    {
      paramString.setAmqpsMessageType(MessageType.DEVICE_TELEMETRY);
      paramString.setDeviceClientConfig(deviceClientConfig);
    }
    return paramString;
  }
  
  public a iotHubMessageToProtonMessage(Message paramMessage)
  {
    a locala = super.iotHubMessageToProtonMessage(paramMessage);
    if ((paramMessage.getOutputName() != null) && (locala.getApplicationProperties() != null) && (getApplicationPropertiesa != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("iothub-outputname", paramMessage.getOutputName());
      localHashMap.putAll(getApplicationPropertiesa);
      locala.setApplicationProperties(new d(localHashMap));
    }
    return locala;
  }
  
  public IotHubTransportMessage protonMessageToIoTHubMessage(a parama)
  {
    IotHubTransportMessage localIotHubTransportMessage = super.protonMessageToIoTHubMessage(parama);
    localIotHubTransportMessage.setMessageType(MessageType.DEVICE_TELEMETRY);
    localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_UNKNOWN);
    if ((parama.getMessageAnnotations() != null) && (getMessageAnnotationsa != null))
    {
      Iterator localIterator = getMessageAnnotationsa.entrySet().iterator();
      while (localIterator.hasNext())
      {
        parama = (Map.Entry)localIterator.next();
        if (getKeyx.equals("x-opt-input-name")) {
          localIotHubTransportMessage.setInputName(parama.getValue().toString());
        }
      }
    }
    return localIotHubTransportMessage;
  }
  
  public AmqpsSendReturnValue sendMessageAndGetDeliveryTag(MessageType paramMessageType, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    try
    {
      if (paramMessageType == MessageType.DEVICE_TELEMETRY)
      {
        paramMessageType = super.sendMessageAndGetDeliveryTag(paramMessageType, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
        return paramMessageType;
      }
      paramMessageType = new AmqpsSendReturnValue(false, -1);
      return paramMessageType;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceTelemetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */