package e.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import d.b.a.s;
import e.c.a.a.b.j.c;
import e.c.a.a.b.j.s.a;
import java.util.Collections;
import java.util.List;

public final class q
  extends a
{
  public static final Parcelable.Creator<q> CREATOR = new r();
  public static final List<c> E = ;
  public boolean A;
  public boolean B;
  public boolean C;
  public String D;
  public LocationRequest x;
  public List<c> y;
  public String z;
  
  public q(LocationRequest paramLocationRequest, List<c> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    x = paramLocationRequest;
    y = paramList;
    z = paramString1;
    A = paramBoolean1;
    B = paramBoolean2;
    C = paramBoolean3;
    D = paramString2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof q)) {
      return false;
    }
    paramObject = (q)paramObject;
    return (s.c(x, x)) && (s.c(y, y)) && (s.c(z, z)) && (A == A) && (B == B) && (C == C) && (s.c(D, D));
  }
  
  public final int hashCode()
  {
    return x.hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(x);
    if (z != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(z);
    }
    if (D != null)
    {
      localStringBuilder.append(" moduleId=");
      localStringBuilder.append(D);
    }
    localStringBuilder.append(" hideAppOps=");
    localStringBuilder.append(A);
    localStringBuilder.append(" clients=");
    localStringBuilder.append(y);
    localStringBuilder.append(" forceCoarseLocation=");
    localStringBuilder.append(B);
    if (C) {
      localStringBuilder.append(" exemptFromBackgroundThrottle");
    }
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x, paramInt, false);
    s.a(paramParcel, 5, y, false);
    s.a(paramParcel, 6, z, false);
    s.a(paramParcel, 7, A);
    s.a(paramParcel, 8, B);
    s.a(paramParcel, 9, C);
    s.a(paramParcel, 10, D, false);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.d.c.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */