package k.a.b.a.c.z0;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.k.n;
import k.a.b.a.c.b;
import k.a.b.a.c.s;

public class x
  extends b<n, List>
  implements s<n>
{
  public static final Object[] d = { i.a(39L), f.a("amqp:modified:list") };
  public static final i e = i.a(39L);
  
  public x(k.a.b.a.c.x paramx)
  {
    super(paramx);
  }
  
  public Class<n> a()
  {
    return n.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    n localn = new n();
    int i = 3 - ((List)paramObject).size();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          break label67;
        }
        return localn;
      }
    }
    else {
      c = ((Map)((List)paramObject).get(2));
    }
    b = ((Boolean)((List)paramObject).get(1));
    label67:
    a = ((Boolean)((List)paramObject).get(0));
    return localn;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new x.a((n)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */