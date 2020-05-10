package i.a.a;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class e
{
  public static HashMap<Class<?>, LinkedHashSet<Class<?>>> a = new HashMap();
  public static HashMap<Class<?>, HashMap<String, String>> b = new HashMap();
  
  static
  {
    a(Object.class, g.class);
    a(Object.class, f.class);
  }
  
  public static void a(Class<?> paramClass1, Class<?> paramClass2)
  {
    synchronized (a)
    {
      LinkedHashSet localLinkedHashSet1 = (LinkedHashSet)a.get(paramClass1);
      LinkedHashSet localLinkedHashSet2 = localLinkedHashSet1;
      if (localLinkedHashSet1 == null)
      {
        localLinkedHashSet2 = new java/util/LinkedHashSet;
        localLinkedHashSet2.<init>();
        a.put(paramClass1, localLinkedHashSet2);
      }
      localLinkedHashSet2.add(paramClass2);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */