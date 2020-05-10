package d.o;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class e0
{
  public final HashMap<String, y> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext()) {
      ((y)localIterator.next()).a();
    }
    a.clear();
  }
}

/* Location:
 * Qualified Name:     d.o.e0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */