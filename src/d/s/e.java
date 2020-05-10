package d.s;

import android.content.Context;
import android.os.Bundle;
import d.o.e0;
import d.o.f0;
import d.o.g.b;
import d.o.l;
import d.o.m;
import d.v.a;
import d.v.b;
import d.v.c;
import java.util.HashMap;
import java.util.UUID;

public final class e
  implements l, f0, c
{
  public final b A;
  public final UUID B;
  public g.b C;
  public g.b D;
  public g E;
  public final i x;
  public final Bundle y;
  public final m z = new m(this);
  
  public e(Context paramContext, i parami, Bundle paramBundle, l paraml, g paramg)
  {
    this(paramContext, parami, paramBundle, paraml, paramg, UUID.randomUUID(), null);
  }
  
  public e(Context paramContext, i parami, Bundle paramBundle1, l paraml, g paramg, UUID paramUUID, Bundle paramBundle2)
  {
    paramContext = new b(this);
    A = paramContext;
    C = g.b.CREATED;
    D = g.b.RESUMED;
    B = paramUUID;
    x = parami;
    y = paramBundle1;
    E = paramg;
    paramContext.a(paramBundle2);
    if (paraml != null) {
      C = getLifecycleb;
    }
    a();
  }
  
  public final void a()
  {
    if (C.ordinal() < D.ordinal()) {
      z.a(C);
    } else {
      z.a(D);
    }
  }
  
  public d.o.g getLifecycle()
  {
    return z;
  }
  
  public a getSavedStateRegistry()
  {
    return A.b;
  }
  
  public e0 getViewModelStore()
  {
    g localg = E;
    if (localg != null)
    {
      UUID localUUID = B;
      e0 locale01 = (e0)c.get(localUUID);
      e0 locale02 = locale01;
      if (locale01 == null)
      {
        locale02 = new e0();
        c.put(localUUID, locale02);
      }
      return locale02;
    }
    throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
  }
}

/* Location:
 * Qualified Name:     base.d.s.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */