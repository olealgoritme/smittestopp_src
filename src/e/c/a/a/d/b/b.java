package e.c.a.a.d.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class b
  extends Binder
  implements IInterface
{
  public b(String paramString)
  {
    attachInterface(this, paramString);
  }
  
  public boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    return false;
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool;
    if (paramInt1 > 16777215)
    {
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    else
    {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
      bool = false;
    }
    if (bool) {
      return true;
    }
    return a(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.d.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */