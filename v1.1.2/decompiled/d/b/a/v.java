package d.b.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

public class v
{
  public static v d;
  public final Context a;
  public final LocationManager b;
  public final a c = new a();
  
  public v(Context paramContext, LocationManager paramLocationManager)
  {
    a = paramContext;
    b = paramLocationManager;
  }
  
  public final Location a(String paramString)
  {
    try
    {
      if (b.isProviderEnabled(paramString))
      {
        paramString = b.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.d("TwilightManager", "Failed to get last known location", paramString);
    }
    return null;
  }
  
  public boolean a()
  {
    a locala = c;
    long l1 = b;
    long l2 = System.currentTimeMillis();
    boolean bool1 = true;
    boolean bool2 = true;
    if (l1 > l2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return a;
    }
    int i = s.a(a, "android.permission.ACCESS_COARSE_LOCATION");
    Object localObject1 = null;
    Object localObject2;
    if (i == 0) {
      localObject2 = a("network");
    } else {
      localObject2 = null;
    }
    if (s.a(a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
      localObject1 = a("gps");
    }
    Object localObject3;
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject3 = localObject2;
      if (((Location)localObject1).getTime() <= ((Location)localObject2).getTime()) {}
    }
    else
    {
      do
      {
        localObject3 = localObject1;
        break;
        localObject3 = localObject2;
      } while (localObject1 != null);
    }
    if (localObject3 != null)
    {
      localObject2 = c;
      long l3 = System.currentTimeMillis();
      if (u.d == null) {
        u.d = new u();
      }
      localObject1 = u.d;
      ((u)localObject1).a(l3 - 86400000L, ((Location)localObject3).getLatitude(), ((Location)localObject3).getLongitude());
      ((u)localObject1).a(l3, ((Location)localObject3).getLatitude(), ((Location)localObject3).getLongitude());
      if (c != 1) {
        bool2 = false;
      }
      l2 = b;
      l1 = a;
      ((u)localObject1).a(l3 + 86400000L, ((Location)localObject3).getLatitude(), ((Location)localObject3).getLongitude());
      long l4 = b;
      if ((l2 != -1L) && (l1 != -1L))
      {
        if (l3 > l1) {
          l2 = l4 + 0L;
        } else if (l3 > l2) {
          l2 = l1 + 0L;
        } else {
          l2 += 0L;
        }
        l2 += 60000L;
      }
      else
      {
        l2 = l3 + 43200000L;
      }
      a = bool2;
      b = l2;
      return a;
    }
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    i = Calendar.getInstance().get(11);
    bool2 = bool1;
    if (i >= 6) {
      if (i >= 22) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public static class a
  {
    public boolean a;
    public long b;
  }
}

/* Location:
 * Qualified Name:     d.b.a.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */