package k.a.b.a.c.c1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.n.j;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class f
  extends b<k.a.b.a.b.n.i, List>
  implements s<k.a.b.a.b.n.i>
{
  public static final Object[] d = { k.a.b.a.b.i.a(23L), k.a.b.a.b.f.a("amqp:end:list") };
  public static final k.a.b.a.b.i e = k.a.b.a.b.i.a(23L);
  
  public f(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.n.i> a()
  {
    return k.a.b.a.b.n.i.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new k.a.b.a.b.n.i();
    if (!localList.isEmpty()) {
      a = ((j)localList.get(0));
    }
    return paramObject;
  }
  
  public k.a.b.a.b.i b()
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
 * Qualified Name:     base.k.a.b.a.c.c1.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */