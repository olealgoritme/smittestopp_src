package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class p0
  extends c<Date>
{
  public a a;
  
  public p0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(Date.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (Date)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (Date)paramObject;
    return a;
  }
  
  public Class<Date> b()
  {
    return Date.class;
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
    extends z<Date>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<Date> paramr0)
    {
      boolean bool;
      if (p0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Date)paramObject;
      x localx = a;
      long l = ((Date)paramObject).getTime();
      a.a(l);
    }
    
    public byte f()
    {
      return -125;
    }
    
    public a getType()
    {
      return p0.this;
    }
    
    public i0 getType()
    {
      return p0.this;
    }
    
    public Object i()
    {
      return new Date(b.g());
    }
    
    public int k()
    {
      return 8;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.p0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */