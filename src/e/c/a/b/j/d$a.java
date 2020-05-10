package e.c.a.b.j;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

public class d$a
  implements ValueAnimator.AnimatorUpdateListener
{
  public d$a(d paramd, TextView paramTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    a.setScaleX(f);
    a.setScaleY(f);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.j.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */