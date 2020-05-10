package d.f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class g$b
  implements Set<Map.Entry<K, V>>
{
  public g$b(g paramg) {}
  
  public boolean add(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    int i = x.c();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      x.a(localEntry.getKey(), localEntry.getValue());
    }
    boolean bool;
    if (i != x.c()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void clear()
  {
    x.a();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    int i = x.a(((Map.Entry)paramObject).getKey());
    if (i < 0) {
      return false;
    }
    return d.a(x.a(i, 1), ((Map.Entry)paramObject).getValue());
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
      Object localObject1 = x.a(i, 0);
      Object localObject2 = x.a(i, 1);
      int k;
      if (localObject1 == null) {
        k = 0;
      } else {
        k = localObject1.hashCode();
      }
      int m;
      if (localObject2 == null) {
        m = 0;
      } else {
        m = localObject2.hashCode();
      }
      j += (k ^ m);
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
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new g.d(x);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return x.c();
  }
  
  public Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     base.d.f.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */