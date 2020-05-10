package g.a;

import java.nio.ByteOrder;
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
    c = new c.a();
    d = new c.b();
    try
    {
      String str2 = System.getProperty("os.arch", "unknown");
    }
    catch (SecurityException localSecurityException1)
    {
      localObject = "unknown";
    }
    String str4 = ((String)localObject).toLowerCase();
    Iterator localIterator = d.keySet().iterator();
    do
    {
      localObject = str4;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
    } while (!((String)localObject).equalsIgnoreCase(str4));
    Object localObject = (String)d.get(localObject);
    e = (String)localObject;
    try
    {
      localObject = System.getProperty("os.name", "unknown");
      str1 = ((String)localObject).toLowerCase();
      localObject = c.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str4 = (String)((Iterator)localObject).next();
        if (str4.equalsIgnoreCase(str1))
        {
          localObject = (String)c.get(str4);
          break label213;
        }
      }
      localObject = str1;
      if (str1.startsWith("windows")) {
        localObject = "windows";
      }
      label213:
      f = (String)localObject;
      g = String.format("%s-%s", new Object[] { e, localObject });
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
    return String.format("%s.platform.%s.%s", new Object[] { c.c.a, f, e });
  }
  
  public String b()
  {
    return String.format("%s.platform.%s", new Object[] { c.c.a, f });
  }
}

/* Location:
 * Qualified Name:     base.g.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */