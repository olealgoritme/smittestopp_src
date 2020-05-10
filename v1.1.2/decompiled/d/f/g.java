package d.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class g<K, V>
{
  public g<K, V>.b a;
  public g<K, V>.c b;
  public g<K, V>.e c;
  
  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    boolean bool;
    if (i != paramMap.size()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static <T> boolean a(Set<T> paramSet, Object paramObject)
  {
    boolean bool1 = true;
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        boolean bool2 = paramSet.containsAll((Collection)paramObject);
        if (bool2) {}
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    catch (NullPointerException|ClassCastException paramSet)
    {
      for (;;) {}
    }
    return false;
  }
  
  public abstract int a(Object paramObject);
  
  public abstract Object a(int paramInt1, int paramInt2);
  
  public abstract V a(int paramInt, V paramV);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(K paramK, V paramV);
  
  public <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int i = c();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < i) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    for (int j = 0; j < i; j++) {
      localObject[j] = a(j, paramInt);
    }
    if (localObject.length > i) {
      localObject[i] = null;
    }
    return (T[])localObject;
  }
  
  public abstract int b(Object paramObject);
  
  public abstract Map<K, V> b();
  
  public Object[] b(int paramInt)
  {
    int i = c();
    Object[] arrayOfObject = new Object[i];
    for (int j = 0; j < i; j++) {
      arrayOfObject[j] = a(j, paramInt);
    }
    return arrayOfObject;
  }
  
  public abstract int c();
  
  public final class a<T>
    implements Iterator<T>
  {
    public boolean A = false;
    public final int x;
    public int y;
    public int z;
    
    public a(int paramInt)
    {
      x = paramInt;
      y = c();
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (z < y) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public T next()
    {
      if (hasNext())
      {
        Object localObject = a(z, x);
        z += 1;
        A = true;
        return (T)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      if (A)
      {
        int i = z - 1;
        z = i;
        y -= 1;
        A = false;
        a(i);
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  public final class b
    implements Set<Map.Entry<K, V>>
  {
    public b() {}
    
    public boolean add(Object paramObject)
    {
      paramObject = (Map.Entry)paramObject;
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = c();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        a(localEntry.getKey(), localEntry.getValue());
      }
      boolean bool;
      if (i != c()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void clear()
    {
      a();
    }
    
    public boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      int i = a(((Map.Entry)paramObject).getKey());
      if (i < 0) {
        return false;
      }
      return d.a(a(i, 1), ((Map.Entry)paramObject).getValue());
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
      int i = c() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject1 = a(i, 0);
        Object localObject2 = a(i, 1);
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
      if (c() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new g.d(g.this);
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
      return c();
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
  
  public final class c
    implements Set<K>
  {
    public c() {}
    
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
      a();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (a(paramObject) >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      Map localMap = b();
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
      int i = c() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject = a(i, 0);
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
      if (c() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Iterator<K> iterator()
    {
      return new g.a(g.this, 0);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = a(paramObject);
      if (i >= 0)
      {
        a(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      Map localMap = b();
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
      return g.a(b(), paramCollection);
    }
    
    public int size()
    {
      return c();
    }
    
    public Object[] toArray()
    {
      return b(0);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return a(paramArrayOfT, 0);
    }
  }
  
  public final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    public int x = c() - 1;
    public int y = -1;
    public boolean z = false;
    
    public d() {}
    
    public boolean equals(Object paramObject)
    {
      if (z)
      {
        boolean bool1 = paramObject instanceof Map.Entry;
        boolean bool2 = false;
        if (!bool1) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        bool1 = bool2;
        if (d.a(((Map.Entry)paramObject).getKey(), a(y, 0)))
        {
          bool1 = bool2;
          if (d.a(((Map.Entry)paramObject).getValue(), a(y, 1))) {
            bool1 = true;
          }
        }
        return bool1;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public K getKey()
    {
      if (z) {
        return (K)a(y, 0);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public V getValue()
    {
      if (z) {
        return (V)a(y, 1);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (y < x) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      if (z)
      {
        Object localObject1 = g.this;
        int i = y;
        int j = 0;
        Object localObject2 = ((g)localObject1).a(i, 0);
        localObject1 = a(y, 1);
        if (localObject2 == null) {
          i = 0;
        } else {
          i = localObject2.hashCode();
        }
        if (localObject1 != null) {
          j = localObject1.hashCode();
        }
        return i ^ j;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public Object next()
    {
      if (hasNext())
      {
        y += 1;
        z = true;
        return this;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      if (z)
      {
        a(y);
        y -= 1;
        x -= 1;
        z = false;
        return;
      }
      throw new IllegalStateException();
    }
    
    public V setValue(V paramV)
    {
      if (z) {
        return (V)a(y, paramV);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getKey());
      localStringBuilder.append("=");
      localStringBuilder.append(getValue());
      return localStringBuilder.toString();
    }
  }
  
  public final class e
    implements Collection<V>
  {
    public e() {}
    
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
      a();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (b(paramObject) >= 0) {
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
      if (c() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Iterator<V> iterator()
    {
      return new g.a(g.this, 1);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = b(paramObject);
      if (i >= 0)
      {
        a(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      int i = c();
      int j = 0;
      boolean bool = false;
      while (j < i)
      {
        int k = i;
        int m = j;
        if (paramCollection.contains(a(j, 1)))
        {
          a(j);
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
      int i = c();
      int j = 0;
      boolean bool = false;
      while (j < i)
      {
        int k = i;
        int m = j;
        if (!paramCollection.contains(a(j, 1)))
        {
          a(j);
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
      return c();
    }
    
    public Object[] toArray()
    {
      return b(1);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return a(paramArrayOfT, 1);
    }
  }
}

/* Location:
 * Qualified Name:     d.f.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */