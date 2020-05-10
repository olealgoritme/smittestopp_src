package d.b.d.i;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

public class s$b
  implements View.OnAttachStateChangeListener
{
  public s$b(s params) {}
  
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
 * Qualified Name:     d.b.d.i.s.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */