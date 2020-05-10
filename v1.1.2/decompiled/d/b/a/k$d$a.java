package d.b.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import d.i.i.n;
import d.i.i.s;
import d.i.i.u;

public class k$d$a
  extends u
{
  public k$d$a(k.d paramd) {}
  
  public void b(View paramView)
  {
    a.b.J.setVisibility(8);
    paramView = a.b;
    PopupWindow localPopupWindow = K;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    } else if ((J.getParent() instanceof View)) {
      n.y((View)a.b.J.getParent());
    }
    a.b.J.removeAllViews();
    a.b.M.a(null);
    a.b.M = null;
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */