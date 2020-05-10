package l.a.b.a.c.c1;

import java.util.Collections;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.n.j;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class c
  extends b<l.a.b.a.b.n.c, List>
  implements s<l.a.b.a.b.n.c>
{
  public static final Object[] d = { i.a(24L), f.a("amqp:close:list") };
  public static final i e = i.a(24L);
  
  public c(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.n.c> b()
  {
    return l.a.b.a.b.n.c.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    l.a.b.a.b.n.c localc = new l.a.b.a.b.n.c();
    if (!((List)paramObject).isEmpty()) {
      a = ((j)((List)paramObject).get(0));
    }
    return localc;
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
 * Qualified Name:     l.a.b.a.c.c1.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */