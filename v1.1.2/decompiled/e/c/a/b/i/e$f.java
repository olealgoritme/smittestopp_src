package e.c.a.b.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

public abstract class e$f
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  public boolean a;
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    throw null;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!a) {
      throw null;
    }
    paramValueAnimator.getAnimatedFraction();
    throw null;
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.i.e.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */