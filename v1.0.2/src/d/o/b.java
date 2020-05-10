package d.o;

import e.a.a.a.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  public static b c = new b();
  public final Map<Class<?>, b.a> a = new HashMap();
  public final Map<Class<?>, Boolean> b = new HashMap();
  
  public b.a a(Class<?> paramClass)
  {
    b.a locala = (b.a)a.get(paramClass);
    if (locala != null) {
      return locala;
    }
    return a(paramClass, null);
  }
  
  public final b.a a(Class<?> paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = a((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(b);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int i = localObject1.length;
    Object localObject2;
    Object localObject3;
    for (int j = 0; j < i; j++)
    {
      localObject2 = ab.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (b.b)((Map.Entry)localObject3).getKey(), (g.a)((Map.Entry)localObject3).getValue(), paramClass);
      }
    }
    if (paramArrayOfMethod == null) {}
    try
    {
      paramArrayOfMethod = paramClass.getDeclaredMethods();
      int k = paramArrayOfMethod.length;
      i = 0;
      boolean bool = false;
      while (i < k)
      {
        localObject1 = paramArrayOfMethod[i];
        localObject3 = (s)((Method)localObject1).getAnnotation(s.class);
        if (localObject3 != null)
        {
          localObject2 = ((Method)localObject1).getParameterTypes();
          if (localObject2.length > 0)
          {
            if (localObject2[0].isAssignableFrom(l.class)) {
              j = 1;
            } else {
              throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
            }
          }
          else {
            j = 0;
          }
          localObject3 = ((s)localObject3).value();
          if (localObject2.length > 1) {
            if (localObject2[1].isAssignableFrom(g.a.class))
            {
              if (localObject3 == g.a.ON_ANY) {
                j = 2;
              } else {
                throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
              }
            }
            else {
              throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
            }
          }
          if (localObject2.length <= 2)
          {
            a(localHashMap, new b.b(j, (Method)localObject1), (g.a)localObject3, paramClass);
            bool = true;
          }
        }
        else
        {
          i++;
          continue;
        }
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      paramArrayOfMethod = new b.a(localHashMap);
      a.put(paramClass, paramArrayOfMethod);
      b.put(paramClass, Boolean.valueOf(bool));
      return paramArrayOfMethod;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  public final void a(Map<b.b, g.a> paramMap, b.b paramb, g.a parama, Class<?> paramClass)
  {
    g.a locala = (g.a)paramMap.get(paramb);
    if ((locala != null) && (parama != locala))
    {
      paramMap = b;
      paramb = a.a("Method ");
      paramb.append(paramMap.getName());
      paramb.append(" in ");
      paramb.append(paramClass.getName());
      paramb.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramb.append(locala);
      paramb.append(", new value ");
      paramb.append(parama);
      throw new IllegalArgumentException(paramb.toString());
    }
    if (locala == null) {
      paramMap.put(paramb, parama);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.o.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */