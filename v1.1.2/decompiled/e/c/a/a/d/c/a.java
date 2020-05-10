package e.c.a.a.d.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a
  implements IInterface
{
  public final IBinder a;
  public final String b;
  
  public a(IBinder paramIBinder, String paramString)
  {
    a = paramIBinder;
    b = paramString;
  }
  
  public final void a(int paramInt, Parcel paramParcel)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      a.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return a;
  }
  
  public final void b(int paramInt, Parcel paramParcel)
  {
    try
    {
      a.transact(paramInt, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
  
  public final Parcel c()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(b);
    return localParcel;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.d.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */