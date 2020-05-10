package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g0
  extends c<Map>
{
  public final g0.b a;
  public final g0.b b;
  public x c;
  public a<?> d;
  
  public g0(x paramx, r paramr)
  {
    c = paramx;
    a = new g0.a(this, paramx, paramr);
    b = new g0.c(this, paramx, paramr);
    c.put(Map.class, this);
    paramr.a(this);
  }
  
  public final int a(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    a locala = d;
    d = null;
    int i = 0;
    try
    {
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (locala == null) {
          paramMap = c.a(localEntry.getKey()).a(localEntry.getKey());
        } else {
          paramMap = locala.a(localEntry.getKey());
        }
        int j = paramMap.d();
        int k = paramMap.b(localEntry.getKey());
        paramMap = c.a(localEntry.getValue()).a(localEntry.getValue());
        int m = paramMap.d();
        int n = paramMap.b(localEntry.getValue());
        i = m + n + (j + k + i);
      }
      return i;
    }
    finally
    {
      d = locala;
    }
  }
  
  public Class<Map> a()
  {
    return Map.class;
  }
  
  public g0.b b(Map paramMap)
  {
    int i = a(paramMap);
    g0.b localb;
    if ((paramMap.size() <= 127) && (i < 254)) {
      localb = b;
    } else {
      localb = a;
    }
    localb.a(paramMap, i);
    return localb;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<g0.b> i()
  {
    return Arrays.asList(new g0.b[] { b, a });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.g0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */