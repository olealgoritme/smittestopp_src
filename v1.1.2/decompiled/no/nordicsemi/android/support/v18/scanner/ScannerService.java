package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k.a.a.a.a.a.a;
import k.a.a.a.a.a.f;
import k.a.a.a.a.a.g;
import k.a.a.a.a.a.h;
import k.a.a.a.a.a.k;

public class ScannerService
  extends Service
{
  public final Object x = new Object();
  public HashMap<PendingIntent, g> y;
  public Handler z;
  
  public final void a(PendingIntent paramPendingIntent)
  {
    synchronized (x)
    {
      paramPendingIntent = (g)y.remove(paramPendingIntent);
      boolean bool = y.isEmpty();
      if (paramPendingIntent == null) {
        return;
      }
      try
      {
        a.a().b(paramPendingIntent);
      }
      catch (Exception paramPendingIntent)
      {
        Log.w("ScannerService", "Stopping scanning failed", paramPendingIntent);
      }
      if (bool) {
        stopSelf();
      }
      return;
    }
  }
  
  public final void a(List<h> paramList, k paramk, PendingIntent paramPendingIntent)
  {
    f localf = new f(paramPendingIntent, paramk, this);
    synchronized (x)
    {
      y.put(paramPendingIntent, localf);
      try
      {
        a.a().a(paramList, paramk, localf, z);
      }
      catch (Exception paramList)
      {
        Log.w("ScannerService", "Starting scanning failed", paramList);
      }
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    y = new HashMap();
    z = new Handler();
  }
  
  public void onDestroy()
  {
    a locala = a.a();
    Iterator localIterator = y.values().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      try
      {
        locala.b(localg);
      }
      catch (Exception localException) {}
    }
    y.clear();
    y = null;
    z = null;
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT");
    boolean bool1 = paramIntent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_START", false);
    if (localPendingIntent == null) {
      synchronized (x)
      {
        bool1 = y.isEmpty();
        if (bool1) {
          stopSelf();
        }
        return 2;
      }
    }
    synchronized (x)
    {
      boolean bool2 = y.containsKey(localPendingIntent);
      if ((bool1) && (!bool2))
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
        ??? = (k)paramIntent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
        if (localArrayList != null) {
          paramIntent = localArrayList;
        } else {
          paramIntent = Collections.emptyList();
        }
        if (??? == null)
        {
          long l1;
          long l2;
          if ((0L == 0L) && (0L == 0L))
          {
            l1 = 500L;
            l2 = 4500L;
          }
          else
          {
            l1 = 0L;
            l2 = l1;
          }
          ??? = new k(0, 1, 0L, 1, 3, true, 255, true, true, true, 10000L, 10000L, l1, l2, null);
        }
        a(paramIntent, (k)???, localPendingIntent);
      }
      else if (((bool1 ^ true)) && (bool2))
      {
        a(localPendingIntent);
      }
      return 2;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
  }
}

/* Location:
 * Qualified Name:     no.nordicsemi.android.support.v18.scanner.ScannerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */