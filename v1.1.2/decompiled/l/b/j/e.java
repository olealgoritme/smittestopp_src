package l.b.j;

import java.security.AccessControlException;
import java.security.AccessController;

public class e
{
  public static final ThreadLocal a = new ThreadLocal();
  
  public static boolean a(String paramString)
  {
    try
    {
      d locald = new l/b/j/d;
      locald.<init>(paramString);
      paramString = (String)AccessController.doPrivileged(locald);
      if (paramString != null)
      {
        boolean bool = "true".equals(f.b(paramString));
        return bool;
      }
    }
    catch (AccessControlException paramString)
    {
      for (;;) {}
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     l.b.j.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */