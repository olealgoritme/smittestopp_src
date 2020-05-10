package androidx.appcompat.view.menu;

import d.b.d.i.g.b;
import d.b.d.i.l;
import d.b.d.i.p;
import d.b.e.c;
import d.b.e.c.b;
import d.b.e.h0;

public class ActionMenuItemView$a
  extends h0
{
  public ActionMenuItemView$a(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public p b()
  {
    Object localObject1 = G.G;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    if (localObject1 != null)
    {
      localObject1 = a.S;
      localObject3 = localObject2;
      if (localObject1 != null) {
        localObject3 = ((l)localObject1).a();
      }
    }
    return (p)localObject3;
  }
  
  public boolean c()
  {
    Object localObject = G;
    g.b localb = E;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localb != null)
    {
      bool2 = bool1;
      if (localb.a(B))
      {
        localObject = b();
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((p)localObject).a()) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.view.menu.ActionMenuItemView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */