package l.a.b.a.c.z0;

import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.c.b;
import l.a.b.a.c.k0;
import l.a.b.a.c.r;
import l.a.b.a.c.r0;
import l.a.b.a.c.x;
import l.a.b.a.c.y;
import l.a.b.a.c.y0;

public class o
  implements l.a.b.a.c.a<l.a.b.a.b.k.e>, y<l.a.b.a.b.k.e>
{
  public static final Object[] b = { i.a(117L), f.a("amqp:data:binary") };
  public final e a;
  
  public o(x paramx)
  {
    a = new e(paramx);
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.k.e)paramObject;
    return a.a(paramObject);
  }
  
  public Class<l.a.b.a.b.k.e> b()
  {
    if (a != null) {
      return l.a.b.a.b.k.e.class;
    }
    throw null;
  }
  
  public void c(Object paramObject)
  {
    l.a.b.a.b.k.e locale = (l.a.b.a.b.k.e)paramObject;
    paramObject = a.b.a;
    ((y0)paramObject).a((byte)0);
    ((y0)paramObject).a((byte)83);
    ((y0)paramObject).a((byte)117);
    a.b.a(a);
  }
  
  public r0<l.a.b.a.b.k.e> e()
  {
    if (a != null) {
      return null;
    }
    throw null;
  }
  
  public Object i()
  {
    Object localObject1 = a.a.a;
    int i = ((k0)localObject1).get();
    if (i != -96)
    {
      if (i != -80)
      {
        if (i == 64)
        {
          localObject1 = new l.a.b.a.b.k.e(null);
          break label123;
        }
        throw new l.a.b.a.a(e.a.a.a.a.a("Expected Binary type but found encoding: ", i));
      }
      i = ((k0)localObject1).h();
    }
    else
    {
      i = ((k0)localObject1).get() & 0xFF;
    }
    if (i <= ((k0)localObject1).c())
    {
      localObject2 = new byte[i];
      ((k0)localObject1).a((byte[])localObject2, 0, i);
      localObject1 = new l.a.b.a.b.k.e(new l.a.b.a.b.a((byte[])localObject2));
      label123:
      return localObject1;
    }
    Object localObject2 = e.a.a.a.a.a("Binary data size ", i, " is specified to be greater than the amount of data available (");
    ((StringBuilder)localObject2).append(((k0)localObject1).c());
    ((StringBuilder)localObject2).append(")");
    throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
  }
  
  public boolean j()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */