package e.c.a.a.b;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import d.b.a.s;
import e.c.a.a.b.j.g0;
import e.c.a.a.c.a;
import e.c.a.a.d.b.c;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class q
  extends e.c.a.a.d.b.b
  implements g0
{
  public int a;
  
  public q(byte[] paramArrayOfByte)
  {
    super("com.google.android.gms.common.internal.ICertData");
    boolean bool;
    if (paramArrayOfByte.length == 25) {
      bool = true;
    } else {
      bool = false;
    }
    s.a(bool);
    a = Arrays.hashCode(paramArrayOfByte);
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public final a a()
  {
    return new e.c.a.a.c.b(c());
  }
  
  public final boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        bool = false;
      }
      else
      {
        paramInt1 = b();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
      }
    }
    else
    {
      paramParcel1 = a();
      paramParcel2.writeNoException();
      c.a(paramParcel2, paramParcel1);
    }
    return bool;
  }
  
  public final int b()
  {
    return a;
  }
  
  public abstract byte[] c();
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof g0))) {
      try
      {
        paramObject = (g0)paramObject;
        if (((g0)paramObject).b() != a) {
          return false;
        }
        paramObject = ((g0)paramObject).a();
        if (paramObject == null) {
          return false;
        }
        paramObject = (byte[])e.c.a.a.c.b.a((a)paramObject);
        boolean bool = Arrays.equals(c(), (byte[])paramObject);
        return bool;
      }
      catch (RemoteException paramObject)
      {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)paramObject);
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */