package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d.b.a.r;
import e.c.a.a.b.j.s.a;
import e.c.a.a.e.d;
import e.c.a.a.e.h;
import java.util.Arrays;

public final class LocationAvailability
  extends a
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationAvailability> CREATOR = new d();
  public int A;
  public h[] B;
  @Deprecated
  public int x;
  @Deprecated
  public int y;
  public long z;
  
  public LocationAvailability(int paramInt1, int paramInt2, int paramInt3, long paramLong, h[] paramArrayOfh)
  {
    A = paramInt1;
    x = paramInt2;
    y = paramInt3;
    z = paramLong;
    B = paramArrayOfh;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (LocationAvailability.class == paramObject.getClass()))
    {
      paramObject = (LocationAvailability)paramObject;
      if ((x == x) && (y == y) && (z == z) && (A == A) && (Arrays.equals(B, B))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(A), Integer.valueOf(x), Integer.valueOf(y), Long.valueOf(z), B });
  }
  
  public final String toString()
  {
    boolean bool;
    if (A < 1000) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder(48);
    localStringBuilder.append("LocationAvailability[isLocationAvailable: ");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y);
    r.a(paramParcel, 3, z);
    r.a(paramParcel, 4, A);
    r.a(paramParcel, 5, B, paramInt, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.location.LocationAvailability
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */