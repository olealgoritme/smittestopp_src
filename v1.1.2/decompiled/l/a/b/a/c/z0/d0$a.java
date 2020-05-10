package l.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.h;
import l.a.b.a.b.k.v;
import l.a.b.a.b.k.w;
import l.a.b.a.b.k.x;
import l.a.b.a.b.k.y;

public final class d0$a
  extends AbstractList
{
  public final v x;
  
  public d0$a(v paramv)
  {
    x = paramv;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    case 6: 
      return x.g;
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
      if ((localObject != null) && (!((h)localObject).equals(h.z))) {
        i = 4;
      } else if (!x.c.equals(y.SESSION_END)) {
        i = 3;
      } else if (!x.b.equals(x.NONE)) {
        i = 2;
      } else if (x.a != null) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.d0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */