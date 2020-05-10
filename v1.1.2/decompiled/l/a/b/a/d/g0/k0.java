package l.a.b.a.d.g0;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l.a.b.a.b.h;

public class k0
{
  public static final h u = h.a(Integer.MAX_VALUE);
  public final a0 a;
  public final y b;
  public int c = -1;
  public int d = -1;
  public final h e = h.a(65535);
  public h f;
  public h g;
  public h h;
  public h i;
  public h j;
  public final Map<h, e0<?>> k;
  public final Map<h, e0<?>> l;
  public final Map<String, e0> m;
  public h n;
  public h o;
  public final Map<h, e> p;
  public final Map<h, e> q;
  public int r;
  public boolean s;
  public boolean t;
  
  public k0(a0 parama0, y paramy)
  {
    h localh = h.z;
    f = localh;
    g = localh;
    h = localh;
    i = h.A;
    j = null;
    k = new HashMap();
    l = new HashMap();
    m = new HashMap();
    n = null;
    p = new HashMap();
    q = new HashMap();
    a = parama0;
    b = paramy;
    h = h.a(R);
  }
  
  public e0 a(h paramh)
  {
    return (e0)k.get(paramh);
  }
  
  public boolean a()
  {
    boolean bool;
    if (c != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void b()
  {
    if (a())
    {
      Iterator localIterator = l.values().iterator();
      while (localIterator.hasNext())
      {
        e0 locale0 = (e0)localIterator.next();
        if (a != null) {
          f.k();
        }
        a = null;
      }
      l.clear();
      b.k();
    }
    c = -1;
  }
  
  public void c()
  {
    int i1;
    if (d != -1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      Iterator localIterator = k.values().iterator();
      while (localIterator.hasNext())
      {
        e0 locale0 = (e0)localIterator.next();
        if (c != null) {
          f.k();
        }
        c = null;
      }
      k.clear();
      b.k();
    }
    d = -1;
  }
  
  public void d()
  {
    y localy = b;
    int i1 = M;
    int i2 = a.T;
    if ((i1 > 0) && (i2 > 0)) {
      g = h.a((i1 - N) / i2);
    } else {
      g = u;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.k0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */