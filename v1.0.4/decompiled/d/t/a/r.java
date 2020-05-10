package d.t.a;

import android.graphics.Rect;
import android.view.View;

public abstract class r
{
  public final s.k a;
  public int b;
  public final Rect c;
  
  public static r a(s.k paramk, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return new q(paramk);
      }
      throw new IllegalArgumentException("invalid orientation");
    }
    return new p(paramk);
  }
  
  public abstract int a();
  
  public abstract int a(View paramView);
  
  public abstract int b();
  
  public abstract int b(View paramView);
  
  public abstract int c();
}

/* Location:
 * Qualified Name:     base.d.t.a.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */