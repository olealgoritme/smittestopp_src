package h.e;

import h.c.d;
import h.c.d.f;
import h.c.f.a;
import h.c.g;
import h.c.g.a;
import h.c.g.f;
import h.c.g.h;
import h.c.g.i;
import h.c.g.j;
import h.c.g.k;
import h.c.g.l;

public abstract class e
  extends g
{
  public static transient d.f d = da;
  public String c;
  
  public e()
  {
    super(f.a.a);
  }
  
  public static e e()
  {
    Object localObject;
    if (d.d().b()) {
      localObject = new a();
    } else {
      localObject = new b();
    }
    return (e)localObject;
  }
  
  public final h.a.d.e a()
  {
    return h.a.d.e.valueOf(b().b());
  }
  
  public void a(int paramInt)
  {
    if (d == d.f.LINUX)
    {
      if (paramInt == 2)
      {
        c = "";
        return;
      }
      g.i locali = c();
      byte[] arrayOfByte = new byte[d];
      locali.a();
      locali.b();
      throw null;
    }
    c().c();
    throw null;
  }
  
  public final void a(h.a.d.e parame)
  {
    b().a(Integer.valueOf(parame.intValue()));
  }
  
  public void a(String paramString)
  {
    c = paramString;
    paramString = c();
    paramString.a();
    paramString.b();
    throw null;
  }
  
  public abstract g.f b();
  
  public abstract g.i c();
  
  public int d()
  {
    if (d == d.f.LINUX)
    {
      localObject = c;
      if (localObject != null) {
        return ((String)localObject).length() + 2;
      }
    }
    Object localObject = c();
    ((g.a)localObject).a();
    ((g.a)localObject).b();
    throw null;
  }
  
  public static final class a
    extends e
  {
    public final g.l e = new g.l(this);
    public final g.l f = new g.l(this);
    public final g.i g = new g.i(this, 108);
    
    public void a(String paramString)
    {
      c = paramString;
      paramString = c();
      paramString.a();
      paramString.b();
      throw null;
    }
    
    public g.f b()
    {
      return f;
    }
    
    public g.i c()
    {
      return g;
    }
  }
  
  public static final class b
    extends e
  {
    public final g.k e = new g.k(this);
    public final g.i f = new g.i(this, 108);
    
    public g.f b()
    {
      return e;
    }
    
    public g.i c()
    {
      return f;
    }
  }
}

/* Location:
 * Qualified Name:     h.e.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */