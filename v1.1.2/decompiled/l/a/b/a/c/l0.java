package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class l0
  extends c<Short>
{
  public a a;
  
  public l0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(Short.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (Short)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (Short)paramObject;
    return a;
  }
  
  public Class<Short> b()
  {
    return Short.class;
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
    extends z<Short>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<Short> paramr0)
    {
      boolean bool;
      if (l0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Short)paramObject;
      x localx = a;
      short s = ((Short)paramObject).shortValue();
      a.a(s);
    }
    
    public byte f()
    {
      return 97;
    }
    
    public a getType()
    {
      return l0.this;
    }
    
    public i0 getType()
    {
      return l0.this;
    }
    
    public Object i()
    {
      return Short.valueOf(b.a.g());
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 2;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.l0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */