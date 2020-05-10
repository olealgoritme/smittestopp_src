package d.u;

import android.os.IBinder;
import android.os.Parcel;

public class c$a$a
  implements c
{
  public IBinder a;
  
  public c$a$a(IBinder paramIBinder)
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

/* Location:
 * Qualified Name:     d.u.c.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */