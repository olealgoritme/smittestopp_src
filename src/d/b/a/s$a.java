package d.b.a;

import android.view.Menu;

import d.b.d.i.g;

public class s$a
  implements Runnable
{
  public s$a(s params) {}
  
  public void run()
  {
    s locals = x;
    Menu localMenu = locals.h();
    g localg;
    if ((localMenu instanceof g)) {
      localg = (g)localMenu;
    } else {
      localg = null;
    }
    if (localg != null) {
      localg.j();
    }
    try
    {
      localMenu.clear();
      if ((!c.onCreatePanelMenu(0, localMenu)) || (!c.onPreparePanel(0, null, localMenu))) {
        localMenu.clear();
      }
      return;
    }
    finally
    {
      if (localg != null) {
        localg.i();
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */