package e.c.a.b.j;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class c
{
  public final ArrayList<c.b> a = new ArrayList();
  public c.b b = null;
  public ValueAnimator c = null;
  public final Animator.AnimatorListener d = new c.a(this);
  
  public void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new c.b(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(d);
    a.add(paramArrayOfInt);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.j.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */