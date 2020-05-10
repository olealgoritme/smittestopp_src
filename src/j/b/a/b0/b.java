package j.b.a.b0;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import l.a.a.b;

public final class b
  extends AdvertiseCallback
{
  public void onStartFailure(int paramInt)
  {
    String str = e.a.a.a.a.a("Failed to start with error code ", paramInt);
    l.a.a.d.b(str, new Object[0]);
  }
  
  public void onStartSuccess(AdvertiseSettings paramAdvertiseSettings)
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Started advertising with settings ");
    localStringBuilder.append(String.valueOf(paramAdvertiseSettings));
    paramAdvertiseSettings = localStringBuilder.toString();
    l.a.a.d.c(paramAdvertiseSettings, new Object[0]);
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.b0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */