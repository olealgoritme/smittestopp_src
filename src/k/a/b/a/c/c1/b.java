package k.a.b.a.c.c1;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.j;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class b
  extends k.a.b.a.c.b<k.a.b.a.b.n.b, List>
  implements s<k.a.b.a.b.n.b>
{
  public static final Object[] d = { i.a(17L), f.a("amqp:begin:list") };
  public static final i e = i.a(17L);
  
  public b(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.n.b> a()
  {
    return k.a.b.a.b.n.b.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    k.a.b.a.b.n.b localb = new k.a.b.a.b.n.b();
    if (localList.size() > 3)
    {
      switch (8 - localList.size())
      {
      default: 
        break;
      case 0: 
        h = ((Map)localList.get(7));
      case 1: 
        paramObject = localList.get(6);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          g = new f[] { (f)paramObject };
        } else {
          g = ((f[])paramObject);
        }
      case 2: 
        paramObject = localList.get(5);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          f = new f[] { (f)paramObject };
        } else {
          f = ((f[])paramObject);
        }
      case 3: 
        h localh = (h)localList.get(4);
        paramObject = localh;
        if (localh == null) {
          paramObject = h.B;
        }
        e = ((h)paramObject);
      case 4: 
        paramObject = (h)localList.get(3);
        if (paramObject == null) {
          break label327;
        }
        d = ((h)paramObject);
      case 5: 
        paramObject = (h)localList.get(2);
        if (paramObject == null) {
          break label317;
        }
        c = ((h)paramObject);
      case 6: 
        paramObject = (h)localList.get(1);
        if (paramObject == null) {
          break label307;
        }
        b = ((h)paramObject);
      }
      a = ((j)localList.get(0));
      break label337;
      label307:
      throw new NullPointerException("the next-outgoing-id field is mandatory");
      label317:
      throw new NullPointerException("the incoming-window field is mandatory");
      label327:
      throw new NullPointerException("the outgoing-window field is mandatory");
      label337:
      return localb;
    }
    throw new q("The outgoing-window field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new b.a((k.a.b.a.b.n.b)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */