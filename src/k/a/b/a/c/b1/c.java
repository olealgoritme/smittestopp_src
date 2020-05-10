package k.a.b.a.c.b1;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.a;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class c
  extends b<k.a.b.a.b.m.c, List>
  implements s<k.a.b.a.b.m.c>
{
  public static final Object[] d = { i.a(51L), f.a("amqp:declared:list") };
  public static final i e = i.a(51L);
  
  public c(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.m.c> a()
  {
    return k.a.b.a.b.m.c.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new k.a.b.a.b.m.c();
    if (!((List)localObject).isEmpty())
    {
      localObject = (a)((List)localObject).get(0);
      if (localObject != null)
      {
        a = ((a)localObject);
        return paramObject;
      }
      throw new NullPointerException("the txn-id field is mandatory");
    }
    throw new q("The txn-id field cannot be omitted");
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
 * Qualified Name:     base.k.a.b.a.c.b1.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */