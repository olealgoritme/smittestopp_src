package l.a.b.a.c.c1;

import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.g;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.n.e;
import l.a.b.a.b.n.n;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.x;

public final class m
  extends b<l.a.b.a.b.n.s, List>
  implements l.a.b.a.c.s<l.a.b.a.b.n.s>
{
  public static final Object[] d = { i.a(20L), f.a("amqp:transfer:list") };
  public static final i e = i.a(20L);
  
  public m(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.n.s> b()
  {
    return l.a.b.a.b.n.s.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    l.a.b.a.b.n.s locals = new l.a.b.a.b.n.s();
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
        c = ((l.a.b.a.b.a)localList.get(2));
      case 9: 
        b = ((h)localList.get(1));
      case 10: 
        locals.a((h)localList.get(0));
      }
      return locals;
    }
    throw new q("The handle field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((l.a.b.a.b.n.s)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public l.a.b.a.b.n.s x;
    
    public a(l.a.b.a.b.n.s params)
    {
      x = params;
    }
    
    public Object get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException(e.a.a.a.a.a("Unknown index ", paramInt));
      case 10: 
        return Boolean.valueOf(x.k);
      case 9: 
        return Boolean.valueOf(x.j);
      case 8: 
        return Boolean.valueOf(x.i);
      case 7: 
        return x.h;
      case 6: 
        Object localObject = x.g;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((n)localObject).getValue();
        }
        return localObject;
      case 5: 
        return Boolean.valueOf(x.f);
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
      l.a.b.a.b.n.s locals = x;
      int i;
      if (k) {
        i = 11;
      } else if (j) {
        i = 10;
      } else if (i) {
        i = 9;
      } else if (h != null) {
        i = 8;
      } else if (g != null) {
        i = 7;
      } else if (f) {
        i = 6;
      } else if (e != null) {
        i = 5;
      } else if (d != null) {
        i = 4;
      } else if (c != null) {
        i = 3;
      } else if (b != null) {
        i = 2;
      } else {
        i = 1;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */