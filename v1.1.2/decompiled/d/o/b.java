package d.o;

import e.a.a.a.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  public static b c = new b();
  public final Map<Class<?>, a> a = new HashMap();
  public final Map<Class<?>, Boolean> b = new HashMap();
  
  public a a(Class<?> paramClass)
  {
    a locala = (a)a.get(paramClass);
    if (locala != null) {
      return locala;
    }
    return a(paramClass, null);
  }
  
  public final a a(Class<?> paramClass, Method[] paramArrayOfMethod)
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
    Object localObject2 = paramClass.getInterfaces();
    int i = localObject2.length;
    Object localObject3;
    for (int j = 0; j < i; j++)
    {
      localObject1 = ab.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        a(localHashMap, (b)((Map.Entry)localObject3).getKey(), (g.a)((Map.Entry)localObject3).getValue(), paramClass);
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
        localObject2 = (s)((Method)localObject1).getAnnotation(s.class);
        if (localObject2 != null)
        {
          localObject3 = ((Method)localObject1).getParameterTypes();
          if (localObject3.length > 0)
          {
            if (localObject3[0].isAssignableFrom(l.class)) {
              j = 1;
            } else {
              throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
            }
          }
          else {
            j = 0;
          }
          localObject2 = ((s)localObject2).value();
          if (localObject3.length > 1) {
            if (localObject3[1].isAssignableFrom(g.a.class))
            {
              if (localObject2 == g.a.ON_ANY) {
                j = 2;
              } else {
                throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
              }
            }
            else {
              throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
            }
          }
          if (localObject3.length <= 2)
          {
            a(localHashMap, new b(j, (Method)localObject1), (g.a)localObject2, paramClass);
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
      paramArrayOfMethod = new a(localHashMap);
      a.put(paramClass, paramArrayOfMethod);
      b.put(paramClass, Boolean.valueOf(bool));
      return paramArrayOfMethod;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  public final void a(Map<b, g.a> paramMap, b paramb, g.a parama, Class<?> paramClass)
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
  
  public static class a
  {
    public final Map<g.a, List<b.b>> a;
    public final Map<b.b, g.a> b;
    
    public a(Map<b.b, g.a> paramMap)
    {
      b = paramMap;
      a = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        g.a locala = (g.a)localEntry.getValue();
        List localList = (List)a.get(locala);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          a.put(locala, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
    }
    
    public static void a(List<b.b> paramList, l paraml, g.a parama, Object paramObject)
    {
      if (paramList != null)
      {
        int i = paramList.size() - 1;
        for (;;)
        {
          if (i < 0) {
            return;
          }
          b.b localb = (b.b)paramList.get(i);
          if (localb != null) {
            try
            {
              int j = a;
              if (j != 0)
              {
                if (j != 1)
                {
                  if (j == 2) {
                    b.invoke(paramObject, new Object[] { paraml, parama });
                  }
                }
                else {
                  b.invoke(paramObject, new Object[] { paraml });
                }
              }
              else {
                b.invoke(paramObject, new Object[0]);
              }
              i--;
            }
            catch (IllegalAccessException paramList)
            {
              throw new RuntimeException(paramList);
            }
            catch (InvocationTargetException paramList)
            {
              throw new RuntimeException("Failed to call observer method", paramList.getCause());
            }
          }
        }
        throw null;
      }
    }
  }
  
  public static class b
  {
    public final int a;
    public final Method b;
    
    public b(int paramInt, Method paramMethod)
    {
      a = paramInt;
      b = paramMethod;
      paramMethod.setAccessible(true);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (b.class == paramObject.getClass()))
      {
        paramObject = (b)paramObject;
        if ((a != a) || (!b.getName().equals(b.getName()))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = a;
      return b.getName().hashCode() + i * 31;
    }
  }
}

/* Location:
 * Qualified Name:     d.o.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */