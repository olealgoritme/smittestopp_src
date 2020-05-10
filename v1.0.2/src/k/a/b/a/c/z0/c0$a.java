package k.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.h;
import k.a.b.a.b.k.u;
import k.a.b.a.b.k.w;
import k.a.b.a.b.k.x;
import k.a.b.a.b.k.y;

public final class c0$a
  extends AbstractList
{
  public final u x;
  
  public c0$a(u paramu)
  {
    x = paramu;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    case 10: 
      return x.g;
    case 9: 
      return x.k;
    case 8: 
      return x.j;
    case 7: 
      return x.i;
    case 6: 
      return x.h;
    case 5: 
      return x.f;
    case 4: 
      return Boolean.valueOf(x.e);
    case 3: 
      return x.d;
    case 2: 
      return x.c.getPolicy();
    case 1: 
      return x.b.getValue();
    }
    return x.a;
  }
  
  public int size()
  {
    Object localObject = x;
    int i;
    if (g != null)
    {
      i = 11;
    }
    else if (k != null)
    {
      i = 10;
    }
    else if (j != null)
    {
      i = 9;
    }
    else if (i != null)
    {
      i = 8;
    }
    else if (h != null)
    {
      i = 7;
    }
    else if (f != null)
    {
      i = 6;
    }
    else if (e)
    {
      i = 5;
    }
    else
    {
      localObject = d;
      if ((localObject != null) && (!((h)localObject).equals(h.z)))
      {
        i = 4;
      }
      else
      {
        localObject = x;
        if (c != y.SESSION_END) {
          i = 3;
        } else if (b != x.NONE) {
          i = 2;
        } else if (a != null) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.c0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */