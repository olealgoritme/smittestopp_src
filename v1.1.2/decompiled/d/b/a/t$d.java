package d.b.a;

import android.view.MenuItem;
import android.view.Window.Callback;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.e.b0;

public final class t$d
  implements h.a
{
  public t$d(t paramt) {}
  
  public void a(h paramh)
  {
    t localt = x;
    if (c != null) {
      if (a.a()) {
        x.c.onPanelClosed(108, paramh);
      } else if (x.c.onPreparePanel(0, null, paramh)) {
        x.c.onMenuOpened(108, paramh);
      }
    }
  }
  
  public boolean a(h paramh, MenuItem paramMenuItem)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     d.b.a.t.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */