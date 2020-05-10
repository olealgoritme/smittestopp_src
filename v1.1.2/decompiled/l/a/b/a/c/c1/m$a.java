package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.n.n;
import l.a.b.a.b.n.s;

public class m$a
  extends AbstractList
{
  public s x;
  
  public m$a(s params)
  {
    x = params;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    case 10: 
      return Boolean.valueOf(x.k);
    case 9: 
      return Boolean.valueOf(x.j);
    case 8: 
      return Boolean.valueOf(x.i);
    case 7: 
      return x.h;
    case 6: 
      Object localObject = x.g;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((n)localObject).getValue();
      }
      return localObject;
    case 5: 
      return Boolean.valueOf(x.f);
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
    s locals = x;
    int i;
    if (k) {
      i = 11;
    } else if (j) {
      i = 10;
    } else if (i) {
      i = 9;
    } else if (h != null) {
      i = 8;
    } else if (g != null) {
      i = 7;
    } else if (f) {
      i = 6;
    } else if (e != null) {
      i = 5;
    } else if (d != null) {
      i = 4;
    } else if (c != null) {
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
 * Qualified Name:     l.a.b.a.c.c1.m.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */