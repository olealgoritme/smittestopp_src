package e.c.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.s;
import e.c.a.a.b.j.q;

public final class k
  extends e.c.a.a.b.j.s.a
{
  public static final Parcelable.Creator<k> CREATOR = new l();
  public final int x;
  public final e.c.a.a.b.a y;
  public final q z;
  
  public k()
  {
    x = 1;
    y = locala;
    z = null;
  }
  
  public k(int paramInt, e.c.a.a.b.a parama, q paramq)
  {
    x = paramInt;
    y = parama;
    z = paramq;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y, paramInt, false);
    s.a(paramParcel, 3, z, paramInt, false);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.f.b.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */