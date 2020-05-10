package androidx.lifecycle;

import d.c.a.b.b;
import d.o.g;
import d.o.g.a;
import d.o.g.b;
import d.o.j;
import d.o.l;
import d.o.m;
import d.o.w;
import d.v.a.b;

public final class SavedStateHandleController
  implements j
{
  public final String x;
  public boolean y = false;
  public final w z;
  
  public SavedStateHandleController(String paramString, w paramw)
  {
    x = paramString;
    z = paramw;
  }
  
  public static void b(d.v.a parama, g paramg)
  {
    g.b localb = b;
    if ((localb != g.b.INITIALIZED) && (!localb.isAtLeast(g.b.STARTED))) {
      paramg.a(new SavedStateHandleController.1(paramg, parama));
    } else {
      parama.a(SavedStateHandleController.a.class);
    }
  }
  
  public void a(l paraml, g.a parama)
  {
    if (parama == g.a.ON_DESTROY)
    {
      y = false;
      getLifecyclea.remove(this);
    }
  }
  
  public void a(d.v.a parama, g paramg)
  {
    if (!y)
    {
      y = true;
      paramg.a(this);
      paramg = x;
      a.b localb = z.b;
      if ((a.b)a.b(paramg, localb) == null) {
        return;
      }
      throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }
    throw new IllegalStateException("Already attached to lifecycleOwner");
  }
}

/* Location:
 * Qualified Name:     base.androidx.lifecycle.SavedStateHandleController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */