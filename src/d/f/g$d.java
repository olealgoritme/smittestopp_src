package d.f;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public final class g$d
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  public int x;
  public int y;
  public boolean z = false;
  
  public g$d(g paramg)
  {
    x = (paramg.c() - 1);
    y = -1;
  }
  
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
      if (d.a(((Map.Entry)paramObject).getKey(), A.a(y, 0)))
      {
        bool1 = bool2;
        if (d.a(((Map.Entry)paramObject).getValue(), A.a(y, 1))) {
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
      return (K)A.a(y, 0);
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public V getValue()
  {
    if (z) {
      return (V)A.a(y, 1);
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
      Object localObject1 = A;
      int i = y;
      int j = 0;
      localObject1 = ((g)localObject1).a(i, 0);
      Object localObject2 = A.a(y, 1);
      if (localObject1 == null) {
        i = 0;
      } else {
        i = localObject1.hashCode();
      }
      if (localObject2 != null) {
        j = localObject2.hashCode();
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
      A.a(y);
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
      return (V)A.a(y, paramV);
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

/* Location:
 * Qualified Name:     base.d.f.g.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */