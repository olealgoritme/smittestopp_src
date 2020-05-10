package d.i.i;

import android.view.View;
import android.view.ViewPropertyAnimator;
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
  
  public s a(v paramv)
  {
    View localView = (View)a.get();
    if (localView != null)
    {
      s.b localb = null;
      if (paramv != null) {
        localb = new s.b(this, paramv, localView);
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
  
  public final void a(View paramView, t paramt)
  {
    if (paramt != null) {
      paramView.animate().setListener(new s.a(this, paramt, paramView));
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
}

/* Location:
 * Qualified Name:     base.d.i.i.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */