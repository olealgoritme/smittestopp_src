package l.a.b.a.c.b1;

import java.util.Collections;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class a
  extends b<l.a.b.a.b.m.a, List>
  implements s<l.a.b.a.b.m.a>
{
  public static final Object[] d = { i.a(48L), f.a("amqp:coordinator:list") };
  public static final i e = i.a(48L);
  
  public a(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.m.a> b()
  {
    return l.a.b.a.b.m.a.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new l.a.b.a.b.m.a();
    if (1 - ((List)localObject).size() == 0)
    {
      localObject = ((List)localObject).get(0);
      if ((localObject != null) && (!localObject.getClass().isArray())) {
        a = new f[] { (f)localObject };
      } else {
        a = ((f[])localObject);
      }
    }
    return paramObject;
  }
  
  public Object d(Object paramObject)
  {
    paramObject = a;
    if ((paramObject != null) && (paramObject.length != 0)) {
      paramObject = Collections.singletonList(paramObject);
    } else {
      paramObject = Collections.EMPTY_LIST;
    }
    return paramObject;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.b1.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */