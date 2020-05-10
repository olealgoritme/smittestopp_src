package e.c.a.b.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import d.n.a.a.b;
import d.n.a.a.c;

public class a
{
  public static final TimeInterpolator a = new b();
  public static final TimeInterpolator b = new d.n.a.a.a();
  public static final TimeInterpolator c = new c();
  public static final TimeInterpolator d = new DecelerateInterpolator();
  
  static
  {
    new LinearInterpolator();
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */