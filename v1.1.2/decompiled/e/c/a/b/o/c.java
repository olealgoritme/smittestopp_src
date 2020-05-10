package e.c.a.b.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.transformation.FabTransformationBehavior;

public class c
  extends AnimatorListenerAdapter
{
  public c(FabTransformationBehavior paramFabTransformationBehavior, e.c.a.b.g.c paramc) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = a.getRevealInfo();
    c = Float.MAX_VALUE;
    a.setRevealInfo(paramAnimator);
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.o.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */