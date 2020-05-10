package k.a.b.a.c.z0;

import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.k.q;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class z
  extends b<q, List>
  implements s<q>
{
  public static final Object[] d = { i.a(35L), f.a("amqp:received:list") };
  public static final i e = i.a(35L);
  
  public z(x paramx)
  {
    super(paramx);
  }
  
  public Class<q> a()
  {
    return q.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new q();
    int i = 2 - localList.size();
    if (i != 0)
    {
      if (i != 1) {
        return paramObject;
      }
    }
    else {
      b = ((i)localList.get(1));
    }
    a = ((h)localList.get(0));
    return paramObject;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new z.b((q)paramObject, null);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */