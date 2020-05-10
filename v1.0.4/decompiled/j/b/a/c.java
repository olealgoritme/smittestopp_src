package j.b.a;

import d.u.g;
import d.u.k;
import d.w.a.f.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
  implements b
{
  public final g a;
  public final d.u.b<a> b;
  public final k c;
  public final k d;
  
  public c(g paramg)
  {
    a = paramg;
    b = new c.a(this, paramg);
    c = new c.b(this, paramg);
    d = new c.c(this, paramg);
  }
  
  public void a()
  {
    a.b();
    f localf = d.a();
    a.c();
    try
    {
      localf.a();
      a.g();
      a.d();
      k localk = d;
      if (localf == c) {
        a.set(false);
      }
      return;
    }
    finally
    {
      a.d();
      d.a(localf);
    }
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */