package d.b.e;

import android.view.MenuItem;
import d.b.d.i.b;
import d.b.d.i.h;
import d.b.d.i.o.a;
import d.b.d.i.t;

public class c$f
  implements o.a
{
  public c$f(c paramc) {}
  
  public void a(h paramh, boolean paramBoolean)
  {
    if ((paramh instanceof t)) {
      paramh.c().a(false);
    }
    o.a locala = x.B;
    if (locala != null) {
      locala.a(paramh, paramBoolean);
    }
  }
  
  public boolean a(h paramh)
  {
    boolean bool = false;
    if (paramh == null) {
      return false;
    }
    x.X = B.getItemId();
    o.a locala = x.B;
    if (locala != null) {
      bool = locala.a(paramh);
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     d.b.e.c.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */