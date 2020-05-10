package d.m.a;

import android.animation.Animator;
import android.view.animation.Animation;

public class g
{
  public final Animation a;
  public final Animator b;
  
  public g(Animator paramAnimator)
  {
    a = null;
    b = paramAnimator;
    if (paramAnimator != null) {
      return;
    }
    throw new IllegalStateException("Animator cannot be null");
  }
  
  public g(Animation paramAnimation)
  {
    a = paramAnimation;
    b = null;
    if (paramAnimation != null) {
      return;
    }
    throw new IllegalStateException("Animation cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */