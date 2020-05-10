package i.l;

import e.c.a.a.b.l.c;
import java.util.Iterator;

public class a
  implements Iterable<Integer>, Object
{
  public final int x;
  public final int y;
  public final int z;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 != Integer.MIN_VALUE)
      {
        x = paramInt1;
        if (paramInt3 > 0)
        {
          if (paramInt1 < paramInt2) {
            paramInt2 -= c.b(c.b(paramInt2, paramInt3) - c.b(paramInt1, paramInt3), paramInt3);
          }
        }
        else
        {
          if (paramInt3 >= 0) {
            break label100;
          }
          if (paramInt1 > paramInt2)
          {
            int i = -paramInt3;
            paramInt2 += c.b(c.b(paramInt1, i) - c.b(paramInt2, i), i);
          }
        }
        y = paramInt2;
        z = paramInt3;
        return;
        label100:
        throw new IllegalArgumentException("Step is zero.");
      }
      throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }
    throw new IllegalArgumentException("Step must be non-zero.");
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      if ((!isEmpty()) || (!((a)paramObject).isEmpty()))
      {
        int i = x;
        paramObject = (a)paramObject;
        if ((i != x) || (y != y) || (z != z)) {}
      }
      else
      {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public int hashCode()
  {
    int i;
    if (isEmpty()) {
      i = -1;
    } else {
      i = (x * 31 + y) * 31 + z;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    int i = z;
    boolean bool = true;
    if (i > 0 ? x <= y : x >= y) {
      bool = false;
    }
    return bool;
  }
  
  public Iterator iterator()
  {
    return new b(x, y, z);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    int i;
    if (z > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(x);
      localStringBuilder.append("..");
      localStringBuilder.append(y);
      localStringBuilder.append(" step ");
      i = z;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(x);
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(y);
      localStringBuilder.append(" step ");
      i = -z;
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     i.l.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */