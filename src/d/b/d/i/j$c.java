package d.b.d.i;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

import d.b.d.b;

public class j$c
  extends FrameLayout
  implements b
{
  public final CollapsibleActionView x;
  
  public j$c(View paramView)
  {
    super(paramView.getContext());
    x = ((CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  public void a()
  {
    x.onActionViewExpanded();
  }
  
  public void b()
  {
    x.onActionViewCollapsed();
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.j.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */