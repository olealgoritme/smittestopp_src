package e.c.a.a.f.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import d.b.a.s;
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
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y);
    s.a(paramParcel, 3, z, paramInt, false);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.f.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */