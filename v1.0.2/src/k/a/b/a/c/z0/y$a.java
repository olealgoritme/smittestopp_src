package k.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.k.p;

public final class y$a
  extends AbstractList
{
  public p x;
  
  public y$a(p paramp)
  {
    x = paramp;
  }
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    case 12: 
      return x.m;
    case 11: 
      return x.l;
    case 10: 
      return x.k;
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
    p localp = x;
    int i;
    if (m != null) {
      i = 13;
    } else if (l != null) {
      i = 12;
    } else if (k != null) {
      i = 11;
    } else if (j != null) {
      i = 10;
    } else if (i != null) {
      i = 9;
    } else if (h != null) {
      i = 8;
    } else if (g != null) {
      i = 7;
    } else if (f != null) {
      i = 6;
    } else if (e != null) {
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
 * Qualified Name:     base.k.a.b.a.c.z0.y.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */