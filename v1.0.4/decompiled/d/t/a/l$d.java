package d.t.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ViewGroup;

public class l$d
  implements ValueAnimator.AnimatorUpdateListener
{
  public l$d(l paraml) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    a.c.setAlpha(i);
    a.d.setAlpha(i);
    a.s.invalidate();
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.l.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */