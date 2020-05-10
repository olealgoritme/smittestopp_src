package d.b.d.i;

import android.view.View;
import android.view.ViewTreeObserver;

public class q$b
  implements View.OnAttachStateChangeListener
{
  public q$b(q paramq) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    Object localObject = x.M;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        x.M = paramView.getViewTreeObserver();
      }
      localObject = x;
      M.removeGlobalOnLayoutListener(G);
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.q.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */