package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class j
  extends c<Byte>
{
  public a a;
  
  public j(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(Byte.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (Byte)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (Byte)paramObject;
    return a;
  }
  
  public Class<Byte> b()
  {
    return Byte.class;
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
    extends z<Byte>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<Byte> paramr0)
    {
      boolean bool;
      if (j.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Byte)paramObject;
      x localx = a;
      byte b = ((Byte)paramObject).byteValue();
      a.a(b);
    }
    
    public byte f()
    {
      return 81;
    }
    
    public a getType()
    {
      return j.this;
    }
    
    public i0 getType()
    {
      return j.this;
    }
    
    public Object i()
    {
      return Byte.valueOf(b.e());
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 1;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */