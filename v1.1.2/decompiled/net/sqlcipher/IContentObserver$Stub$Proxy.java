package net.sqlcipher;

import android.os.IBinder;
import android.os.Parcel;

public class IContentObserver$Stub$Proxy
  implements IContentObserver
{
  public IBinder mRemote;
  
  public IContentObserver$Stub$Proxy(IBinder paramIBinder)
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

/* Location:
 * Qualified Name:     net.sqlcipher.IContentObserver.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */