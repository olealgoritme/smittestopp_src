package l.a.b.a.c;

import java.util.HashMap;
import java.util.Map;
import l.a.b.a.b.e;

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
  
  public r0<e> a(e parame)
  {
    r0 localr01 = a.a(parame.b()).a(parame.b());
    r0 localr02 = (r0)b.get(localr01);
    parame = localr02;
    if (localr02 == null)
    {
      parame = new a(localr01);
      b.put(localr01, parame);
    }
    return parame;
  }
  
  public Class<e> b()
  {
    return e.class;
  }
  
  public void c(Object paramObject)
  {
    e locale = (e)paramObject;
    paramObject = a(locale);
    ((r0)paramObject).c();
    ((r0)paramObject).b(locale);
  }
  
  public r0<e> e()
  {
    return null;
  }
  
  public class a
    implements r0
  {
    public final r0 a;
    public final r0 b;
    public final int c;
    
    public a(r0 paramr0)
    {
      a = paramr0;
      paramr0 = a.a(c).a(c);
      b = paramr0;
      int i = paramr0.d();
      int j = b.a(c);
      c = (a.d() + (j + (i + 1)));
    }
    
    public int a(Object paramObject)
    {
      return a.a(((e)paramObject).b());
    }
    
    public boolean a(r0 paramr0)
    {
      boolean bool;
      if ((v.this == paramr0.getType()) && (a.a(a))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      a.b(((e)paramObject).b());
    }
    
    public void c()
    {
      a.a.a((byte)0);
      b.c();
      b.b(c);
      a.c();
    }
    
    public int d()
    {
      return c;
    }
    
    public boolean e()
    {
      return a.e();
    }
    
    public a getType()
    {
      return v.this;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */