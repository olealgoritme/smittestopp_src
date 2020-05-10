package no.simula.corona;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import k.b.a.a;

public final class MainActivity$c
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      paramIBinder = (a)paramIBinder;
      paramComponentName = a;
      paramIBinder = a;
      A = paramIBinder;
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
    paramComponentName = a.A;
    if (paramComponentName != null) {
      x = null;
    }
    paramComponentName = a;
    A = null;
    MainActivity.c(paramComponentName);
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.MainActivity.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */