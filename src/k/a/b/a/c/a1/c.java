package k.a.b.a.c.a1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.l.e;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

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
  
  public Class<e> a()
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
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return Collections.singletonList(a);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.a1.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */