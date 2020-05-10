package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public final class h
  extends c<Boolean>
{
  public b a;
  public b b;
  public b c;
  
  public h(x paramx, r paramr)
  {
    a = new d(paramx, paramr);
    b = new c(paramx, paramr);
    c = new a(paramx, paramr);
    c.put(Boolean.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    if (((Boolean)paramObject).booleanValue()) {
      paramObject = a;
    } else {
      paramObject = b;
    }
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    if (((Boolean)paramObject).booleanValue()) {
      paramObject = a;
    } else {
      paramObject = b;
    }
    return (r0)paramObject;
  }
  
  public Class<Boolean> b()
  {
    return Boolean.class;
  }
  
  public r0 e()
  {
    return c;
  }
  
  public Collection<b> k()
  {
    return Arrays.asList(new b[] { a, b, c });
  }
  
  public class a
    extends z<Boolean>
    implements h.b
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(boolean paramBoolean)
    {
      a.a.a(paramBoolean);
    }
    
    public boolean a()
    {
      boolean bool;
      if (b.e() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean a(r0<Boolean> paramr0)
    {
      boolean bool;
      if (h.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Boolean)paramObject;
      x localx = a;
      int i = ((Boolean)paramObject).booleanValue();
      a.a(i);
    }
    
    public byte f()
    {
      return 86;
    }
    
    public a getType()
    {
      return h.this;
    }
    
    public i0 getType()
    {
      return h.this;
    }
    
    public Object i()
    {
      int i;
      if (b.e() != 0) {
        i = 1;
      } else {
        i = 0;
      }
      Boolean localBoolean;
      if (i != 0) {
        localBoolean = Boolean.TRUE;
      } else {
        localBoolean = Boolean.FALSE;
      }
      return localBoolean;
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
  
  public static abstract interface b
    extends j0<Boolean>
  {
    public abstract void a(boolean paramBoolean);
    
    public abstract boolean a();
  }
  
  public class c
    extends z<Boolean>
    implements h.b
  {
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(boolean paramBoolean) {}
    
    public boolean a()
    {
      return false;
    }
    
    public boolean a(r0<Boolean> paramr0)
    {
      boolean bool;
      if (paramr0 == this) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Boolean)paramObject;
    }
    
    public byte f()
    {
      return 66;
    }
    
    public a getType()
    {
      return h.this;
    }
    
    public i0 getType()
    {
      return h.this;
    }
    
    public Object i()
    {
      return Boolean.FALSE;
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 0;
    }
  }
  
  public class d
    extends z<Boolean>
    implements h.b
  {
    public d(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(boolean paramBoolean) {}
    
    public boolean a()
    {
      return true;
    }
    
    public boolean a(r0<Boolean> paramr0)
    {
      boolean bool;
      if (paramr0 == this) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Boolean)paramObject;
    }
    
    public byte f()
    {
      return 65;
    }
    
    public a getType()
    {
      return h.this;
    }
    
    public i0 getType()
    {
      return h.this;
    }
    
    public Object i()
    {
      return Boolean.TRUE;
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 0;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */