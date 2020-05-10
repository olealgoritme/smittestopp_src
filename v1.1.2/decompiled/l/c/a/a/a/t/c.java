package l.c.a.a.a.t;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class c
{
  public static String a = a.class.getName();
  
  public static b a(String paramString1, String paramString2)
  {
    Object localObject = a;
    ResourceBundle localResourceBundle = ResourceBundle.getBundle(paramString1);
    paramString1 = null;
    try
    {
      localObject = Class.forName((String)localObject);
      localObject = (b)((Class)localObject).newInstance();
      ((b)localObject).a(localResourceBundle, paramString2, null);
      paramString1 = (String)localObject;
    }
    catch (NoClassDefFoundError|ClassNotFoundException|IllegalAccessException|InstantiationException|ExceptionInInitializerError|SecurityException localNoClassDefFoundError)
    {
      for (;;) {}
    }
    if (paramString1 != null) {
      return paramString1;
    }
    throw new MissingResourceException("Error locating the logging class", "l.c.a.a.a.t.c", paramString2);
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.t.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */