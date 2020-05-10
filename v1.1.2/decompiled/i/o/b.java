package i.o;

import i.e;
import i.k.a.p;
import i.n.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class b
  implements a<i.l.c>
{
  public final CharSequence a;
  public final int b;
  public final int c;
  public final p<CharSequence, Integer, i.c<Integer, Integer>> d;
  
  public b(CharSequence paramCharSequence, int paramInt1, int paramInt2, p<? super CharSequence, ? super Integer, i.c<Integer, Integer>> paramp) {}
  
  public Iterator<i.l.c> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<i.l.c>, Object
  {
    public i.l.c A;
    public int B;
    public int x = -1;
    public int y;
    public int z;
    
    public a()
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
        int k = C.c;
        if (k > 0)
        {
          i = B + 1;
          B = i;
          if (i >= k) {}
        }
        else
        {
          if (z <= C.a.length()) {
            break label105;
          }
        }
        A = new i.l.c(y, g.a(C.a));
        z = -1;
        break label269;
        label105:
        Object localObject = C;
        localObject = (i.c)d.a(a, Integer.valueOf(z));
        if (localObject == null)
        {
          A = new i.l.c(y, g.a(C.a));
          z = -1;
        }
        else
        {
          int m = ((Number)x).intValue();
          i = ((Number)y).intValue();
          k = y;
          if (m <= Integer.MIN_VALUE)
          {
            localObject = i.l.c.B;
            localObject = i.l.c.A;
          }
          else
          {
            localObject = new i.l.c(k, m - 1);
          }
          A = ((i.l.c)localObject);
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
        i.l.c localc = A;
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
}

/* Location:
 * Qualified Name:     i.o.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */