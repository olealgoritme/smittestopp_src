package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class a0
  extends c<Float>
{
  public a a;
  
  public a0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(Float.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (Float)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (Float)paramObject;
    return a;
  }
  
  public Class<Float> b()
  {
    return Float.class;
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
    extends z<Float>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<Float> paramr0)
    {
      boolean bool;
      if (a0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Float)paramObject;
      x localx = a;
      float f = ((Float)paramObject).floatValue();
      a.a(f);
    }
    
    public byte f()
    {
      return 114;
    }
    
    public a getType()
    {
      return a0.this;
    }
    
    public i0 getType()
    {
      return a0.this;
    }
    
    public Object i()
    {
      return Float.valueOf(b.a.e());
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 4;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.a0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */