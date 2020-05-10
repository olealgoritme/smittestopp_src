package e.c.c.w;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class t
{
  public static final Map<Class<?>, Class<?>> a;
  
  static
  {
    HashMap localHashMap1 = new HashMap(16);
    HashMap localHashMap2 = new HashMap(16);
    Class localClass = Boolean.TYPE;
    localHashMap1.put(localClass, Boolean.class);
    localHashMap2.put(Boolean.class, localClass);
    localClass = Byte.TYPE;
    localHashMap1.put(localClass, Byte.class);
    localHashMap2.put(Byte.class, localClass);
    localClass = Character.TYPE;
    localHashMap1.put(localClass, Character.class);
    localHashMap2.put(Character.class, localClass);
    localClass = Double.TYPE;
    localHashMap1.put(localClass, Double.class);
    localHashMap2.put(Double.class, localClass);
    localClass = Float.TYPE;
    localHashMap1.put(localClass, Float.class);
    localHashMap2.put(Float.class, localClass);
    localClass = Integer.TYPE;
    localHashMap1.put(localClass, Integer.class);
    localHashMap2.put(Integer.class, localClass);
    localClass = Long.TYPE;
    localHashMap1.put(localClass, Long.class);
    localHashMap2.put(Long.class, localClass);
    localClass = Short.TYPE;
    localHashMap1.put(localClass, Short.class);
    localHashMap2.put(Short.class, localClass);
    localClass = Void.TYPE;
    localHashMap1.put(localClass, Void.class);
    localHashMap2.put(Void.class, localClass);
    a = Collections.unmodifiableMap(localHashMap1);
    Collections.unmodifiableMap(localHashMap2);
  }
  
  public static <T> Class<T> a(Class<T> paramClass)
  {
    Object localObject = a;
    if (paramClass != null)
    {
      localObject = (Class)((Map)localObject).get(paramClass);
      if (localObject != null) {
        paramClass = (Class<T>)localObject;
      }
      return paramClass;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */