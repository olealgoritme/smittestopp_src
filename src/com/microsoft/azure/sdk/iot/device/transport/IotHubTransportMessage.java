package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.IotHubMethod;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import com.microsoft.azure.sdk.iot.device.MessageProperty;
import com.microsoft.azure.sdk.iot.device.MessageType;

public class IotHubTransportMessage
  extends Message
{
  public IotHubMethod iotHubMethod;
  public MessageCallback messageCallback;
  public Object messageCallbackContext;
  public String methodName;
  public DeviceOperations operationType;
  public String requestId;
  public String status;
  public String uriPath;
  public String version;
  
  public IotHubTransportMessage(String paramString)
  {
    super(paramString);
    super.setMessageType(MessageType.UNKNOWN);
    methodName = null;
    version = null;
    requestId = null;
    status = null;
    operationType = DeviceOperations.DEVICE_OPERATION_UNKNOWN;
  }
  
  public IotHubTransportMessage(byte[] paramArrayOfByte, MessageType paramMessageType)
  {
    super(paramArrayOfByte);
    super.setMessageType(paramMessageType);
    methodName = null;
    version = null;
    requestId = null;
    status = null;
    operationType = DeviceOperations.DEVICE_OPERATION_UNKNOWN;
  }
  
  public IotHubTransportMessage(byte[] paramArrayOfByte, MessageType paramMessageType, String paramString1, String paramString2, MessageProperty[] paramArrayOfMessageProperty)
  {
    super(paramArrayOfByte);
    super.setMessageType(paramMessageType);
    setMessageId(paramString1);
    setCorrelationId(paramString2);
    int i = paramArrayOfMessageProperty.length;
    for (int j = 0; j < i; j++)
    {
      paramArrayOfByte = paramArrayOfMessageProperty[j];
      setProperty(paramArrayOfByte.getName(), paramArrayOfByte.getValue());
    }
  }
  
  public DeviceOperations getDeviceOperationType()
  {
    return operationType;
  }
  
  public IotHubMethod getIotHubMethod()
  {
    return iotHubMethod;
  }
  
  public MessageCallback getMessageCallback()
  {
    return messageCallback;
  }
  
  public Object getMessageCallbackContext()
  {
    return messageCallbackContext;
  }
  
  public String getMethodName()
  {
    return methodName;
  }
  
  public String getRequestId()
  {
    return requestId;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getUriPath()
  {
    return uriPath;
  }
  
  public String getVersion()
  {
    return version;
  }
  
  public boolean isMessageAckNeeded(IotHubClientProtocol paramIotHubClientProtocol)
  {
    if ((paramIotHubClientProtocol == IotHubClientProtocol.MQTT) || (paramIotHubClientProtocol == IotHubClientProtocol.MQTT_WS)) {
      paramIotHubClientProtocol = operationType;
    }
    return (paramIotHubClientProtocol != DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST) && (paramIotHubClientProtocol != DeviceOperations.DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST) && (paramIotHubClientProtocol != DeviceOperations.DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_REQUEST);
  }
  
  public void setDeviceOperationType(DeviceOperations paramDeviceOperations)
  {
    operationType = paramDeviceOperations;
  }
  
  public void setIotHubMethod(IotHubMethod paramIotHubMethod)
  {
    iotHubMethod = paramIotHubMethod;
  }
  
  public void setMessageCallback(MessageCallback paramMessageCallback)
  {
    messageCallback = paramMessageCallback;
  }
  
  public void setMessageCallbackContext(Object paramObject)
  {
    messageCallbackContext = paramObject;
  }
  
  public void setMethodName(String paramString)
  {
    if (paramString != null)
    {
      methodName = paramString;
      return;
    }
    throw new IllegalArgumentException("Method name cannot be null");
  }
  
  public void setRequestId(String paramString)
  {
    requestId = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setUriPath(String paramString)
  {
    uriPath = paramString;
  }
  
  public void setVersion(String paramString)
  {
    version = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    String str = requestId;
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("Request Id [");
      localStringBuilder.append(requestId);
      localStringBuilder.append("] ");
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */