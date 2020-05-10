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
  public b.c<K, V> x;
  public b.c<K, V> y;
  public WeakHashMap<b.f<K, V>, Boolean> z = new WeakHashMap();
  
  public b.c<K, V> a(K paramK)
  {
    for (b.c localc = x; (localc != null) && (!x.equals(paramK)); localc = z) {}
    return localc;
  }
  
  public b.c<K, V> a(K paramK, V paramV)
  {
    paramK = new b.c(paramK, paramV);
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
    b.d locald = new b.d(this);
    z.put(locald, Boolean.valueOf(false));
    return locald;
  }
  
  public V b(K paramK, V paramV)
  {
    b.c localc = a(paramK);
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
      localObject2 = (b.e)paramObject;
      if (!((b.e)localObject2).hasNext()) {
        break;
      }
      localObject3 = (b.e)localObject1;
      if (!((b.e)localObject3).hasNext()) {
        break;
      }
      localObject2 = (Map.Entry)((b.e)localObject2).next();
      localObject3 = ((b.e)localObject3).next();
    } while (((localObject2 != null) || (localObject3 == null)) && ((localObject2 == null) || (((Map.Entry)localObject2).equals(localObject3))));
    return false;
    if ((((b.e)localObject2).hasNext()) || (((b.e)localObject1).hasNext())) {
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
      b.e locale = (b.e)localIterator;
      if (!locale.hasNext()) {
        break;
      }
      i += ((Map.Entry)locale.next()).hashCode();
    }
    return i;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    b.a locala = new b.a(x, y);
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
        ((b.f)((Iterator)localObject).next()).a(paramK);
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
      b.e locale = (b.e)localIterator;
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
}

/* Location:
 * Qualified Name:     base.d.c.a.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */