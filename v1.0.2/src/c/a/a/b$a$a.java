package c.a.a;

import android.os.IBinder;
import android.os.Parcel;

public class b$a$a
  implements b
{
  public IBinder a;
  
  public b$a$a(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public boolean a(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
      localParcel1.writeLong(paramLong);
      IBinder localIBinder = a;
      boolean bool = false;
      localIBinder.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean a(a parama)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
      if (parama != null) {
        parama = parama.asBinder();
      } else {
        parama = null;
      }
      localParcel1.writeStrongBinder(parama);
      parama = a;
      boolean bool = false;
      parama.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     base.c.a.a.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */