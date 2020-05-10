package k.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.n.j;

public class g$a
  extends AbstractList
{
  public j x;
  
  public g$a(j paramj)
  {
    x = paramj;
  }
  
  public Object get(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return x.c;
        }
        throw new IllegalStateException(a.a("Unknown index ", paramInt));
      }
      return x.b;
    }
    return x.a;
  }
  
  public int size()
  {
    j localj = x;
    int i;
    if (c != null) {
      i = 3;
    } else if (b != null) {
      i = 2;
    } else {
      i = 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */