package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class k
  extends b<l.a.b.a.b.n.k, List>
  implements s<l.a.b.a.b.n.k>
{
  public static final Object[] d = { i.a(19L), f.a("amqp:flow:list") };
  public static final i e = i.a(19L);
  
  public k(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.n.k> b()
  {
    return l.a.b.a.b.n.k.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new l.a.b.a.b.n.k();
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
        ((l.a.b.a.b.n.k)paramObject).c((h)localList.get(3));
      case 8: 
        ((l.a.b.a.b.n.k)paramObject).b((h)localList.get(2));
      case 9: 
        ((l.a.b.a.b.n.k)paramObject).a((h)localList.get(1));
      case 10: 
        a = ((h)localList.get(0));
      }
      return paramObject;
    }
    throw new q("The outgoing-window field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((l.a.b.a.b.n.k)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public l.a.b.a.b.n.k x;
    
    public a(l.a.b.a.b.n.k paramk)
    {
      x = paramk;
    }
    
    public Object get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException(a.a("Unknown index ", paramInt));
      case 10: 
        return x.k;
      case 9: 
        return Boolean.valueOf(x.j);
      case 8: 
        return Boolean.valueOf(x.i);
      case 7: 
        return x.h;
      case 6: 
        return x.g;
      case 5: 
        return x.f;
      case 4: 
        return x.e;
      case 3: 
        return x.d;
      case 2: 
        return x.c;
      case 1: 
        return x.b;
      }
      return x.a;
    }
    
    public int size()
    {
      l.a.b.a.b.n.k localk = x;
      int i;
      if (k != null) {
        i = 11;
      } else if (j) {
        i = 10;
      } else if (i) {
        i = 9;
      } else if (h != null) {
        i = 8;
      } else if (g != null) {
        i = 7;
      } else if (f != null) {
        i = 6;
      } else if (e != null) {
        i = 5;
      } else {
        i = 4;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */