package l.a.b.a.c;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import l.a.b.a.b.f;

public class o0
  extends c<f>
{
  public static final Charset e = Charset.forName("US-ASCII");
  public final d a;
  public final d b;
  public final Map<k0, f> c = new HashMap();
  public r.b<f> d = new a();
  
  public o0(x paramx, r paramr)
  {
    a = new b(paramx, paramr);
    b = new c(paramx, paramr);
    c.put(f.class, this);
    paramr.a(this);
  }
  
  public j0 a(Object paramObject)
  {
    if (((f)paramObject).length() <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    if (((f)paramObject).length() <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (r0)paramObject;
  }
  
  public Class<f> b()
  {
    return f.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<d> k()
  {
    return Arrays.asList(new d[] { b, a });
  }
  
  public class a
    implements r.b<f>
  {
    public a() {}
    
    public Object a(r paramr, k0 paramk0)
    {
      Object localObject = (f)c.get(paramk0);
      paramr = (r)localObject;
      if (localObject == null)
      {
        localObject = new byte[paramk0.a()];
        paramk0.a((byte[])localObject);
        paramr = f.a(new String((byte[])localObject, o0.e));
        c.put(new k0.a(ByteBuffer.wrap((byte[])localObject)), paramr);
      }
      return paramr;
    }
  }
  
  public class b
    extends d0<f>
    implements o0.d
  {
    public b(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<f> paramr0)
    {
      boolean bool;
      if (o0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int c(Object paramObject)
    {
      return ((f)paramObject).length();
    }
    
    public void d(Object paramObject)
    {
      paramObject = (f)paramObject;
      a.a.b(((f)paramObject).length());
      ((f)paramObject).a(a.a);
    }
    
    public byte f()
    {
      return -77;
    }
    
    public a getType()
    {
      return o0.this;
    }
    
    public i0 getType()
    {
      return o0.this;
    }
    
    public Object i()
    {
      r localr = b;
      int i = localr.f();
      return (f)localr.a(d, i);
    }
  }
  
  public class c
    extends m0<f>
    implements o0.d
  {
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<f> paramr0)
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
      return ((f)paramObject).length();
    }
    
    public void d(Object paramObject)
    {
      paramObject = (f)paramObject;
      a.a.b(((f)paramObject).length());
      ((f)paramObject).a(a.a);
    }
    
    public byte f()
    {
      return -93;
    }
    
    public a getType()
    {
      return o0.this;
    }
    
    public i0 getType()
    {
      return o0.this;
    }
    
    public Object i()
    {
      r localr = b;
      int i = localr.e();
      return (f)localr.a(d, i & 0xFF);
    }
  }
  
  public static abstract interface d
    extends j0<f>
  {}
}

/* Location:
 * Qualified Name:     l.a.b.a.c.o0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */