package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import com.microsoft.azure.sdk.iot.deps.twin.TwinState;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import java.io.PrintStream;
import k.f.b;

public final class DeviceTwin$deviceTwinResponseMessageCallback
  implements MessageCallback
{
  public DeviceTwin$deviceTwinResponseMessageCallback(DeviceTwin paramDeviceTwin) {}
  
  public IotHubMessageResult execute(Message paramMessage, Object paramObject)
  {
    synchronized (DeviceTwin.access$000(this$0))
    {
      paramObject = IotHubStatusCode.ERROR;
      if (paramMessage.getMessageType() != MessageType.DEVICE_TWIN)
      {
        System.out.print("Unexpected message type received");
        DeviceTwin.access$200(this$0).execute((IotHubStatusCode)paramObject, DeviceTwin.access$100(this$0));
        paramMessage = IotHubMessageResult.ABANDON;
        return paramMessage;
      }
      paramMessage = (IotHubTransportMessage)paramMessage;
      Object localObject2 = paramMessage.getStatus();
      int i = paramMessage.getDeviceOperationType().ordinal();
      if (i != 1)
      {
        if (i != 3)
        {
          if (i == 5)
          {
            DeviceTwin.access$602(this$0, true);
            paramObject = new java/lang/String;
            ((String)paramObject).<init>(paramMessage.getBytes(), Message.DEFAULT_IOTHUB_MESSAGE_CHARSET);
            paramMessage = TwinState.createFromDesiredPropertyJson((String)paramObject);
            if (paramMessage.getDesiredProperty() != null) {
              DeviceTwin.access$400(this$0, paramMessage.getDesiredProperty());
            }
          }
        }
        else
        {
          if (localObject2 != null) {
            paramObject = IotHubStatusCode.getIotHubStatusCode(Integer.parseInt((String)localObject2));
          }
          localObject2 = DeviceTwin.access$300();
          paramMessage = new java/lang/StringBuilder;
          paramMessage.<init>();
          paramMessage.append("Executing twin status callback for device operation twin update reported properties response with status ");
          paramMessage.append(paramObject);
          ((b)localObject2).e(paramMessage.toString());
          DeviceTwin.access$200(this$0).execute((IotHubStatusCode)paramObject, DeviceTwin.access$100(this$0));
        }
      }
      else
      {
        if (localObject2 != null) {
          paramObject = IotHubStatusCode.getIotHubStatusCode(Integer.parseInt((String)localObject2));
        }
        DeviceTwin.access$300().d("Executing twin callback for message {}", paramMessage);
        DeviceTwin.access$200(this$0).execute((IotHubStatusCode)paramObject, DeviceTwin.access$100(this$0));
        DeviceTwin.access$300().d("Twin callback returned for message {}", paramMessage);
        if (paramObject == IotHubStatusCode.OK)
        {
          paramObject = new java/lang/String;
          ((String)paramObject).<init>(paramMessage.getBytes(), Message.DEFAULT_IOTHUB_MESSAGE_CHARSET);
          paramMessage = TwinState.createFromPropertiesJson((String)paramObject);
          if (paramMessage.getDesiredProperty() != null) {
            DeviceTwin.access$400(this$0, paramMessage.getDesiredProperty());
          }
          if (paramMessage.getReportedProperty() != null) {
            DeviceTwin.access$500(this$0, paramMessage.getReportedProperty());
          }
        }
      }
      paramMessage = IotHubMessageResult.COMPLETE;
      return paramMessage;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceTwin.deviceTwinResponseMessageCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */