package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.n.g;
import l.a.b.a.b.n.o;

public final class e$a
  extends AbstractList
{
  public g x;
  
  public e$a(g paramg)
  {
    x = paramg;
  }
  
  public Object get(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5) {
                return Boolean.valueOf(x.f);
              }
              throw new IllegalStateException(a.a("Unknown index ", paramInt));
            }
            return x.e;
          }
          return Boolean.valueOf(x.d);
        }
        return x.c;
      }
      return x.b;
    }
    return Boolean.valueOf(x.a.getValue());
  }
  
  public int size()
  {
    g localg = x;
    int i;
    if (f) {
      i = 6;
    } else if (e != null) {
      i = 5;
    } else if (d) {
      i = 4;
    } else if (c != null) {
      i = 3;
    } else {
      i = 2;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */