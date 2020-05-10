package k.a.b.a.c.z0;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.k.v;
import k.a.b.a.b.k.y;
import k.a.b.a.c.b;
import k.a.b.a.c.s;

public class d0
  extends b<v, List>
  implements s<v>
{
  public static final Object[] d = { i.a(41L), f.a("amqp:target:list") };
  public static final i e = i.a(41L);
  
  public d0(k.a.b.a.c.x paramx)
  {
    super(paramx);
  }
  
  public Class<v> a()
  {
    return v.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    v localv = new v();
    Object localObject;
    switch (7 - localList.size())
    {
    default: 
      break;
    case 0: 
      paramObject = localList.get(6);
      if ((paramObject != null) && (!paramObject.getClass().isArray())) {
        g = new f[] { (f)paramObject };
      } else {
        g = ((f[])paramObject);
      }
    case 1: 
      f = ((Map)localList.get(5));
    case 2: 
      paramObject = (Boolean)localList.get(4);
      boolean bool;
      if (paramObject == null) {
        bool = false;
      } else {
        bool = ((Boolean)paramObject).booleanValue();
      }
      e = bool;
    case 3: 
      localObject = (h)localList.get(3);
      paramObject = localObject;
      if (localObject == null) {
        paramObject = h.z;
      }
      d = ((h)paramObject);
    case 4: 
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
    case 5: 
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
    return localv;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new d0.a((v)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.d0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */