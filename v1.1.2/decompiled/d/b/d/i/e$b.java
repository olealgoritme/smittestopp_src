package d.b.d.i;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

public class e$b
  implements View.OnAttachStateChangeListener
{
  public e$b(e parame) {}
  
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
 * Qualified Name:     d.b.d.i.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */