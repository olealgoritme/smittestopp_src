package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.j;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class b
  extends l.a.b.a.c.b<l.a.b.a.b.n.b, List>
  implements s<l.a.b.a.b.n.b>
{
  public static final Object[] d = { i.a(17L), f.a("amqp:begin:list") };
  public static final i e = i.a(17L);
  
  public b(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.n.b> b()
  {
    return l.a.b.a.b.n.b.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    l.a.b.a.b.n.b localb = new l.a.b.a.b.n.b();
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
  
  public Object d(Object paramObject)
  {
    return new a((l.a.b.a.b.n.b)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public l.a.b.a.b.n.b x;
    
    public a(l.a.b.a.b.n.b paramb)
    {
      x = paramb;
    }
    
    public Object get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException(a.a("Unknown index ", paramInt));
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
      if (h != null)
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
        if ((localObject != null) && (!((h)localObject).equals(h.B))) {
          i = 5;
        } else {
          i = 4;
        }
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */