package c.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 2)
    {
      if (paramInt1 != 3)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 5)
          {
            if (paramInt1 != 6)
            {
              if (paramInt1 != 1598968902) {
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
              }
              paramParcel2.writeString("android.support.customtabs.ICustomTabsCallback");
              return true;
            }
            paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            paramParcel1.readInt();
            if (paramParcel1.readInt() != 0) {
              Uri localUri = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
            }
            paramParcel1.readInt();
            if (paramParcel1.readInt() != 0) {
              paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
            }
            paramParcel2.writeNoException();
            return true;
          }
          paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
          paramParcel1.readString();
          if (paramParcel1.readInt() != 0) {
            paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          }
          paramParcel2.writeNoException();
          return true;
        }
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
        if (paramParcel1.readInt() != 0) {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
      paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
    paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     base.c.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */