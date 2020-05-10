package e.c.a.a.b.j;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class m
  implements n
{
  public final IBinder a;
  
  public m(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(l paraml, g paramg)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
      if (paraml != null) {
        paraml = paraml.asBinder();
      } else {
        paraml = null;
      }
      localParcel1.writeStrongBinder(paraml);
      if (paramg != null)
      {
        localParcel1.writeInt(1);
        paramg.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      a.transact(46, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */