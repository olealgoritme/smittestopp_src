package g.c;

import g.c.l.c;
import g.c.l.c.a;
import g.c.l.d;
import g.c.l.f;
import g.c.l.g;
import g.c.l.h.a;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class a<T>
{
  public final List<String> a = new ArrayList();
  public final List<String> b = new ArrayList();
  public final List<d> c = new ArrayList();
  public final List<c> d = new ArrayList();
  public final Map<b, Object> e = new EnumMap(b.class);
  public final h.a f = new h.a();
  public final c.a g = new c.a();
  public final Class<T> h;
  public boolean i = false;
  
  public a(Class<T> paramClass)
  {
    h = paramClass;
  }
  
  public T a()
  {
    if (!b.isEmpty())
    {
      Object localObject1 = c;
      Object localObject2 = f;
      ((List)localObject1).add(0, new g.c.l.e(new g(a, b)));
      localObject2 = e;
      Object localObject3 = b.TypeMapper;
      if (c.size() > 1) {
        localObject1 = new g.c.l.b(c);
      } else {
        localObject1 = (d)c.get(0);
      }
      ((Map)localObject2).put(localObject3, localObject1);
      localObject2 = d;
      localObject1 = g;
      if (localObject1 != null)
      {
        ((List)localObject2).add(0, new f(a));
        localObject3 = e;
        localObject2 = b.FunctionMapper;
        if (d.size() > 1) {
          localObject1 = new g.c.l.a(d);
        } else {
          localObject1 = (c)d.get(0);
        }
        ((Map)localObject3).put(localObject2, localObject1);
        try
        {
          localObject3 = h;
          localObject2 = Collections.unmodifiableList(b);
          localObject1 = new java/util/ArrayList;
          ((ArrayList)localObject1).<init>(a);
          ((ArrayList)localObject1).addAll(a.b.a);
          a((Class)localObject3, (Collection)localObject2, Collections.unmodifiableList((List)localObject1), Collections.unmodifiableMap(e));
          throw null;
        }
        catch (Exception localException)
        {
          RuntimeException localRuntimeException;
          if ((localException instanceof RuntimeException)) {
            localRuntimeException = (RuntimeException)localException;
          } else {
            localRuntimeException = new RuntimeException(localRuntimeException);
          }
          if (!i) {
            return (T)a(localRuntimeException);
          }
          throw localRuntimeException;
        }
        catch (LinkageError localLinkageError)
        {
          if (!i) {
            return (T)a(localLinkageError);
          }
          throw localLinkageError;
        }
      }
      throw null;
    }
    throw new UnsatisfiedLinkError("no library names specified");
  }
  
  public abstract T a(Class<T> paramClass, Collection<String> paramCollection1, Collection<String> paramCollection2, Map<b, Object> paramMap);
  
  public final T a(Throwable paramThrowable)
  {
    Class localClass1 = h;
    ClassLoader localClassLoader = localClass1.getClassLoader();
    Class localClass2 = h;
    paramThrowable = new a.a(this, paramThrowable);
    return (T)localClass1.cast(Proxy.newProxyInstance(localClassLoader, new Class[] { localClass2, g.c.m.e.class }, paramThrowable));
  }
}

/* Location:
 * Qualified Name:     base.g.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */