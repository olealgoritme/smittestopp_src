package k.a.b.a.c.c1;

import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.k.s;
import k.a.b.a.b.n.g;
import k.a.b.a.b.n.o;
import k.a.b.a.c.b;
import k.a.b.a.c.k0;
import k.a.b.a.c.q;
import k.a.b.a.c.r;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y;
import k.a.b.a.c.y0;

public class h
  implements k.a.b.a.c.a<g>, y<g>
{
  public static final Object[] b = { i.a(21L), f.a("amqp:disposition:list") };
  public static final byte[] c = { 0, 83, 36, 69 };
  public final e a;
  
  public h(x paramx)
  {
    a = new e(paramx);
  }
  
  public Class<g> a()
  {
    return g.class;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (g)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    g localg = (g)paramObject;
    paramObject = a.b.a;
    if (f) {
      i = 6;
    } else if (e != null) {
      i = 5;
    } else if (d) {
      i = 4;
    } else if (c != null) {
      i = 3;
    } else {
      i = 2;
    }
    Object localObject = e;
    int j;
    int k;
    if ((localObject != null) && (localObject != k.a.b.a.b.k.a.a) && (localObject != s.a))
    {
      j = -48;
      k = j;
    }
    else
    {
      j = -64;
      k = j;
    }
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)21);
    ((y0)paramObject).a(k);
    if (k == -64) {
      j = 1;
    } else {
      j = 4;
    }
    int m = ((y0)paramObject).position();
    if (j == 1)
    {
      ((y0)paramObject).a((byte)0);
      ((y0)paramObject).a((byte)i);
    }
    else
    {
      ((y0)paramObject).b(0);
      ((y0)paramObject).b(i);
    }
    for (int n = 0; n < i; n++) {
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n != 3)
            {
              if (n != 4)
              {
                if (n == 5) {
                  a.b.a(f);
                } else {
                  throw new IllegalArgumentException(e.a.a.a.a.a("Unknown Disposition value index: ", n));
                }
              }
              else if (k.a.b.a.b.k.a.a.equals(e))
              {
                localObject = a.b.a;
                byte[] arrayOfByte = c;
                ((y0)localObject).a(arrayOfByte, 0, arrayOfByte.length);
              }
              else
              {
                a.b.b(e);
              }
            }
            else {
              a.b.a(d);
            }
          }
          else {
            a.b.a(c);
          }
        }
        else {
          a.b.a(b);
        }
      }
      else {
        a.b.a(a.getValue());
      }
    }
    int i = ((y0)paramObject).position();
    n = i - m - j;
    ((y0)paramObject).a(m);
    if (j == 1) {
      ((y0)paramObject).a((byte)n);
    } else {
      ((y0)paramObject).b(n);
    }
    ((y0)paramObject).a(i);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public r0<g> f()
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
          throw new q(e.a.a.a.a.a("Incorrect type found in Disposition encoding: ", i));
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
    g localg = new g();
    for (int j = 0; j < i; j++) {
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  f = localr.a(false);
                } else {
                  throw new IllegalStateException("To many entries in Disposition encoding");
                }
              }
              else {
                e = ((k.a.b.a.b.n.e)localr.d());
              }
            }
            else {
              d = localr.a(false);
            }
          }
          else {
            c = localr.a(null);
          }
        }
        else {
          localg.a(localr.a(null));
        }
      }
      else
      {
        o localo;
        if (Boolean.TRUE.equals(localr.a(null))) {
          localo = o.RECEIVER;
        } else {
          localo = o.SENDER;
        }
        localg.a(localo);
      }
    }
    return localg;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */