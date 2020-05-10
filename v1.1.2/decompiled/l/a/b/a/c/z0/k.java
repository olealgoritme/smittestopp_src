package l.a.b.a.c.z0;

import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.c.b;
import l.a.b.a.c.k0;
import l.a.b.a.c.q;
import l.a.b.a.c.r;
import l.a.b.a.c.r0;
import l.a.b.a.c.x;
import l.a.b.a.c.y;
import l.a.b.a.c.y0;

public class k
  implements l.a.b.a.c.a<l.a.b.a.b.k.a>, y<l.a.b.a.b.k.a>
{
  public static final Object[] b = { i.a(36L), f.a("amqp:accepted:list") };
  public static final byte[] c = { 0, 83, 36, 69 };
  public final a a;
  
  public k(x paramx)
  {
    a = new a(paramx);
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.k.a)paramObject;
    return a.a(paramObject);
  }
  
  public Class<l.a.b.a.b.k.a> b()
  {
    return l.a.b.a.b.k.a.class;
  }
  
  public void c(Object paramObject)
  {
    paramObject = (l.a.b.a.b.k.a)paramObject;
    y0 localy0 = a.b.a;
    paramObject = c;
    localy0.a((byte[])paramObject, 0, paramObject.length);
  }
  
  public r0<l.a.b.a.b.k.a> e()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object i()
  {
    r localr = a.a;
    int i = a.get();
    if (i != -64)
    {
      if (i != -48)
      {
        if (i != 69) {
          throw new q(e.a.a.a.a.a("Incorrect type found in Accepted type encoding: ", i));
        }
      }
      else
      {
        a.h();
        a.h();
      }
    }
    else
    {
      a.get();
      a.get();
    }
    return l.a.b.a.b.k.a.a;
  }
  
  public boolean j()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */