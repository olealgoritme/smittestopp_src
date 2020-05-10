package d.b.e;

import android.view.MenuItem;
import d.b.d.i.b;
import d.b.d.i.g;
import d.b.d.i.m.a;
import d.b.d.i.r;

public class c$f
  implements m.a
{
  public c$f(c paramc) {}
  
  public void a(g paramg, boolean paramBoolean)
  {
    if ((paramg instanceof r)) {
      paramg.c().a(false);
    }
    m.a locala = x.B;
    if (locala != null) {
      locala.a(paramg, paramBoolean);
    }
  }
  
  public boolean a(g paramg)
  {
    boolean bool = false;
    if (paramg == null) {
      return false;
    }
    x.W = B.getItemId();
    m.a locala = x.B;
    if (locala != null) {
      bool = locala.a(paramg);
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.c.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */