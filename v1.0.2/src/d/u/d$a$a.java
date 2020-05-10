package d.u;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class d$a$a
  implements d
{
  public IBinder a;
  
  public d$a$a(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public int a(c paramc, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
      if (paramc != null) {
        paramc = paramc.asBinder();
      } else {
        paramc = null;
      }
      localParcel1.writeStrongBinder(paramc);
      localParcel1.writeString(paramString);
      a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
      localParcel.writeInt(paramInt);
      localParcel.writeStringArray(paramArrayOfString);
      a.transact(3, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(c paramc, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
      if (paramc != null) {
        paramc = paramc.asBinder();
      } else {
        paramc = null;
      }
      localParcel1.writeStrongBinder(paramc);
      localParcel1.writeInt(paramInt);
      a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
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
 * Qualified Name:     base.d.u.d.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */