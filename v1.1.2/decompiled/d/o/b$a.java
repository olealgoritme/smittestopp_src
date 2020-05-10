package d.o;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b$a
{
  public final Map<g.a, List<b.b>> a;
  public final Map<b.b, g.a> b;
  
  public b$a(Map<b.b, g.a> paramMap)
  {
    b = paramMap;
    a = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      g.a locala = (g.a)localEntry.getValue();
      List localList = (List)a.get(locala);
      paramMap = localList;
      if (localList == null)
      {
        paramMap = new ArrayList();
        a.put(locala, paramMap);
      }
      paramMap.add(localEntry.getKey());
    }
  }
  
  public static void a(List<b.b> paramList, l paraml, g.a parama, Object paramObject)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      for (;;)
      {
        if (i < 0) {
          return;
        }
        b.b localb = (b.b)paramList.get(i);
        if (localb != null) {
          try
          {
            int j = a;
            if (j != 0)
            {
              if (j != 1)
              {
                if (j == 2) {
                  b.invoke(paramObject, new Object[] { paraml, parama });
                }
              }
              else {
                b.invoke(paramObject, new Object[] { paraml });
              }
            }
            else {
              b.invoke(paramObject, new Object[0]);
            }
            i--;
          }
          catch (IllegalAccessException paramList)
          {
            throw new RuntimeException(paramList);
          }
          catch (InvocationTargetException paramList)
          {
            throw new RuntimeException("Failed to call observer method", paramList.getCause());
          }
        }
      }
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     d.o.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */