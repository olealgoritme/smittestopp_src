package net.sqlcipher;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class BulkCursorNative
  extends Binder
  implements IBulkCursor
{
  public BulkCursorNative()
  {
    attachInterface(this, "android.content.IBulkCursor");
  }
  
  public static IBulkCursor asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IBulkCursor localIBulkCursor = (IBulkCursor)paramIBinder.queryLocalInterface("android.content.IBulkCursor");
    if (localIBulkCursor != null) {
      return localIBulkCursor;
    }
    return new BulkCursorProxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    switch (paramInt1)
    {
    default: 
      break;
    case 12: 
    case 11: 
    case 10: 
    case 9: 
    case 8: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
      try
      {
        paramParcel1.enforceInterface("android.content.IBulkCursor");
        close();
        paramParcel2.writeNoException();
        return true;
      }
      catch (Exception paramParcel1)
      {
        boolean bool;
        DatabaseUtils.writeExceptionToParcel(paramParcel2, paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = respond(paramParcel1.readBundle(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = getExtras();
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      bool = getWantsAllOnMoveCalls();
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      onMove(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramInt1 = requery(IContentObserver.Stub.asInterface(paramParcel1.readStrongBinder()), (CursorWindow)CursorWindow.CREATOR.createFromParcel(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      paramParcel2.writeBundle(getExtras());
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      deactivate();
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      bool = deleteRow(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool == true) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      bool = updateRows(paramParcel1.readHashMap(null));
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool == true) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = getColumnNames();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramParcel1.length);
      paramInt2 = paramParcel1.length;
      for (paramInt1 = k; paramInt1 < paramInt2; paramInt1++) {
        paramParcel2.writeString(paramParcel1[paramInt1]);
      }
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramInt1 = count();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = getWindow(paramParcel1.readInt());
      if (paramParcel1 == null)
      {
        paramParcel2.writeInt(0);
        return true;
      }
      paramParcel2.writeNoException();
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 0);
      return true;
    }
    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.BulkCursorNative
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */