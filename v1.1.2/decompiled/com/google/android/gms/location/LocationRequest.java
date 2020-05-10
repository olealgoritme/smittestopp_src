package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d.b.a.s;
import e.c.a.a.e.e;
import java.util.Arrays;

public final class LocationRequest
  extends e.c.a.a.b.j.s.a
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationRequest> CREATOR = new e();
  public boolean A;
  public long B;
  public int C;
  public float D;
  public long E;
  public int x;
  public long y;
  public long z;
  
  public LocationRequest()
  {
    x = 102;
    y = 3600000L;
    z = 600000L;
    A = false;
    B = Long.MAX_VALUE;
    C = Integer.MAX_VALUE;
    D = 0.0F;
    E = 0L;
  }
  
  public LocationRequest(int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt2, float paramFloat, long paramLong4)
  {
    x = paramInt1;
    y = paramLong1;
    z = paramLong2;
    A = paramBoolean;
    B = paramLong3;
    C = paramInt2;
    D = paramFloat;
    E = paramLong4;
  }
  
  public static void a(long paramLong)
  {
    if (paramLong >= 0L) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(38);
    localStringBuilder.append("invalid interval: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LocationRequest)) {
      return false;
    }
    paramObject = (LocationRequest)paramObject;
    if (x == x)
    {
      long l1 = y;
      if ((l1 == y) && (z == z) && (A == A) && (B == B) && (C == C) && (D == D))
      {
        long l2 = E;
        if (l2 < l1) {
          l2 = l1;
        }
        long l3 = E;
        long l4 = y;
        l1 = l3;
        if (l3 < l4) {
          l1 = l4;
        }
        if (l2 == l1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(x), Long.valueOf(y), Float.valueOf(D), Long.valueOf(E) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Request[");
    int i = x;
    String str;
    if (i != 100)
    {
      if (i != 102)
      {
        if (i != 104)
        {
          if (i != 105) {
            str = "???";
          } else {
            str = "PRIORITY_NO_POWER";
          }
        }
        else {
          str = "PRIORITY_LOW_POWER";
        }
      }
      else {
        str = "PRIORITY_BALANCED_POWER_ACCURACY";
      }
    }
    else {
      str = "PRIORITY_HIGH_ACCURACY";
    }
    localStringBuilder.append(str);
    if (x != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(y);
      localStringBuilder.append("ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(z);
    localStringBuilder.append("ms");
    if (E > y)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(E);
      localStringBuilder.append("ms");
    }
    if (D > 0.0F)
    {
      localStringBuilder.append(" smallestDisplacement=");
      localStringBuilder.append(D);
      localStringBuilder.append("m");
    }
    long l1 = B;
    if (l1 != Long.MAX_VALUE)
    {
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("ms");
    }
    if (C != Integer.MAX_VALUE)
    {
      localStringBuilder.append(" num=");
      localStringBuilder.append(C);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y);
    s.a(paramParcel, 3, z);
    s.a(paramParcel, 4, A);
    s.a(paramParcel, 5, B);
    s.a(paramParcel, 6, C);
    float f = D;
    s.c(paramParcel, 7, 4);
    paramParcel.writeFloat(f);
    s.a(paramParcel, 8, E);
    s.k(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */