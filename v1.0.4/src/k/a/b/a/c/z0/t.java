package k.a.b.a.c.z0;

import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.k.p;
import k.a.b.a.c.b;
import k.a.b.a.c.k0;
import k.a.b.a.c.q;
import k.a.b.a.c.r;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y0;

public class t
  implements k.a.b.a.c.a<p>, k.a.b.a.c.y<p>
{
  public static final Object[] b = { i.a(115L), f.a("amqp:properties:list") };
  public final y a;
  
  public t(x paramx)
  {
    a = new y(paramx);
  }
  
  public Class<p> a()
  {
    return p.class;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (p)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    p localp = (p)paramObject;
    paramObject = a.b.a;
    String str = m;
    int i = 0;
    int j = 4;
    int k;
    if (str != null) {
      k = 13;
    } else if (l != null) {
      k = 12;
    } else if (k != null) {
      k = 11;
    } else if (j != null) {
      k = 10;
    } else if (i != null) {
      k = 9;
    } else if (h != null) {
      k = 8;
    } else if (g != null) {
      k = 7;
    } else if (f != null) {
      k = 6;
    } else if (e != null) {
      k = 5;
    } else if (d != null) {
      k = 4;
    } else if (c != null) {
      k = 3;
    } else if (b != null) {
      k = 2;
    } else if (a != null) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    int n;
    if (k == 0)
    {
      m = 69;
      n = m;
    }
    else
    {
      m = -48;
      n = m;
    }
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)115);
    ((y0)paramObject).a(n);
    if (n != 69)
    {
      if (n == -64) {
        j = 1;
      }
      m = ((y0)paramObject).position();
      if (j == 1)
      {
        ((y0)paramObject).a((byte)0);
        ((y0)paramObject).a((byte)k);
      }
      else
      {
        ((y0)paramObject).b(0);
        ((y0)paramObject).b(k);
      }
      while (i < k)
      {
        switch (i)
        {
        default: 
          throw new IllegalArgumentException(e.a.a.a.a.a("Unknown Properties value index: ", i));
        case 12: 
          a.b.a(m);
          break;
        case 11: 
          a.b.a(l);
          break;
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
          a.b.a(h);
          break;
        case 6: 
          a.b.a(g);
          break;
        case 5: 
          a.b.b(f);
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
          a.b.b(a);
        }
        i++;
      }
      k = ((y0)paramObject).position();
      i = k - m - j;
      ((y0)paramObject).a(m);
      if (j == 1) {
        ((y0)paramObject).a((byte)i);
      } else {
        ((y0)paramObject).b(i);
      }
      ((y0)paramObject).a(k);
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public r0<p> f()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object k()
  {
    r localr = a.a;
    Object localObject = a;
    int i = ((k0)localObject).get();
    int j = 0;
    if (i != -64)
    {
      if (i != -48)
      {
        if (i == 69) {
          i = 0;
        } else {
          throw new q(e.a.a.a.a.a("Incorrect type found in Properties encoding: ", i));
        }
      }
      else
      {
        ((k0)localObject).d();
        i = ((k0)localObject).d();
      }
    }
    else
    {
      ((k0)localObject).get();
      i = ((k0)localObject).get() & 0xFF;
    }
    localObject = new p();
    while (j < i)
    {
      switch (j)
      {
      default: 
        throw new IllegalStateException("To many entries in Properties encoding");
      case 12: 
        m = localr.a(null);
        break;
      case 11: 
        l = localr.a(null);
        break;
      case 10: 
        k = localr.a(null);
        break;
      case 9: 
        j = localr.a(null);
        break;
      case 8: 
        i = localr.a(null);
        break;
      case 7: 
        h = localr.a(null);
        break;
      case 6: 
        g = localr.a(null);
        break;
      case 5: 
        f = localr.d();
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
        a = localr.d();
      }
      j++;
    }
    return localObject;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */