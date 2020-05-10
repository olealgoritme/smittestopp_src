package e.c.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.r;
import e.c.a.a.b.j.p;
import e.c.a.a.b.j.s.a;

public final class i
  extends a
{
  public static final Parcelable.Creator<i> CREATOR = new j();
  public final int x;
  public final p y;
  
  public i(int paramInt, p paramp)
  {
    x = paramInt;
    y = paramp;
  }
  
  public i(p paramp)
  {
    x = 1;
    y = paramp;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y, paramInt, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.f.b.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */