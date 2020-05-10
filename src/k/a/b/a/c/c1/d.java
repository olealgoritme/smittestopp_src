package k.a.b.a.c.c1;

import java.util.List;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.n.j;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class d
  extends b<k.a.b.a.b.n.f, List>
  implements s<k.a.b.a.b.n.f>
{
  public static final Object[] d = { i.a(22L), k.a.b.a.b.f.a("amqp:detach:list") };
  public static final i e = i.a(22L);
  
  public d(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.n.f> a()
  {
    return k.a.b.a.b.n.f.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new k.a.b.a.b.n.f();
    if (!((List)localObject).isEmpty())
    {
      int i = 3 - ((List)localObject).size();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            break label98;
          }
          break label118;
        }
      }
      else {
        c = ((j)((List)localObject).get(2));
      }
      Boolean localBoolean = (Boolean)((List)localObject).get(1);
      boolean bool;
      if (localBoolean == null) {
        bool = false;
      } else {
        bool = localBoolean.booleanValue();
      }
      b = bool;
      label98:
      localObject = (h)((List)localObject).get(0);
      if (localObject != null)
      {
        a = ((h)localObject);
        label118:
        return paramObject;
      }
      throw new NullPointerException("the handle field is mandatory");
    }
    throw new q("The handle field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new d.a((k.a.b.a.b.n.f)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */