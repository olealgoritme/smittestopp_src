package l.a.b.a.c.z0;

import java.util.HashMap;
import java.util.LinkedHashMap;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.c.b;
import l.a.b.a.c.c;
import l.a.b.a.c.e.b;
import l.a.b.a.c.g0;
import l.a.b.a.c.j0;
import l.a.b.a.c.k0;
import l.a.b.a.c.n0;
import l.a.b.a.c.q;
import l.a.b.a.c.q0;
import l.a.b.a.c.r;
import l.a.b.a.c.r0;
import l.a.b.a.c.x;
import l.a.b.a.c.y;
import l.a.b.a.c.y0;

public class n
  implements l.a.b.a.c.a<l.a.b.a.b.k.d>, y<l.a.b.a.b.k.d>
{
  public static final Object[] c = { i.a(116L), f.a("amqp:application-properties:map") };
  public final d a;
  public final n0 b;
  
  public n(x paramx)
  {
    a = new d(paramx);
    b = ((n0)paramx.a(String.class, null));
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.k.d)paramObject;
    return a.a(paramObject);
  }
  
  public Class<l.a.b.a.b.k.d> b()
  {
    return l.a.b.a.b.k.d.class;
  }
  
  public void c(Object paramObject)
  {
    l.a.b.a.b.k.d locald = (l.a.b.a.b.k.d)paramObject;
    paramObject = a.b.a;
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)116);
    paramObject = (g0)a.b.a(a);
    d = b;
    try
    {
      ((c)paramObject).c(a);
      return;
    }
    finally
    {
      d = null;
    }
  }
  
  public r0<l.a.b.a.b.k.d> e()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object i()
  {
    r localr = a.a;
    k0 localk0 = a;
    int i = localk0.get();
    if (i != -63)
    {
      if (i != -47)
      {
        if (i == 64)
        {
          localObject1 = new l.a.b.a.b.k.d(null);
          break label348;
        }
        throw new l.a.b.a.a(e.a.a.a.a.a("Expected Map type but found encoding: ", i));
      }
      localk0.h();
      i = localk0.h();
    }
    else
    {
      localk0.get();
      i = localk0.get() & 0xFF;
    }
    if (i <= localk0.c())
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(i);
      int j = 0;
      localObject1 = null;
      while (j < i / 2)
      {
        String str = localr.a(null);
        if (str != null)
        {
          int k = localk0.get(localk0.position());
          if ((k != -32) && (k != -16)) {
            k = 0;
          } else {
            k = 1;
          }
          if (localObject1 == null)
          {
            localObject1 = localr.b();
          }
          else
          {
            int m = localk0.get(localk0.position());
            if ((m != 0) && ((localObject1 instanceof j0)))
            {
              if (m != ((j0)localObject1).f()) {
                localObject1 = localr.b();
              } else {
                localk0.get();
              }
            }
            else {
              localObject1 = localr.b();
            }
            if (localObject1 == null) {
              break label317;
            }
          }
          Object localObject2;
          if (k != 0) {
            localObject2 = ((e.b)localObject1).h();
          } else {
            localObject2 = ((q0)localObject1).i();
          }
          localLinkedHashMap.put(str, localObject2);
          j++;
          continue;
          label317:
          throw new q("Unknown constructor found in Map encoding: ");
        }
        else
        {
          throw new q("String key in ApplicationProperties cannot be null");
        }
      }
      localObject1 = new l.a.b.a.b.k.d(localLinkedHashMap);
      label348:
      return localObject1;
    }
    Object localObject1 = e.a.a.a.a.a("Map element count ", i, " is specified to be greater than the amount of data available (");
    ((StringBuilder)localObject1).append(localk0.c());
    ((StringBuilder)localObject1).append(")");
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public boolean j()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */