package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import com.microsoft.azure.sdk.iot.device.transport.TransportUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import k.a.b.a.b.f;
import k.a.b.a.b.k.d;
import k.a.b.a.b.k.p;

public final class AmqpsDeviceMethods
  extends AmqpsDeviceOperations
{
  public static final String APPLICATION_PROPERTY_KEY_IOTHUB_METHOD_NAME = "IoThub-methodname";
  public static final String APPLICATION_PROPERTY_KEY_IOTHUB_STATUS = "IoThub-status";
  public static final String CORRELATION_ID_KEY = "com.microsoft:channel-correlation-id";
  public static final String CORRELATION_ID_KEY_PREFIX = "methods:";
  public static final String RECEIVER_LINK_ENDPOINT_PATH = "/devices/%s/methods/devicebound";
  public static final String RECEIVER_LINK_ENDPOINT_PATH_MODULES = "/devices/%s/modules/%s/methods/devicebound";
  public static final String RECEIVER_LINK_TAG_PREFIX = "receiver_link_devicemethods-";
  public static final String SENDER_LINK_ENDPOINT_PATH = "/devices/%s/methods/devicebound";
  public static final String SENDER_LINK_ENDPOINT_PATH_MODULES = "/devices/%s/modules/%s/methods/devicebound";
  public static final String SENDER_LINK_TAG_PREFIX = "sender_link_devicemethods-";
  public DeviceClientConfig deviceClientConfig;
  
  public AmqpsDeviceMethods(DeviceClientConfig paramDeviceClientConfig)
  {
    super(paramDeviceClientConfig, "/devices/%s/methods/devicebound", "/devices/%s/methods/devicebound", "/devices/%s/modules/%s/methods/devicebound", "/devices/%s/modules/%s/methods/devicebound", "sender_link_devicemethods-", "receiver_link_devicemethods-");
    deviceClientConfig = paramDeviceClientConfig;
    paramDeviceClientConfig = paramDeviceClientConfig.getModuleId();
    Object localObject1;
    Object localObject2;
    if ((paramDeviceClientConfig != null) && (!paramDeviceClientConfig.isEmpty()))
    {
      localObject1 = amqpProperties;
      paramDeviceClientConfig = f.a("com.microsoft:channel-correlation-id");
      localObject2 = e.a.a.a.a.a("methods:");
      ((StringBuilder)localObject2).append(UUID.randomUUID().toString());
      ((Map)localObject1).put(paramDeviceClientConfig, f.a(((StringBuilder)localObject2).toString()));
    }
    else
    {
      localObject2 = amqpProperties;
      paramDeviceClientConfig = f.a("com.microsoft:channel-correlation-id");
      localObject1 = e.a.a.a.a.a("methods:");
      ((StringBuilder)localObject1).append(UUID.randomUUID().toString());
      ((Map)localObject2).put(paramDeviceClientConfig, f.a(((StringBuilder)localObject1).toString()));
    }
    amqpProperties.put(f.a("com.microsoft:api-version"), TransportUtils.IOTHUB_API_VERSION);
  }
  
  public AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig)
  {
    if ((paramAmqpsMessage.getAmqpsMessageType() == MessageType.DEVICE_METHODS) && (deviceClientConfig.getDeviceId().equals(paramDeviceClientConfig.getDeviceId()))) {
      return new AmqpsConvertFromProtonReturnValue(protonMessageToIoTHubMessage(paramAmqpsMessage), paramDeviceClientConfig.getDeviceMethodsMessageCallback(), paramDeviceClientConfig.getDeviceMethodsMessageContext());
    }
    return null;
  }
  
  public AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage)
  {
    if (paramMessage.getMessageType() == MessageType.DEVICE_METHODS) {
      return new AmqpsConvertToProtonReturnValue(iotHubMessageToProtonMessage(paramMessage), MessageType.DEVICE_METHODS);
    }
    return null;
  }
  
  public String getLinkInstanceType()
  {
    return "methods";
  }
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    paramString = super.getMessageFromReceiverLink(paramString);
    if (paramString != null)
    {
      paramString.setAmqpsMessageType(MessageType.DEVICE_METHODS);
      paramString.setDeviceClientConfig(deviceClientConfig);
    }
    return paramString;
  }
  
  public k.a.b.a.f.d.a iotHubMessageToProtonMessage(Message paramMessage)
  {
    k.a.b.a.f.d.a locala = super.iotHubMessageToProtonMessage(paramMessage);
    IotHubTransportMessage localIotHubTransportMessage = (IotHubTransportMessage)paramMessage;
    if (locala.getProperties() != null) {
      paramMessage = locala.getProperties();
    } else {
      paramMessage = new p();
    }
    if (localIotHubTransportMessage.getRequestId() != null) {
      f = UUID.fromString(localIotHubTransportMessage.getRequestId());
    }
    locala.setProperties(paramMessage);
    paramMessage = new HashMap();
    if (localIotHubTransportMessage.getStatus() != null) {
      paramMessage.put("IoThub-status", Integer.valueOf(Integer.parseInt(localIotHubTransportMessage.getStatus())));
    }
    new HashMap();
    if ((locala.getApplicationProperties() != null) && (getApplicationPropertiesa != null)) {
      paramMessage.putAll(getApplicationPropertiesa);
    }
    locala.setApplicationProperties(new d(paramMessage));
    return locala;
  }
  
  public IotHubTransportMessage protonMessageToIoTHubMessage(k.a.b.a.f.d.a parama)
  {
    IotHubTransportMessage localIotHubTransportMessage = super.protonMessageToIoTHubMessage(parama);
    localIotHubTransportMessage.setMessageType(MessageType.DEVICE_METHODS);
    localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_METHOD_RECEIVE_REQUEST);
    if ((parama.getApplicationProperties() != null) && (getApplicationPropertiesa != null))
    {
      Map localMap = getApplicationPropertiesa;
      if (localMap.containsKey("IoThub-methodname")) {
        localIotHubTransportMessage.setMethodName(localMap.get("IoThub-methodname").toString());
      }
    }
    if ((parama.getProperties() != null) && (getPropertiesf != null)) {
      localIotHubTransportMessage.setRequestId(getPropertiesf.toString());
    }
    return localIotHubTransportMessage;
  }
  
  public AmqpsSendReturnValue sendMessageAndGetDeliveryTag(MessageType paramMessageType, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    try
    {
      if (paramMessageType == MessageType.DEVICE_METHODS)
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
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceMethods
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */