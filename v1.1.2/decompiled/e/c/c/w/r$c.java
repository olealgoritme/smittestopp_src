package e.c.c.w;

import java.util.AbstractSet;
import java.util.Iterator;

public final class r$c
  extends AbstractSet<K>
{
  public r$c(r paramr) {}
  
  public void clear()
  {
    x.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool;
    if (x.a(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<K> iterator()
  {
    return new a();
  }
  
  public boolean remove(Object paramObject)
  {
    r localr = x;
    paramObject = localr.a(paramObject);
    boolean bool = true;
    if (paramObject != null) {
      localr.b((r.e)paramObject, true);
    }
    if (paramObject == null) {
      bool = false;
    }
    return bool;
  }
  
  public int size()
  {
    return x.z;
  }
  
  public class a
    extends r<K, V>.d<K>
  {
    public a()
    {
      super();
    }
    
    public K next()
    {
      return (K)aC;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.r.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */