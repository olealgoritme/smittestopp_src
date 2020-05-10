package d.f;

import java.util.Collection;
import java.util.Iterator;

public final class g$e
  implements Collection<V>
{
  public g$e(g paramg) {}
  
  public boolean add(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    x.a();
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool;
    if (x.b(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (x.c() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<V> iterator()
  {
    return new g.a(x, 1);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = x.b(paramObject);
    if (i >= 0)
    {
      x.a(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    int i = x.c();
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      int k = i;
      int m = j;
      if (paramCollection.contains(x.a(j, 1)))
      {
        x.a(j);
        m = j - 1;
        k = i - 1;
        bool = true;
      }
      j = m + 1;
      i = k;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int i = x.c();
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      int k = i;
      int m = j;
      if (!paramCollection.contains(x.a(j, 1)))
      {
        x.a(j);
        m = j - 1;
        k = i - 1;
        bool = true;
      }
      j = m + 1;
      i = k;
    }
    return bool;
  }
  
  public int size()
  {
    return x.c();
  }
  
  public Object[] toArray()
  {
    return x.b(1);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return x.a(paramArrayOfT, 1);
  }
}

/* Location:
 * Qualified Name:     base.d.f.g.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */