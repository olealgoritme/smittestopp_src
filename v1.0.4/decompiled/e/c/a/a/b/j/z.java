package e.c.a.a.b.j;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.r;
import e.c.a.a.b.c;
import e.c.a.a.b.j.s.a;

public final class z
  extends a
{
  public static final Parcelable.Creator<z> CREATOR = new a0();
  public Bundle x;
  public c[] y;
  
  public z() {}
  
  public z(Bundle paramBundle, c[] paramArrayOfc)
  {
    x = paramBundle;
    y = paramArrayOfc;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    Bundle localBundle = x;
    if (localBundle != null)
    {
      int j = r.j(paramParcel, 1);
      paramParcel.writeBundle(localBundle);
      r.k(paramParcel, j);
    }
    r.a(paramParcel, 2, y, paramInt, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */