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
      E = new a();
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
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
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
  
  public class a
    extends g<K, V>
  {
    public a() {}
    
    public int a(Object paramObject)
    {
      return a.this.a(paramObject);
    }
    
    public Object a(int paramInt1, int paramInt2)
    {
      return y[((paramInt1 << 1) + paramInt2)];
    }
    
    public V a(int paramInt, V paramV)
    {
      Object localObject = a.this;
      paramInt = (paramInt << 1) + 1;
      localObject = y;
      V ? = localObject[paramInt];
      localObject[paramInt] = paramV;
      return ?;
    }
    
    public void a()
    {
      clear();
    }
    
    public void a(int paramInt)
    {
      d(paramInt);
    }
    
    public void a(K paramK, V paramV)
    {
      put(paramK, paramV);
    }
    
    public int b(Object paramObject)
    {
      return a.this.b(paramObject);
    }
    
    public Map<K, V> b()
    {
      return a.this;
    }
    
    public int c()
    {
      return z;
    }
  }
}

/* Location:
 * Qualified Name:     d.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */