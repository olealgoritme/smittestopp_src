package d.i.i;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

public final class l
  implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener
{
  public final View x;
  public ViewTreeObserver y;
  public final Runnable z;
  
  public l(View paramView, Runnable paramRunnable)
  {
    x = paramView;
    y = paramView.getViewTreeObserver();
    z = paramRunnable;
  }
  
  public static l a(View paramView, Runnable paramRunnable)
  {
    if (paramView != null)
    {
      if (paramRunnable != null)
      {
        paramRunnable = new l(paramView, paramRunnable);
        paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
        paramView.addOnAttachStateChangeListener(paramRunnable);
        return paramRunnable;
      }
      throw new NullPointerException("runnable == null");
    }
    throw new NullPointerException("view == null");
  }
  
  public void a()
  {
    if (y.isAlive()) {
      y.removeOnPreDrawListener(this);
    } else {
      x.getViewTreeObserver().removeOnPreDrawListener(this);
    }
    x.removeOnAttachStateChangeListener(this);
  }
  
  public boolean onPreDraw()
  {
    a();
    z.run();
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    y = paramView.getViewTreeObserver();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    a();
  }
}

/* Location:
 * Qualified Name:     d.i.i.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */