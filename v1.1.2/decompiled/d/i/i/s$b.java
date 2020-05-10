package d.i.i;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout;
import d.b.a.w;
import d.b.a.w.c;

public class s$b
  implements ValueAnimator.AnimatorUpdateListener
{
  public s$b(s params, v paramv, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ((View)a).a.d.getParent()).invalidate();
  }
}

/* Location:
 * Qualified Name:     d.i.i.s.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */