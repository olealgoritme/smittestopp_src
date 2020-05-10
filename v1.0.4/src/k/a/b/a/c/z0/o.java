package k.a.b.a.c.z0;

import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.c.b;
import k.a.b.a.c.k0;
import k.a.b.a.c.r;
import k.a.b.a.c.r0;
import k.a.b.a.c.x;
import k.a.b.a.c.y;
import k.a.b.a.c.y0;

public class o
  implements k.a.b.a.c.a<k.a.b.a.b.k.e>, y<k.a.b.a.b.k.e>
{
  public static final Object[] b = { i.a(117L), f.a("amqp:data:binary") };
  public final e a;
  
  public o(x paramx)
  {
    a = new e(paramx);
  }
  
  public Class<k.a.b.a.b.k.e> a()
  {
    if (a != null) {
      return k.a.b.a.b.k.e.class;
    }
    throw null;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (k.a.b.a.b.k.e)paramObject;
    return a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    k.a.b.a.b.k.e locale = (k.a.b.a.b.k.e)paramObject;
    paramObject = a.b.a;
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)117);
    a.b.a(a);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public r0<k.a.b.a.b.k.e> f()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object k()
  {
    Object localObject1 = a.a.a;
    int i = ((k0)localObject1).get();
    if (i != -96)
    {
      if (i != -80)
      {
        if (i == 64)
        {
          localObject1 = new k.a.b.a.b.k.e(null);
          break label123;
        }
        throw new k.a.b.a.a(e.a.a.a.a.a("Expected Binary type but found encoding: ", i));
      }
      i = ((k0)localObject1).d();
    }
    else
    {
      i = ((k0)localObject1).get() & 0xFF;
    }
    if (i <= ((k0)localObject1).c())
    {
      localObject2 = new byte[i];
      ((k0)localObject1).a((byte[])localObject2, 0, i);
      localObject1 = new k.a.b.a.b.k.e(new k.a.b.a.b.a((byte[])localObject2));
      label123:
      return localObject1;
    }
    Object localObject2 = e.a.a.a.a.a("Binary data size ", i, " is specified to be greater than the amount of data available (");
    ((StringBuilder)localObject2).append(((k0)localObject1).c());
    ((StringBuilder)localObject2).append(")");
    throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */