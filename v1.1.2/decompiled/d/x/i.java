package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import d.f.a;
import java.util.ArrayList;

public class i
  extends AnimatorListenerAdapter
{
  public i(h paramh, a parama) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a.remove(paramAnimator);
    b.T.remove(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    b.T.add(paramAnimator);
  }
}

/* Location:
 * Qualified Name:     d.x.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */