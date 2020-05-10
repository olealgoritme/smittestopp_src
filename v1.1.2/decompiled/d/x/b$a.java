package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;

public class b$a
  extends AnimatorListenerAdapter
{
  public b$a(b paramb, ViewGroup paramViewGroup, BitmapDrawable paramBitmapDrawable, View paramView, float paramFloat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    u localu = v.a(a);
    paramAnimator = b;
    a.remove(paramAnimator);
    paramAnimator = c;
    float f = d;
    v.a.a(paramAnimator, f);
  }
}

/* Location:
 * Qualified Name:     d.x.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */