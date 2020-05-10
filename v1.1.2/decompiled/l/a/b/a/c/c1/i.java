package l.a.b.a.c.c1;

import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.c.b;
import l.a.b.a.c.g0;
import l.a.b.a.c.k0;
import l.a.b.a.c.q;
import l.a.b.a.c.r;
import l.a.b.a.c.r0;
import l.a.b.a.c.x;
import l.a.b.a.c.y;
import l.a.b.a.c.y0;

public class i
  implements l.a.b.a.c.a<l.a.b.a.b.n.k>, y<l.a.b.a.b.n.k>
{
  public static final Object[] b = { l.a.b.a.b.i.a(19L), f.a("amqp:flow:list") };
  public final k a;
  
  public i(x paramx)
  {
    a = new k(paramx);
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.n.k)paramObject;
    return a.a(paramObject);
  }
  
  public Class<l.a.b.a.b.n.k> b()
  {
    return l.a.b.a.b.n.k.class;
  }
  
  public void c(Object paramObject)
  {
    l.a.b.a.b.n.k localk = (l.a.b.a.b.n.k)paramObject;
    paramObject = a.b.a;
    Map localMap = k;
    int i = 4;
    if (localMap != null) {
      j = 11;
    } else if (j) {
      j = 10;
    } else if (i) {
      j = 9;
    } else if (h != null) {
      j = 8;
    } else if (g != null) {
      j = 7;
    } else if (f != null) {
      j = 6;
    } else if (e != null) {
      j = 5;
    } else {
      j = 4;
    }
    int m;
    if (k == null)
    {
      k = -64;
      m = k;
    }
    else
    {
      k = -48;
      m = k;
    }
    int k = 0;
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)19);
    ((y0)paramObject).a(m);
    if (m == -64) {
      i = 1;
    }
    int n = ((y0)paramObject).position();
    if (i == 1)
    {
      ((y0)paramObject).a((byte)0);
      ((y0)paramObject).a((byte)j);
    }
    else
    {
      ((y0)paramObject).c(0);
      ((y0)paramObject).c(j);
    }
    while (k < j)
    {
      switch (k)
      {
      default: 
        throw new IllegalArgumentException(e.a.a.a.a.a("Unknown Flow value index: ", k));
      case 10: 
        Object localObject = a.b;
        localMap = k;
        if (localMap == null)
        {
          ((x)localObject).a();
        }
        else
        {
          localObject = u.a(localMap);
          ((r0)localObject).c();
          ((r0)localObject).b(localMap);
        }
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
    k = ((y0)paramObject).position();
    int j = k - n - i;
    ((y0)paramObject).a(n);
    if (i == 1) {
      ((y0)paramObject).a((byte)j);
    } else {
      ((y0)paramObject).c(j);
    }
    ((y0)paramObject).a(k);
  }
  
  public r0<l.a.b.a.b.n.k> e()
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
          throw new q(e.a.a.a.a.a("Incorrect type found in Flow encoding: ", i));
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
    l.a.b.a.b.n.k localk = new l.a.b.a.b.n.k();
    for (int j = 0; j < i; j++) {
      switch (j)
      {
      default: 
        throw new IllegalStateException("To many entries in Flow encoding");
      case 10: 
        k = localr.c();
        break;
      case 9: 
        j = localr.a(false);
        break;
      case 8: 
        i = localr.a(false);
        break;
      case 7: 
        h = localr.a(null);
        break;
      case 6: 
        g = localr.a(null);
        break;
      case 5: 
        f = localr.a(null);
        break;
      case 4: 
        e = localr.a(null);
        break;
      case 3: 
        localk.c(localr.a(null));
        break;
      case 2: 
        localk.b(localr.a(null));
        break;
      case 1: 
        localk.a(localr.a(null));
        break;
      case 0: 
        a = localr.a(null);
      }
    }
    return localk;
  }
  
  public boolean j()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */