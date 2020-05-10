package d.u;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class d$a
  extends Binder
  implements d
{
  public d$a()
  {
    attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
  }
  
  public static d a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
    if ((localIInterface != null) && ((localIInterface instanceof d))) {
      return (d)localIInterface;
    }
    return new d.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 1598968902) {
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          }
          paramParcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
          return true;
        }
        paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        a(paramParcel1.readInt(), paramParcel1.createStringArray());
        return true;
      }
      paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
      a(c.a.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
    paramInt1 = a(c.a.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}

/* Location:
 * Qualified Name:     base.d.u.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */