package j.a.b.m;

import j.a.b.j.f;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class l
{
  public static final n<j.a.b.f> c = new a();
  public static final n<j.a.b.f> d = new b();
  public static final n<j.a.b.c> e = new c();
  public static final n<j.a.b.b> f = new d();
  public static final n<Iterable<? extends Object>> g = new e();
  public static final n<Enum<?>> h = new f();
  public static final n<Map<String, ? extends Object>> i = new g();
  public static final n<Object> j = new b();
  public static final n<Object> k = new a();
  public static final n<Object> l = new h();
  public ConcurrentHashMap<Class<?>, n<?>> a = new ConcurrentHashMap();
  public LinkedList<i> b = new LinkedList();
  
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
    b.addLast(new i(j.a.b.f.class, localn));
    localn = c;
    b.addLast(new i(j.a.b.e.class, localn));
    localn = e;
    b.addLast(new i(j.a.b.c.class, localn));
    localn = f;
    b.addLast(new i(j.a.b.b.class, localn));
    localn = i;
    b.addLast(new i(Map.class, localn));
    localn = g;
    b.addLast(new i(Iterable.class, localn));
    localn = h;
    b.addLast(new i(Enum.class, localn));
    localn = l;
    b.addLast(new i(Number.class, localn));
  }
  
  public static void a(String paramString, Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
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
      j.a.b.i.a(paramString, paramAppendable, paramg);
      paramAppendable.append('"');
    }
    if (paramg != null)
    {
      paramAppendable.append(':');
      if ((paramObject instanceof String)) {
        paramg.a(paramAppendable, (String)paramObject);
      } else {
        j.a.b.i.a(paramObject, paramAppendable, paramg);
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
  
  public class a
    implements n<j.a.b.f>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      ((j.a.b.f)paramObject).a(paramAppendable);
    }
  }
  
  public class b
    implements n<j.a.b.f>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      ((j.a.b.f)paramObject).a(paramAppendable, paramg);
    }
  }
  
  public class c
    implements n<j.a.b.c>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      paramAppendable.append(((j.a.b.c)paramObject).a(paramg));
    }
  }
  
  public class d
    implements n<j.a.b.b>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      paramAppendable.append(((j.a.b.b)paramObject).a());
    }
  }
  
  public class e
    implements n<Iterable<? extends Object>>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      paramObject = (Iterable)paramObject;
      if (paramg != null)
      {
        paramAppendable.append('[');
        paramObject = ((Iterable)paramObject).iterator();
        int i = 1;
        for (;;)
        {
          if (!((Iterator)paramObject).hasNext())
          {
            paramAppendable.append(']');
            return;
          }
          Object localObject = ((Iterator)paramObject).next();
          if (i != 0) {
            i = 0;
          } else {
            paramAppendable.append(',');
          }
          if (localObject == null) {
            paramAppendable.append("null");
          } else {
            j.a.b.i.a(localObject, paramAppendable, paramg);
          }
        }
      }
      throw null;
    }
  }
  
  public class f
    implements n<Enum<?>>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      paramg.a(paramAppendable, ((Enum)paramObject).name());
    }
  }
  
  public class g
    implements n<Map<String, ? extends Object>>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      paramObject = (Map)paramObject;
      if (paramg != null)
      {
        paramAppendable.append('{');
        paramObject = ((Map)paramObject).entrySet().iterator();
        int i = 1;
        for (;;)
        {
          if (!((Iterator)paramObject).hasNext())
          {
            paramAppendable.append('}');
            return;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
          Object localObject = localEntry.getValue();
          if ((localObject != null) || (!d))
          {
            if (i != 0) {
              i = 0;
            } else {
              paramAppendable.append(',');
            }
            l.a(localEntry.getKey().toString(), localObject, paramAppendable, paramg);
          }
        }
      }
      throw null;
    }
  }
  
  public class h
    implements n<Object>
  {
    public void a(Object paramObject, Appendable paramAppendable, j.a.b.g paramg)
    {
      paramAppendable.append(paramObject.toString());
    }
  }
  
  public static class i
  {
    public Class<?> a;
    public n<?> b;
    
    public i(Class<?> paramClass, n<?> paramn)
    {
      a = paramClass;
      b = paramn;
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.m.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */