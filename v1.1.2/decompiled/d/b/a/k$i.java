package d.b.a;

import android.view.Window.Callback;
import d.b.d.i.h;
import d.b.d.i.o.a;

public final class k$i
  implements o.a
{
  public k$i(k paramk) {}
  
  public void a(h paramh, boolean paramBoolean)
  {
    h localh = paramh.c();
    int i;
    if (localh != paramh) {
      i = 1;
    } else {
      i = 0;
    }
    k localk = x;
    if (i != 0) {
      paramh = localh;
    }
    paramh = localk.a(paramh);
    if (paramh != null) {
      if (i != 0)
      {
        x.a(a, paramh, localh);
        x.a(paramh, true);
      }
      else
      {
        x.a(paramh, paramBoolean);
      }
    }
  }
  
  public boolean a(h paramh)
  {
    if (paramh == null)
    {
      Object localObject = x;
      if (U)
      {
        localObject = ((k)localObject).h();
        if ((localObject != null) && (!x.d0)) {
          ((Window.Callback)localObject).onMenuOpened(108, paramh);
        }
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */