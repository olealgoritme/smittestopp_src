package e.c.a.a.f.b;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class f
  extends e.c.a.a.d.a.a
  implements e
{
  public f()
  {
    super("com.google.android.gms.signin.internal.ISignInCallbacks");
  }
  
  public boolean a(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject;
    if (paramInt1 != 3)
    {
      if (paramInt1 != 4)
      {
        if (paramInt1 != 6)
        {
          if (paramInt1 != 7)
          {
            if (paramInt1 != 8) {
              return false;
            }
            a((k)e.c.a.a.d.a.b.a(paramParcel1, k.CREATOR));
          }
          else
          {
            localObject = (Status)e.c.a.a.d.a.b.a(paramParcel1, Status.CREATOR);
            paramParcel1 = (GoogleSignInAccount)e.c.a.a.d.a.b.a(paramParcel1, GoogleSignInAccount.CREATOR);
          }
        }
        else {
          paramParcel1 = (Status)e.c.a.a.d.a.b.a(paramParcel1, Status.CREATOR);
        }
      }
      else {
        paramParcel1 = (Status)e.c.a.a.d.a.b.a(paramParcel1, Status.CREATOR);
      }
    }
    else
    {
      localObject = (e.c.a.a.b.a)e.c.a.a.d.a.b.a(paramParcel1, e.c.a.a.b.a.CREATOR);
      paramParcel1 = (b)e.c.a.a.d.a.b.a(paramParcel1, b.CREATOR);
    }
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.f.b.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */