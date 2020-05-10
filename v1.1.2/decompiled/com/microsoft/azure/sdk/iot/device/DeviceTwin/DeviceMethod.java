package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import com.microsoft.azure.sdk.iot.deps.serializer.MethodParser;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceIO;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.ObjectLock;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import l.f.b;
import l.f.c;

public final class DeviceMethod
{
  public static final b log = c.a(DeviceMethod.class);
  public final ObjectLock DEVICE_METHOD_LOCK = new ObjectLock();
  public DeviceClientConfig config;
  public DeviceIO deviceIO;
  public DeviceMethodCallback deviceMethodCallback;
  public Object deviceMethodCallbackContext;
  public IotHubEventCallback deviceMethodStatusCallback;
  public Object deviceMethodStatusCallbackContext;
  public boolean isSubscribed = false;
  
  public DeviceMethod(DeviceIO paramDeviceIO, DeviceClientConfig paramDeviceClientConfig, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    if ((paramDeviceIO != null) && (paramDeviceClientConfig != null))
    {
      if (paramIotHubEventCallback != null)
      {
        deviceIO = paramDeviceIO;
        config = paramDeviceClientConfig;
        deviceMethodStatusCallback = paramIotHubEventCallback;
        deviceMethodStatusCallbackContext = paramObject;
        paramDeviceClientConfig.setDeviceMethodsMessageCallback(new deviceMethodResponseCallback(null), null);
        return;
      }
      throw new IllegalArgumentException("Status call back cannot be null");
    }
    throw new IllegalArgumentException("Client or config cannot be null");
  }
  
  public void subscribeToDeviceMethod(DeviceMethodCallback paramDeviceMethodCallback, Object paramObject)
  {
    if (paramDeviceMethodCallback != null)
    {
      deviceMethodCallback = paramDeviceMethodCallback;
      deviceMethodCallbackContext = paramObject;
      if (!isSubscribed)
      {
        paramDeviceMethodCallback = MessageType.DEVICE_METHODS;
        paramDeviceMethodCallback = new IotHubTransportMessage(new byte[0], paramDeviceMethodCallback);
        paramDeviceMethodCallback.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST);
        paramDeviceMethodCallback.setConnectionDeviceId(config.getDeviceId());
        deviceIO.sendEventAsync(paramDeviceMethodCallback, new deviceMethodRequestMessageCallback(null), null, config.getDeviceId());
      }
      return;
    }
    throw new IllegalArgumentException("Callback cannot be null");
  }
  
  public final class deviceMethodRequestMessageCallback
    implements IotHubEventCallback
  {
    public deviceMethodRequestMessageCallback() {}
    
    public void execute(IotHubStatusCode paramIotHubStatusCode, Object paramObject)
    {
      if (DeviceMethod.access$400(DeviceMethod.this) != null) {
        DeviceMethod.access$400(DeviceMethod.this).execute(paramIotHubStatusCode, DeviceMethod.access$300(DeviceMethod.this));
      }
    }
  }
  
  public final class deviceMethodResponseCallback
    implements MessageCallback
  {
    public DeviceClientConfig nestedConfig = DeviceMethod.access$000(DeviceMethod.this);
    
    public deviceMethodResponseCallback() {}
    
    public IotHubMessageResult execute(Message paramMessage, Object paramObject)
    {
      synchronized (DeviceMethod.access$100(DeviceMethod.this))
      {
        IotHubStatusCode localIotHubStatusCode = IotHubStatusCode.ERROR;
        paramObject = IotHubMessageResult.ABANDON;
        if (paramMessage.getMessageType() != MessageType.DEVICE_METHODS)
        {
          DeviceMethod.access$200().a("Unexpected message type received {}", paramMessage.getMessageType());
          DeviceMethod.access$400(DeviceMethod.this).execute(localIotHubStatusCode, DeviceMethod.access$300(DeviceMethod.this));
          paramMessage = IotHubMessageResult.ABANDON;
          return paramMessage;
        }
        Object localObject = (IotHubTransportMessage)paramMessage;
        if (((IotHubTransportMessage)localObject).getDeviceOperationType().ordinal() != 10)
        {
          DeviceMethod.access$200().c("Received unknown type message for device methods");
          paramMessage = (Message)paramObject;
        }
        else
        {
          if (DeviceMethod.access$500(DeviceMethod.this) != null)
          {
            if (!DeviceMethod.access$600(DeviceMethod.this)) {
              DeviceMethod.access$602(DeviceMethod.this, true);
            }
            try
            {
              DeviceMethod.access$200().b("Executing method invocation callback for method name {} for message {}", ((IotHubTransportMessage)localObject).getMethodName(), localObject);
              DeviceMethodData localDeviceMethodData = DeviceMethod.access$500(DeviceMethod.this).call(((IotHubTransportMessage)localObject).getMethodName(), ((Message)localObject).getBytes(), DeviceMethod.access$700(DeviceMethod.this));
              DeviceMethod.access$200().b("Method invocation callback returned for method name {} for message {}", ((IotHubTransportMessage)localObject).getMethodName(), localObject);
              if (localDeviceMethodData != null)
              {
                paramObject = new com/microsoft/azure/sdk/iot/deps/serializer/MethodParser;
                ((MethodParser)paramObject).<init>(localDeviceMethodData.getResponseMessage());
                paramMessage = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
                paramMessage.<init>(((MethodParser)paramObject).toJson().getBytes(), MessageType.DEVICE_METHODS);
                paramMessage.setRequestId(((IotHubTransportMessage)localObject).getRequestId());
                paramMessage.setConnectionDeviceId(nestedConfig.getDeviceId());
                paramMessage.setStatus(String.valueOf(localDeviceMethodData.getStatus()));
                paramMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_METHOD_SEND_RESPONSE);
                localObject = DeviceMethod.access$900(DeviceMethod.this);
                paramObject = new com/microsoft/azure/sdk/iot/device/DeviceTwin/DeviceMethod$deviceMethodRequestMessageCallback;
                ((DeviceMethod.deviceMethodRequestMessageCallback)paramObject).<init>(DeviceMethod.this, null);
                ((DeviceIO)localObject).sendEventAsync(paramMessage, (IotHubEventCallback)paramObject, null, nestedConfig.getDeviceId());
                paramMessage = IotHubMessageResult.COMPLETE;
              }
              else
              {
                DeviceMethod.access$200().b("User callback did not send any data for response");
                paramMessage = IotHubMessageResult.REJECT;
                DeviceMethod.access$400(DeviceMethod.this).execute(localIotHubStatusCode, DeviceMethod.access$300(DeviceMethod.this));
              }
            }
            catch (Exception paramMessage)
            {
              DeviceMethod.access$200().b("User callback did not succeed");
              paramMessage = IotHubMessageResult.REJECT;
              DeviceMethod.access$400(DeviceMethod.this).execute(localIotHubStatusCode, DeviceMethod.access$300(DeviceMethod.this));
            }
          }
          DeviceMethod.access$200().c("Received device method request, but device has not setup device method");
          paramMessage = (Message)paramObject;
        }
        return paramMessage;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */