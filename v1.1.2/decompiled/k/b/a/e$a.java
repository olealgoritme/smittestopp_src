package k.b.a;

import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import i.o.g;
import java.util.List;

public final class e$a
  implements MessageCallback
{
  public IotHubMessageResult execute(Message paramMessage, Object paramObject)
  {
    if (paramMessage != null) {
      paramMessage = paramMessage.getProperty("versionAndroid");
    } else {
      paramMessage = null;
    }
    if (paramMessage == null) {
      return IotHubMessageResult.ABANDON;
    }
    if (g.a(paramMessage, new String[] { "." }, false, 0, 6).size() == 3)
    {
      a.f = paramMessage;
      return IotHubMessageResult.COMPLETE;
    }
    return IotHubMessageResult.ABANDON;
  }
}

/* Location:
 * Qualified Name:     k.b.a.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */