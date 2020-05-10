package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import l.a.b.a.b.j;

public class w0
  extends c<j>
{
  public a a;
  
  public w0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(j.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (j)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (j)paramObject;
    return a;
  }
  
  public Class<j> b()
  {
    return j.class;
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
    extends z<j>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<j> paramr0)
    {
      boolean bool;
      if (w0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      j localj = (j)paramObject;
      paramObject = a;
      short s = x;
      a.a(s);
    }
    
    public byte f()
    {
      return 96;
    }
    
    public a getType()
    {
      return w0.this;
    }
    
    public i0 getType()
    {
      return w0.this;
    }
    
    public Object i()
    {
      return j.a(b.a.g());
    }
    
    public int k()
    {
      return 2;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.w0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */