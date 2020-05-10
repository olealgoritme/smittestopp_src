package d.b.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionBarContextView;
import d.i.i.n;
import d.i.i.s;
import d.i.i.u;

public class p
  extends u
{
  public p(k paramk) {}
  
  public void b(View paramView)
  {
    a.J.setAlpha(1.0F);
    a.M.a(null);
    a.M = null;
  }
  
  public void c(View paramView)
  {
    a.J.setVisibility(0);
    a.J.sendAccessibilityEvent(32);
    if ((a.J.getParent() instanceof View)) {
      n.y((View)a.J.getParent());
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */