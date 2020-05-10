package k.a.b.a.c.c1;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.g;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.n.n;
import k.a.b.a.b.n.o;
import k.a.b.a.b.n.p;
import k.a.b.a.b.n.r;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class a
  extends b<k.a.b.a.b.n.a, List>
  implements s<k.a.b.a.b.n.a>
{
  public static final Object[] d = { i.a(18L), f.a("amqp:attach:list") };
  public static final i e = i.a(18L);
  
  public a(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.n.a> a()
  {
    return k.a.b.a.b.n.a.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    k.a.b.a.b.n.a locala = new k.a.b.a.b.n.a();
    if (localList.size() > 2)
    {
      Object localObject;
      switch (14 - localList.size())
      {
      default: 
        break;
      case 0: 
        n = ((Map)localList.get(13));
      case 1: 
        paramObject = localList.get(12);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          m = new f[] { (f)paramObject };
        } else {
          m = ((f[])paramObject);
        }
      case 2: 
        paramObject = localList.get(11);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          l = new f[] { (f)paramObject };
        } else {
          l = ((f[])paramObject);
        }
      case 3: 
        k = ((i)localList.get(10));
      case 4: 
        j = ((h)localList.get(9));
      case 5: 
        paramObject = (Boolean)localList.get(8);
        boolean bool;
        if (paramObject == null) {
          bool = false;
        } else {
          bool = ((Boolean)paramObject).booleanValue();
        }
        i = bool;
      case 6: 
        h = ((Map)localList.get(7));
      case 7: 
        g = ((r)localList.get(6));
      case 8: 
        f = ((k.a.b.a.b.n.q)localList.get(5));
      case 9: 
        paramObject = (g)localList.get(4);
        if (paramObject == null) {
          paramObject = n.FIRST;
        } else {
          paramObject = n.values()[(x & 0xFF)];
        }
        localObject = paramObject;
        if (paramObject == null) {
          localObject = n.FIRST;
        }
        e = ((n)localObject);
      case 10: 
        paramObject = (g)localList.get(3);
        if (paramObject == null) {
          paramObject = p.MIXED;
        } else {
          paramObject = p.values()[(x & 0xFF)];
        }
        localObject = paramObject;
        if (paramObject == null) {
          localObject = p.MIXED;
        }
        d = ((p)localObject);
      case 11: 
        if (Boolean.TRUE.equals(localList.get(2))) {
          paramObject = o.RECEIVER;
        } else {
          paramObject = o.SENDER;
        }
        if (paramObject == null) {
          break label539;
        }
        c = ((o)paramObject);
      case 12: 
        paramObject = (h)localList.get(1);
        if (paramObject == null) {
          break label529;
        }
        b = ((h)paramObject);
      }
      paramObject = (String)localList.get(0);
      if (paramObject != null)
      {
        a = ((String)paramObject);
      }
      else
      {
        throw new NullPointerException("the name field is mandatory");
        label529:
        throw new NullPointerException("the handle field is mandatory");
        label539:
        throw new NullPointerException("Role cannot be null");
      }
      return locala;
    }
    throw new k.a.b.a.c.q("The role field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new a.a((k.a.b.a.b.n.a)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */