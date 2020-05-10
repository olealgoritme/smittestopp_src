package e.e.a.u;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class h
{
  public static Map<g, Set<e>> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(g.y, new HashSet(Arrays.asList(new e[] { e.SIGN, e.VERIFY })));
    localHashMap.put(g.z, new HashSet(Arrays.asList(new e[] { e.ENCRYPT, e.DECRYPT, e.WRAP_KEY, e.UNWRAP_KEY })));
    a = Collections.unmodifiableMap(localHashMap);
  }
  
  public static boolean a(g paramg, Set<e> paramSet)
  {
    if ((paramg != null) && (paramSet != null)) {
      return ((Set)a.get(paramg)).containsAll(paramSet);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.u.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */