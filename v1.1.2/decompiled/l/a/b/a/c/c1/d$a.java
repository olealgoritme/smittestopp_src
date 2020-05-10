package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.n.f;

public class d$a
  extends AbstractList
{
  public f x;
  
  public d$a(f paramf)
  {
    x = paramf;
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
      return Boolean.valueOf(x.b);
    }
    return x.a;
  }
  
  public int size()
  {
    f localf = x;
    int i;
    if (c != null) {
      i = 3;
    } else if (b) {
      i = 2;
    } else {
      i = 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */