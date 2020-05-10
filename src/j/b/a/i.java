package j.b.a;

import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeCallback;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeReason;
import com.microsoft.azure.sdk.iot.device.transport.IotHubConnectionStatus;
import java.util.LinkedHashMap;
import java.util.Map;
import l.a.a.b;

public final class i
  implements IotHubConnectionStatusChangeCallback
{
  public i(h paramh) {}
  
  public final void execute(IotHubConnectionStatus paramIotHubConnectionStatus, IotHubConnectionStatusChangeReason paramIotHubConnectionStatusChangeReason, Throwable paramThrowable, Object paramObject)
  {
    if (paramThrowable != null)
    {
      paramObject = new LinkedHashMap();
      ((Map)paramObject).put("where", "IoTHubDevice::registerConnectionStatus");
      Crashes.trackError(paramThrowable, (Map)paramObject, null);
    }
    paramThrowable = a;
    e = false;
    boolean bool;
    if ((paramIotHubConnectionStatus == null) || (paramIotHubConnectionStatus.ordinal() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    c = bool;
    if (paramIotHubConnectionStatusChangeReason != null)
    {
      paramIotHubConnectionStatusChangeReason = paramIotHubConnectionStatusChangeReason.name();
      if (paramIotHubConnectionStatusChangeReason != null) {}
    }
    else
    {
      paramIotHubConnectionStatusChangeReason = "null";
    }
    if (paramIotHubConnectionStatus != null)
    {
      paramIotHubConnectionStatus = paramIotHubConnectionStatus.name();
      if (paramIotHubConnectionStatus != null) {}
    }
    else
    {
      paramIotHubConnectionStatus = "null-status";
    }
    paramIotHubConnectionStatus = e.a.a.a.a.a(paramIotHubConnectionStatus, " because ", paramIotHubConnectionStatusChangeReason);
    l.a.a.d.b(paramIotHubConnectionStatus, new Object[0]);
    Analytics.trackEvent(paramIotHubConnectionStatus);
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */