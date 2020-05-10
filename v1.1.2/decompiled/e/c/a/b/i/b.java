package e.c.a.b.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.c.a.b.j.f;

public class b
  extends AnimatorListenerAdapter
{
  public boolean a;
  
  public b(e parame, boolean paramBoolean, e.d paramd) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = d;
    a = 0;
    b = null;
    if (!a)
    {
      paramAnimator = o;
      int i;
      if (b) {
        i = 8;
      } else {
        i = 4;
      }
      paramAnimator.a(i, b);
      paramAnimator = c;
      if (paramAnimator != null)
      {
        paramAnimator = (a)paramAnimator;
        throw null;
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    d.o.a(0, b);
    e locale = d;
    a = 1;
    b = paramAnimator;
    a = false;
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */