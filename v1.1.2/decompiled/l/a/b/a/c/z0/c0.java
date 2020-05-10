package l.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.k.o;
import l.a.b.a.b.k.u;
import l.a.b.a.b.k.w;
import l.a.b.a.b.k.y;
import l.a.b.a.c.b;
import l.a.b.a.c.s;

public class c0
  extends b<u, List>
  implements s<u>
{
  public static final Object[] d = { i.a(40L), f.a("amqp:source:list") };
  public static final i e = i.a(40L);
  
  public c0(l.a.b.a.c.x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<u> b()
  {
    return u.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    u localu = new u();
    Object localObject;
    switch (11 - localList.size())
    {
    default: 
      break;
    case 0: 
      paramObject = localList.get(10);
      if ((paramObject != null) && (!paramObject.getClass().isArray())) {
        g = new f[] { (f)paramObject };
      } else {
        g = ((f[])paramObject);
      }
    case 1: 
      paramObject = localList.get(9);
      if ((paramObject != null) && (!paramObject.getClass().isArray())) {
        k = new f[] { (f)paramObject };
      } else {
        k = ((f[])paramObject);
      }
    case 2: 
      j = ((o)localList.get(8));
    case 3: 
      i = ((Map)localList.get(7));
    case 4: 
      h = ((f)localList.get(6));
    case 5: 
      f = ((Map)localList.get(5));
    case 6: 
      paramObject = (Boolean)localList.get(4);
      boolean bool;
      if (paramObject == null) {
        bool = false;
      } else {
        bool = ((Boolean)paramObject).booleanValue();
      }
      e = bool;
    case 7: 
      localObject = (h)localList.get(3);
      paramObject = localObject;
      if (localObject == null) {
        paramObject = h.z;
      }
      d = ((h)paramObject);
    case 8: 
      paramObject = (f)localList.get(2);
      if (paramObject == null) {
        paramObject = y.SESSION_END;
      } else {
        paramObject = y.valueOf((f)paramObject);
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = y.SESSION_END;
      }
      c = ((y)localObject);
    case 9: 
      paramObject = (h)localList.get(1);
      if (paramObject == null) {
        paramObject = l.a.b.a.b.k.x.NONE;
      } else {
        paramObject = l.a.b.a.b.k.x.get((h)paramObject);
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = l.a.b.a.b.k.x.NONE;
      }
      b = ((l.a.b.a.b.k.x)localObject);
    }
    a = ((String)localList.get(0));
    return localu;
  }
  
  public Object d(Object paramObject)
  {
    return new a((u)paramObject);
  }
  
  public static final class a
    extends AbstractList
  {
    public final u x;
    
    public a(u paramu)
    {
      x = paramu;
    }
    
    public Object get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException(a.a("Unknown index ", paramInt));
      case 10: 
        return x.g;
      case 9: 
        return x.k;
      case 8: 
        return x.j;
      case 7: 
        return x.i;
      case 6: 
        return x.h;
      case 5: 
        return x.f;
      case 4: 
        return Boolean.valueOf(x.e);
      case 3: 
        return x.d;
      case 2: 
        return x.c.getPolicy();
      case 1: 
        return x.b.getValue();
      }
      return x.a;
    }
    
    public int size()
    {
      Object localObject = x;
      int i;
      if (g != null)
      {
        i = 11;
      }
      else if (k != null)
      {
        i = 10;
      }
      else if (j != null)
      {
        i = 9;
      }
      else if (i != null)
      {
        i = 8;
      }
      else if (h != null)
      {
        i = 7;
      }
      else if (f != null)
      {
        i = 6;
      }
      else if (e)
      {
        i = 5;
      }
      else
      {
        localObject = d;
        if ((localObject != null) && (!((h)localObject).equals(h.z)))
        {
          i = 4;
        }
        else
        {
          localObject = x;
          if (c != y.SESSION_END) {
            i = 3;
          } else if (b != l.a.b.a.b.k.x.NONE) {
            i = 2;
          } else if (a != null) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */