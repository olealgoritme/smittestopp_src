package no.simula.corona;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import j.b.a.d;

public final class MainActivity$c
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      paramIBinder = (d)paramIBinder;
      paramComponentName = a;
      paramIBinder = a;
      z = paramIBinder;
      if (paramIBinder != null) {
        x = paramComponentName;
      }
      if (!a.isFinishing()) {
        a.l();
      }
    }
    MainActivity.c(a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = a.z;
    if (paramComponentName != null) {
      x = null;
    }
    paramComponentName = a;
    z = null;
    MainActivity.c(paramComponentName);
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.MainActivity.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */