package d.f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g$c
  implements Set<K>
{
  public g$c(g paramg) {}
  
  public boolean add(K paramK)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends K> paramCollection)
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
    if (x.a(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    Map localMap = x.b();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!localMap.containsKey(paramCollection.next())) {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    return g.a(this, paramObject);
  }
  
  public int hashCode()
  {
    int i = x.c() - 1;
    int j = 0;
    while (i >= 0)
    {
      Object localObject = x.a(i, 0);
      int k;
      if (localObject == null) {
        k = 0;
      } else {
        k = localObject.hashCode();
      }
      j += k;
      i--;
    }
    return j;
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
  
  public Iterator<K> iterator()
  {
    return new g.a(x, 0);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = x.a(paramObject);
    if (i >= 0)
    {
      x.a(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    Map localMap = x.b();
    int i = localMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localMap.remove(paramCollection.next());
    }
    boolean bool;
    if (i != localMap.size()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return g.a(x.b(), paramCollection);
  }
  
  public int size()
  {
    return x.c();
  }
  
  public Object[] toArray()
  {
    return x.b(0);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return x.a(paramArrayOfT, 0);
  }
}

/* Location:
 * Qualified Name:     base.d.f.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */