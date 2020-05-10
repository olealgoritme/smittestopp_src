package l.b.i.b.f;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import l.b.a.l2.s;
import l.b.a.o;
import l.b.i.a.e;
import l.b.i.a.h;
import l.b.i.a.i;
import l.b.i.a.j;
import l.b.i.a.n;
import l.b.i.b.e.c;
import l.b.i.b.g.r;
import l.b.i.b.g.t;
import l.b.i.b.g.t.b;
import l.b.i.b.g.w;
import l.b.i.b.g.y;
import l.b.i.b.g.y.b;

public class a
{
  public static Map a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(e.q, new c(null));
    a.put(e.r, new c(null));
    a.put(e.e, new d(null));
    a.put(e.f, new b(null));
    a.put(e.g, new f(null));
    a.put(e.l, new g(null));
  }
  
  public static l.b.c.d.a a(s params)
  {
    l.b.a.l2.a locala = x;
    e locale = (e)a.get(x);
    if (locale != null) {
      return locale.a(params, null);
    }
    params = e.a.a.a.a.a("algorithm identifier in public key not recognised: ");
    params.append(x);
    throw new IOException(params.toString());
  }
  
  public static class b
    extends a.e
  {
    public l.b.c.d.a a(s params, Object paramObject)
    {
      return new l.b.i.b.b.b(y.j());
    }
  }
  
  public static class c
    extends a.e
  {
    public l.b.c.d.a a(s params, Object paramObject)
    {
      paramObject = x;
      int i = ((Integer)b.i.get(x)).intValue();
      params = y;
      if (y == 0) {
        return new l.b.i.b.c.b(i, l.b.c.e.a.a(x));
      }
      throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }
  }
  
  public static class d
    extends a.e
  {
    public l.b.c.d.a a(s params, Object paramObject)
    {
      return new c(y.j(), b.a(h.a(x.y)));
    }
  }
  
  public static abstract class e
  {
    public abstract l.b.c.d.a a(s params, Object paramObject);
  }
  
  public static class f
    extends a.e
  {
    public l.b.c.d.a a(s params, Object paramObject)
    {
      paramObject = i.a(x.y);
      o localo = z.x;
      params = n.a(params.f());
      paramObject = new y.b(new w(y, b.a(localo)));
      c = l.b.c.e.a.b(l.b.c.e.a.a(x));
      b = l.b.c.e.a.b(l.b.c.e.a.a(y));
      return new y((y.b)paramObject, null);
    }
  }
  
  public static class g
    extends a.e
  {
    public l.b.c.d.a a(s params, Object paramObject)
    {
      paramObject = j.a(x.y);
      o localo = A.x;
      params = n.a(params.f());
      paramObject = new t.b(new r(y, z, b.a(localo)));
      c = l.b.c.e.a.b(l.b.c.e.a.a(x));
      b = l.b.c.e.a.b(l.b.c.e.a.a(y));
      return new t((t.b)paramObject, null);
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */