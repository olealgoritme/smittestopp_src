package j.b.a.b0;

import android.app.Application;
import l.a.a.b;

public final class i
{
  public g a;
  public boolean b;
  public boolean c;
  public i.a d;
  public Application e;
  public h f;
  public final j.a.a.a.a.a.a g;
  
  public i(Application paramApplication, h paramh, j.a.a.a.a.a.a parama) {}
  
  public final void a()
  {
    l.a.a.d.b("startScanning", new Object[0]);
    if (a == null) {
      a = new g(e, f, g);
    }
    g localg = a;
    if (localg != null) {
      localg.a(false);
    }
  }
  
  public final void b()
  {
    l.a.a.d.b("stopScanning", new Object[0]);
    g localg = a;
    if (localg != null) {
      try
      {
        f.a(e);
        f.b(e);
      }
      catch (Exception localException)
      {
        l.a.a.d.a(localException);
      }
    }
    a = null;
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.b0.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */