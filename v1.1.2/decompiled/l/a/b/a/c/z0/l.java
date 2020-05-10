package l.a.b.a.c.z0;

import java.util.Collections;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.c.k0;
import l.a.b.a.c.q0;
import l.a.b.a.c.r;
import l.a.b.a.c.r0;
import l.a.b.a.c.x;
import l.a.b.a.c.y;
import l.a.b.a.c.y0;

public class l
  implements l.a.b.a.c.a<l.a.b.a.b.k.b>, y<l.a.b.a.b.k.b>
{
  public static final Object[] b = { i.a(118L), f.a("amqp:amqp-sequence:list") };
  public final b a;
  
  public l(x paramx)
  {
    a = new b(paramx);
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.k.b)paramObject;
    return a.a(paramObject);
  }
  
  public Class<l.a.b.a.b.k.b> b()
  {
    return l.a.b.a.b.k.b.class;
  }
  
  public void c(Object paramObject)
  {
    l.a.b.a.b.k.b localb = (l.a.b.a.b.k.b)paramObject;
    paramObject = a.b.a;
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)118);
    a.b.b(a);
  }
  
  public r0<l.a.b.a.b.k.b> e()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object i()
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
            throw new l.a.b.a.a(e.a.a.a.a.a("Expected List type but found encoding: ", i));
          }
        }
        else {
          localObject = null;
        }
      }
      else {
        localObject = (List)c['Ð'].i();
      }
    }
    else {
      localObject = (List)c['À'].i();
    }
    return new l.a.b.a.b.k.b((List)localObject);
  }
  
  public boolean j()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */