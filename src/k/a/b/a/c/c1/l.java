package k.a.b.a.c.c1;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.j;
import k.a.b.a.b.n.m;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

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
  
  public Class<m> a()
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
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new l.a((m)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */