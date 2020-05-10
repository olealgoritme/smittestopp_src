package d.b.a;

import android.view.Window.Callback;
import d.b.d.i.h;
import d.b.d.i.o.a;

public final class k$c
  implements o.a
{
  public k$c(k paramk) {}
  
  public void a(h paramh, boolean paramBoolean)
  {
    x.b(paramh);
  }
  
  public boolean a(h paramh)
  {
    Window.Callback localCallback = x.h();
    if (localCallback != null) {
      localCallback.onMenuOpened(108, paramh);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */