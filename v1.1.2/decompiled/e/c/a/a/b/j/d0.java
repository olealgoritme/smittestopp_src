package e.c.a.a.b.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import e.c.a.a.b.m.a;
import e.c.a.a.b.m.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d0
  implements ServiceConnection
{
  public final Set<ServiceConnection> a;
  public int b;
  public boolean c;
  public IBinder d;
  public final i.a e;
  public ComponentName f;
  
  public d0(c0 paramc0, i.a parama)
  {
    e = parama;
    a = new HashSet();
    b = 2;
  }
  
  public final void a(String paramString)
  {
    b = 3;
    paramString = g;
    Object localObject1 = f;
    Object localObject2 = d;
    paramString = e.a();
    int i = e.d;
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = paramString.getComponent();
      bool = false;
      if (localObject1 != null)
      {
        localObject1 = ((ComponentName)localObject1).getPackageName();
        "com.google.android.gms".equals(localObject1);
      }
    }
    try
    {
      j = ba.getPackageManager().getApplicationInfo((String)localObject1, 0).flags;
      if ((j & 0x200000) != 0) {
        j = 1;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      int j;
      for (;;) {}
    }
    j = 0;
    if (j != 0) {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
    } else {
      bool = ((Context)localObject2).bindService(paramString, this, i);
    }
    c = bool;
    if (bool)
    {
      localObject2 = g.e.obtainMessage(1, e);
      paramString = g;
      e.sendMessageDelayed((Message)localObject2, h);
      return;
    }
    b = 2;
    try
    {
      localObject2 = g.f;
      paramString = g.d;
      if (localObject2 != null)
      {
        paramString.unbindService(this);
        return;
      }
      throw null;
    }
    catch (IllegalArgumentException paramString)
    {
      return;
    }
    throw null;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (g.c)
    {
      g.e.removeMessages(1, e);
      d = paramIBinder;
      f = paramComponentName;
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
      b = 1;
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (g.c)
    {
      g.e.removeMessages(1, e);
      d = null;
      f = paramComponentName;
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
      b = 2;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.d0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */