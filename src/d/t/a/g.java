package d.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

public class g
  extends AnimatorListenerAdapter
{
  public g(k paramk, s.x paramx, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    b.setAlpha(1.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    c.setListener(null);
    d.a(a);
    d.o.remove(a);
    d.d();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (d != null) {
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */