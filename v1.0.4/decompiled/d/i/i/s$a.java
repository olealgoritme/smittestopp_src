package d.i.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class s$a
  extends AnimatorListenerAdapter
{
  public s$a(s params, t paramt, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a.c(b);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a.a(b);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    a.b(b);
  }
}

/* Location:
 * Qualified Name:     base.d.i.i.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */