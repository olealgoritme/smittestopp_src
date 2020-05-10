package d.b.d.i;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import d.b.d.b;

public class k$b
  extends FrameLayout
  implements b
{
  public final CollapsibleActionView x;
  
  public k$b(View paramView)
  {
    super(paramView.getContext());
    x = ((CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  public void a()
  {
    x.onActionViewExpanded();
  }
  
  public void c()
  {
    x.onActionViewCollapsed();
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.k.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */