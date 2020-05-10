package l.a.b.a.c.c1;

import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.g;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.n.n;
import l.a.b.a.b.n.o;
import l.a.b.a.b.n.p;
import l.a.b.a.b.n.r;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class a
  extends b<l.a.b.a.b.n.a, List>
  implements s<l.a.b.a.b.n.a>
{
  public static final Object[] d = { i.a(18L), f.a("amqp:attach:list") };
  public static final i e = i.a(18L);
  
  public a(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.n.a> b()
  {
    return l.a.b.a.b.n.a.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    l.a.b.a.b.n.a locala = new l.a.b.a.b.n.a();
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
        f = ((l.a.b.a.b.n.q)localList.get(5));
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
    throw new l.a.b.a.c.q("The role field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((l.a.b.a.b.n.a)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public l.a.b.a.b.n.a x;
    
    public a(l.a.b.a.b.n.a parama)
    {
      x = parama;
    }
    
    public Object get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException(e.a.a.a.a.a("Unknown index ", paramInt));
      case 13: 
        return x.n;
      case 12: 
        return x.m;
      case 11: 
        return x.l;
      case 10: 
        return x.k;
      case 9: 
        return x.j;
      case 8: 
        return Boolean.valueOf(x.i);
      case 7: 
        return x.h;
      case 6: 
        return x.g;
      case 5: 
        return x.f;
      case 4: 
        return x.e.getValue();
      case 3: 
        return x.d.getValue();
      case 2: 
        return Boolean.valueOf(x.c.getValue());
      case 1: 
        return x.b;
      }
      return x.a;
    }
    
    public int size()
    {
      Object localObject = x;
      int i;
      if (n != null)
      {
        i = 14;
      }
      else if (m != null)
      {
        i = 13;
      }
      else if (l != null)
      {
        i = 12;
      }
      else if (k != null)
      {
        i = 11;
      }
      else if (j != null)
      {
        i = 10;
      }
      else if (i)
      {
        i = 9;
      }
      else if (h != null)
      {
        i = 8;
      }
      else if (g != null)
      {
        i = 7;
      }
      else if (f != null)
      {
        i = 6;
      }
      else
      {
        localObject = e;
        if ((localObject != null) && (!((Enum)localObject).equals(n.FIRST)))
        {
          i = 5;
        }
        else
        {
          localObject = x.d;
          if ((localObject != null) && (!((Enum)localObject).equals(p.MIXED))) {
            i = 4;
          } else {
            i = 3;
          }
        }
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */