package k.a.b.a.c.a1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class a
  extends b<k.a.b.a.b.l.a, List>
  implements s<k.a.b.a.b.l.a>
{
  public static final Object[] d = { i.a(66L), f.a("amqp:sasl-challenge:list") };
  public static final i e = i.a(66L);
  
  public a(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.l.a> a()
  {
    return k.a.b.a.b.l.a.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new k.a.b.a.b.l.a();
    if (!((List)localObject).isEmpty())
    {
      localObject = (k.a.b.a.b.a)((List)localObject).get(0);
      if (localObject != null)
      {
        a = ((k.a.b.a.b.a)localObject);
        return paramObject;
      }
      throw new NullPointerException("the challenge field is mandatory");
    }
    throw new q("The challenge field cannot be omitted");
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
 * Qualified Name:     base.k.a.b.a.c.a1.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */