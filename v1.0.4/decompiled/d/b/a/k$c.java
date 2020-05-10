package d.b.a;

import d.b.d.i.g;
import d.b.d.i.m.a;

public final class k$c
  implements m.a
{
  public k$c(k paramk) {}
  
  public void a(g paramg, boolean paramBoolean)
  {
    x.b(paramg);
  }
  
  public boolean a(g paramg)
  {
    Window.Callback localCallback = x.j();
    if (localCallback != null) {
      localCallback.onMenuOpened(108, paramg);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */