package androidx.savedstate;

import android.os.Bundle;
import d.c.a.b.b;
import d.v.a;
import d.v.a.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class Recreator$a
  implements a.b
{
  public final Set<String> a = new HashSet();
  
  public Recreator$a(a parama)
  {
    if ((a.b)a.b("androidx.savedstate.Restarter", this) == null) {
      return;
    }
    throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("classes_to_restore", new ArrayList(a));
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     base.androidx.savedstate.Recreator.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */