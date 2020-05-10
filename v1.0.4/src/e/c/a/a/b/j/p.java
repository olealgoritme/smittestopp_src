package e.c.a.a.b.j;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import d.b.a.r;
import e.c.a.a.b.j.s.a;

public class p
  extends a
{
  public static final Parcelable.Creator<p> CREATOR = new x();
  public final GoogleSignInAccount A;
  public final int x;
  public final Account y;
  public final int z;
  
  public p(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount)
  {
    x = paramInt1;
    y = paramAccount;
    z = paramInt2;
    A = paramGoogleSignInAccount;
  }
  
  public p(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    x = 2;
    y = paramAccount;
    z = paramInt;
    A = paramGoogleSignInAccount;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y, paramInt, false);
    r.a(paramParcel, 3, z);
    r.a(paramParcel, 4, A, paramInt, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */