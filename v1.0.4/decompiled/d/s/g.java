package d.s;

import d.o.a0;
import d.o.e0;
import d.o.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class g
  extends y
{
  public static final a0 d = new g.a();
  public final HashMap<UUID, e0> c = new HashMap();
  
  public void b()
  {
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext()) {
      ((e0)localIterator.next()).a();
    }
    c.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NavControllerViewModel{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("} ViewModelStores (");
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.s.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */