package androidx.appcompat.widget;

import android.view.MenuItem;
import android.view.Window.Callback;
import d.b.a.s;
import d.b.a.s.b;
import d.b.d.i.g;
import d.b.d.i.g.a;

public class ActionMenuView$d
  implements g.a
{
  public ActionMenuView$d(ActionMenuView paramActionMenuView) {}
  
  public void a(g paramg)
  {
    g.a locala = x.S;
    if (locala != null) {
      locala.a(paramg);
    }
  }
  
  public boolean a(g paramg, MenuItem paramMenuItem)
  {
    paramg = x.a0;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramg != null)
    {
      paramg = a.g0;
      boolean bool3;
      if (paramg != null) {
        bool3 = a.c.onMenuItemSelected(0, paramMenuItem);
      } else {
        bool3 = false;
      }
      bool2 = bool1;
      if (bool3) {
        bool2 = true;
      }
    }
    return bool2;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.ActionMenuView.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */