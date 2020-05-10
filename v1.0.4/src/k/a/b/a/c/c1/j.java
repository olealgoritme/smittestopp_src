package k.a.b.a.c.c1;

import k.a.b.a.b.f;
import k.a.b.a.b.g;
import k.a.b.a.b.i;
import k.a.b.a.b.n.e;
import k.a.b.a.b.n.n;
import k.a.b.a.b.n.s;
import k.a.b.a.c.b;
import k.a.b.a.c.k0;
import k.a.b.a.c.q;
import k.a.b.a.c.r;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y;
import k.a.b.a.c.y0;

public class j
  implements k.a.b.a.c.a<s>, y<s>
{
  public static final Object[] b = { i.a(20L), f.a("amqp:transfer:list") };
  public final m a;
  
  public j(x paramx)
  {
    a = new m(paramx);
  }
  
  public Class<s> a()
  {
    return s.class;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (s)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    s locals = (s)paramObject;
    y0 localy0 = a.b.a;
    boolean bool = k;
    int i = 4;
    if (bool) {
      j = 11;
    } else if (j) {
      j = 10;
    } else if (i) {
      j = 9;
    } else if (h != null) {
      j = 8;
    } else if (g != null) {
      j = 7;
    } else if (f) {
      j = 6;
    } else if (e != null) {
      j = 5;
    } else if (d != null) {
      j = 4;
    } else if (c != null) {
      j = 3;
    } else if (b != null) {
      j = 2;
    } else {
      j = 1;
    }
    paramObject = h;
    int k = -48;
    int m;
    if (paramObject != null)
    {
      m = k;
    }
    else
    {
      paramObject = c;
      if ((paramObject != null) && (c > 200))
      {
        m = k;
      }
      else
      {
        k = -64;
        m = k;
      }
    }
    k = 0;
    localy0.a((byte)0);
    localy0.a((byte)83);
    localy0.a((byte)20);
    localy0.a(m);
    if (m == -64) {
      i = 1;
    }
    int n = localy0.position();
    if (i == 1)
    {
      localy0.a((byte)0);
      localy0.a((byte)j);
    }
    else
    {
      localy0.b(0);
      localy0.b(j);
    }
    while (k < j)
    {
      switch (k)
      {
      default: 
        throw new IllegalArgumentException(e.a.a.a.a.a("Unknown Transfer value index: ", k));
      case 10: 
        a.b.a(k);
        break;
      case 9: 
        a.b.a(j);
        break;
      case 8: 
        a.b.a(i);
        break;
      case 7: 
        a.b.b(h);
        break;
      case 6: 
        paramObject = g;
        x localx = a.b;
        if (paramObject == null) {
          paramObject = null;
        } else {
          paramObject = ((n)paramObject).getValue();
        }
        localx.b(paramObject);
        break;
      case 5: 
        a.b.a(f);
        break;
      case 4: 
        a.b.a(e);
        break;
      case 3: 
        a.b.a(d);
        break;
      case 2: 
        a.b.a(c);
        break;
      case 1: 
        a.b.a(b);
        break;
      case 0: 
        a.b.a(a);
      }
      k++;
    }
    k = localy0.position();
    int j = k - n - i;
    localy0.a(n);
    if (i == 1) {
      localy0.a((byte)j);
    } else {
      localy0.b(j);
    }
    localy0.a(k);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public r0<s> f()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object k()
  {
    r localr = a.a;
    int i = a.get();
    if (i != -64)
    {
      if (i != -48)
      {
        if (i == 69) {
          i = 0;
        } else {
          throw new q(e.a.a.a.a.a("Incorrect type found in Transfer encoding: ", i));
        }
      }
      else
      {
        a.d();
        i = a.d();
      }
    }
    else
    {
      a.get();
      i = a.get() & 0xFF;
    }
    s locals = new s();
    for (int j = 0; j < i; j++)
    {
      n localn = null;
      switch (j)
      {
      default: 
        throw new IllegalStateException("To many entries in Transfer encoding");
      case 10: 
        k = localr.a(false);
        break;
      case 9: 
        j = localr.a(false);
        break;
      case 8: 
        i = localr.a(false);
        break;
      case 7: 
        h = ((e)localr.d());
        break;
      case 6: 
        g localg = localr.a(null);
        if (localg != null) {
          localn = n.values()[(x & 0xFF)];
        }
        g = localn;
        break;
      case 5: 
        f = localr.a(false);
        break;
      case 4: 
        e = localr.a(null);
        break;
      case 3: 
        d = localr.a(null);
        break;
      case 2: 
        c = localr.a(null);
        break;
      case 1: 
        b = localr.a(null);
        break;
      case 0: 
        locals.a(localr.a(null));
      }
    }
    return locals;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */