package l.a.b.a.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g0$a
  extends d0<Map>
  implements g0.b
{
  public Map c;
  public int d;
  
  public g0$a(g0 paramg0, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public void a(Map paramMap, int paramInt)
  {
    c = paramMap;
    d = paramInt;
  }
  
  public boolean a(r0<Map> paramr0)
  {
    boolean bool;
    if (e == paramr0.getType()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int c(Object paramObject)
  {
    paramObject = (Map)paramObject;
    int i;
    if (paramObject == c) {
      i = d;
    } else {
      i = e.a((Map)paramObject);
    }
    return i + 4;
  }
  
  public void d(Object paramObject)
  {
    paramObject = (Map)paramObject;
    Object localObject = a.a;
    if (paramObject == c) {
      i = d;
    } else {
      i = e.a((Map)paramObject);
    }
    ((y0)localObject).b(i + 4 + 4);
    localObject = a;
    int i = ((Map)paramObject).size();
    a.c(i * 2);
    Iterator localIterator = ((Map)paramObject).entrySet().iterator();
    paramObject = e;
    localObject = d;
    d = null;
    try
    {
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localObject == null) {
          paramObject = e.c.a(localEntry.getKey()).a(localEntry.getKey());
        } else {
          paramObject = ((a)localObject).a(localEntry.getKey());
        }
        ((r0)paramObject).c();
        ((r0)paramObject).b(localEntry.getKey());
        paramObject = a.a(localEntry.getValue()).a(localEntry.getValue());
        ((r0)paramObject).c();
        ((r0)paramObject).b(localEntry.getValue());
      }
      return;
    }
    finally
    {
      e.d = ((a)localObject);
    }
  }
  
  public byte f()
  {
    return -47;
  }
  
  public a getType()
  {
    return e;
  }
  
  public i0 getType()
  {
    return e;
  }
  
  public Object i()
  {
    r localr = b;
    k0 localk0 = a;
    localr.f();
    int i = localr.f();
    if (i <= localr.a())
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(i);
      q0 localq01 = null;
      localObject1 = null;
      int j = 0;
      while (j < i / 2)
      {
        localq01 = g0.a(localr, localk0, localq01);
        if (localq01 != null)
        {
          Object localObject2 = localq01.i();
          int k = localk0.get(localk0.position());
          if ((k != -32) && (k != -16)) {
            k = 0;
          } else {
            k = 1;
          }
          q0 localq02 = g0.a(localr, localk0, (q0)localObject1);
          if (localq02 != null)
          {
            if (k != 0) {
              localObject1 = ((e.b)localq02).h();
            } else {
              localObject1 = localq02.i();
            }
            localLinkedHashMap.put(localObject2, localObject1);
            j++;
            localObject1 = localq02;
          }
          else
          {
            throw new q("Unknown constructor");
          }
        }
        else
        {
          throw new q("Unknown constructor");
        }
      }
      return localLinkedHashMap;
    }
    Object localObject1 = e.a.a.a.a.a("Map element count ", i, " is specified to be greater than the amount of data available (");
    ((StringBuilder)localObject1).append(localr.a());
    ((StringBuilder)localObject1).append(")");
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.g0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */