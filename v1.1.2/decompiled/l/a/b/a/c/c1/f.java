package l.a.b.a.c.c1;

import java.util.Collections;
import java.util.List;
import l.a.b.a.b.n.j;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class f
  extends b<l.a.b.a.b.n.i, List>
  implements s<l.a.b.a.b.n.i>
{
  public static final Object[] d = { l.a.b.a.b.i.a(23L), l.a.b.a.b.f.a("amqp:end:list") };
  public static final l.a.b.a.b.i e = l.a.b.a.b.i.a(23L);
  
  public f(x paramx)
  {
    super(paramx);
  }
  
  public l.a.b.a.b.i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.n.i> b()
  {
    return l.a.b.a.b.n.i.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    l.a.b.a.b.n.i locali = new l.a.b.a.b.n.i();
    if (!((List)paramObject).isEmpty()) {
      a = ((j)((List)paramObject).get(0));
    }
    return locali;
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
 * Qualified Name:     l.a.b.a.c.c1.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */