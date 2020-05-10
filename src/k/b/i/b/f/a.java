package k.b.i.b.f;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import k.b.a.l2.s;
import k.b.i.a.e;

public class a
{
  public static Map a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(e.q, new a.c(null));
    a.put(e.r, new a.c(null));
    a.put(e.e, new a.d(null));
    a.put(e.f, new a.b(null));
    a.put(e.g, new a.f(null));
    a.put(e.l, new a.g(null));
  }
  
  public static k.b.c.d.a a(s params)
  {
    k.b.a.l2.a locala = x;
    a.e locale = (a.e)a.get(x);
    if (locale != null) {
      return locale.a(params, null);
    }
    params = e.a.a.a.a.a("algorithm identifier in public key not recognised: ");
    params.append(x);
    throw new IOException(params.toString());
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */