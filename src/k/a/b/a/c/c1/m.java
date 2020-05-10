package k.a.b.a.c.c1;

import java.util.List;
import k.a.b.a.b.a;
import k.a.b.a.b.f;
import k.a.b.a.b.g;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.n.e;
import k.a.b.a.b.n.n;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.x;

public final class m
  extends b<k.a.b.a.b.n.s, List>
  implements k.a.b.a.c.s<k.a.b.a.b.n.s>
{
  public static final Object[] d = { i.a(20L), f.a("amqp:transfer:list") };
  public static final i e = i.a(20L);
  
  public m(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.n.s> a()
  {
    return k.a.b.a.b.n.s.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    k.a.b.a.b.n.s locals = new k.a.b.a.b.n.s();
    if (!localList.isEmpty())
    {
      boolean bool;
      switch (11 - localList.size())
      {
      default: 
        break;
      case 0: 
        paramObject = (Boolean)localList.get(10);
        if (paramObject == null) {
          bool = false;
        } else {
          bool = ((Boolean)paramObject).booleanValue();
        }
        k = bool;
      case 1: 
        paramObject = (Boolean)localList.get(9);
        if (paramObject == null) {
          bool = false;
        } else {
          bool = ((Boolean)paramObject).booleanValue();
        }
        j = bool;
      case 2: 
        paramObject = (Boolean)localList.get(8);
        if (paramObject == null) {
          bool = false;
        } else {
          bool = ((Boolean)paramObject).booleanValue();
        }
        i = bool;
      case 3: 
        h = ((e)localList.get(7));
      case 4: 
        paramObject = (g)localList.get(6);
        if (paramObject == null) {
          paramObject = null;
        } else {
          paramObject = n.values()[(x & 0xFF)];
        }
        g = ((n)paramObject);
      case 5: 
        paramObject = (Boolean)localList.get(5);
        if (paramObject == null) {
          bool = false;
        } else {
          bool = ((Boolean)paramObject).booleanValue();
        }
        f = bool;
      case 6: 
        e = ((Boolean)localList.get(4));
      case 7: 
        d = ((h)localList.get(3));
      case 8: 
        c = ((a)localList.get(2));
      case 9: 
        b = ((h)localList.get(1));
      case 10: 
        locals.a((h)localList.get(0));
      }
      return locals;
    }
    throw new q("The handle field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new m.a((k.a.b.a.b.n.s)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */