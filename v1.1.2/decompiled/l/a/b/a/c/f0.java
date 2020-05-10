package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class f0
  extends c<Long>
{
  public b a;
  public b b;
  
  public f0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    b = new c(paramx, paramr);
    c.put(Long.class, this);
    paramr.a(this);
  }
  
  public b a(Long paramLong)
  {
    long l = paramLong.longValue();
    if ((l >= -128L) && (l <= 127L)) {
      paramLong = b;
    } else {
      paramLong = a;
    }
    return paramLong;
  }
  
  public Class<Long> b()
  {
    return Long.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<b> k()
  {
    return Arrays.asList(new b[] { b, a });
  }
  
  public class a
    extends z<Long>
    implements f0.b
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public long a()
    {
      return b.g();
    }
    
    public void a(long paramLong)
    {
      a.a.a(paramLong);
    }
    
    public boolean a(r0<Long> paramr0)
    {
      boolean bool;
      if (f0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (Long)paramObject;
      x localx = a;
      long l = ((Long)paramObject).longValue();
      a.a(l);
    }
    
    public byte f()
    {
      return -127;
    }
    
    public a getType()
    {
      return f0.this;
    }
    
    public i0 getType()
    {
      return f0.this;
    }
    
    public Object i()
    {
      return Long.valueOf(b.g());
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
  
  public static abstract interface b
    extends j0<Long>
  {
    public abstract long a();
    
    public abstract void a(long paramLong);
  }
  
  public class c
    extends z<Long>
    implements f0.b
  {
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public long a()
    {
      return b.e();
    }
    
    public void a(long paramLong)
    {
      x localx = a;
      byte b = (byte)(int)paramLong;
      a.a(b);
    }
    
    public boolean a(r0<Long> paramr0)
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
      paramObject = (Long)paramObject;
      x localx = a;
      byte b = (byte)(int)((Long)paramObject).longValue();
      a.a(b);
    }
    
    public byte f()
    {
      return 85;
    }
    
    public a getType()
    {
      return f0.this;
    }
    
    public i0 getType()
    {
      return f0.this;
    }
    
    public Object i()
    {
      return Long.valueOf(b.e());
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
 * Qualified Name:     l.a.b.a.c.f0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */