package d.b.a;

import android.view.View;

import d.i.i.n;
import d.i.i.u;

public class p
  extends u
{
  public p(k paramk) {}
  
  public void a(View paramView)
  {
    a.L.setAlpha(1.0F);
    a.O.a(null);
    a.O = null;
  }
  
  public void b(View paramView)
  {
    a.L.setVisibility(0);
    a.L.sendAccessibilityEvent(32);
    if ((a.L.getParent() instanceof View)) {
      n.y((View)a.L.getParent());
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */