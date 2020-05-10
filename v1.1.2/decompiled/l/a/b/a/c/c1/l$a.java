package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.h;
import l.a.b.a.b.j;
import l.a.b.a.b.n.m;

public class l$a
  extends AbstractList
{
  public m x;
  
  public l$a(m paramm)
  {
    x = paramm;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    case 9: 
      return x.j;
    case 8: 
      return x.i;
    case 7: 
      return x.h;
    case 6: 
      return x.g;
    case 5: 
      return x.f;
    case 4: 
      return x.e;
    case 3: 
      return x.d;
    case 2: 
      return x.c;
    case 1: 
      return x.b;
    }
    return x.a;
  }
  
  public int size()
  {
    Object localObject = x;
    int i;
    if (j != null)
    {
      i = 10;
    }
    else if (i != null)
    {
      i = 9;
    }
    else if (h != null)
    {
      i = 8;
    }
    else if (g != null)
    {
      i = 7;
    }
    else if (f != null)
    {
      i = 6;
    }
    else if (e != null)
    {
      i = 5;
    }
    else
    {
      localObject = d;
      if ((localObject != null) && (!((j)localObject).equals(j.z)))
      {
        i = 4;
      }
      else
      {
        localObject = x.c;
        if ((localObject != null) && (!((h)localObject).equals(h.B))) {
          i = 3;
        } else if (x.b != null) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.l.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */