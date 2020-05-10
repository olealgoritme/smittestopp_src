package e.c.a.a.b.j;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import d.b.a.s;
import e.c.a.a.d.b.b;
import e.c.a.a.d.b.c;

public abstract interface l
  extends IInterface
{
  public static abstract class a
    extends b
    implements l
  {
    public a()
    {
      super();
    }
    
    public final boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      IBinder localIBinder;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            return false;
          }
          paramInt1 = paramParcel1.readInt();
          localIBinder = paramParcel1.readStrongBinder();
          z localz = (z)c.a(paramParcel1, z.CREATOR);
          paramParcel1 = (b.i)this;
          s.b(a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
          s.a(localz);
          a.s = localz;
          paramParcel1.a(paramInt1, localIBinder, x);
        }
        else
        {
          paramParcel1.readInt();
          paramParcel1 = (Bundle)c.a(paramParcel1, Bundle.CREATOR);
          Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
      }
      else
      {
        paramInt1 = paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        paramParcel1 = (Bundle)c.a(paramParcel1, Bundle.CREATOR);
        ((b.i)this).a(paramInt1, localIBinder, paramParcel1);
      }
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */