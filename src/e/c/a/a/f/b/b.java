package e.c.a.a.f.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import d.b.a.r;
import e.c.a.a.b.i.h;
import e.c.a.a.b.j.s.a;

public final class b
  extends a
  implements h
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  public final int x;
  public int y;
  public Intent z;
  
  public b()
  {
    x = 2;
    y = 0;
    z = null;
  }
  
  public b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    x = paramInt1;
    y = paramInt2;
    z = paramIntent;
  }
  
  public final Status a()
  {
    if (y == 0) {
      return Status.B;
    }
    return Status.D;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y);
    r.a(paramParcel, 3, z, paramInt, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.f.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */