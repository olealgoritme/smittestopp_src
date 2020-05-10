package d.b.a;

import d.b.d.i.g;
import d.b.d.i.m.a;

public final class k$k
  implements m.a
{
  public k$k(k paramk) {}
  
  public void a(g paramg, boolean paramBoolean)
  {
    g localg = paramg.c();
    int i;
    if (localg != paramg) {
      i = 1;
    } else {
      i = 0;
    }
    k localk = x;
    if (i != 0) {
      paramg = localg;
    }
    paramg = localk.a(paramg);
    if (paramg != null) {
      if (i != 0)
      {
        x.a(a, paramg, localg);
        x.a(paramg, true);
      }
      else
      {
        x.a(paramg, paramBoolean);
      }
    }
  }
  
  public boolean a(g paramg)
  {
    if (paramg == null)
    {
      Object localObject = x;
      if (W)
      {
        localObject = ((k)localObject).j();
        if ((localObject != null) && (!x.i0)) {
          ((Window.Callback)localObject).onMenuOpened(108, paramg);
        }
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */