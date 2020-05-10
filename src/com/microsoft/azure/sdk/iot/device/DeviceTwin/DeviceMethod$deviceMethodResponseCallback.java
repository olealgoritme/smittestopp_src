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
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import k.f.b;

public final class DeviceMethod$deviceMethodResponseCallback
  implements MessageCallback
{
  public DeviceClientConfig nestedConfig = DeviceMethod.access$000(this$0);
  
  public DeviceMethod$deviceMethodResponseCallback(DeviceMethod paramDeviceMethod) {}
  
  public IotHubMessageResult execute(Message paramMessage, Object paramObject)
  {
    synchronized (DeviceMethod.access$100(this$0))
    {
      IotHubStatusCode localIotHubStatusCode = IotHubStatusCode.ERROR;
      paramObject = IotHubMessageResult.ABANDON;
      if (paramMessage.getMessageType() != MessageType.DEVICE_METHODS)
      {
        DeviceMethod.access$200().a("Unexpected message type received {}", paramMessage.getMessageType());
        DeviceMethod.access$400(this$0).execute(localIotHubStatusCode, DeviceMethod.access$300(this$0));
        paramMessage = IotHubMessageResult.ABANDON;
        return paramMessage;
      }
      Object localObject = (IotHubTransportMessage)paramMessage;
      if (((IotHubTransportMessage)localObject).getDeviceOperationType().ordinal() != 10)
      {
        DeviceMethod.access$200().d("Received unknown type message for device methods");
        paramMessage = (Message)paramObject;
      }
      else
      {
        if (DeviceMethod.access$500(this$0) != null)
        {
          if (!DeviceMethod.access$600(this$0)) {
            DeviceMethod.access$602(this$0, true);
          }
          try
          {
            DeviceMethod.access$200().e("Executing method invocation callback for method name {} for message {}", ((IotHubTransportMessage)localObject).getMethodName(), localObject);
            paramObject = DeviceMethod.access$500(this$0).call(((IotHubTransportMessage)localObject).getMethodName(), ((Message)localObject).getBytes(), DeviceMethod.access$700(this$0));
            DeviceMethod.access$200().e("Method invocation callback returned for method name {} for message {}", ((IotHubTransportMessage)localObject).getMethodName(), localObject);
            if (paramObject != null)
            {
              MethodParser localMethodParser = new com/microsoft/azure/sdk/iot/deps/serializer/MethodParser;
              localMethodParser.<init>(((DeviceMethodData)paramObject).getResponseMessage());
              paramMessage = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
              paramMessage.<init>(localMethodParser.toJson().getBytes(), MessageType.DEVICE_METHODS);
              paramMessage.setRequestId(((IotHubTransportMessage)localObject).getRequestId());
              paramMessage.setConnectionDeviceId(nestedConfig.getDeviceId());
              paramMessage.setStatus(String.valueOf(((DeviceMethodData)paramObject).getStatus()));
              paramMessage.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_METHOD_SEND_RESPONSE);
              paramObject = DeviceMethod.access$900(this$0);
              localObject = new com/microsoft/azure/sdk/iot/device/DeviceTwin/DeviceMethod$deviceMethodRequestMessageCallback;
              ((DeviceMethod.deviceMethodRequestMessageCallback)localObject).<init>(this$0, null);
              ((DeviceIO)paramObject).sendEventAsync(paramMessage, (IotHubEventCallback)localObject, null, nestedConfig.getDeviceId());
              paramMessage = IotHubMessageResult.COMPLETE;
            }
            else
            {
              DeviceMethod.access$200().c("User callback did not send any data for response");
              paramMessage = IotHubMessageResult.REJECT;
              DeviceMethod.access$400(this$0).execute(localIotHubStatusCode, DeviceMethod.access$300(this$0));
            }
          }
          catch (Exception paramMessage)
          {
            DeviceMethod.access$200().c("User callback did not succeed");
            paramMessage = IotHubMessageResult.REJECT;
            DeviceMethod.access$400(this$0).execute(localIotHubStatusCode, DeviceMethod.access$300(this$0));
          }
        }
        DeviceMethod.access$200().d("Received device method request, but device has not setup device method");
        paramMessage = (Message)paramObject;
      }
      return paramMessage;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethod.deviceMethodResponseCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */