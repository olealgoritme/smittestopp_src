package k.a.b.a.c.z0;

import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.k.r;
import k.a.b.a.b.n.j;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class a0
  extends b<r, List>
  implements s<r>
{
  public static final Object[] d = { i.a(37L), f.a("amqp:rejected:list") };
  public static final i e = i.a(37L);
  
  public a0(x paramx)
  {
    super(paramx);
  }
  
  public Class<r> a()
  {
    return r.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new r();
    if (1 - localList.size() == 0) {
      a = ((j)localList.get(0));
    }
    return paramObject;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new a0.b((r)paramObject, null);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.a0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */