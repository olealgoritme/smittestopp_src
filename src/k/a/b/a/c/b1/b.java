package k.a.b.a.c.b1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.m.e;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class b
  extends k.a.b.a.c.b<k.a.b.a.b.m.b, List>
  implements s<k.a.b.a.b.m.b>
{
  public static final Object[] d = { i.a(49L), f.a("amqp:declare:list") };
  public static final i e = i.a(49L);
  
  public b(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.m.b> a()
  {
    return k.a.b.a.b.m.b.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    k.a.b.a.b.m.b localb = new k.a.b.a.b.m.b();
    if (!((List)paramObject).isEmpty()) {
      a = ((e)((List)paramObject).get(0));
    }
    return localb;
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
 * Qualified Name:     base.k.a.b.a.c.b1.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */