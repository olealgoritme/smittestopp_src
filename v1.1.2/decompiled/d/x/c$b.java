package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import d.i.i.n;

public class c$b
  extends AnimatorListenerAdapter
{
  public final View a;
  public boolean b = false;
  
  public c$b(View paramView)
  {
    a = paramView;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = a;
    v.a.a(paramAnimator, 1.0F);
    if (b) {
      a.setLayerType(0, null);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((n.r(a)) && (a.getLayerType() == 0))
    {
      b = true;
      a.setLayerType(2, null);
    }
  }
}

/* Location:
 * Qualified Name:     d.x.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */