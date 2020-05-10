package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

public final class BulkCursorProxy
  implements IBulkCursor
{
  public Bundle mExtras;
  public IBinder mRemote;
  
  public BulkCursorProxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
    mExtras = null;
  }
  
  public IBinder asBinder()
  {
    return mRemote;
  }
  
  public void close()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    mRemote.transact(12, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    localParcel1.recycle();
    localParcel2.recycle();
  }
  
  public int count()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    boolean bool = mRemote.transact(2, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i;
    if (!bool) {
      i = -1;
    } else {
      i = localParcel2.readInt();
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return i;
  }
  
  public void deactivate()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    mRemote.transact(6, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    localParcel1.recycle();
    localParcel2.recycle();
  }
  
  public boolean deleteRow(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeInt(paramInt);
    IBinder localIBinder = mRemote;
    boolean bool = false;
    localIBinder.transact(5, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    if (localParcel2.readInt() == 1) {
      bool = true;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return bool;
  }
  
  public String[] getColumnNames()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    Object localObject = mRemote;
    int i = 0;
    ((IBinder)localObject).transact(3, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int j = localParcel2.readInt();
    localObject = new String[j];
    while (i < j)
    {
      localObject[i] = localParcel2.readString();
      i++;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return (String[])localObject;
  }
  
  public Bundle getExtras()
  {
    if (mExtras == null)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      mRemote.transact(10, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      mExtras = localParcel2.readBundle(BulkCursorProxy.class.getClassLoader());
      localParcel1.recycle();
      localParcel2.recycle();
    }
    return mExtras;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    IBinder localIBinder = mRemote;
    boolean bool = false;
    localIBinder.transact(9, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i = localParcel2.readInt();
    localParcel1.recycle();
    localParcel2.recycle();
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public CursorWindow getWindow(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeInt(paramInt);
    mRemote.transact(1, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    CursorWindow localCursorWindow;
    if (localParcel2.readInt() == 1) {
      localCursorWindow = CursorWindow.newFromParcel(localParcel2);
    } else {
      localCursorWindow = null;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return localCursorWindow;
  }
  
  public void onMove(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeInt(paramInt);
    mRemote.transact(8, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    localParcel1.recycle();
    localParcel2.recycle();
  }
  
  public int requery(IContentObserver paramIContentObserver, CursorWindow paramCursorWindow)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeStrongInterface(paramIContentObserver);
    paramCursorWindow.writeToParcel(localParcel1, 0);
    boolean bool = mRemote.transact(7, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i;
    if (!bool)
    {
      i = -1;
    }
    else
    {
      i = localParcel2.readInt();
      mExtras = localParcel2.readBundle(BulkCursorProxy.class.getClassLoader());
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return i;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeBundle(paramBundle);
    mRemote.transact(11, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    paramBundle = localParcel2.readBundle(BulkCursorProxy.class.getClassLoader());
    localParcel1.recycle();
    localParcel2.recycle();
    return paramBundle;
  }
  
  public boolean updateRows(Map paramMap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeMap(paramMap);
    paramMap = mRemote;
    boolean bool = false;
    paramMap.transact(4, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    if (localParcel2.readInt() == 1) {
      bool = true;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return bool;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.BulkCursorProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */