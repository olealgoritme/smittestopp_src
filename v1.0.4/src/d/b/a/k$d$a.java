package d.b.a;

import android.view.View;

import d.i.i.n;
import d.i.i.u;

public class k$d$a
  extends u
{
  public k$d$a(k.d paramd) {}
  
  public void a(View paramView)
  {
    a.b.L.setVisibility(8);
    k localk = a.b;
    paramView = M;
    if (paramView != null) {
      paramView.dismiss();
    } else if ((L.getParent() instanceof View)) {
      n.y((View)a.b.L.getParent());
    }
    a.b.L.removeAllViews();
    a.b.O.a(null);
    a.b.O = null;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */