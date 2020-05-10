package e.c.a.a.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import d.b.a.s;
import java.util.Arrays;

public final class j
  extends e.c.a.a.b.j.s.a
{
  public static final Parcelable.Creator<j> CREATOR = new k();
  public long A;
  public int B;
  public boolean x;
  public long y;
  public float z;
  
  public j()
  {
    x = true;
    y = 50L;
    z = 0.0F;
    A = Long.MAX_VALUE;
    B = Integer.MAX_VALUE;
  }
  
  public j(boolean paramBoolean, long paramLong1, float paramFloat, long paramLong2, int paramInt)
  {
    x = paramBoolean;
    y = paramLong1;
    z = paramFloat;
    A = paramLong2;
    B = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof j)) {
      return false;
    }
    paramObject = (j)paramObject;
    return (x == x) && (y == y) && (Float.compare(z, z) == 0) && (A == A) && (B == B);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Boolean.valueOf(x), Long.valueOf(y), Float.valueOf(z), Long.valueOf(A), Integer.valueOf(B) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("DeviceOrientationRequest[mShouldUseMag=");
    localStringBuilder.append(x);
    localStringBuilder.append(" mMinimumSamplingPeriodMs=");
    localStringBuilder.append(y);
    localStringBuilder.append(" mSmallestAngleChangeRadians=");
    localStringBuilder.append(z);
    long l1 = A;
    if (l1 != Long.MAX_VALUE)
    {
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("ms");
    }
    if (B != Integer.MAX_VALUE)
    {
      localStringBuilder.append(" num=");
      localStringBuilder.append(B);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y);
    float f = z;
    s.c(paramParcel, 3, 4);
    paramParcel.writeFloat(f);
    s.a(paramParcel, 4, A);
    s.a(paramParcel, 5, B);
    s.k(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.e.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */