package e.c.a.a.d.c;

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
  public final Status x;
  
  static
  {
    new b(Status.B);
  }
  
  public b(Status paramStatus)
  {
    x = paramStatus;
  }
  
  public final Status a()
  {
    return x;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x, paramInt, false);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.d.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */