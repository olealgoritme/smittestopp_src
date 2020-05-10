package d.b.a;

import d.b.d.i.g;
import d.b.d.i.m.a;

public final class s$c
  implements m.a
{
  public boolean x;
  
  public s$c(s params) {}
  
  public void a(g paramg, boolean paramBoolean)
  {
    if (x) {
      return;
    }
    x = true;
    y.a.g();
    Window.Callback localCallback = y.c;
    if (localCallback != null) {
      localCallback.onPanelClosed(108, paramg);
    }
    x = false;
  }
  
  public boolean a(g paramg)
  {
    Window.Callback localCallback = y.c;
    if (localCallback != null)
    {
      localCallback.onMenuOpened(108, paramg);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.s.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */