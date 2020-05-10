package d.b.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class u
{
  public static u d;
  public final Context a;
  public final LocationManager b;
  public final u.a c = new u.a();
  
  public u(Context paramContext, LocationManager paramLocationManager)
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
}

/* Location:
 * Qualified Name:     base.d.b.a.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */