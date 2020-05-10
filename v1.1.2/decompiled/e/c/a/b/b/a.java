package e.c.a.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;

public class a
  implements ValueAnimator.AnimatorUpdateListener
{
  public a(AppBarLayout.BaseBehavior paramBaseBehavior, CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    c.c(a, b, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */