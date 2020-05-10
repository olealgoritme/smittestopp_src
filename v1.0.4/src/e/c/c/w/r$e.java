package e.c.c.w;

import java.util.Map.Entry;

public final class r$e<K, V>
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
  
  public r$e()
  {
    C = null;
    B = this;
    A = this;
  }
  
  public r$e(e<K, V> parame1, K paramK, e<K, V> parame2, e<K, V> parame3)
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

/* Location:
 * Qualified Name:     base.e.c.c.w.r.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */