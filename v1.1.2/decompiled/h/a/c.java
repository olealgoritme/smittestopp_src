package h.a;

import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  public static final c a;
  public static final boolean b;
  public static final Map<String, String> c;
  public static final Map<String, String> d;
  public static final String e;
  public static final String f;
  public static final String g;
  
  static
  {
    String str1 = "unknown";
    a = new c();
    b = Boolean.valueOf(System.getProperty("jnr.constants.fake", "true")).booleanValue();
    c = new a();
    d = new b();
    try
    {
      String str2 = System.getProperty("os.arch", "unknown");
    }
    catch (SecurityException localSecurityException1)
    {
      localObject1 = "unknown";
    }
    Object localObject2 = ((String)localObject1).toLowerCase();
    Iterator localIterator = d.keySet().iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (String)localIterator.next();
    } while (!((String)localObject1).equalsIgnoreCase((String)localObject2));
    Object localObject1 = (String)d.get(localObject1);
    e = (String)localObject1;
    try
    {
      localObject1 = System.getProperty("os.name", "unknown");
      str1 = ((String)localObject1).toLowerCase();
      localObject2 = c.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if (((String)localObject1).equalsIgnoreCase(str1))
        {
          localObject1 = (String)c.get(localObject1);
          break label213;
        }
      }
      localObject1 = str1;
      if (str1.startsWith("windows")) {
        localObject1 = "windows";
      }
      label213:
      f = (String)localObject1;
      g = String.format("%s-%s", new Object[] { e, localObject1 });
      ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
      return;
    }
    catch (SecurityException localSecurityException2)
    {
      for (;;)
      {
        String str3 = str1;
      }
    }
  }
  
  public String a()
  {
    return String.format("%s.platform.%s.%s", new Object[] { c.a, f, e });
  }
  
  public String b()
  {
    return String.format("%s.platform.%s", new Object[] { c.a, f });
  }
  
  public static final class a
    extends HashMap<String, String>
  {
    public a()
    {
      put("Mac OS X", "darwin");
      put("SunOS", "solaris");
    }
  }
  
  public static final class b
    extends HashMap<String, String>
  {
    public b()
    {
      put("x86", "i386");
    }
  }
  
  public static final class c
  {
    public static final String a;
    
    static
    {
      Object localObject = new c();
      String str;
      try
      {
        localObject = localObject.getClass();
        Package localPackage = ((Class)localObject).getPackage();
        if (localPackage != null) {
          localObject = localPackage.getName();
        } else {
          localObject = ((Class)localObject).getName().substring(0, ((Class)localObject).getName().lastIndexOf('.'));
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        str = "jnr.constants";
      }
      a = str;
    }
  }
}

/* Location:
 * Qualified Name:     h.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */