package k.a.b.a.c.z0;

import java.util.HashMap;
import java.util.LinkedHashMap;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.c;
import k.a.b.a.c.e.b;
import k.a.b.a.c.g0;
import k.a.b.a.c.j0;
import k.a.b.a.c.k0;
import k.a.b.a.c.o0;
import k.a.b.a.c.q;
import k.a.b.a.c.q0;
import k.a.b.a.c.r;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y;
import k.a.b.a.c.y0;

public class p
  implements k.a.b.a.c.a<k.a.b.a.b.k.j>, y<k.a.b.a.b.k.j>
{
  public static final Object[] c = { i.a(113L), f.a("amqp:delivery-annotations:map") };
  public final j a;
  public final o0 b;
  
  public p(x paramx)
  {
    a = new j(paramx);
    b = ((o0)paramx.a(f.class, null));
  }
  
  public Class<k.a.b.a.b.k.j> a()
  {
    return k.a.b.a.b.k.j.class;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (k.a.b.a.b.k.j)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    k.a.b.a.b.k.j localj = (k.a.b.a.b.k.j)paramObject;
    paramObject = a.b.a;
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)113);
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
  
  public boolean e()
  {
    return false;
  }
  
  public r0<k.a.b.a.b.k.j> f()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object k()
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
          localObject1 = new k.a.b.a.b.k.j(null);
          break label348;
        }
        throw new k.a.b.a.a(e.a.a.a.a.a("Expected Map type but found encoding: ", i));
      }
      localk0.d();
      i = localk0.d();
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
        f localf = localr.a(null);
        if (localf != null)
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
              if (m != ((j0)localObject1).g()) {
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
            localObject2 = ((e.b)localObject1).j();
          } else {
            localObject2 = ((q0)localObject1).k();
          }
          localLinkedHashMap.put(localf, localObject2);
          j++;
          continue;
          label317:
          throw new q("Unknown constructor found in Map encoding: ");
        }
        else
        {
          throw new q("String key in DeliveryAnnotations cannot be null");
        }
      }
      localObject1 = new k.a.b.a.b.k.j(localLinkedHashMap);
      label348:
      return localObject1;
    }
    Object localObject1 = e.a.a.a.a.a("Map element count ", i, " is specified to be greater than the amount of data available (");
    ((StringBuilder)localObject1).append(localk0.c());
    ((StringBuilder)localObject1).append(")");
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */