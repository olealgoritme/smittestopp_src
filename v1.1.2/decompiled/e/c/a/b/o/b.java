package e.c.a.b.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;
import e.c.a.b.g.c;

public class b
  extends AnimatorListenerAdapter
{
  public b(FabTransformationBehavior paramFabTransformationBehavior, c paramc, Drawable paramDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a.setCircularRevealOverlayDrawable(null);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    a.setCircularRevealOverlayDrawable(b);
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.o.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */