package l.a.b.a.c.c1;

import java.util.AbstractList;
import l.a.b.a.b.n.n;
import l.a.b.a.b.n.o;
import l.a.b.a.b.n.p;

public class a$a
  extends AbstractList
{
  public l.a.b.a.b.n.a x;
  
  public a$a(l.a.b.a.b.n.a parama)
  {
    x = parama;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(e.a.a.a.a.a("Unknown index ", paramInt));
    case 13: 
      return x.n;
    case 12: 
      return x.m;
    case 11: 
      return x.l;
    case 10: 
      return x.k;
    case 9: 
      return x.j;
    case 8: 
      return Boolean.valueOf(x.i);
    case 7: 
      return x.h;
    case 6: 
      return x.g;
    case 5: 
      return x.f;
    case 4: 
      return x.e.getValue();
    case 3: 
      return x.d.getValue();
    case 2: 
      return Boolean.valueOf(x.c.getValue());
    case 1: 
      return x.b;
    }
    return x.a;
  }
  
  public int size()
  {
    Object localObject = x;
    int i;
    if (n != null)
    {
      i = 14;
    }
    else if (m != null)
    {
      i = 13;
    }
    else if (l != null)
    {
      i = 12;
    }
    else if (k != null)
    {
      i = 11;
    }
    else if (j != null)
    {
      i = 10;
    }
    else if (i)
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
    else
    {
      localObject = e;
      if ((localObject != null) && (!((Enum)localObject).equals(n.FIRST)))
      {
        i = 5;
      }
      else
      {
        localObject = x.d;
        if ((localObject != null) && (!((Enum)localObject).equals(p.MIXED))) {
          i = 4;
        } else {
          i = 3;
        }
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */