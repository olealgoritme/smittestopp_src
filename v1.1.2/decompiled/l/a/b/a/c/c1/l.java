package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.j;
import l.a.b.a.b.n.m;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class l
  extends b<m, List>
  implements s<m>
{
  public static final Object[] d = { i.a(16L), f.a("amqp:open:list") };
  public static final i e = i.a(16L);
  
  public l(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<m> b()
  {
    return m.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    m localm = new m();
    if (!localList.isEmpty())
    {
      Object localObject;
      switch (10 - localList.size())
      {
      default: 
        break;
      case 0: 
        j = ((Map)localList.get(9));
      case 1: 
        paramObject = localList.get(8);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          i = new f[] { (f)paramObject };
        } else {
          i = ((f[])paramObject);
        }
      case 2: 
        paramObject = localList.get(7);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          h = new f[] { (f)paramObject };
        } else {
          h = ((f[])paramObject);
        }
      case 3: 
        paramObject = localList.get(6);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          g = new f[] { (f)paramObject };
        } else {
          g = ((f[])paramObject);
        }
      case 4: 
        paramObject = localList.get(5);
        if ((paramObject != null) && (!paramObject.getClass().isArray())) {
          f = new f[] { (f)paramObject };
        } else {
          f = ((f[])paramObject);
        }
      case 5: 
        e = ((h)localList.get(4));
      case 6: 
        localObject = (j)localList.get(3);
        paramObject = localObject;
        if (localObject == null) {
          paramObject = j.z;
        }
        d = ((j)paramObject);
      case 7: 
        localObject = (h)localList.get(2);
        paramObject = localObject;
        if (localObject == null) {
          paramObject = h.B;
        }
        c = ((h)paramObject);
      case 8: 
        b = ((String)localList.get(1));
      }
      localm.a((String)localList.get(0));
      return localm;
    }
    throw new q("The container-id field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((m)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public m x;
    
    public a(m paramm)
    {
      x = paramm;
    }
    
    public Object get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException(a.a("Unknown index ", paramInt));
      case 9: 
        return x.j;
      case 8: 
        return x.i;
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
      Object localObject = x;
      int i;
      if (j != null)
      {
        i = 10;
      }
      else if (i != null)
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
      else if (e != null)
      {
        i = 5;
      }
      else
      {
        localObject = d;
        if ((localObject != null) && (!((j)localObject).equals(j.z)))
        {
          i = 4;
        }
        else
        {
          localObject = x.c;
          if ((localObject != null) && (!((h)localObject).equals(h.B))) {
            i = 3;
          } else if (x.b != null) {
            i = 2;
          } else {
            i = 1;
          }
        }
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */