package k.a.b.a.c.a1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.a;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.l.g;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class e
  extends b<g, List>
  implements s<g>
{
  public static final Object[] d = { i.a(67L), f.a("amqp:sasl-response:list") };
  public static final i e = i.a(67L);
  
  public e(x paramx)
  {
    super(paramx);
  }
  
  public Class<g> a()
  {
    return g.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new g();
    if (!((List)localObject).isEmpty())
    {
      if (1 - ((List)localObject).size() == 0)
      {
        localObject = (a)((List)localObject).get(0);
        if (localObject != null) {
          a = ((a)localObject);
        }
      }
      else
      {
        return paramObject;
      }
      throw new NullPointerException("the response field is mandatory");
    }
    throw new q("The response field cannot be omitted");
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
 * Qualified Name:     base.k.a.b.a.c.a1.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */