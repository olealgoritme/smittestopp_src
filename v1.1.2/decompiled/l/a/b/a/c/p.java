package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class p
  extends c<l.a.b.a.b.d>
{
  public a a;
  
  public p(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(l.a.b.a.b.d.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.d)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.d)paramObject;
    return a;
  }
  
  public Class<l.a.b.a.b.d> b()
  {
    return l.a.b.a.b.d.class;
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
    extends z<l.a.b.a.b.d>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<l.a.b.a.b.d> paramr0)
    {
      boolean bool;
      if (p.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      l.a.b.a.b.d locald = (l.a.b.a.b.d)paramObject;
      paramObject = a;
      long l = y;
      a.a(l);
    }
    
    public byte f()
    {
      return -124;
    }
    
    public a getType()
    {
      return p.this;
    }
    
    public i0 getType()
    {
      return p.this;
    }
    
    public Object i()
    {
      return new l.a.b.a.b.d(b.g());
    }
    
    public int k()
    {
      return 8;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */