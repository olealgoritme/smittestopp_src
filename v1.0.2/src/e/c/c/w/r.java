package e.c.c.w;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;

public final class r<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  public static final Comparator<Comparable> E = new r.a();
  public int A = 0;
  public final r.e<K, V> B = new r.e();
  public r<K, V>.b C;
  public r<K, V>.c D;
  public Comparator<? super K> x;
  public r.e<K, V> y;
  public int z = 0;
  
  public r()
  {
    if (localComparator == null) {
      localComparator = E;
    }
    x = localComparator;
  }
  
  public r.e<K, V> a(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramObject != null) {}
    try
    {
      localObject2 = a(paramObject, false);
      return (r.e<K, V>)localObject2;
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
  }
  
  public r.e<K, V> a(K paramK, boolean paramBoolean)
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
          return (r.e<K, V>)localObject;
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
    r.e locale = B;
    if (localObject == null)
    {
      if ((localComparator == E) && (!(paramK instanceof Comparable)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramK.getClass().getName());
        ((StringBuilder)localObject).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject).toString());
      }
      paramK = new r.e((r.e)localObject, paramK, locale, B);
      y = paramK;
    }
    else
    {
      paramK = new r.e((r.e)localObject, paramK, locale, B);
      if (i < 0) {
        y = paramK;
      } else {
        z = paramK;
      }
      a((r.e)localObject, true);
    }
    z += 1;
    A += 1;
    return paramK;
  }
  
  public r.e<K, V> a(Map.Entry<?, ?> paramEntry)
  {
    r.e locale = a(paramEntry.getKey());
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
  
  public final void a(r.e<K, V> parame)
  {
    r.e locale1 = y;
    r.e locale2 = z;
    r.e locale3 = y;
    r.e locale4 = z;
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
  
  public final void a(r.e<K, V> parame1, r.e<K, V> parame2)
  {
    r.e locale = x;
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
  
  public final void a(r.e<K, V> parame, boolean paramBoolean)
  {
    while (parame != null)
    {
      r.e locale1 = y;
      r.e locale2 = z;
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
      r.e locale3;
      if (n == -2)
      {
        locale3 = y;
        locale1 = z;
        if (locale1 != null) {
          k = E;
        } else {
          k = 0;
        }
        m = j;
        if (locale3 != null) {
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
  
  public final void b(r.e<K, V> parame)
  {
    r.e locale1 = y;
    r.e locale2 = z;
    r.e locale3 = y;
    r.e locale4 = z;
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
  
  public void b(r.e<K, V> parame, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = B;
      A = A;
      A.B = ((r.e)localObject1);
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
      b((r.e)localObject1, false);
      localObject2 = y;
      int j;
      if (localObject2 != null)
      {
        j = E;
        y = ((r.e)localObject2);
        x = ((r.e)localObject1);
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
        z = ((r.e)localObject2);
        x = ((r.e)localObject1);
        z = null;
      }
      E = (Math.max(j, i) + 1);
      a(parame, (r.e)localObject1);
      return;
    }
    if (localObject1 != null)
    {
      a(parame, (r.e)localObject1);
      y = null;
    }
    else if (localObject2 != null)
    {
      a(parame, (r.e)localObject2);
      z = null;
    }
    else
    {
      a(parame, null);
    }
    a((r.e)localObject3, false);
    z -= 1;
    A += 1;
  }
  
  public void clear()
  {
    y = null;
    z = 0;
    A += 1;
    r.e locale = B;
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
    r.b localb = C;
    if (localb == null)
    {
      localb = new r.b(this);
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
    r.c localc = D;
    if (localc == null)
    {
      localc = new r.c(this);
      D = localc;
    }
    return localc;
  }
  
  public V put(K paramK, V paramV)
  {
    if (paramK != null)
    {
      r.e locale = a(paramK, true);
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
      b((r.e)paramObject, true);
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
}

/* Location:
 * Qualified Name:     base.e.c.c.w.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */