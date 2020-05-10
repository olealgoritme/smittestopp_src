package androidx.appcompat.view.menu;

import d.b.d.i.h.b;
import d.b.d.i.n;
import d.b.d.i.r;
import d.b.e.c;
import d.b.e.c.b;
import d.b.e.f0;

public class ActionMenuItemView$a
  extends f0
{
  public ActionMenuItemView$a(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public r b()
  {
    Object localObject1 = G.F;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    if (localObject1 != null)
    {
      localObject1 = a.T;
      localObject3 = localObject2;
      if (localObject1 != null) {
        localObject3 = ((n)localObject1).a();
      }
    }
    return (r)localObject3;
  }
  
  public boolean c()
  {
    Object localObject = G;
    h.b localb = D;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localb != null)
    {
      bool2 = bool1;
      if (localb.a(A))
      {
        localObject = b();
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((r)localObject).e()) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.view.menu.ActionMenuItemView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */