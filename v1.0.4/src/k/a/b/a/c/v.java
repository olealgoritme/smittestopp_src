package k.a.b.a.c;

import java.util.HashMap;
import java.util.Map;
import k.a.b.a.b.e;

public class v
  implements a<e>
{
  public final x a;
  public final Map<r0, r0> b = new HashMap();
  public final Object c;
  
  public v(x paramx, Object paramObject)
  {
    a = paramx;
    c = paramObject;
  }
  
  public Class<e> a()
  {
    return e.class;
  }
  
  public r0<e> a(e parame)
  {
    r0 localr01 = a.a(parame.b()).a(parame.b());
    r0 localr02 = (r0)b.get(localr01);
    parame = localr02;
    if (localr02 == null)
    {
      parame = new v.a(this, localr01);
      b.put(localr01, parame);
    }
    return parame;
  }
  
  public void c(Object paramObject)
  {
    paramObject = (e)paramObject;
    r0 localr0 = a((e)paramObject);
    localr0.c();
    localr0.a(paramObject);
  }
  
  public r0<e> f()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */