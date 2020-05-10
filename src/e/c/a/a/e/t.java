package e.c.a.a.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import e.c.a.a.d.c.a;
import e.c.a.a.d.c.u;

public final class t
  extends a
  implements r
{
  public t(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.ILocationCallback");
  }
  
  public final void a(LocationAvailability paramLocationAvailability)
  {
    Parcel localParcel = c();
    u.a(localParcel, paramLocationAvailability);
    b(2, localParcel);
  }
  
  public final void a(LocationResult paramLocationResult)
  {
    Parcel localParcel = c();
    u.a(localParcel, paramLocationResult);
    b(1, localParcel);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.e.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */