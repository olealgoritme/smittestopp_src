package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class t
  extends c<Double>
{
  public a a;
  
  public t(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(Double.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (Double)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (Double)paramObject;
    return a;
  }
  
  public Class<Double> b()
  {
    return Double.class;
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
    extends z<Double>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<Double> paramr0)
    {
      boolean bool;
      if (t.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      Double localDouble = (Double)paramObject;
      paramObject = a;
      double d = localDouble.doubleValue();
      a.a(d);
    }
    
    public byte f()
    {
      return -126;
    }
    
    public a getType()
    {
      return t.this;
    }
    
    public i0 getType()
    {
      return t.this;
    }
    
    public Object i()
    {
      return Double.valueOf(b.a.d());
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 8;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */