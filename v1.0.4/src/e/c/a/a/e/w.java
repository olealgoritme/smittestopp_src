package e.c.a.a.e;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import e.c.a.a.d.c.a;

public final class w
  extends a
  implements u
{
  public w(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.ILocationListener");
  }
  
  public final void a(Location paramLocation)
  {
    Parcel localParcel = c();
    e.c.a.a.d.c.u.a(localParcel, paramLocation);
    b(1, localParcel);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.e.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */