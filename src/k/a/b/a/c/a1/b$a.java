package k.a.b.a.c.a1;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.l.d;

public class b$a
  extends AbstractList
{
  public d x;
  
  public b$a(d paramd)
  {
    x = paramd;
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
    d locald = x;
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
 * Qualified Name:     base.k.a.b.a.c.a1.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */