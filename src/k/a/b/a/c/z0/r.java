package k.a.b.a.c.z0;

import k.a.b.a.b.f;
import k.a.b.a.b.g;
import k.a.b.a.b.i;
import k.a.b.a.b.k.l;
import k.a.b.a.c.b;
import k.a.b.a.c.k0;
import k.a.b.a.c.q;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y;
import k.a.b.a.c.y0;

public class r
  implements k.a.b.a.c.a<l>, y<l>
{
  public static final Object[] b = { i.a(112L), f.a("amqp:header:list") };
  public final v a;
  
  public r(x paramx)
  {
    a = new v(paramx);
  }
  
  public Class<l> a()
  {
    return l.class;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    paramObject = (l)paramObject;
    y0 localy0 = a.b.a;
    Object localObject = e;
    int i = 0;
    int j;
    if (localObject != null) {
      j = 5;
    } else if (d != null) {
      j = 4;
    } else if (c != null) {
      j = 3;
    } else if (b != null) {
      j = 2;
    } else if (a != null) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    int m;
    if (j == 0)
    {
      k = 69;
      m = k;
    }
    else
    {
      k = -64;
      m = k;
    }
    localy0.a((byte)0);
    localy0.a((byte)83);
    localy0.a((byte)112);
    localy0.a(m);
    if (m != 69)
    {
      if (m == -64) {
        k = 1;
      } else {
        k = 4;
      }
      int n = localy0.position();
      if (k == 1)
      {
        localy0.a((byte)0);
        localy0.a((byte)j);
      }
      else
      {
        localy0.b(0);
        localy0.b(j);
      }
      while (i < j)
      {
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4) {
                  a.b.a(e);
                } else {
                  throw new IllegalArgumentException(e.a.a.a.a.a("Unknown Header value index: ", i));
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
          else
          {
            x localx = a.b;
            localObject = b;
            if (localObject == null)
            {
              localx.a();
            }
            else if (h != null)
            {
              a.a((byte)80);
              byte b1 = x;
              a.a(b1);
            }
            else
            {
              throw null;
            }
          }
        }
        else {
          a.b.a(a);
        }
        i++;
      }
      i = localy0.position();
      j = i - n - k;
      localy0.a(n);
      if (k == 1) {
        localy0.a((byte)j);
      } else {
        localy0.b(j);
      }
      localy0.a(i);
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public r0<l> f()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object k()
  {
    k.a.b.a.c.r localr = a.a;
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
          throw new q(e.a.a.a.a.a("Incorrect type found in Header encoding: ", i));
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
    localObject = new l();
    while (j < i)
    {
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j == 4) {
                e = localr.a(null);
              } else {
                throw new IllegalStateException("To many entries in Header encoding");
              }
            }
            else {
              d = localr.a(null);
            }
          }
          else {
            c = localr.a(null);
          }
        }
        else {
          b = localr.a(null);
        }
      }
      else {
        a = localr.a(null);
      }
      j++;
    }
    return localObject;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */