package d.i.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import d.b.a.w;
import d.b.a.w.c;
import java.lang.ref.WeakReference;

public final class s
{
  public WeakReference<View> a;
  public Runnable b = null;
  public Runnable c = null;
  public int d = -1;
  
  public s(View paramView)
  {
    a = new WeakReference(paramView);
  }
  
  public s a(float paramFloat)
  {
    View localView = (View)a.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public s a(long paramLong)
  {
    View localView = (View)a.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public s a(t paramt)
  {
    View localView = (View)a.get();
    if (localView != null) {
      a(localView, paramt);
    }
    return this;
  }
  
  public s a(final v paramv)
  {
    final View localView = (View)a.get();
    if (localView != null)
    {
      b localb = null;
      if (paramv != null) {
        localb = new b(paramv, localView);
      }
      localView.animate().setUpdateListener(localb);
    }
    return this;
  }
  
  public void a()
  {
    View localView = (View)a.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public final void a(final View paramView, final t paramt)
  {
    if (paramt != null) {
      paramView.animate().setListener(new a(paramt, paramView));
    } else {
      paramView.animate().setListener(null);
    }
  }
  
  public s b(float paramFloat)
  {
    View localView = (View)a.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  public class a
    extends AnimatorListenerAdapter
  {
    public a(t paramt, View paramView) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      paramt.a(paramView);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramt.b(paramView);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      paramt.c(paramView);
    }
  }
  
  public class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    public b(v paramv, View paramView) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      ((View)paramva.d.getParent()).invalidate();
    }
  }
}

/* Location:
 * Qualified Name:     d.i.i.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */