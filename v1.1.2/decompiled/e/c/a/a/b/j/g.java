package e.c.a.a.b.j;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import d.b.a.s;
import e.c.a.a.b.c;
import e.c.a.a.b.e;

public class g
  extends e.c.a.a.b.j.s.a
{
  public static final Parcelable.Creator<g> CREATOR = new b0();
  public String A;
  public IBinder B;
  public Scope[] C;
  public Bundle D;
  public Account E;
  public c[] F;
  public c[] G;
  public boolean H;
  public final int x;
  public final int y;
  public int z;
  
  public g(int paramInt)
  {
    x = 4;
    z = e.a;
    y = paramInt;
    H = true;
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, c[] paramArrayOfc1, c[] paramArrayOfc2, boolean paramBoolean)
  {
    x = paramInt1;
    y = paramInt2;
    z = paramInt3;
    if ("com.google.android.gms".equals(paramString)) {
      A = "com.google.android.gms";
    } else {
      A = paramString;
    }
    if (paramInt1 < 2)
    {
      paramString = null;
      if (paramIBinder != null) {
        paramString = a.a(k.a.a(paramIBinder));
      }
      E = paramString;
    }
    else
    {
      B = paramIBinder;
      E = paramAccount;
    }
    C = paramArrayOfScope;
    D = paramBundle;
    F = paramArrayOfc1;
    G = paramArrayOfc2;
    H = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y);
    s.a(paramParcel, 3, z);
    s.a(paramParcel, 4, A, false);
    s.a(paramParcel, 5, B, false);
    s.a(paramParcel, 6, C, paramInt, false);
    Bundle localBundle = D;
    if (localBundle != null)
    {
      int j = s.j(paramParcel, 7);
      paramParcel.writeBundle(localBundle);
      s.k(paramParcel, j);
    }
    s.a(paramParcel, 8, E, paramInt, false);
    s.a(paramParcel, 10, F, paramInt, false);
    s.a(paramParcel, 11, G, paramInt, false);
    s.a(paramParcel, 12, H);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */