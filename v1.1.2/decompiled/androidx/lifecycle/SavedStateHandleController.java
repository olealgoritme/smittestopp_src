package androidx.lifecycle;

import d.c.a.b.b;
import d.o.e0;
import d.o.f0;
import d.o.g;
import d.o.g.a;
import d.o.g.b;
import d.o.j;
import d.o.l;
import d.o.m;
import d.o.w;
import d.o.y;
import d.v.a.a;
import d.v.a.b;
import d.v.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
  
  public static void b(final d.v.a parama, g paramg)
  {
    g.b localb = b;
    if ((localb != g.b.INITIALIZED) && (!localb.isAtLeast(g.b.STARTED))) {
      paramg.a(new j()
      {
        public void a(l paramAnonymousl, g.a paramAnonymousa)
        {
          if (paramAnonymousa == g.a.ON_START)
          {
            x).a.remove(this);
            parama.a(SavedStateHandleController.a.class);
          }
        }
      });
    } else {
      parama.a(a.class);
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
      String str = x;
      paramg = z.b;
      if ((a.b)a.b(str, paramg) == null) {
        return;
      }
      throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }
    throw new IllegalStateException("Already attached to lifecycleOwner");
  }
  
  public static final class a
    implements a.a
  {
    public void a(c paramc)
    {
      if ((paramc instanceof f0))
      {
        e0 locale0 = ((f0)paramc).getViewModelStore();
        d.v.a locala = paramc.getSavedStateRegistry();
        if (locale0 != null)
        {
          Iterator localIterator = new HashSet(a.keySet()).iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (String)localIterator.next();
            Object localObject2 = (y)a.get(localObject1);
            localObject1 = paramc.getLifecycle();
            localObject2 = (SavedStateHandleController)((y)localObject2).a("androidx.lifecycle.savedstate.vm.tag");
            if ((localObject2 != null) && (!y))
            {
              ((SavedStateHandleController)localObject2).a(locala, (g)localObject1);
              SavedStateHandleController.b(locala, (g)localObject1);
            }
          }
          if (!new HashSet(a.keySet()).isEmpty()) {
            locala.a(a.class);
          }
          return;
        }
        throw null;
      }
      throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
    }
  }
}

/* Location:
 * Qualified Name:     androidx.lifecycle.SavedStateHandleController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */