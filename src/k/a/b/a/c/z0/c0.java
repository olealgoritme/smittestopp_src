package k.a.b.a.c.z0;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.k.o;
import k.a.b.a.b.k.u;
import k.a.b.a.b.k.y;
import k.a.b.a.c.b;
import k.a.b.a.c.s;

public class c0
  extends b<u, List>
  implements s<u>
{
  public static final Object[] d = { i.a(40L), f.a("amqp:source:list") };
  public static final i e = i.a(40L);
  
  public c0(k.a.b.a.c.x paramx)
  {
    super(paramx);
  }
  
  public Class<u> a()
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
        paramObject = k.a.b.a.b.k.x.NONE;
      } else {
        paramObject = k.a.b.a.b.k.x.get((h)paramObject);
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = k.a.b.a.b.k.x.NONE;
      }
      b = ((k.a.b.a.b.k.x)localObject);
    }
    a = ((String)localList.get(0));
    return localu;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new c0.a((u)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */