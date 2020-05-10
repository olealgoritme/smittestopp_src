package net.sqlcipher;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IContentObserver$Stub
  extends Binder
  implements IContentObserver
{
  public static final String DESCRIPTOR = "net.sqlcipher.IContentObserver";
  public static final int TRANSACTION_onChange = 1;
  
  public IContentObserver$Stub()
  {
    attachInterface(this, "net.sqlcipher.IContentObserver");
  }
  
  public static IContentObserver asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("net.sqlcipher.IContentObserver");
    if ((localIInterface != null) && ((localIInterface instanceof IContentObserver))) {
      return (IContentObserver)localIInterface;
    }
    return new Proxy(paramIBinder);
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
      paramParcel2.writeString("net.sqlcipher.IContentObserver");
      return true;
    }
    paramParcel1.enforceInterface("net.sqlcipher.IContentObserver");
    boolean bool;
    if (paramParcel1.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    onChange(bool);
    return true;
  }
  
  public static class Proxy
    implements IContentObserver
  {
    public IBinder mRemote;
    
    public Proxy(IBinder paramIBinder)
    {
      mRemote = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return mRemote;
    }
    
    public String getInterfaceDescriptor()
    {
      return "net.sqlcipher.IContentObserver";
    }
    
    public void onChange(boolean paramBoolean)
    {
      Parcel localParcel = Parcel.obtain();
      try
      {
        localParcel.writeInterfaceToken("net.sqlcipher.IContentObserver");
        int i;
        if (paramBoolean) {
          i = 1;
        } else {
          i = 0;
        }
        localParcel.writeInt(i);
        mRemote.transact(1, localParcel, null, 1);
        return;
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.IContentObserver.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */