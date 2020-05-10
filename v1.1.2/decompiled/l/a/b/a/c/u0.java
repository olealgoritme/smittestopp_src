package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import l.a.b.a.b.h;

public class u0
  extends c<h>
{
  public c a;
  public c b;
  public c c;
  
  public u0(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    b = new b(paramx, paramr);
    c = new d(paramx, paramr);
    c.put(h.class, this);
    paramr.a(this);
  }
  
  public c a(h paramh)
  {
    int i = x;
    if (i == 0) {
      paramh = c;
    } else if ((i >= 0) && (i <= 255)) {
      paramh = b;
    } else {
      paramh = a;
    }
    return paramh;
  }
  
  public Class<h> b()
  {
    return h.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<c> k()
  {
    return Arrays.asList(new c[] { a, b, c });
  }
  
  public class a
    extends z<h>
    implements u0.c
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<h> paramr0)
    {
      boolean bool;
      if (u0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      h localh = (h)paramObject;
      paramObject = a;
      int i = x;
      a.c(i);
    }
    
    public byte f()
    {
      return 112;
    }
    
    public a getType()
    {
      return u0.this;
    }
    
    public i0 getType()
    {
      return u0.this;
    }
    
    public Object i()
    {
      return h.a(b.f());
    }
    
    public int k()
    {
      return 4;
    }
  }
  
  public class b
    extends z<h>
    implements u0.c
  {
    public b(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<h> paramr0)
    {
      boolean bool;
      if ((paramr0 != this) && (!(paramr0 instanceof u0.d))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      paramObject = (h)paramObject;
      x localx = a;
      byte b = (byte)x;
      a.a(b);
    }
    
    public byte f()
    {
      return 82;
    }
    
    public a getType()
    {
      return u0.this;
    }
    
    public i0 getType()
    {
      return u0.this;
    }
    
    public Object i()
    {
      return h.a(b.e() & 0xFF);
    }
    
    public int k()
    {
      return 1;
    }
  }
  
  public static abstract interface c
    extends j0<h>
  {}
  
  public class d
    extends z<h>
    implements u0.c
  {
    public d(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<h> paramr0)
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
      paramObject = (h)paramObject;
    }
    
    public byte f()
    {
      return 67;
    }
    
    public a getType()
    {
      return u0.this;
    }
    
    public i0 getType()
    {
      return u0.this;
    }
    
    public Object i()
    {
      return h.z;
    }
    
    public int k()
    {
      return 0;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.u0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */