package l.a.b.a.c.a1;

import java.util.Collections;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.l.e;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class c
  extends b<e, List>
  implements s<e>
{
  public static final Object[] d = { i.a(64L), f.a("amqp:sasl-mechanisms:list") };
  public static final i e = i.a(64L);
  
  public c(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<e> b()
  {
    return e.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new e();
    if (!((List)localObject).isEmpty())
    {
      localObject = ((List)localObject).get(0);
      if ((localObject != null) && (!localObject.getClass().isArray())) {
        ((e)paramObject).a(new f[] { (f)localObject });
      } else {
        ((e)paramObject).a((f[])localObject);
      }
      return paramObject;
    }
    throw new q("The sasl-server-mechanisms field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return Collections.singletonList(a);
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.a1.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */