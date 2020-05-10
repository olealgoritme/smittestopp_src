package e.c.a.a.d.c;

import android.os.Parcel;

public abstract class e
  extends p
  implements d
{
  public e()
  {
    super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }
  
  public final boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      a((b)u.a(paramParcel1, b.CREATOR));
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.d.c.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */