package e.c.a.a.e;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import e.c.a.a.d.c.p;

public abstract class v
  extends p
  implements u
{
  public static u a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
    if ((localIInterface instanceof u)) {
      return (u)localIInterface;
    }
    return new w(paramIBinder);
  }
  
  public final boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      a((Location)e.c.a.a.d.c.u.a(paramParcel1, Location.CREATOR));
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.e.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */