package d.b.a;

import android.view.Menu;
import android.view.Window.Callback;
import d.b.d.i.h;

public class t$a
  implements Runnable
{
  public t$a(t paramt) {}
  
  public void run()
  {
    t localt = x;
    Menu localMenu = localt.h();
    h localh;
    if ((localMenu instanceof h)) {
      localh = (h)localMenu;
    } else {
      localh = null;
    }
    if (localh != null) {
      localh.j();
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
      if (localh != null) {
        localh.i();
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.t.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */