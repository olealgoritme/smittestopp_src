package d.c.a.b;

import e.a.a.a.a;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public int A = 0;
  public c<K, V> x;
  public c<K, V> y;
  public WeakHashMap<f<K, V>, Boolean> z = new WeakHashMap();
  
  public c<K, V> a(K paramK)
  {
    for (c localc = x; (localc != null) && (!x.equals(paramK)); localc = z) {}
    return localc;
  }
  
  public c<K, V> a(K paramK, V paramV)
  {
    paramK = new c(paramK, paramV);
    A += 1;
    paramV = y;
    if (paramV == null)
    {
      x = paramK;
      y = paramK;
      return paramK;
    }
    z = paramK;
    A = paramV;
    y = paramK;
    return paramK;
  }
  
  public b<K, V>.d a()
  {
    d locald = new d();
    z.put(locald, Boolean.valueOf(false));
    return locald;
  }
  
  public V b(K paramK, V paramV)
  {
    c localc = a(paramK);
    if (localc != null) {
      return (V)y;
    }
    a(paramK, paramV);
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    Object localObject1 = (b)paramObject;
    if (A != A) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((b)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    do
    {
      localObject2 = (e)paramObject;
      if (!((e)localObject2).hasNext()) {
        break;
      }
      localObject3 = (e)localObject1;
      if (!((e)localObject3).hasNext()) {
        break;
      }
      localObject2 = (Map.Entry)((e)localObject2).next();
      localObject3 = ((e)localObject3).next();
    } while (((localObject2 != null) || (localObject3 == null)) && ((localObject2 == null) || (((Map.Entry)localObject2).equals(localObject3))));
    return false;
    if ((((e)localObject2).hasNext()) || (((e)localObject1).hasNext())) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    Iterator localIterator = iterator();
    int i = 0;
    for (;;)
    {
      e locale = (e)localIterator;
      if (!locale.hasNext()) {
        break;
      }
      i += ((Map.Entry)locale.next()).hashCode();
    }
    return i;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    a locala = new a(x, y);
    z.put(locala, Boolean.valueOf(false));
    return locala;
  }
  
  public V remove(K paramK)
  {
    paramK = a(paramK);
    if (paramK == null) {
      return null;
    }
    A -= 1;
    if (!z.isEmpty())
    {
      localObject = z.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).a(paramK);
      }
    }
    Object localObject = A;
    if (localObject != null) {
      z = z;
    } else {
      x = z;
    }
    localObject = z;
    if (localObject != null) {
      A = A;
    } else {
      y = A;
    }
    z = null;
    A = null;
    return (V)y;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("[");
    Iterator localIterator = iterator();
    for (;;)
    {
      e locale = (e)localIterator;
      if (!locale.hasNext()) {
        break;
      }
      localStringBuilder.append(((Map.Entry)locale.next()).toString());
      if (locale.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class a<K, V>
    extends b.e<K, V>
  {
    public a(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    public b.c<K, V> b(b.c<K, V> paramc)
    {
      return A;
    }
    
    public b.c<K, V> c(b.c<K, V> paramc)
    {
      return z;
    }
  }
  
  public static class b<K, V>
    extends b.e<K, V>
  {
    public b(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    public b.c<K, V> b(b.c<K, V> paramc)
    {
      return z;
    }
    
    public b.c<K, V> c(b.c<K, V> paramc)
    {
      return A;
    }
  }
  
  public static class c<K, V>
    implements Map.Entry<K, V>
  {
    public c<K, V> A;
    public final K x;
    public final V y;
    public c<K, V> z;
    
    public c(K paramK, V paramV)
    {
      x = paramK;
      y = paramV;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      if ((!x.equals(x)) || (!y.equals(y))) {
        bool = false;
      }
      return bool;
    }
    
    public K getKey()
    {
      return (K)x;
    }
    
    public V getValue()
    {
      return (V)y;
    }
    
    public int hashCode()
    {
      return x.hashCode() ^ y.hashCode();
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(x);
      localStringBuilder.append("=");
      localStringBuilder.append(y);
      return localStringBuilder.toString();
    }
  }
  
  public class d
    implements Iterator<Map.Entry<K, V>>, b.f<K, V>
  {
    public b.c<K, V> x;
    public boolean y = true;
    
    public d() {}
    
    public void a(b.c<K, V> paramc)
    {
      b.c localc = x;
      if (paramc == localc)
      {
        paramc = A;
        x = paramc;
        boolean bool;
        if (paramc == null) {
          bool = true;
        } else {
          bool = false;
        }
        y = bool;
      }
    }
    
    public boolean hasNext()
    {
      boolean bool1 = y;
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        if (x == null) {
          bool3 = false;
        }
        return bool3;
      }
      b.c localc = x;
      if ((localc != null) && (z != null)) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    
    public Object next()
    {
      if (y)
      {
        y = false;
        x = x;
      }
      else
      {
        b.c localc = x;
        if (localc != null) {
          localc = z;
        } else {
          localc = null;
        }
        x = localc;
      }
      return x;
    }
  }
  
  public static abstract class e<K, V>
    implements Iterator<Map.Entry<K, V>>, b.f<K, V>
  {
    public b.c<K, V> x;
    public b.c<K, V> y;
    
    public e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      x = paramc2;
      y = paramc1;
    }
    
    public void a(b.c<K, V> paramc)
    {
      b.c localc1 = x;
      Object localObject = null;
      if ((localc1 == paramc) && (paramc == y))
      {
        y = null;
        x = null;
      }
      localc1 = x;
      if (localc1 == paramc) {
        x = b(localc1);
      }
      localc1 = y;
      if (localc1 == paramc)
      {
        b.c localc2 = x;
        paramc = (b.c<K, V>)localObject;
        if (localc1 != localc2) {
          if (localc2 == null) {
            paramc = (b.c<K, V>)localObject;
          } else {
            paramc = c(localc1);
          }
        }
        y = paramc;
      }
    }
    
    public abstract b.c<K, V> b(b.c<K, V> paramc);
    
    public abstract b.c<K, V> c(b.c<K, V> paramc);
    
    public boolean hasNext()
    {
      boolean bool;
      if (y != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Object next()
    {
      b.c localc1 = y;
      b.c localc2 = x;
      if ((localc1 != localc2) && (localc2 != null)) {
        localc2 = c(localc1);
      } else {
        localc2 = null;
      }
      y = localc2;
      return localc1;
    }
  }
  
  public static abstract interface f<K, V>
  {
    public abstract void a(b.c<K, V> paramc);
  }
}

/* Location:
 * Qualified Name:     d.c.a.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */