package l.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class k
  extends c<Character>
{
  public a a;
  
  public k(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    c.put(Character.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (Character)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (Character)paramObject;
    return a;
  }
  
  public Class<Character> b()
  {
    return Character.class;
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
    extends z<Character>
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<Character> paramr0)
    {
      boolean bool;
      if (k.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Character)paramObject;
      x localx = a;
      int i = ((Character)paramObject).charValue();
      a.c(i & 0xFFFF);
    }
    
    public byte f()
    {
      return 115;
    }
    
    public a getType()
    {
      return k.this;
    }
    
    public i0 getType()
    {
      return k.this;
    }
    
    public Object i()
    {
      return Character.valueOf((char)(b.f() & 0xFFFF));
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
 * Qualified Name:     l.a.b.a.c.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */