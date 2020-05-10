package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import l.a.b.a.b.g;

public class t0
  extends c<g>
{
  public a a;
  
  public t0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(g.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (g)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (g)paramObject;
    return a;
  }
  
  public Class<g> b()
  {
    return g.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<a> k()
  {
    return Collections.singleton(a);
  }
  
  public class a
    extends z<g>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<g> paramr0)
    {
      boolean bool;
      if (t0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (g)paramObject;
      x localx = a;
      byte b = x;
      a.a(b);
    }
    
    public byte f()
    {
      return 80;
    }
    
    public a getType()
    {
      return t0.this;
    }
    
    public i0 getType()
    {
      return t0.this;
    }
    
    public Object i()
    {
      return g.a(b.e());
    }
    
    public int k()
    {
      return 1;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.t0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */