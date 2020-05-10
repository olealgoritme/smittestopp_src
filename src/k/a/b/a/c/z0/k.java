package k.a.b.a.c.z0;

import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.k0;
import k.a.b.a.c.q;
import k.a.b.a.c.r;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y;
import k.a.b.a.c.y0;

public class k
  implements k.a.b.a.c.a<k.a.b.a.b.k.a>, y<k.a.b.a.b.k.a>
{
  public static final Object[] b = { i.a(36L), f.a("amqp:accepted:list") };
  public static final byte[] c = { 0, 83, 36, 69 };
  public final a a;
  
  public k(x paramx)
  {
    a = new a(paramx);
  }
  
  public Class<k.a.b.a.b.k.a> a()
  {
    return k.a.b.a.b.k.a.class;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (k.a.b.a.b.k.a)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    paramObject = (k.a.b.a.b.k.a)paramObject;
    paramObject = a.b.a;
    byte[] arrayOfByte = c;
    ((y0)paramObject).a(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public r0<k.a.b.a.b.k.a> f()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object k()
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
        a.d();
        a.d();
      }
    }
    else
    {
      a.get();
      a.get();
    }
    return k.a.b.a.b.k.a.a;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */