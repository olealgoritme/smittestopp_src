package k.a.b.a.c.b1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class a
  extends b<k.a.b.a.b.m.a, List>
  implements s<k.a.b.a.b.m.a>
{
  public static final Object[] d = { i.a(48L), f.a("amqp:coordinator:list") };
  public static final i e = i.a(48L);
  
  public a(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.m.a> a()
  {
    return k.a.b.a.b.m.a.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new k.a.b.a.b.m.a();
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
  
  public i b()
  {
    return e;
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
 * Qualified Name:     base.k.a.b.a.c.b1.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */