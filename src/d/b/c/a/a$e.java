package d.b.c.a;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

public class a$e
  extends a.g
{
  public final ObjectAnimator a;
  public final boolean b;
  
  public a$e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(null);
    int i = paramAnimationDrawable.getNumberOfFrames();
    int j;
    if (paramBoolean1) {
      j = i - 1;
    } else {
      j = 0;
    }
    if (paramBoolean1) {
      i = 0;
    } else {
      i--;
    }
    a.f localf = new a.f(paramAnimationDrawable, paramBoolean1);
    paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { j, i });
    paramAnimationDrawable.setAutoCancel(true);
    paramAnimationDrawable.setDuration(c);
    paramAnimationDrawable.setInterpolator(localf);
    b = paramBoolean2;
    a = paramAnimationDrawable;
  }
  
  public boolean a()
  {
    return b;
  }
  
  public void b()
  {
    a.reverse();
  }
  
  public void c()
  {
    a.start();
  }
  
  public void d()
  {
    a.cancel();
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */