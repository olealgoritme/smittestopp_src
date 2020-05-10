package androidx.appcompat.widget;

import android.view.MenuItem;
import android.view.Window.Callback;
import d.b.a.t;
import d.b.a.t.b;
import d.b.d.i.h;
import d.b.d.i.h.a;

public class ActionMenuView$d
  implements h.a
{
  public ActionMenuView$d(ActionMenuView paramActionMenuView) {}
  
  public void a(h paramh)
  {
    h.a locala = x.S;
    if (locala != null) {
      locala.a(paramh);
    }
  }
  
  public boolean a(h paramh, MenuItem paramMenuItem)
  {
    paramh = x.a0;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramh != null)
    {
      paramh = a.g0;
      boolean bool3;
      if (paramh != null) {
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
 * Qualified Name:     androidx.appcompat.widget.ActionMenuView.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */