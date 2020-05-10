package d.u;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface c
  extends IInterface
{
  public abstract void a(String[] paramArrayOfString);
  
  public static abstract class a
    extends Binder
    implements c
  {
    public a()
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
      return new a(paramIBinder);
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
    
    public static class a
      implements c
    {
      public IBinder a;
      
      public a(IBinder paramIBinder)
      {
        a = paramIBinder;
      }
      
      public void a(String[] paramArrayOfString)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
          localParcel.writeStringArray(paramArrayOfString);
          a.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return a;
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.u.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */