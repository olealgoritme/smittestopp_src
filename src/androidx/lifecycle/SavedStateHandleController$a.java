package androidx.lifecycle;

import d.o.e0;
import d.o.f0;
import d.o.g;
import d.o.l;
import d.o.y;
import d.v.a;
import d.v.a.a;
import d.v.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class SavedStateHandleController$a
  implements a.a
{
  public void a(c paramc)
  {
    if ((paramc instanceof f0))
    {
      e0 locale0 = ((f0)paramc).getViewModelStore();
      a locala = paramc.getSavedStateRegistry();
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

/* Location:
 * Qualified Name:     base.androidx.lifecycle.SavedStateHandleController.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */