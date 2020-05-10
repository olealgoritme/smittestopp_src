package k.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.k.l;

public final class v$a
  extends AbstractList
{
  public final l x;
  
  public v$a(l paraml)
  {
    x = paraml;
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
            if (paramInt == 4) {
              return x.e;
            }
            throw new IllegalStateException(a.a("Unknown index ", paramInt));
          }
          return x.d;
        }
        return x.c;
      }
      return x.b;
    }
    return x.a;
  }
  
  public int size()
  {
    l locall = x;
    int i;
    if (e != null) {
      i = 5;
    } else if (d != null) {
      i = 4;
    } else if (c != null) {
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
 * Qualified Name:     base.k.a.b.a.c.z0.v.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */