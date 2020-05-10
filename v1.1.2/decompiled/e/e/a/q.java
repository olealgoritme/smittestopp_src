package e.e.a;

import j.a.b.d;
import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class q
  extends e
{
  public static final Set<String> E;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("alg");
    localHashSet.add("typ");
    localHashSet.add("cty");
    localHashSet.add("crit");
    E = Collections.unmodifiableSet(localHashSet);
  }
  
  public q(h paramh, String paramString, Set<String> paramSet, Map<String, Object> paramMap, e.e.a.v.c paramc)
  {
    super(a.y, paramh, paramString, paramSet, paramMap, paramc);
  }
  
  public static q a(e.e.a.v.c paramc)
  {
    d locald = e.c.a.a.b.l.c.b(paramc.e());
    if (e.a(locald) == a.y)
    {
      Iterator localIterator = locald.keySet().iterator();
      h localh = null;
      Object localObject1 = localh;
      Object localObject2 = localObject1;
      Object localObject3 = localObject2;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!"alg".equals(str))
        {
          Object localObject4;
          if ("typ".equals(str))
          {
            localObject4 = e.c.a.a.b.l.c.d(locald, str);
            if (localObject4 != null) {
              localh = new h((String)localObject4);
            }
          }
          else if ("cty".equals(str))
          {
            localObject1 = e.c.a.a.b.l.c.d(locald, str);
          }
          else if ("crit".equals(str))
          {
            localObject4 = e.c.a.a.b.l.c.e(locald, str);
            if (localObject4 != null) {
              localObject2 = new HashSet((Collection)localObject4);
            }
          }
          else
          {
            Object localObject5 = locald.get(str);
            if (!E.contains(str))
            {
              localObject4 = localObject3;
              if (localObject3 == null) {
                localObject4 = new HashMap();
              }
              ((Map)localObject4).put(str, localObject5);
              localObject3 = localObject4;
            }
            else
            {
              throw new IllegalArgumentException(e.a.a.a.a.a("The parameter name \"", str, "\" matches a registered name"));
            }
          }
        }
      }
      return new q(localh, (String)localObject1, (Set)localObject2, (Map)localObject3, paramc);
    }
    throw new ParseException("The algorithm \"alg\" header parameter must be \"none\"", 0);
  }
}

/* Location:
 * Qualified Name:     e.e.a.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */