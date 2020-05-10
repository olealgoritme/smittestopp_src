package e.c.a.a.d.c;

import android.os.IBinder;
import android.os.Parcel;

public final class f
  extends a
  implements d
{
  public f(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }
  
  public final void a(b paramb)
  {
    Parcel localParcel = c();
    u.a(localParcel, paramb);
    b(1, localParcel);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.d.c.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */