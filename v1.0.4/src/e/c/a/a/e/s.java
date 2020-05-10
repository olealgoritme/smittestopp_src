package e.c.a.a.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import e.c.a.a.d.c.p;
import e.c.a.a.d.c.u;

public abstract class s
  extends p
  implements r
{
  public s()
  {
    super("com.google.android.gms.location.ILocationCallback");
  }
  
  public static r a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
    if ((localIInterface instanceof r)) {
      return (r)localIInterface;
    }
    return new t(paramIBinder);
  }
  
  public final boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      a((LocationAvailability)u.a(paramParcel1, LocationAvailability.CREATOR));
    }
    else
    {
      a((LocationResult)u.a(paramParcel1, LocationResult.CREATOR));
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.e.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */