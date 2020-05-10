package k.b.i.b.f;

import java.util.HashMap;
import java.util.Map;
import k.b.a.o;
import k.b.a.t;
import k.b.c.c.g;

public class b
{
  public static final k.b.a.l2.a a = new k.b.a.l2.a(k.b.i.a.e.q);
  public static final k.b.a.l2.a b = new k.b.a.l2.a(k.b.i.a.e.r);
  public static final k.b.a.l2.a c = new k.b.a.l2.a(k.b.a.g2.a.h);
  public static final k.b.a.l2.a d = new k.b.a.l2.a(k.b.a.g2.a.g);
  public static final k.b.a.l2.a e = new k.b.a.l2.a(k.b.a.g2.a.c);
  public static final k.b.a.l2.a f = new k.b.a.l2.a(k.b.a.g2.a.e);
  public static final k.b.a.l2.a g = new k.b.a.l2.a(k.b.a.g2.a.i);
  public static final k.b.a.l2.a h = new k.b.a.l2.a(k.b.a.g2.a.j);
  public static final Map i;
  
  static
  {
    HashMap localHashMap = new HashMap();
    i = localHashMap;
    localHashMap.put(k.b.i.a.e.q, Integer.valueOf(5));
    i.put(k.b.i.a.e.r, Integer.valueOf(6));
  }
  
  public static String a(k.b.i.a.h paramh)
  {
    paramh = y;
    if (x.b(cx)) {
      return "SHA3-256";
    }
    if (x.b(dx)) {
      return "SHA-512/256";
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("unknown tree digest: ");
    localStringBuilder.append(x);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static k.b.a.l2.a a(int paramInt)
  {
    if (paramInt != 5)
    {
      if (paramInt == 6) {
        return b;
      }
      throw new IllegalArgumentException(e.a.a.a.a.a("unknown security category: ", paramInt));
    }
    return a;
  }
  
  public static k.b.a.l2.a a(String paramString)
  {
    if (paramString.equals("SHA3-256")) {
      return c;
    }
    if (paramString.equals("SHA-512/256")) {
      return d;
    }
    throw new IllegalArgumentException(e.a.a.a.a.b("unknown tree digest: ", paramString));
  }
  
  public static k.b.c.a a(o paramo)
  {
    if (paramo.b(k.b.a.g2.a.c)) {
      return new k.b.c.c.e();
    }
    if (paramo.b(k.b.a.g2.a.e)) {
      return new g();
    }
    if (paramo.b(k.b.a.g2.a.i)) {
      return new k.b.c.c.h(128);
    }
    if (paramo.b(k.b.a.g2.a.j)) {
      return new k.b.c.c.h(256);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognized digest OID: ");
    localStringBuilder.append(paramo);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static k.b.a.l2.a b(String paramString)
  {
    if (paramString.equals("SHA-256")) {
      return e;
    }
    if (paramString.equals("SHA-512")) {
      return f;
    }
    if (paramString.equals("SHAKE128")) {
      return g;
    }
    if (paramString.equals("SHAKE256")) {
      return h;
    }
    throw new IllegalArgumentException(e.a.a.a.a.b("unknown tree digest: ", paramString));
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */