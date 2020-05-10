package e.c.c.w;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class r$b
  extends AbstractSet<Map.Entry<K, V>>
{
  public r$b(r paramr) {}
  
  public void clear()
  {
    x.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof Map.Entry)) && (x.a((Map.Entry)paramObject) != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new r.b.a(this);
  }
  
  public boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = x.a((Map.Entry)paramObject);
    if (paramObject == null) {
      return false;
    }
    x.b((r.e)paramObject, true);
    return true;
  }
  
  public int size()
  {
    return x.z;
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.r.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */