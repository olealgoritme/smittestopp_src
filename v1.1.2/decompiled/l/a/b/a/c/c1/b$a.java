package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.h;
import l.a.b.a.b.n.b;

public class b$a
  extends AbstractList
{
  public b x;
  
  public b$a(b paramb)
  {
    x = paramb;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
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
    if (h != null)
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
      if ((localObject != null) && (!((h)localObject).equals(h.B))) {
        i = 5;
      } else {
        i = 4;
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */