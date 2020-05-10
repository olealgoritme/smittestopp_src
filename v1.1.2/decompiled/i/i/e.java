package i.i;

import i.k.b.g;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  implements Map, Serializable
{
  public static final e x = new e();
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(Object paramObject)
  {
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    if ((paramObject instanceof Void))
    {
      if ((Void)paramObject != null) {
        return false;
      }
      g.a("value");
      throw null;
    }
    return false;
  }
  
  public final Set<Map.Entry> entrySet()
  {
    return f.x;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof Map)) && (((Map)paramObject).isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final Object get(Object paramObject)
  {
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public final Set<Object> keySet()
  {
    return f.x;
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Object remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return 0;
  }
  
  public String toString()
  {
    return "{}";
  }
  
  public final Collection values()
  {
    return d.x;
  }
}

/* Location:
 * Qualified Name:     i.i.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */