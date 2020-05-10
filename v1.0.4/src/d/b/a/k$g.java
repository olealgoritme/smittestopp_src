package d.b.a;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

public abstract class k$g
{
  public BroadcastReceiver a;
  
  public k$g(k paramk) {}
  
  public void a()
  {
    BroadcastReceiver localBroadcastReceiver = a;
    if (localBroadcastReceiver != null) {}
    try
    {
      b.A.unregisterReceiver(localBroadcastReceiver);
      a = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public abstract IntentFilter b();
  
  public abstract int c();
  
  public abstract void d();
  
  public void e()
  {
    a();
    IntentFilter localIntentFilter = b();
    if ((localIntentFilter != null) && (localIntentFilter.countActions() != 0))
    {
      if (a == null) {
        a = new k.g.a(this);
      }
      b.A.registerReceiver(a, localIntentFilter);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */