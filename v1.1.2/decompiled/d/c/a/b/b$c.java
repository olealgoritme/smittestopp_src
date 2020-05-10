package d.c.a.b;

import java.util.Map.Entry;

public class b$c<K, V>
  implements Map.Entry<K, V>
{
  public c<K, V> A;
  public final K x;
  public final V y;
  public c<K, V> z;
  
  public b$c(K paramK, V paramV)
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

/* Location:
 * Qualified Name:     d.c.a.b.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */