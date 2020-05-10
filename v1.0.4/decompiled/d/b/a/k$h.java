package d.b.a;

import android.content.IntentFilter;
import android.location.Location;
import android.util.Log;

import java.util.Calendar;

public class k$h
  extends k.g
{
  public final u c;
  
  public k$h(k paramk, u paramu)
  {
    super(paramk);
    c = paramu;
  }
  
  public IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    return localIntentFilter;
  }
  
  public int c()
  {
    u localu = c;
    u.a locala = c;
    long l1 = b;
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 1;
    if (l1 > l2) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      bool2 = a;
    }
    else
    {
      j = r.a(a, "android.permission.ACCESS_COARSE_LOCATION");
      Object localObject1 = null;
      Object localObject2;
      if (j == 0) {
        localObject2 = localu.a("network");
      } else {
        localObject2 = null;
      }
      if (r.a(a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localObject1 = localu.a("gps");
      }
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = localObject2;
        if (((Location)localObject1).getTime() <= ((Location)localObject2).getTime()) {
          break label156;
        }
      }
      else
      {
        localObject3 = localObject2;
        if (localObject1 == null) {
          break label156;
        }
      }
      Object localObject3 = localObject1;
      label156:
      if (localObject3 != null)
      {
        localObject2 = c;
        l2 = System.currentTimeMillis();
        if (t.d == null) {
          t.d = new t();
        }
        localObject1 = t.d;
        ((t)localObject1).a(l2 - 86400000L, ((Location)localObject3).getLatitude(), ((Location)localObject3).getLongitude());
        ((t)localObject1).a(l2, ((Location)localObject3).getLatitude(), ((Location)localObject3).getLongitude());
        if (c == 1) {
          bool2 = true;
        }
        long l3 = b;
        long l4 = a;
        ((t)localObject1).a(l2 + 86400000L, ((Location)localObject3).getLatitude(), ((Location)localObject3).getLongitude());
        l1 = b;
        if ((l3 != -1L) && (l4 != -1L))
        {
          if (l2 > l4) {
            l2 = l1 + 0L;
          } else if (l2 > l3) {
            l2 = l4 + 0L;
          } else {
            l2 = l3 + 0L;
          }
          l2 += 60000L;
        }
        else
        {
          l2 = 43200000L + l2;
        }
        a = bool2;
        b = l2;
        bool2 = a;
      }
      else
      {
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        j = Calendar.getInstance().get(11);
        if (j >= 6)
        {
          bool2 = bool1;
          if (j < 22) {}
        }
        else
        {
          bool2 = true;
        }
      }
    }
    int j = i;
    if (bool2) {
      j = 2;
    }
    return j;
  }
  
  public void d()
  {
    d.d();
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */