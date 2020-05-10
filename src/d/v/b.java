package d.v;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry.1;
import d.c.a.b.b.d;
import d.o.g;
import d.o.g.b;
import d.o.l;
import d.o.m;
import java.util.Map.Entry;

public final class b
{
  public final c a;
  public final a b;
  
  public b(c paramc)
  {
    a = paramc;
    b = new a();
  }
  
  public void a(Bundle paramBundle)
  {
    g localg = a.getLifecycle();
    if (b == g.b.INITIALIZED)
    {
      localg.a(new Recreator(a));
      a locala = b;
      if (!c)
      {
        if (paramBundle != null) {
          b = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        localg.a(new SavedStateRegistry.1(locala));
        c = true;
        return;
      }
      throw new IllegalStateException("SavedStateRegistry was already restored.");
    }
    throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
  }
  
  public void b(Bundle paramBundle)
  {
    Object localObject1 = b;
    if (localObject1 != null)
    {
      Bundle localBundle = new Bundle();
      Object localObject2 = b;
      if (localObject2 != null) {
        localBundle.putAll((Bundle)localObject2);
      }
      localObject2 = a.a();
      while (((b.d)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((b.d)localObject2).next();
        localBundle.putBundle((String)((Map.Entry)localObject1).getKey(), ((a.b)((Map.Entry)localObject1).getValue()).a());
      }
      paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", localBundle);
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.v.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */