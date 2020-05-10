package k.a.b.a.c.c1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.n.j;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class c
  extends b<k.a.b.a.b.n.c, List>
  implements s<k.a.b.a.b.n.c>
{
  public static final Object[] d = { i.a(24L), f.a("amqp:close:list") };
  public static final i e = i.a(24L);
  
  public c(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.n.c> a()
  {
    return k.a.b.a.b.n.c.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    k.a.b.a.b.n.c localc = new k.a.b.a.b.n.c();
    if (!((List)paramObject).isEmpty()) {
      a = ((j)((List)paramObject).get(0));
    }
    return localc;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    paramObject = a;
    if (paramObject == null) {
      paramObject = Collections.EMPTY_LIST;
    } else {
      paramObject = Collections.singletonList(paramObject);
    }
    return paramObject;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */