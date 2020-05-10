package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException.IotHubService;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import com.microsoft.azure.sdk.iot.device.transport.TransportUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import k.a.b.a.b.f;
import k.a.b.a.b.k.m;
import k.a.b.a.b.k.p;

public final class AmqpsDeviceTwin
  extends AmqpsDeviceOperations
{
  public static final String CORRELATION_ID_KEY = "com.microsoft:channel-correlation-id";
  public static final String CORRELATION_ID_KEY_PREFIX = "twin:";
  public static final String DEFAULT_STATUS_CODE = "200";
  public static final String MESSAGE_ANNOTATION_FIELD_KEY_OPERATION = "operation";
  public static final String MESSAGE_ANNOTATION_FIELD_KEY_RESOURCE = "resource";
  public static final String MESSAGE_ANNOTATION_FIELD_KEY_STATUS = "status";
  public static final String MESSAGE_ANNOTATION_FIELD_KEY_VERSION = "version";
  public static final String MESSAGE_ANNOTATION_FIELD_VALUE_DELETE = "DELETE";
  public static final String MESSAGE_ANNOTATION_FIELD_VALUE_GET = "GET";
  public static final String MESSAGE_ANNOTATION_FIELD_VALUE_NOTIFICATIONS_TWIN_PROPERTIES_DESIRED = "/notifications/twin/properties/desired";
  public static final String MESSAGE_ANNOTATION_FIELD_VALUE_PATCH = "PATCH";
  public static final String MESSAGE_ANNOTATION_FIELD_VALUE_PROPERTIES_DESIRED = "/properties/desired";
  public static final String MESSAGE_ANNOTATION_FIELD_VALUE_PROPERTIES_REPORTED = "/properties/reported";
  public static final String MESSAGE_ANNOTATION_FIELD_VALUE_PUT = "PUT";
  public static final String RECEIVER_LINK_ENDPOINT_PATH = "/devices/%s/twin";
  public static final String RECEIVER_LINK_ENDPOINT_PATH_MODULES = "/devices/%s/modules/%s/twin";
  public static final String RECEIVER_LINK_TAG_PREFIX = "receiver_link_devicetwin-";
  public static final String SENDER_LINK_ENDPOINT_PATH = "/devices/%s/twin";
  public static final String SENDER_LINK_ENDPOINT_PATH_MODULES = "/devices/%s/modules/%s/twin";
  public static final String SENDER_LINK_TAG_PREFIX = "sender_link_devicetwin-";
  public Map<String, DeviceOperations> correlationIdList;
  public DeviceClientConfig deviceClientConfig;
  
  public AmqpsDeviceTwin(DeviceClientConfig paramDeviceClientConfig)
  {
    super(paramDeviceClientConfig, "/devices/%s/twin", "/devices/%s/twin", "/devices/%s/modules/%s/twin", "/devices/%s/modules/%s/twin", "sender_link_devicetwin-", "receiver_link_devicetwin-");
    deviceClientConfig = paramDeviceClientConfig;
    amqpProperties.put(f.a("com.microsoft:api-version"), TransportUtils.IOTHUB_API_VERSION);
    Map localMap = amqpProperties;
    f localf = f.a("com.microsoft:channel-correlation-id");
    paramDeviceClientConfig = e.a.a.a.a.a("twin:");
    paramDeviceClientConfig.append(UUID.randomUUID().toString());
    localMap.put(localf, f.a(paramDeviceClientConfig.toString()));
    correlationIdList = new HashMap();
  }
  
  public AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig)
  {
    if ((paramAmqpsMessage.getAmqpsMessageType() == MessageType.DEVICE_TWIN) && (deviceClientConfig.getDeviceId().equals(paramDeviceClientConfig.getDeviceId()))) {
      return new AmqpsConvertFromProtonReturnValue(protonMessageToIoTHubMessage(paramAmqpsMessage), paramDeviceClientConfig.getDeviceTwinMessageCallback(), paramDeviceClientConfig.getDeviceTwinMessageContext());
    }
    return null;
  }
  
  public AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage)
  {
    if (paramMessage.getMessageType() == MessageType.DEVICE_TWIN) {
      return new AmqpsConvertToProtonReturnValue(iotHubMessageToProtonMessage(paramMessage), MessageType.DEVICE_TWIN);
    }
    return null;
  }
  
  public String getLinkInstanceType()
  {
    return "twin";
  }
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    paramString = super.getMessageFromReceiverLink(paramString);
    if (paramString != null)
    {
      paramString.setAmqpsMessageType(MessageType.DEVICE_TWIN);
      paramString.setDeviceClientConfig(deviceClientConfig);
    }
    return paramString;
  }
  
  public k.a.b.a.f.d.a iotHubMessageToProtonMessage(Message paramMessage)
  {
    k.a.b.a.f.d.a locala = super.iotHubMessageToProtonMessage(paramMessage);
    IotHubTransportMessage localIotHubTransportMessage = (IotHubTransportMessage)paramMessage;
    if (localIotHubTransportMessage.getCorrelationId() != null)
    {
      getPropertiesf = UUID.fromString(localIotHubTransportMessage.getCorrelationId());
      correlationIdList.put(localIotHubTransportMessage.getCorrelationId(), localIotHubTransportMessage.getDeviceOperationType());
    }
    paramMessage = new HashMap();
    int i = localIotHubTransportMessage.getDeviceOperationType().ordinal();
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            TransportUtils.throwTransportExceptionWithIotHubServiceType("Invalid device operation type in iotHubMessageToProtonMessage!", TransportException.IotHubService.TWIN);
          }
          else
          {
            paramMessage.put(f.a("operation"), "DELETE");
            paramMessage.put(f.a("resource"), "/notifications/twin/properties/desired");
          }
        }
        else
        {
          paramMessage.put(f.a("operation"), "PUT");
          paramMessage.put(f.a("resource"), "/notifications/twin/properties/desired");
        }
      }
      else
      {
        paramMessage.put(f.a("operation"), "PATCH");
        paramMessage.put(f.a("resource"), "/properties/reported");
        if (localIotHubTransportMessage.getVersion() != null) {
          try
          {
            paramMessage.put(f.a("version"), Long.valueOf(Long.parseLong(localIotHubTransportMessage.getVersion())));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            TransportUtils.throwTransportExceptionWithIotHubServiceType(localNumberFormatException, TransportException.IotHubService.TWIN);
          }
        }
      }
    }
    else {
      paramMessage.put(f.a("operation"), "GET");
    }
    if ((locala.getMessageAnnotations() != null) && (getMessageAnnotationsa != null)) {
      paramMessage.putAll(getMessageAnnotationsa);
    }
    locala.setMessageAnnotations(new m(paramMessage));
    return locala;
  }
  
  public IotHubTransportMessage protonMessageToIoTHubMessage(k.a.b.a.f.d.a parama)
  {
    IotHubTransportMessage localIotHubTransportMessage = super.protonMessageToIoTHubMessage(parama);
    localIotHubTransportMessage.setMessageType(MessageType.DEVICE_TWIN);
    localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_UNKNOWN);
    Object localObject1 = parama.getMessageAnnotations();
    if (localObject1 != null)
    {
      Iterator localIterator = a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        localObject1 = (f)((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        if (x.equals("status")) {
          localIotHubTransportMessage.setStatus(localObject2.toString());
        } else if (x.equals("version")) {
          localIotHubTransportMessage.setVersion(localObject2.toString());
        } else if ((x.equals("resource")) && (localObject2.toString().equals("/properties/desired"))) {
          localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_RESPONSE);
        }
      }
    }
    parama = parama.getProperties();
    if (parama != null)
    {
      localObject1 = f;
      if (localObject1 != null)
      {
        localIotHubTransportMessage.setCorrelationId(localObject1.toString());
        if (!correlationIdList.containsKey(f.toString())) {
          return localIotHubTransportMessage;
        }
        int i = ((DeviceOperations)correlationIdList.get(f.toString())).ordinal();
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i != 6) {
                TransportUtils.throwTransportExceptionWithIotHubServiceType("Invalid device operation type in protonMessageToIoTHubMessage!", TransportException.IotHubService.TWIN);
              } else {
                localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_RESPONSE);
              }
            }
            else {
              localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_RESPONSE);
            }
          }
          else {
            localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_UPDATE_REPORTED_PROPERTIES_RESPONSE);
          }
        }
        else {
          localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_GET_RESPONSE);
        }
        correlationIdList.remove(f.toString());
        return localIotHubTransportMessage;
      }
    }
    if (localIotHubTransportMessage.getDeviceOperationType() == DeviceOperations.DEVICE_OPERATION_UNKNOWN)
    {
      localIotHubTransportMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_RESPONSE);
      if ((localIotHubTransportMessage.getStatus() == null) || (localIotHubTransportMessage.getStatus().isEmpty())) {
        localIotHubTransportMessage.setStatus("200");
      }
    }
    return localIotHubTransportMessage;
  }
  
  public AmqpsSendReturnValue sendMessageAndGetDeliveryTag(MessageType paramMessageType, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    try
    {
      if (paramMessageType == MessageType.DEVICE_TWIN)
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
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceTwin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */