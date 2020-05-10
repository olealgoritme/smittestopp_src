package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;
import d.b.d.i.i;

public class Toolbar$c
  implements View.OnClickListener
{
  public Toolbar$c(Toolbar paramToolbar) {}
  
  public void onClick(View paramView)
  {
    paramView = x.k0;
    if (paramView == null) {
      paramView = null;
    } else {
      paramView = y;
    }
    if (paramView != null) {
      paramView.collapseActionView();
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.Toolbar.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */