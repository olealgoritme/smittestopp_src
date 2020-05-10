package no.simula.corona;

import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import java.util.List;
import m.a.a.b;

public final class DataCollectorService$a
  implements IotHubEventCallback
{
  public final String a;
  public final List<Long> b;
  
  public DataCollectorService$a(String paramString, List<Long> paramList) {}
  
  public void execute(IotHubStatusCode paramIotHubStatusCode, Object paramObject)
  {
    if (paramIotHubStatusCode != null)
    {
      int i = paramIotHubStatusCode.ordinal();
      if ((i == 0) || (i == 1)) {
        break label90;
      }
      if (i == 5) {}
    }
    else
    {
      paramObject = e.a.a.a.a.a("Uploaded failed because ");
      if (paramIotHubStatusCode != null)
      {
        paramIotHubStatusCode = paramIotHubStatusCode.name();
        if (paramIotHubStatusCode != null) {}
      }
      else
      {
        paramIotHubStatusCode = "N/A";
      }
      ((StringBuilder)paramObject).append(paramIotHubStatusCode);
      paramIotHubStatusCode = ((StringBuilder)paramObject).toString();
      Analytics.trackEvent(paramIotHubStatusCode);
      m.a.a.d.b(paramIotHubStatusCode, new Object[0]);
      break label131;
    }
    DataCollectorService.a(c);
    break label131;
    label90:
    paramIotHubStatusCode = e.a.a.a.a.a(e.a.a.a.a.a("Uploaded "), a, " data, OK, OK_EMPTY");
    m.a.a.d.c(paramIotHubStatusCode, new Object[0]);
    DataCollectorService.a(c, a, b);
    label131:
    c.L = null;
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.DataCollectorService.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */