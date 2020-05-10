package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d.b.a.r;
import e.c.a.a.b.i.h;
import e.c.a.a.b.i.m;
import e.c.a.a.b.j.o;
import e.c.a.a.b.j.s.a;
import java.util.Arrays;

public final class Status
  extends a
  implements h, ReflectedParcelable
{
  public static final Status B = new Status(0, null);
  public static final Status C;
  public static final Parcelable.Creator<Status> CREATOR = new m();
  public static final Status D;
  public final PendingIntent A;
  public final int x;
  public final int y;
  public final String z;
  
  static
  {
    new Status(14, null);
    new Status(8, null);
    C = new Status(15, null);
    D = new Status(16, null);
    new Status(17, null);
    new Status(18, null);
  }
  
  public Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    x = paramInt1;
    y = paramInt2;
    z = paramString;
    A = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    x = 1;
    y = paramInt;
    z = paramString;
    A = null;
  }
  
  public final Status a()
  {
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {
      return false;
    }
    paramObject = (Status)paramObject;
    return (x == x) && (y == y) && (r.c(z, z)) && (r.c(A, A));
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(x), Integer.valueOf(y), z, A });
  }
  
  public final String toString()
  {
    o localo = r.c(this);
    Object localObject = z;
    if (localObject == null)
    {
      int i = y;
      switch (i)
      {
      case 1: 
      case 9: 
      case 11: 
      case 12: 
      default: 
        localObject = new StringBuilder(32);
        ((StringBuilder)localObject).append("unknown status code: ");
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
        break;
      case 18: 
        localObject = "DEAD_CLIENT";
        break;
      case 17: 
        localObject = "API_NOT_CONNECTED";
        break;
      case 16: 
        localObject = "CANCELED";
        break;
      case 15: 
        localObject = "TIMEOUT";
        break;
      case 14: 
        localObject = "INTERRUPTED";
        break;
      case 13: 
        localObject = "ERROR";
        break;
      case 10: 
        localObject = "DEVELOPER_ERROR";
        break;
      case 8: 
        localObject = "INTERNAL_ERROR";
        break;
      case 7: 
        localObject = "NETWORK_ERROR";
        break;
      case 6: 
        localObject = "RESOLUTION_REQUIRED";
        break;
      case 5: 
        localObject = "INVALID_ACCOUNT";
        break;
      case 4: 
        localObject = "SIGN_IN_REQUIRED";
        break;
      case 3: 
        localObject = "SERVICE_DISABLED";
        break;
      case 2: 
        localObject = "SERVICE_VERSION_UPDATE_REQUIRED";
        break;
      case 0: 
        localObject = "SUCCESS";
        break;
      case -1: 
        localObject = "SUCCESS_CACHE";
      }
    }
    localo.a("statusCode", localObject);
    localo.a("resolution", A);
    return localo.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, y);
    r.a(paramParcel, 2, z, false);
    r.a(paramParcel, 3, A, paramInt, false);
    r.a(paramParcel, 1000, x);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.common.api.Status
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */