package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class s0
  extends c<UUID>
{
  public a a;
  
  public s0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(UUID.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (UUID)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (UUID)paramObject;
    return a;
  }
  
  public Class<UUID> b()
  {
    return UUID.class;
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
    extends z<UUID>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<UUID> paramr0)
    {
      boolean bool;
      if (s0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (UUID)paramObject;
      x localx = a;
      long l = ((UUID)paramObject).getMostSignificantBits();
      a.a(l);
      localx = a;
      l = ((UUID)paramObject).getLeastSignificantBits();
      a.a(l);
    }
    
    public byte f()
    {
      return -104;
    }
    
    public a getType()
    {
      return s0.this;
    }
    
    public i0 getType()
    {
      return s0.this;
    }
    
    public Object i()
    {
      return new UUID(b.g(), b.g());
    }
    
    public int k()
    {
      return 16;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.s0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */