package e.c.a.a.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class p
  extends e.c.a.a.d.c.p
  implements o
{
  public static o a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
    if ((localIInterface instanceof o)) {
      return (o)localIInterface;
    }
    return new q(paramIBinder);
  }
  
  public final boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    throw new NoSuchMethodError();
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.e.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */