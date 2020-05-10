package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class o
  extends c<l.a.b.a.b.c>
{
  public a a;
  
  public o(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(l.a.b.a.b.c.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.c)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (l.a.b.a.b.c)paramObject;
    return a;
  }
  
  public Class<l.a.b.a.b.c> b()
  {
    return l.a.b.a.b.c.class;
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
    extends z<l.a.b.a.b.c>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<l.a.b.a.b.c> paramr0)
    {
      boolean bool;
      if (o.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (l.a.b.a.b.c)paramObject;
      x localx = a;
      int i = y;
      a.c(i);
    }
    
    public byte f()
    {
      return 116;
    }
    
    public a getType()
    {
      return o.this;
    }
    
    public i0 getType()
    {
      return o.this;
    }
    
    public Object i()
    {
      return new l.a.b.a.b.c(b.f());
    }
    
    public int k()
    {
      return 4;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */