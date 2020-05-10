package d.e.a;

import android.graphics.drawable.Drawable;

public class f
  extends Drawable
{
  public static final double a = Math.cos(Math.toRadians(45.0D));
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean)
    {
      double d = paramFloat1;
      f = (float)((1.0D - a) * paramFloat2 + d);
    }
    return f;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d = paramFloat1 * 1.5F;
      return (float)((1.0D - a) * paramFloat2 + d);
    }
    return paramFloat1 * 1.5F;
  }
}

/* Location:
 * Qualified Name:     d.e.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */