package e.c.a.a.b.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class b$j
  implements ServiceConnection
{
  public final int a;
  
  public b$j(b paramb, int paramInt)
  {
    a = paramInt;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      b.a(b);
      return;
    }
    synchronized (b.f)
    {
      b localb = b;
      paramComponentName = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if ((paramComponentName != null) && ((paramComponentName instanceof n))) {
        paramComponentName = (n)paramComponentName;
      } else {
        paramComponentName = new m(paramIBinder);
      }
      g = paramComponentName;
      paramIBinder = b;
      int i = a;
      paramComponentName = d;
      paramComponentName.sendMessage(paramComponentName.obtainMessage(7, i, -1, new b.l(paramIBinder, 0)));
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (b.f)
    {
      b.g = null;
      ??? = b.d;
      ???.sendMessage(???.obtainMessage(6, a, 1));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.b.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */