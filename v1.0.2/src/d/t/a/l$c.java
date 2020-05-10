package d.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;

public class l$c
  extends AnimatorListenerAdapter
{
  public boolean a = false;
  
  public l$c(l paraml) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (a)
    {
      a = false;
      return;
    }
    if (((Float)b.z.getAnimatedValue()).floatValue() == 0.0F)
    {
      paramAnimator = b;
      A = 0;
      paramAnimator.a(0);
    }
    else
    {
      paramAnimator = b;
      A = 2;
      s.invalidate();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.l.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */