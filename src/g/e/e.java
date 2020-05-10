package g.e;

import g.c.d;
import g.c.d.f;
import g.c.f.a;
import g.c.g;
import g.c.g.a;
import g.c.g.f;
import g.c.g.h;
import g.c.g.i;
import g.c.g.j;

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
      localObject = new e.a();
    } else {
      localObject = new e.b();
    }
    return (e)localObject;
  }
  
  public final g.a.d.e a()
  {
    return g.a.d.e.valueOf(b().b());
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
  
  public final void a(g.a.d.e parame)
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
}

/* Location:
 * Qualified Name:     base.g.e.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */