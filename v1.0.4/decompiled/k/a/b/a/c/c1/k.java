package k.a.b.a.c.c1;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class k
  extends b<k.a.b.a.b.n.k, List>
  implements s<k.a.b.a.b.n.k>
{
  public static final Object[] d = { i.a(19L), f.a("amqp:flow:list") };
  public static final i e = i.a(19L);
  
  public k(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.n.k> a()
  {
    return k.a.b.a.b.n.k.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new k.a.b.a.b.n.k();
    if (localList.size() > 3)
    {
      Boolean localBoolean;
      boolean bool;
      switch (11 - localList.size())
      {
      default: 
        break;
      case 0: 
        k = ((Map)localList.get(10));
      case 1: 
        localBoolean = (Boolean)localList.get(9);
        if (localBoolean == null) {
          bool = false;
        } else {
          bool = localBoolean.booleanValue();
        }
        j = bool;
      case 2: 
        localBoolean = (Boolean)localList.get(8);
        if (localBoolean == null) {
          bool = false;
        } else {
          bool = localBoolean.booleanValue();
        }
        i = bool;
      case 3: 
        h = ((h)localList.get(7));
      case 4: 
        g = ((h)localList.get(6));
      case 5: 
        f = ((h)localList.get(5));
      case 6: 
        e = ((h)localList.get(4));
      case 7: 
        ((k.a.b.a.b.n.k)paramObject).c((h)localList.get(3));
      case 8: 
        ((k.a.b.a.b.n.k)paramObject).b((h)localList.get(2));
      case 9: 
        ((k.a.b.a.b.n.k)paramObject).a((h)localList.get(1));
      case 10: 
        a = ((h)localList.get(0));
      }
      return paramObject;
    }
    throw new q("The outgoing-window field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new k.a((k.a.b.a.b.n.k)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */