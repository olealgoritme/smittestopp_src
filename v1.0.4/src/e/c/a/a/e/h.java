package e.c.a.a.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.r;
import e.c.a.a.b.j.s.a;
import java.util.Arrays;

public final class h
  extends a
{
  public static final Parcelable.Creator<h> CREATOR = new i();
  public final long A;
  public final int x;
  public final int y;
  public final long z;
  
  public h(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    x = paramInt1;
    y = paramInt2;
    z = paramLong1;
    A = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (h.class == paramObject.getClass()))
    {
      paramObject = (h)paramObject;
      if ((x == x) && (y == y) && (z == z) && (A == A)) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(y), Integer.valueOf(x), Long.valueOf(A), Long.valueOf(z) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NetworkLocationStatus:");
    localStringBuilder.append(" Wifi status: ");
    localStringBuilder.append(x);
    localStringBuilder.append(" Cell status: ");
    localStringBuilder.append(y);
    localStringBuilder.append(" elapsed time NS: ");
    localStringBuilder.append(A);
    localStringBuilder.append(" system time ms: ");
    localStringBuilder.append(z);
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y);
    r.a(paramParcel, 3, z);
    r.a(paramParcel, 4, A);
    r.k(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.e.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */