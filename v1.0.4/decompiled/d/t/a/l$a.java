package d.t.a;

import android.animation.ValueAnimator;

public class l$a
  implements Runnable
{
  public l$a(l paraml) {}
  
  public void run()
  {
    l locall = x;
    int i = A;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
    }
    else {
      z.cancel();
    }
    A = 3;
    ValueAnimator localValueAnimator = z;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 0.0F });
    z.setDuration('Ǵ');
    z.start();
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.l.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */