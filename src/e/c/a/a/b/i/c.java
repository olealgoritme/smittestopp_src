package e.c.a.a.b.i;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import d.b.a.r;
import e.c.a.a.b.i.k.h0;
import e.c.a.a.b.i.k.t;
import e.c.a.a.b.j.d.a;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class c<O extends a.d>
{
  public final Context a;
  public final a<O> b;
  public final O c;
  public final h0<O> d;
  public final int e;
  public final e.c.a.a.b.i.k.c f;
  
  @Deprecated
  public c(Context paramContext, a<O> parama, O paramO, e.c.a.a.b.i.k.a parama1)
  {
    r.b(paramContext, "Null context is not permitted.");
    r.b(parama, "Api must not be null.");
    r.b(parama1, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    a = paramContext.getApplicationContext();
    b = parama;
    c = paramO;
    d = new h0(parama, paramO);
    paramContext = new e/c/a/a/b/i/k/t;
    paramContext = e.c.a.a.b.i.k.c.a(a);
    f = paramContext;
    e = g.getAndIncrement();
    paramContext = f.m;
    paramContext.sendMessage(paramContext.obtainMessage(7, this));
  }
  
  public d.a a()
  {
    d.a locala = new d.a();
    Object localObject1 = c;
    boolean bool = localObject1 instanceof a.d.b;
    Object localObject2 = null;
    if (bool)
    {
      localObject1 = ((a.d.b)localObject1).a();
      if (localObject1 != null)
      {
        if (A == null) {
          break label90;
        }
        localObject2 = new Account(A, "com.google");
        break label90;
      }
    }
    localObject1 = c;
    if ((localObject1 instanceof a.d.a)) {
      localObject2 = ((a.d.a)localObject1).getAccount();
    }
    label90:
    a = ((Account)localObject2);
    localObject2 = c;
    if ((localObject2 instanceof a.d.b))
    {
      localObject2 = ((a.d.b)localObject2).a();
      if (localObject2 != null)
      {
        localObject2 = ((GoogleSignInAccount)localObject2).b();
        break label142;
      }
    }
    localObject2 = Collections.emptySet();
    label142:
    if (b == null) {
      b = new d.f.c();
    }
    b.addAll((Collection)localObject2);
    e = a.getClass().getName();
    d = a.getPackageName();
    return locala;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */