package k.a.b.a.c.b1;

import java.util.List;
import k.a.b.a.b.a;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class d
  extends b<k.a.b.a.b.m.d, List>
  implements s<k.a.b.a.b.m.d>
{
  public static final Object[] d = { i.a(50L), f.a("amqp:discharge:list") };
  public static final i e = i.a(50L);
  
  public d(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.m.d> a()
  {
    return k.a.b.a.b.m.d.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new k.a.b.a.b.m.d();
    if (!((List)localObject).isEmpty())
    {
      int i = 2 - ((List)localObject).size();
      if (i != 0)
      {
        if (i != 1) {
          break label77;
        }
      }
      else {
        b = ((Boolean)((List)localObject).get(1));
      }
      localObject = (a)((List)localObject).get(0);
      if (localObject != null)
      {
        a = ((a)localObject);
        label77:
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
    return new d.a((k.a.b.a.b.m.d)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.b1.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */