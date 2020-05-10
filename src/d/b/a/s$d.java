package d.b.a;

import android.view.MenuItem;

import d.b.d.i.g;
import d.b.d.i.g.a;

public final class s$d
  implements g.a
{
  public s$d(s params) {}
  
  public void a(g paramg)
  {
    s locals = x;
    if (c != null) {
      if (a.b()) {
        x.c.onPanelClosed(108, paramg);
      } else if (x.c.onPreparePanel(0, null, paramg)) {
        x.c.onMenuOpened(108, paramg);
      }
    }
  }
  
  public boolean a(g paramg, MenuItem paramMenuItem)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.s.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */