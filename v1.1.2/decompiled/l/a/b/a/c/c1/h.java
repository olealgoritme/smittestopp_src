package l.a.b.a.c.c1;

import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.k.s;
import l.a.b.a.b.n.g;
import l.a.b.a.b.n.o;
import l.a.b.a.c.b;
import l.a.b.a.c.k0;
import l.a.b.a.c.q;
import l.a.b.a.c.r;
import l.a.b.a.c.r0;
import l.a.b.a.c.x;
import l.a.b.a.c.y;
import l.a.b.a.c.y0;

public class h
  implements l.a.b.a.c.a<g>, y<g>
{
  public static final Object[] b = { i.a(21L), f.a("amqp:disposition:list") };
  public static final byte[] c = { 0, 83, 36, 69 };
  public final e a;
  
  public h(x paramx)
  {
    a = new e(paramx);
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (g)paramObject;
    return a.a(paramObject);
  }
  
  public Class<g> b()
  {
    return g.class;
  }
  
  public void c(Object paramObject)
  {
    paramObject = (g)paramObject;
    y0 localy01 = a.b.a;
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
    if ((localObject != null) && (localObject != l.a.b.a.b.k.a.a) && (localObject != s.a))
    {
      j = -48;
      k = j;
    }
    else
    {
      j = -64;
      k = j;
    }
    localy01.a((byte)0);
    localy01.a((byte)83);
    localy01.a((byte)21);
    localy01.a(k);
    if (k == -64) {
      j = 1;
    } else {
      j = 4;
    }
    int m = localy01.position();
    if (j == 1)
    {
      localy01.a((byte)0);
      localy01.a((byte)i);
    }
    else
    {
      localy01.c(0);
      localy01.c(i);
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
              else if (l.a.b.a.b.k.a.a.equals(e))
              {
                y0 localy02 = a.b.a;
                localObject = c;
                localy02.a((byte[])localObject, 0, localObject.length);
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
    n = localy01.position();
    int i = n - m - j;
    localy01.a(m);
    if (j == 1) {
      localy01.a((byte)i);
    } else {
      localy01.c(i);
    }
    localy01.a(n);
  }
  
  public r0<g> e()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object i()
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
        a.h();
        i = a.h();
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
                e = ((l.a.b.a.b.n.e)localr.d());
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
  
  public boolean j()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */