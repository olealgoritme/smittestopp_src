package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class g
  extends c<l.a.b.a.b.a>
{
  public final a a;
  public final a b;
  
  public g(x paramx, r paramr)
  {
    a = new b(paramx, paramr);
    b = new c(paramx, paramr);
    c.put(l.a.b.a.b.a.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    if (c <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    if (c <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (r0)paramObject;
  }
  
  public Class<l.a.b.a.b.a> b()
  {
    return l.a.b.a.b.a.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<a> k()
  {
    return Arrays.asList(new a[] { b, a });
  }
  
  public static abstract interface a
    extends j0<l.a.b.a.b.a>
  {}
  
  public class b
    extends d0<l.a.b.a.b.a>
    implements g.a
  {
    public b(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<l.a.b.a.b.a> paramr0)
    {
      boolean bool;
      if (g.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int c(Object paramObject)
    {
      return c;
    }
    
    public void d(Object paramObject)
    {
      paramObject = (l.a.b.a.b.a)paramObject;
      a.a.b(c);
      x localx = a;
      byte[] arrayOfByte = a;
      int i = b;
      int j = c;
      a.a(arrayOfByte, i, j);
    }
    
    public byte f()
    {
      return -80;
    }
    
    public a getType()
    {
      return g.this;
    }
    
    public i0 getType()
    {
      return g.this;
    }
    
    public Object i()
    {
      r localr = b;
      int i = localr.f();
      if (i <= localr.a())
      {
        localObject = new byte[i];
        a.a((byte[])localObject, 0, i);
        return new l.a.b.a.b.a((byte[])localObject);
      }
      Object localObject = e.a.a.a.a.a("Binary data size ", i, " is specified to be greater than the amount of data available (");
      ((StringBuilder)localObject).append(localr.a());
      ((StringBuilder)localObject).append(")");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  public class c
    extends m0<l.a.b.a.b.a>
    implements g.a
  {
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<l.a.b.a.b.a> paramr0)
    {
      boolean bool;
      if (paramr0 == this) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int c(Object paramObject)
    {
      return c;
    }
    
    public void d(Object paramObject)
    {
      l.a.b.a.b.a locala = (l.a.b.a.b.a)paramObject;
      a.a.b(c);
      paramObject = a;
      byte[] arrayOfByte = a;
      int i = b;
      int j = c;
      a.a(arrayOfByte, i, j);
    }
    
    public byte f()
    {
      return -96;
    }
    
    public a getType()
    {
      return g.this;
    }
    
    public i0 getType()
    {
      return g.this;
    }
    
    public Object i()
    {
      int i = b.e() & 0xFF;
      byte[] arrayOfByte = new byte[i];
      b.a.a(arrayOfByte, 0, i);
      return new l.a.b.a.b.a(arrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */