package d.k.b;

import android.view.animation.Interpolator;

public final class a$a
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}

/* Location:
 * Qualified Name:     base.d.k.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */