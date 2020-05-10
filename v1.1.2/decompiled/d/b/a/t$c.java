package d.b.a;

import android.view.Window.Callback;
import d.b.d.i.h;
import d.b.d.i.o.a;
import d.b.e.b0;

public final class t$c
  implements o.a
{
  public boolean x;
  
  public t$c(t paramt) {}
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (x) {
      return;
    }
    x = true;
    y.a.g();
    Window.Callback localCallback = y.c;
    if (localCallback != null) {
      localCallback.onPanelClosed(108, paramh);
    }
    x = false;
  }
  
  public boolean a(h paramh)
  {
    Window.Callback localCallback = y.c;
    if (localCallback != null)
    {
      localCallback.onMenuOpened(108, paramh);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     d.b.a.t.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */