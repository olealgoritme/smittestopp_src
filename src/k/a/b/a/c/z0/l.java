package k.a.b.a.c.z0;

import java.util.Collections;
import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.k0;
import k.a.b.a.c.q0;
import k.a.b.a.c.r;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y;
import k.a.b.a.c.y0;

public class l
  implements k.a.b.a.c.a<k.a.b.a.b.k.b>, y<k.a.b.a.b.k.b>
{
  public static final Object[] b = { i.a(118L), f.a("amqp:amqp-sequence:list") };
  public final b a;
  
  public l(x paramx)
  {
    a = new b(paramx);
  }
  
  public Class<k.a.b.a.b.k.b> a()
  {
    return k.a.b.a.b.k.b.class;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (k.a.b.a.b.k.b)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    paramObject = (k.a.b.a.b.k.b)paramObject;
    y0 localy0 = a.b.a;
    localy0.a((byte)0);
    localy0.a((byte)83);
    localy0.a((byte)118);
    a.b.b(a);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public r0<k.a.b.a.b.k.b> f()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object k()
  {
    Object localObject = a.a;
    int i = a.get();
    if (i != -64)
    {
      if (i != -48)
      {
        if (i != 64)
        {
          if (i == 69) {
            localObject = Collections.EMPTY_LIST;
          } else {
            throw new k.a.b.a.a(e.a.a.a.a.a("Expected List type but found encoding: ", i));
          }
        }
        else {
          localObject = null;
        }
      }
      else {
        localObject = (List)c['Ð'].k();
      }
    }
    else {
      localObject = (List)c['À'].k();
    }
    return new k.a.b.a.b.k.b((List)localObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */