package i.a.b.m;

import i.a.b.j.f;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class l
{
  public static final n<i.a.b.f> c = new l.a();
  public static final n<i.a.b.f> d = new l.b();
  public static final n<i.a.b.c> e = new l.c();
  public static final n<i.a.b.b> f = new l.d();
  public static final n<Iterable<? extends Object>> g = new l.e();
  public static final n<Enum<?>> h = new l.f();
  public static final n<Map<String, ? extends Object>> i = new l.g();
  public static final n<Object> j = new b();
  public static final n<Object> k = new a();
  public static final n<Object> l = new l.h();
  public ConcurrentHashMap<Class<?>, n<?>> a = new ConcurrentHashMap();
  public LinkedList<l.i> b = new LinkedList();
  
  public l()
  {
    a(new m(this), new Class[] { String.class });
    a(new c(this), new Class[] { Double.class });
    a(new d(this), new Class[] { Date.class });
    a(new e(this), new Class[] { Float.class });
    a(l, new Class[] { Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class });
    a(l, new Class[] { Boolean.class });
    a(new f(this), new Class[] { int[].class });
    a(new g(this), new Class[] { short[].class });
    a(new h(this), new Class[] { long[].class });
    a(new i(this), new Class[] { float[].class });
    a(new j(this), new Class[] { double[].class });
    a(new k(this), new Class[] { boolean[].class });
    n localn = d;
    b.addLast(new l.i(i.a.b.f.class, localn));
    localn = c;
    b.addLast(new l.i(i.a.b.e.class, localn));
    localn = e;
    b.addLast(new l.i(i.a.b.c.class, localn));
    localn = f;
    b.addLast(new l.i(i.a.b.b.class, localn));
    localn = i;
    b.addLast(new l.i(Map.class, localn));
    localn = g;
    b.addLast(new l.i(Iterable.class, localn));
    localn = h;
    b.addLast(new l.i(Enum.class, localn));
    localn = l;
    b.addLast(new l.i(Number.class, localn));
  }
  
  public static void a(String paramString, Object paramObject, Appendable paramAppendable, i.a.b.g paramg)
  {
    if (paramString == null)
    {
      paramAppendable.append("null");
    }
    else if (!e.a(paramString))
    {
      paramAppendable.append(paramString);
    }
    else
    {
      paramAppendable.append('"');
      i.a.b.i.a(paramString, paramAppendable, paramg);
      paramAppendable.append('"');
    }
    if (paramg != null)
    {
      paramAppendable.append(':');
      if ((paramObject instanceof String)) {
        paramg.a(paramAppendable, (String)paramObject);
      } else {
        i.a.b.i.a(paramObject, paramAppendable, paramg);
      }
      return;
    }
    throw null;
  }
  
  public <T> void a(n<T> paramn, Class<?>... paramVarArgs)
  {
    int m = paramVarArgs.length;
    for (int n = 0;; n++)
    {
      if (n >= m) {
        return;
      }
      Class<?> localClass = paramVarArgs[n];
      a.put(localClass, paramn);
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */