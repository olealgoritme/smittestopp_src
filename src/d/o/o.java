package d.o;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o
{
  public static Map<Class<?>, Integer> a = new HashMap();
  public static Map<Class<?>, List<Constructor<? extends e>>> b = new HashMap();
  
  public static int a(Class<?> paramClass)
  {
    Object localObject1 = (Integer)a.get(paramClass);
    if (localObject1 != null) {
      return ((Integer)localObject1).intValue();
    }
    localObject1 = paramClass.getCanonicalName();
    int i = 1;
    int j;
    Class[] arrayOfClass;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if (localObject1 == null)
    {
      j = i;
    }
    else
    {
      arrayOfClass = null;
      try
      {
        localObject1 = paramClass.getPackage();
        localObject3 = paramClass.getCanonicalName();
        if (localObject1 != null) {
          localObject1 = ((Package)localObject1).getName();
        } else {
          localObject1 = "";
        }
        if (!((String)localObject1).isEmpty()) {
          localObject3 = ((String)localObject3).substring(((String)localObject1).length() + 1);
        }
        localObject3 = a((String)localObject3);
        if (((String)localObject1).isEmpty())
        {
          localObject1 = localObject3;
        }
        else
        {
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(".");
          ((StringBuilder)localObject4).append((String)localObject3);
          localObject1 = ((StringBuilder)localObject4).toString();
        }
        localObject3 = Class.forName((String)localObject1).getDeclaredConstructor(new Class[] { paramClass });
        localObject1 = localObject3;
        if (!((Constructor)localObject3).isAccessible())
        {
          ((Constructor)localObject3).setAccessible(true);
          localObject1 = localObject3;
        }
      }
      catch (NoSuchMethodException paramClass)
      {
        throw new RuntimeException(paramClass);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject2 = null;
      }
      if (localObject2 != null) {
        b.put(paramClass, Collections.singletonList(localObject2));
      }
    }
    for (;;)
    {
      j = 2;
      break label549;
      localObject2 = b.c;
      localObject3 = (Boolean)b.get(paramClass);
      boolean bool;
      if (localObject3 != null) {
        bool = ((Boolean)localObject3).booleanValue();
      }
      try
      {
        localObject3 = paramClass.getDeclaredMethods();
        int k = localObject3.length;
        for (j = 0; j < k; j++) {
          if ((s)localObject3[j].getAnnotation(s.class) != null)
          {
            ((b)localObject2).a(paramClass, (Method[])localObject3);
            bool = true;
            break label331;
          }
        }
        b.put(paramClass, Boolean.valueOf(false));
        bool = false;
        label331:
        if (bool)
        {
          j = i;
        }
        else
        {
          localObject2 = paramClass.getSuperclass();
          if ((localObject2 != null) && (k.class.isAssignableFrom((Class)localObject2))) {
            j = 1;
          } else {
            j = 0;
          }
          localObject3 = arrayOfClass;
          if (j != 0)
          {
            if (a((Class)localObject2) == 1) {
              j = i;
            } else {
              localObject3 = new ArrayList((Collection)b.get(localObject2));
            }
          }
          else
          {
            arrayOfClass = paramClass.getInterfaces();
            int m = arrayOfClass.length;
            j = 0;
            while (j < m)
            {
              localObject4 = arrayOfClass[j];
              if ((localObject4 != null) && (k.class.isAssignableFrom((Class)localObject4))) {
                k = 1;
              } else {
                k = 0;
              }
              if (k == 0)
              {
                localObject2 = localObject3;
              }
              else
              {
                if (a((Class)localObject4) == 1)
                {
                  j = i;
                  break label549;
                }
                localObject2 = localObject3;
                if (localObject3 == null) {
                  localObject2 = new ArrayList();
                }
                ((List)localObject2).addAll((Collection)b.get(localObject4));
              }
              j++;
              localObject3 = localObject2;
            }
            j = i;
            if (localObject3 != null)
            {
              b.put(paramClass, localObject3);
              continue;
            }
          }
        }
        label549:
        a.put(paramClass, Integer.valueOf(j));
        return j;
      }
      catch (NoClassDefFoundError paramClass)
      {
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
      }
    }
  }
  
  public static e a(Constructor<? extends e> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (e)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  public static j a(Object paramObject)
  {
    boolean bool1 = paramObject instanceof j;
    boolean bool2 = paramObject instanceof d;
    if ((bool1) && (bool2)) {
      return new FullLifecycleObserverAdapter((d)paramObject, (j)paramObject);
    }
    if (bool2) {
      return new FullLifecycleObserverAdapter((d)paramObject, null);
    }
    if (bool1) {
      return (j)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (a((Class)localObject) == 2)
    {
      localObject = (List)b.get(localObject);
      int i = ((List)localObject).size();
      int j = 0;
      if (i == 1) {
        return new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
      }
      e[] arrayOfe = new e[((List)localObject).size()];
      while (j < ((List)localObject).size())
      {
        arrayOfe[j] = a((Constructor)((List)localObject).get(j), paramObject);
        j++;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfe);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.replace(".", "_"));
    localStringBuilder.append("_LifecycleAdapter");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.o.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */