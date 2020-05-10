package k.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.k.n;

public final class x$a
  extends AbstractList
{
  public final n x;
  
  public x$a(n paramn)
  {
    x = paramn;
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
    n localn = x;
    int i;
    if (c != null) {
      i = 3;
    } else if (b != null) {
      i = 2;
    } else if (a != null) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.x.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */