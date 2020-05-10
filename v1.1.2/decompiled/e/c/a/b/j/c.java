package e.c.a.b.j;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class c
{
  public final ArrayList<b> a = new ArrayList();
  public b b = null;
  public ValueAnimator c = null;
  public final Animator.AnimatorListener d = new a();
  
  public void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new b(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(d);
    a.add(paramArrayOfInt);
  }
  
  public class a
    extends AnimatorListenerAdapter
  {
    public a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      c localc = c.this;
      if (c == paramAnimator) {
        c = null;
      }
    }
  }
  
  public static class b
  {
    public final int[] a;
    public final ValueAnimator b;
    
    public b(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      a = paramArrayOfInt;
      b = paramValueAnimator;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.j.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */