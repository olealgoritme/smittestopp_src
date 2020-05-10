package k.a.b.a.c.z0;

import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.g;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.k.l;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class v
  extends b<l, List>
  implements s<l>
{
  public static final Object[] d = { i.a(112L), f.a("amqp:header:list") };
  public static final i e = i.a(112L);
  
  public v(x paramx)
  {
    super(paramx);
  }
  
  public Class<l> a()
  {
    return l.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    l locall = new l();
    int i = 5 - ((List)paramObject).size();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          break label77;
        }
        if (i == 3) {
          break label91;
        }
        if (i == 4) {
          break label105;
        }
        return locall;
      }
    }
    else {
      e = ((h)((List)paramObject).get(4));
    }
    d = ((Boolean)((List)paramObject).get(3));
    label77:
    c = ((h)((List)paramObject).get(2));
    label91:
    b = ((g)((List)paramObject).get(1));
    label105:
    a = ((Boolean)((List)paramObject).get(0));
    return locall;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new v.a((l)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */