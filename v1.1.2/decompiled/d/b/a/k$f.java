package d.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public final class k$f
{
  public v a;
  public boolean b;
  public BroadcastReceiver c;
  public IntentFilter d;
  
  public k$f(k paramk, v paramv)
  {
    a = paramv;
    b = paramv.a();
  }
  
  public void a()
  {
    BroadcastReceiver localBroadcastReceiver = c;
    if (localBroadcastReceiver != null)
    {
      e.x.unregisterReceiver(localBroadcastReceiver);
      c = null;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */