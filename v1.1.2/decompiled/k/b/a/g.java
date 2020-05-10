package k.b.a;

import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.RetryDecision;
import com.microsoft.azure.sdk.iot.device.transport.RetryPolicy;

public final class g
  implements RetryPolicy
{
  public static final g a = new g();
  
  public final RetryDecision getRetryDecision(int paramInt, TransportException paramTransportException)
  {
    Crashes.trackError(paramTransportException);
    return new RetryDecision(false, 10000L);
  }
}

/* Location:
 * Qualified Name:     k.b.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */