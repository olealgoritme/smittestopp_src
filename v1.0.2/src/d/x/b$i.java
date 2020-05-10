package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import d.i.i.n;

public class b$i
  extends AnimatorListenerAdapter
{
  public boolean a;
  
  public b$i(b paramb, View paramView, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!a)
    {
      n.a(b, c);
      v.a(b, d, e, f, g);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.x.b.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */