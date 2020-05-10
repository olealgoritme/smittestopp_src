package e.c.a.a.b.j;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.s;

public class q
  extends e.c.a.a.b.j.s.a
{
  public static final Parcelable.Creator<q> CREATOR = new y();
  public boolean A;
  public boolean B;
  public final int x;
  public IBinder y;
  public e.c.a.a.b.a z;
  
  public q(int paramInt, IBinder paramIBinder, e.c.a.a.b.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    x = paramInt;
    y = paramIBinder;
    z = parama;
    A = paramBoolean1;
    B = paramBoolean2;
  }
  
  public k b()
  {
    return k.a.a(y);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof q)) {
      return false;
    }
    paramObject = (q)paramObject;
    return (z.equals(z)) && (b().equals(((q)paramObject).b()));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y, false);
    s.a(paramParcel, 3, z, paramInt, false);
    s.a(paramParcel, 4, A);
    s.a(paramParcel, 5, B);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */