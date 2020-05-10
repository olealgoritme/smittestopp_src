package l.b.j;

import java.security.PrivilegedAction;
import java.util.Map;

public final class d
  implements PrivilegedAction
{
  public d(String paramString) {}
  
  public Object run()
  {
    Map localMap = (Map)e.a.get();
    if (localMap != null) {
      return localMap.get(a);
    }
    return System.getProperty(a);
  }
}

/* Location:
 * Qualified Name:     l.b.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */