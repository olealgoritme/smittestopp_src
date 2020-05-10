package l.a.b.a.c.b1;

import java.util.Collections;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.m.e;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class b
  extends l.a.b.a.c.b<l.a.b.a.b.m.b, List>
  implements s<l.a.b.a.b.m.b>
{
  public static final Object[] d = { i.a(49L), f.a("amqp:declare:list") };
  public static final i e = i.a(49L);
  
  public b(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.m.b> b()
  {
    return l.a.b.a.b.m.b.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new l.a.b.a.b.m.b();
    if (!localList.isEmpty()) {
      a = ((e)localList.get(0));
    }
    return paramObject;
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
 * Qualified Name:     l.a.b.a.c.b1.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */