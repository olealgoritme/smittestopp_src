package d.b.d.i;

import android.view.View;
import android.view.ViewTreeObserver;

public class d$b
  implements View.OnAttachStateChangeListener
{
  public d$b(d paramd) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    Object localObject = x.V;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        x.V = paramView.getViewTreeObserver();
      }
      localObject = x;
      V.removeGlobalOnLayoutListener(G);
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.d.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */