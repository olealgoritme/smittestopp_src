package h.o;

import h.e;
import h.k.a.p;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class b$a
  implements Iterator<h.l.c>, Object
{
  public h.l.c A;
  public int B;
  public int x = -1;
  public int y;
  public int z;
  
  public b$a()
  {
    int i = b;
    int j = a.length();
    if (j >= 0)
    {
      int k;
      if (i < 0)
      {
        k = 0;
      }
      else
      {
        k = i;
        if (i > j) {
          k = j;
        }
      }
      y = k;
      z = k;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(j);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(0);
    localStringBuilder.append('.');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final void a()
  {
    int i = z;
    int j = 0;
    if (i < 0)
    {
      x = 0;
      A = null;
    }
    else
    {
      i = C.c;
      int k;
      if (i > 0)
      {
        k = B + 1;
        B = k;
        if (k >= i) {}
      }
      else
      {
        if (z <= C.a.length()) {
          break label105;
        }
      }
      A = new h.l.c(y, g.a(C.a));
      z = -1;
      break label269;
      label105:
      Object localObject = C;
      localObject = (h.c)d.a(a, Integer.valueOf(z));
      if (localObject == null)
      {
        A = new h.l.c(y, g.a(C.a));
        z = -1;
      }
      else
      {
        int m = ((Number)x).intValue();
        i = ((Number)y).intValue();
        k = y;
        if (m <= Integer.MIN_VALUE)
        {
          localObject = h.l.c.B;
          localObject = h.l.c.A;
        }
        else
        {
          localObject = new h.l.c(k, m - 1);
        }
        A = ((h.l.c)localObject);
        k = m + i;
        y = k;
        if (i == 0) {
          j = 1;
        }
        z = (k + j);
      }
      label269:
      x = 1;
    }
  }
  
  public boolean hasNext()
  {
    if (x == -1) {
      a();
    }
    int i = x;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public Object next()
  {
    if (x == -1) {
      a();
    }
    if (x != 0)
    {
      h.l.c localc = A;
      if (localc != null)
      {
        A = null;
        x = -1;
        return localc;
      }
      throw new e("null cannot be cast to non-null type kotlin.ranges.IntRange");
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}

/* Location:
 * Qualified Name:     base.h.o.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */