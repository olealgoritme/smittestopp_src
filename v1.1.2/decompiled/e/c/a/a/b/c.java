package e.c.a.a.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.s;
import e.c.a.a.b.j.s.a;
import java.util.Arrays;

public class c
  extends a
{
  public static final Parcelable.Creator<c> CREATOR = new o();
  public final String x;
  @Deprecated
  public final int y;
  public final long z;
  
  public c(String paramString, int paramInt, long paramLong)
  {
    x = paramString;
    y = paramInt;
    z = paramLong;
  }
  
  public long b()
  {
    long l1 = z;
    long l2 = l1;
    if (l1 == -1L) {
      l2 = y;
    }
    return l2;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c))
    {
      c localc = (c)paramObject;
      paramObject = x;
      if (((paramObject != null) && (((String)paramObject).equals(x))) || ((x == null) && (x == null) && (b() == localc.b()))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { x, Long.valueOf(b()) });
  }
  
  public String toString()
  {
    e.c.a.a.b.j.o localo = s.c(this);
    localo.a("name", x);
    localo.a("version", Long.valueOf(b()));
    return localo.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = s.a(paramParcel);
    s.a(paramParcel, 1, x, false);
    s.a(paramParcel, 2, y);
    s.a(paramParcel, 3, b());
    s.k(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */