package l.a.b.a.c.b1;

import java.util.Collections;
import java.util.List;
import l.a.b.a.b.a;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class c
  extends b<l.a.b.a.b.m.c, List>
  implements s<l.a.b.a.b.m.c>
{
  public static final Object[] d = { i.a(51L), f.a("amqp:declared:list") };
  public static final i e = i.a(51L);
  
  public c(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.m.c> b()
  {
    return l.a.b.a.b.m.c.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new l.a.b.a.b.m.c();
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
  
  public Object d(Object paramObject)
  {
    return Collections.singletonList(a);
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.b1.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */