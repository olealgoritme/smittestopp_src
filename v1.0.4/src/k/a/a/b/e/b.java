package k.a.a.b.e;

import java.io.Serializable;
import java.util.Map.Entry;

public abstract class b<L, R>
  implements Map.Entry<L, R>, Comparable<b<L, R>>, Serializable
{
  public int compareTo(Object paramObject)
  {
    Object localObject = (b)paramObject;
    k.a.a.b.c.a locala = new k.a.a.b.c.a();
    a locala1 = (a)this;
    paramObject = x;
    localObject = (a)localObject;
    locala.a(paramObject, x, null);
    locala.a(y, y, null);
    return a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      if ((!k.a.a.b.a.a(getKey(), ((Map.Entry)paramObject).getKey())) || (!k.a.a.b.a.a(getValue(), ((Map.Entry)paramObject).getValue()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final L getKey()
  {
    return (L)x;
  }
  
  public R getValue()
  {
    return (R)y;
  }
  
  public int hashCode()
  {
    Object localObject = getKey();
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = getKey().hashCode();
    }
    if (getValue() != null) {
      i = getValue().hashCode();
    }
    return j ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    a locala = (a)this;
    localStringBuilder.append(x);
    localStringBuilder.append(',');
    localStringBuilder.append(y);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.a.b.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */