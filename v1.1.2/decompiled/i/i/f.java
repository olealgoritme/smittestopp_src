package i.i;

import i.k.b.e;
import i.k.b.g;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class f
  implements Set, Serializable
{
  public static final f x = new f();
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Void))
    {
      if ((Void)paramObject != null) {
        return false;
      }
      g.a("element");
      throw null;
    }
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    if (paramCollection != null) {
      return paramCollection.isEmpty();
    }
    g.a("elements");
    throw null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof Set)) && (((Set)paramObject).isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return c.x;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return 0;
  }
  
  public Object[] toArray()
  {
    return e.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return e.a(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return "[]";
  }
}

/* Location:
 * Qualified Name:     i.i.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */