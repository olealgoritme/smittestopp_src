package j.b.a;

import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.RetryDecision;
import com.microsoft.azure.sdk.iot.device.transport.RetryPolicy;

public final class j
  implements RetryPolicy
{
  public static final j a = new j();
  
  public final RetryDecision getRetryDecision(int paramInt, TransportException paramTransportException)
  {
    Crashes.trackError(paramTransportException);
    return new RetryDecision(false, 10000L);
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */