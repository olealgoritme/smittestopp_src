package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class c0
  extends c<Integer>
{
  public b a;
  public b b;
  
  public c0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    b = new c(paramx, paramr);
    c.put(Integer.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    int i = ((Integer)paramObject).intValue();
    if ((i >= -128) && (i <= 127)) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    int i = ((Integer)paramObject).intValue();
    if ((i >= -128) && (i <= 127)) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (r0)paramObject;
  }
  
  public Class<Integer> b()
  {
    return Integer.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<b> k()
  {
    return Arrays.asList(new b[] { a, b });
  }
  
  public class a
    extends z<Integer>
    implements c0.b
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public int a()
    {
      return b.f();
    }
    
    public void a(int paramInt)
    {
      a.a.c(paramInt);
    }
    
    public boolean a(r0<Integer> paramr0)
    {
      boolean bool;
      if (c0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Integer)paramObject;
      x localx = a;
      int i = ((Integer)paramObject).intValue();
      a.c(i);
    }
    
    public byte f()
    {
      return 113;
    }
    
    public a getType()
    {
      return c0.this;
    }
    
    public i0 getType()
    {
      return c0.this;
    }
    
    public Object i()
    {
      return Integer.valueOf(b.f());
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
  
  public static abstract interface b
    extends j0<Integer>
  {
    public abstract int a();
    
    public abstract void a(int paramInt);
  }
  
  public class c
    extends z<Integer>
    implements c0.b
  {
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public int a()
    {
      return b.e();
    }
    
    public void a(int paramInt)
    {
      x localx = a;
      byte b = (byte)paramInt;
      a.a(b);
    }
    
    public boolean a(r0<Integer> paramr0)
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
      paramObject = (Integer)paramObject;
      x localx = a;
      byte b = (byte)((Integer)paramObject).intValue();
      a.a(b);
    }
    
    public byte f()
    {
      return 84;
    }
    
    public a getType()
    {
      return c0.this;
    }
    
    public i0 getType()
    {
      return c0.this;
    }
    
    public Object i()
    {
      return Integer.valueOf(b.e());
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
 * Qualified Name:     l.a.b.a.c.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */