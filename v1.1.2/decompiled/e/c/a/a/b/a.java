package e.c.a.a.b;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.s;
import e.c.a.a.b.j.o;
import java.util.Arrays;

public final class a
  extends e.c.a.a.b.j.s.a
{
  public static final a B = new a(0);
  public static final Parcelable.Creator<a> CREATOR = new n();
  public final String A;
  public final int x;
  public final int y;
  public final PendingIntent z;
  
  public a(int paramInt)
  {
    x = 1;
    y = paramInt;
    z = null;
    A = null;
  }
  
  public a(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString)
  {
    x = paramInt1;
    y = paramInt2;
    z = paramPendingIntent;
    A = paramString;
  }
  
  public a(int paramInt, PendingIntent paramPendingIntent)
  {
    x = 1;
    y = paramInt;
    z = paramPendingIntent;
    A = null;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 99)
    {
      if (paramInt != 1500)
      {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            StringBuilder localStringBuilder = new StringBuilder(31);
            localStringBuilder.append("UNKNOWN_ERROR_CODE(");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          case 21: 
            return "API_VERSION_UPDATE_REQUIRED";
          case 20: 
            return "RESTRICTED_PROFILE";
          case 19: 
            return "SERVICE_MISSING_PERMISSION";
          case 18: 
            return "SERVICE_UPDATING";
          case 17: 
            return "SIGN_IN_FAILED";
          case 16: 
            return "API_UNAVAILABLE";
          case 15: 
            return "INTERRUPTED";
          case 14: 
            return "TIMEOUT";
          }
          return "CANCELED";
        case 11: 
          return "LICENSE_CHECK_FAILED";
        case 10: 
          return "DEVELOPER_ERROR";
        case 9: 
          return "SERVICE_INVALID";
        case 8: 
          return "INTERNAL_ERROR";
        case 7: 
          return "NETWORK_ERROR";
        case 6: 
          return "RESOLUTION_REQUIRED";
        case 5: 
          return "INVALID_ACCOUNT";
        case 4: 
          return "SIGN_IN_REQUIRED";
        case 3: 
          return "SERVICE_DISABLED";
        case 2: 
          return "SERVICE_VERSION_UPDATE_REQUIRED";
        case 1: 
          return "SERVICE_MISSING";
        case 0: 
          return "SUCCESS";
        }
        return "UNKNOWN";
      }
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    }
    return "UNFINISHED";
  }
  
  public final boolean b()
  {
    return y == 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return (y == y) && (s.c(z, z)) && (s.c(A, A));
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(y), z, A });
  }
  
  public final String toString()
  {
    o localo = s.c(this);
    localo.a("statusCode", a(y));
    localo.a("resolution", z);
    localo.a("message", A);
    return localo.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y);
    s.a(paramParcel, 3, z, paramInt, false);
    s.a(paramParcel, 4, A, false);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */