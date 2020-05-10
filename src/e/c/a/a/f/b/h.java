package e.c.a.a.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import e.c.a.a.d.a.b;

public final class h
  implements g, IInterface
{
  public final IBinder a;
  public final String b;
  
  public h(IBinder paramIBinder)
  {
    a = paramIBinder;
    b = "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public final void a(i parami, e parame)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(b);
    b.a(localParcel, parami);
    if (parame == null) {
      localParcel.writeStrongBinder(null);
    } else {
      localParcel.writeStrongBinder(parame.asBinder());
    }
    parami = Parcel.obtain();
    try
    {
      a.transact(12, localParcel, parami, 0);
      parami.readException();
      return;
    }
    finally
    {
      localParcel.recycle();
      parami.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.f.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */