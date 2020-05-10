package e.c.c.w;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class r<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  public static final Comparator<Comparable> E = new a();
  public int A = 0;
  public final e<K, V> B = new e();
  public r<K, V>.b C;
  public r<K, V>.c D;
  public Comparator<? super K> x;
  public e<K, V> y;
  public int z = 0;
  
  public r()
  {
    if (localComparator == null) {
      localComparator = E;
    }
    x = localComparator;
  }
  
  public e<K, V> a(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramObject != null) {}
    try
    {
      localObject2 = a(paramObject, false);
      return (e<K, V>)localObject2;
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
  }
  
  public e<K, V> a(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = x;
    Object localObject = y;
    if (localObject != null)
    {
      Comparable localComparable;
      if (localComparator == E) {
        localComparable = (Comparable)paramK;
      } else {
        localComparable = null;
      }
      for (;;)
      {
        if (localComparable != null) {
          i = localComparable.compareTo(C);
        } else {
          i = localComparator.compare(paramK, C);
        }
        if (i == 0) {
          return (e<K, V>)localObject;
        }
        if (i < 0) {
          locale = y;
        } else {
          locale = z;
        }
        if (locale == null) {
          break;
        }
        localObject = locale;
      }
    }
    int i = 0;
    if (!paramBoolean) {
      return null;
    }
    e locale = B;
    if (localObject == null)
    {
      if ((localComparator == E) && (!(paramK instanceof Comparable)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramK.getClass().getName());
        ((StringBuilder)localObject).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject).toString());
      }
      paramK = new e((e)localObject, paramK, locale, B);
      y = paramK;
    }
    else
    {
      paramK = new e((e)localObject, paramK, locale, B);
      if (i < 0) {
        y = paramK;
      } else {
        z = paramK;
      }
      a((e)localObject, true);
    }
    z += 1;
    A += 1;
    return paramK;
  }
  
  public e<K, V> a(Map.Entry<?, ?> paramEntry)
  {
    e locale = a(paramEntry.getKey());
    int i = 1;
    if (locale != null)
    {
      Object localObject = D;
      paramEntry = paramEntry.getValue();
      if ((localObject != paramEntry) && ((localObject == null) || (!localObject.equals(paramEntry)))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
      {
        j = i;
        break label76;
      }
    }
    int j = 0;
    label76:
    if (j != 0) {
      paramEntry = locale;
    } else {
      paramEntry = null;
    }
    return paramEntry;
  }
  
  public final void a(e<K, V> parame)
  {
    e locale1 = y;
    e locale2 = z;
    e locale3 = y;
    e locale4 = z;
    z = locale3;
    if (locale3 != null) {
      x = parame;
    }
    a(parame, locale2);
    y = parame;
    x = locale2;
    int i = 0;
    if (locale1 != null) {
      j = E;
    } else {
      j = 0;
    }
    if (locale3 != null) {
      k = E;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    E = k;
    int j = i;
    if (locale4 != null) {
      j = E;
    }
    E = (Math.max(k, j) + 1);
  }
  
  public final void a(e<K, V> parame1, e<K, V> parame2)
  {
    e locale = x;
    x = null;
    if (parame2 != null) {
      x = locale;
    }
    if (locale != null)
    {
      if (y == parame1) {
        y = parame2;
      } else {
        z = parame2;
      }
    }
    else {
      y = parame2;
    }
  }
  
  public final void a(e<K, V> parame, boolean paramBoolean)
  {
    while (parame != null)
    {
      e locale1 = y;
      e locale2 = z;
      int i = 0;
      int j = 0;
      int k;
      if (locale1 != null) {
        k = E;
      } else {
        k = 0;
      }
      int m;
      if (locale2 != null) {
        m = E;
      } else {
        m = 0;
      }
      int n = k - m;
      e locale3;
      if (n == -2)
      {
        locale1 = y;
        locale3 = z;
        if (locale3 != null) {
          k = E;
        } else {
          k = 0;
        }
        m = j;
        if (locale1 != null) {
          m = E;
        }
        k = m - k;
        if ((k != -1) && ((k != 0) || (paramBoolean)))
        {
          b(locale2);
          a(parame);
        }
        else
        {
          a(parame);
        }
        if (paramBoolean) {
          break;
        }
      }
      else if (n == 2)
      {
        locale2 = y;
        locale3 = z;
        if (locale3 != null) {
          k = E;
        } else {
          k = 0;
        }
        m = i;
        if (locale2 != null) {
          m = E;
        }
        k = m - k;
        if ((k != 1) && ((k != 0) || (paramBoolean)))
        {
          a(locale1);
          b(parame);
        }
        else
        {
          b(parame);
        }
        if (paramBoolean) {
          break;
        }
      }
      else if (n == 0)
      {
        E = (k + 1);
        if (paramBoolean) {
          break;
        }
      }
      else
      {
        E = (Math.max(k, m) + 1);
        if (!paramBoolean) {
          break;
        }
      }
      parame = x;
    }
  }
  
  public final void b(e<K, V> parame)
  {
    e locale1 = y;
    e locale2 = z;
    e locale3 = y;
    e locale4 = z;
    y = locale4;
    if (locale4 != null) {
      x = parame;
    }
    a(parame, locale1);
    z = parame;
    x = locale1;
    int i = 0;
    if (locale2 != null) {
      j = E;
    } else {
      j = 0;
    }
    if (locale4 != null) {
      k = E;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    E = k;
    int j = i;
    if (locale3 != null) {
      j = E;
    }
    E = (Math.max(k, j) + 1);
  }
  
  public void b(e<K, V> parame, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = B;
      A = A;
      A.B = ((e)localObject1);
    }
    Object localObject1 = y;
    Object localObject2 = z;
    Object localObject3 = x;
    int i = 0;
    if ((localObject1 != null) && (localObject2 != null))
    {
      if (E > E)
      {
        localObject3 = z;
        localObject2 = localObject1;
        for (localObject1 = localObject3;; localObject1 = z)
        {
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          if (localObject2 == null) {
            break;
          }
        }
      }
      for (localObject1 = y; localObject1 != null; localObject1 = localObject3)
      {
        localObject3 = y;
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      b((e)localObject1, false);
      localObject2 = y;
      int j;
      if (localObject2 != null)
      {
        j = E;
        y = ((e)localObject2);
        x = ((e)localObject1);
        y = null;
      }
      else
      {
        j = 0;
      }
      localObject2 = z;
      if (localObject2 != null)
      {
        i = E;
        z = ((e)localObject2);
        x = ((e)localObject1);
        z = null;
      }
      E = (Math.max(j, i) + 1);
      a(parame, (e)localObject1);
      return;
    }
    if (localObject1 != null)
    {
      a(parame, (e)localObject1);
      y = null;
    }
    else if (localObject2 != null)
    {
      a(parame, (e)localObject2);
      z = null;
    }
    else
    {
      a(parame, null);
    }
    a((e)localObject3, false);
    z -= 1;
    A += 1;
  }
  
  public void clear()
  {
    y = null;
    z = 0;
    A += 1;
    e locale = B;
    B = locale;
    A = locale;
  }
  
  public boolean containsKey(Object paramObject)
  {
    boolean bool;
    if (a(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    b localb = C;
    if (localb == null)
    {
      localb = new b();
      C = localb;
    }
    return localb;
  }
  
  public V get(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null) {
      paramObject = D;
    } else {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  public Set<K> keySet()
  {
    c localc = D;
    if (localc == null)
    {
      localc = new c();
      D = localc;
    }
    return localc;
  }
  
  public V put(K paramK, V paramV)
  {
    if (paramK != null)
    {
      e locale = a(paramK, true);
      paramK = D;
      D = paramV;
      return paramK;
    }
    throw new NullPointerException("key == null");
  }
  
  public V remove(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null) {
      b((e)paramObject, true);
    }
    if (paramObject != null) {
      paramObject = D;
    } else {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  public int size()
  {
    return z;
  }
  
  public static final class a
    implements Comparator<Comparable>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo((Comparable)paramObject2);
    }
  }
  
  public class b
    extends AbstractSet<Map.Entry<K, V>>
  {
    public b() {}
    
    public void clear()
    {
      r.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof Map.Entry)) && (a((Map.Entry)paramObject) != null)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = a((Map.Entry)paramObject);
      if (paramObject == null) {
        return false;
      }
      b((r.e)paramObject, true);
      return true;
    }
    
    public int size()
    {
      return z;
    }
    
    public class a
      extends r<K, V>.d<Map.Entry<K, V>>
    {
      public a()
      {
        super();
      }
      
      public Object next()
      {
        return a();
      }
    }
  }
  
  public final class c
    extends AbstractSet<K>
  {
    public c() {}
    
    public void clear()
    {
      r.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (a(paramObject) != null) {
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
      r localr = r.this;
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
      return z;
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
  
  public abstract class d<T>
    implements Iterator<T>
  {
    public r.e<K, V> x;
    public r.e<K, V> y;
    public int z;
    
    public d()
    {
      this$1 = r.this;
      x = B.A;
      y = null;
      z = A;
    }
    
    public final r.e<K, V> a()
    {
      r.e locale = x;
      r localr = r.this;
      if (locale != B)
      {
        if (A == z)
        {
          x = A;
          y = locale;
          return locale;
        }
        throw new ConcurrentModificationException();
      }
      throw new NoSuchElementException();
    }
    
    public final boolean hasNext()
    {
      boolean bool;
      if (x != B) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final void remove()
    {
      r.e locale = y;
      if (locale != null)
      {
        b(locale, true);
        y = null;
        z = A;
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  public static final class e<K, V>
    implements Map.Entry<K, V>
  {
    public e<K, V> A;
    public e<K, V> B;
    public final K C;
    public V D;
    public int E;
    public e<K, V> x;
    public e<K, V> y;
    public e<K, V> z;
    
    public e()
    {
      C = null;
      B = this;
      A = this;
    }
    
    public e(e<K, V> parame1, K paramK, e<K, V> parame2, e<K, V> parame3)
    {
      x = parame1;
      C = paramK;
      E = 1;
      A = parame2;
      B = parame3;
      A = this;
      B = this;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (Map.Entry)paramObject;
        Object localObject = C;
        if (localObject == null)
        {
          bool3 = bool2;
          if (((Map.Entry)paramObject).getKey() != null) {
            break label108;
          }
        }
        else
        {
          bool3 = bool2;
          if (!localObject.equals(((Map.Entry)paramObject).getKey())) {
            break label108;
          }
        }
        localObject = D;
        if (localObject == null)
        {
          bool3 = bool2;
          if (((Map.Entry)paramObject).getValue() != null) {
            break label108;
          }
        }
        else
        {
          bool3 = bool2;
          if (!localObject.equals(((Map.Entry)paramObject).getValue())) {
            break label108;
          }
        }
        bool3 = true;
      }
      label108:
      return bool3;
    }
    
    public K getKey()
    {
      return (K)C;
    }
    
    public V getValue()
    {
      return (V)D;
    }
    
    public int hashCode()
    {
      Object localObject = C;
      int i = 0;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = localObject.hashCode();
      }
      localObject = D;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      return j ^ i;
    }
    
    public V setValue(V paramV)
    {
      Object localObject = D;
      D = paramV;
      return (V)localObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(C);
      localStringBuilder.append("=");
      localStringBuilder.append(D);
      return localStringBuilder.toString();
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */