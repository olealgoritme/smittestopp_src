package d.u;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class c$a
  extends Binder
  implements c
{
  public c$a()
  {
    attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
  }
  
  public static c a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new c.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
      return true;
    }
    paramParcel1.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
    a(paramParcel1.createStringArray());
    return true;
  }
}

/* Location:
 * Qualified Name:     base.d.u.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */