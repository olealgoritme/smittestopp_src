package d.f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends h<K, V>
  implements Map<K, V>
{
  public g<K, V> E;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(h paramh)
  {
    if (paramh != null)
    {
      int i = z;
      b(z + i);
      int j = z;
      int k = 0;
      if (j == 0)
      {
        if (i > 0)
        {
          System.arraycopy(x, 0, x, 0, i);
          System.arraycopy(y, 0, y, 0, i << 1);
          z = i;
        }
      }
      else {
        while (k < i)
        {
          put(paramh.c(k), paramh.e(k));
          k++;
        }
      }
    }
  }
  
  public final g<K, V> b()
  {
    if (E == null) {
      E = new a.a(this);
    }
    return E;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    g localg = b();
    if (a == null) {
      a = new g.b(localg);
    }
    return a;
  }
  
  public Set<K> keySet()
  {
    g localg = b();
    if (b == null) {
      b = new g.c(localg);
    }
    return b;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    int i = z;
    b(paramMap.size() + i);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      put(paramMap.getKey(), paramMap.getValue());
    }
  }
  
  public Collection<V> values()
  {
    g localg = b();
    if (c == null) {
      c = new g.e(localg);
    }
    return c;
  }
}

/* Location:
 * Qualified Name:     base.d.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */