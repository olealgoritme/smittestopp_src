package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class j
  extends AnimatorListenerAdapter
{
  public j(h paramh) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a.a();
    paramAnimator.removeListener(this);
  }
}

/* Location:
 * Qualified Name:     base.d.x.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */