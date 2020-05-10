package d.m.a;

import android.util.Log;
import androidx.fragment.app.Fragment;
import d.o.a0;
import d.o.e0;
import d.o.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class t
  extends y
{
  public static final a0 i = new a();
  public final HashMap<String, Fragment> c = new HashMap();
  public final HashMap<String, t> d = new HashMap();
  public final HashMap<String, e0> e = new HashMap();
  public final boolean f;
  public boolean g = false;
  public boolean h = false;
  
  public t(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public boolean a(Fragment paramFragment)
  {
    if (!c.containsKey(mWho)) {
      return true;
    }
    if (f) {
      return g;
    }
    return h ^ true;
  }
  
  public void b()
  {
    if (p.c(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCleared called for ");
      localStringBuilder.append(this);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    g = true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (t.class == paramObject.getClass()))
    {
      paramObject = (t)paramObject;
      if ((!c.equals(c)) || (!d.equals(d)) || (!e.equals(e))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = c.hashCode();
    int k = d.hashCode();
    return e.hashCode() + (k + j * 31) * 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FragmentManagerViewModel{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("} Fragments (");
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") Child Non Config (");
    localIterator = d.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") ViewModelStores (");
    localIterator = e.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public static final class a
    implements a0
  {
    public <T extends y> T a(Class<T> paramClass)
    {
      return new t(true);
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */