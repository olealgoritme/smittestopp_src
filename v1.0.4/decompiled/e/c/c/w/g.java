package e.c.c.w;

import e.c.c.x.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public final class g
{
  public final Map<Type, e.c.c.f<?>> a;
  public final e.c.c.w.a0.b b = e.c.c.w.a0.b.a;
  
  public g(Map<Type, e.c.c.f<?>> paramMap)
  {
    a = paramMap;
  }
  
  public <T> s<T> a(a<T> parama)
  {
    Type localType = parama.getType();
    Class localClass = parama.getRawType();
    parama = (e.c.c.f)a.get(localType);
    if (parama != null) {
      return new g.a(this, parama, localType);
    }
    parama = (e.c.c.f)a.get(localClass);
    if (parama != null) {
      return new g.b(this, parama, localType);
    }
    Object localObject = null;
    try
    {
      Constructor localConstructor = localClass.getDeclaredConstructor(new Class[0]);
      if (!localConstructor.isAccessible()) {
        b.a(localConstructor);
      }
      parama = new e/c/c/w/h;
      parama.<init>(this, localConstructor);
    }
    catch (NoSuchMethodException parama)
    {
      parama = null;
    }
    if (parama != null) {
      return parama;
    }
    if (Collection.class.isAssignableFrom(localClass))
    {
      if (SortedSet.class.isAssignableFrom(localClass)) {
        parama = new i(this);
      } else if (EnumSet.class.isAssignableFrom(localClass)) {
        parama = new j(this, localType);
      } else if (Set.class.isAssignableFrom(localClass)) {
        parama = new k(this);
      } else if (Queue.class.isAssignableFrom(localClass)) {
        parama = new l(this);
      } else {
        parama = new m(this);
      }
    }
    else
    {
      parama = (a<T>)localObject;
      if (Map.class.isAssignableFrom(localClass)) {
        if (ConcurrentNavigableMap.class.isAssignableFrom(localClass)) {
          parama = new n(this);
        } else if (ConcurrentMap.class.isAssignableFrom(localClass)) {
          parama = new b(this);
        } else if (SortedMap.class.isAssignableFrom(localClass)) {
          parama = new c(this);
        } else if (((localType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.get(((ParameterizedType)localType).getActualTypeArguments()[0]).getRawType()))) {
          parama = new d(this);
        } else {
          parama = new e(this);
        }
      }
    }
    if (parama != null) {
      return parama;
    }
    return new f(this, localClass, localType);
  }
  
  public String toString()
  {
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */