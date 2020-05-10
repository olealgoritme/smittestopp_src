package k.b.i.b.g;

import java.util.HashMap;
import java.util.Map;
import k.b.a.o;
import k.b.a.t;
import k.b.c.c.e;
import k.b.c.c.g;
import k.b.c.c.h;

public class f
{
  public static Map<String, o> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put("SHA-256", k.b.a.g2.a.c);
    a.put("SHA-512", k.b.a.g2.a.e);
    a.put("SHAKE128", k.b.a.g2.a.i);
    a.put("SHAKE256", k.b.a.g2.a.j);
  }
  
  public static k.b.c.a a(o paramo)
  {
    if (paramo.b(k.b.a.g2.a.c)) {
      return new e();
    }
    if (paramo.b(k.b.a.g2.a.e)) {
      return new g();
    }
    if (paramo.b(k.b.a.g2.a.i)) {
      return new h(128);
    }
    if (paramo.b(k.b.a.g2.a.j)) {
      return new h(256);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognized digest OID: ");
    localStringBuilder.append(paramo);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */