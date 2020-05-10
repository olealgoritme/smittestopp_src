package e.c.a.a.f.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import d.b.a.s;
import e.c.a.a.b.i.d.a;
import e.c.a.a.b.i.d.b;
import e.c.a.a.b.j.b;
import e.c.a.a.b.j.b.d;
import e.c.a.a.b.j.d;
import e.c.a.a.b.j.h;
import e.c.a.a.b.j.p;
import e.c.a.a.f.f;

public class a
  extends h<g>
  implements f
{
  public Integer A;
  public final boolean x = true;
  public final d y;
  public final Bundle z;
  
  public a(Context paramContext, Looper paramLooper, d paramd, d.a parama, d.b paramb)
  {
    super(paramContext, paramLooper, 44, paramd, parama, paramb);
    y = paramd;
    z = localBundle;
    A = h;
  }
  
  public final void a(e parame)
  {
    s.b(parame, "Expecting a valid ISignInCallbacks");
    try
    {
      Object localObject1 = y.a;
      if (localObject1 == null) {
        localObject1 = new Account("<<default account>>", "com.google");
      }
      localObject2 = null;
      if ("<<default account>>".equals(name)) {
        localObject2 = e.c.a.a.a.a.a.a.a.a(b).a();
      }
      p localp = new e/c/a/a/b/j/p;
      localp.<init>((Account)localObject1, A.intValue(), (GoogleSignInAccount)localObject2);
      localObject2 = (g)k();
      localObject1 = new e/c/a/a/f/b/i;
      ((i)localObject1).<init>(localp);
      ((g)localObject2).a((i)localObject1, parame);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Object localObject2;
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        localObject2 = new e/c/a/a/f/b/k;
        ((k)localObject2).<init>();
        parame.a((k)localObject2);
        return;
      }
      catch (RemoteException parame)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  public int c()
  {
    return 12451000;
  }
  
  public final void h()
  {
    b.d locald = new b.d(this);
    s.b(locald, "Connection progress callbacks cannot be null.");
    h = locald;
    b(2, null);
  }
  
  public boolean i()
  {
    return x;
  }
  
  public Bundle j()
  {
    String str = y.e;
    if (!b.getPackageName().equals(str)) {
      z.putString("com.google.android.gms.signin.internal.realClientPackageName", y.e);
    }
    return z;
  }
  
  public String l()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public String m()
  {
    return "com.google.android.gms.signin.service.START";
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.f.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */