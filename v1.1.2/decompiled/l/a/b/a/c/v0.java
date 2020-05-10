package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import l.a.b.a.b.i;

public class v0
  extends c<i>
{
  public c a;
  public c b;
  public c c;
  
  public v0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    b = new b(paramx, paramr);
    c = new d(paramx, paramr);
    c.put(i.class, this);
    paramr.a(this);
  }
  
  public c a(i parami)
  {
    long l = x;
    boolean bool = l < 0L;
    if (!bool) {
      parami = c;
    } else if ((!bool) && (l <= 255L)) {
      parami = b;
    } else {
      parami = a;
    }
    return parami;
  }
  
  public Class<i> b()
  {
    return i.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<c> k()
  {
    return Arrays.asList(new c[] { c, b, a });
  }
  
  public class a
    extends z<i>
    implements v0.c
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<i> paramr0)
    {
      boolean bool;
      if (v0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      i locali = (i)paramObject;
      paramObject = a;
      long l = x;
      a.a(l);
    }
    
    public byte f()
    {
      return Byte.MIN_VALUE;
    }
    
    public a getType()
    {
      return v0.this;
    }
    
    public i0 getType()
    {
      return v0.this;
    }
    
    public Object i()
    {
      return i.a(b.g());
    }
    
    public int k()
    {
      return 8;
    }
  }
  
  public class b
    extends z<i>
    implements v0.c
  {
    public b(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<i> paramr0)
    {
      boolean bool;
      if ((paramr0 != this) && (!(paramr0 instanceof v0.d))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (i)paramObject;
      x localx = a;
      byte b = (byte)(int)x;
      a.a(b);
    }
    
    public byte f()
    {
      return 83;
    }
    
    public a getType()
    {
      return v0.this;
    }
    
    public i0 getType()
    {
      return v0.this;
    }
    
    public Object i()
    {
      return i.a(b.e() & 0xFF);
    }
    
    public int k()
    {
      return 1;
    }
  }
  
  public static abstract interface c
    extends j0<i>
  {}
  
  public class d
    extends z<i>
    implements v0.c
  {
    public d(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<i> paramr0)
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
      paramObject = (i)paramObject;
    }
    
    public byte f()
    {
      return 68;
    }
    
    public a getType()
    {
      return v0.this;
    }
    
    public i0 getType()
    {
      return v0.this;
    }
    
    public Object i()
    {
      return i.A;
    }
    
    public int k()
    {
      return 0;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.v0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */