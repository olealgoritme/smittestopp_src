package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import d.b.a.s;

public class b0$a
  extends AnimatorListenerAdapter
  implements h.d
{
  public final View a;
  public final int b;
  public final ViewGroup c;
  public final boolean d;
  public boolean e;
  public boolean f = false;
  
  public b0$a(View paramView, int paramInt, boolean paramBoolean)
  {
    a = paramView;
    b = paramInt;
    c = ((ViewGroup)paramView.getParent());
    d = paramBoolean;
    a(true);
  }
  
  public final void a()
  {
    if (!f)
    {
      v.a(a, b);
      ViewGroup localViewGroup = c;
      if (localViewGroup != null) {
        localViewGroup.invalidate();
      }
    }
    a(false);
  }
  
  public void a(h paramh) {}
  
  public final void a(boolean paramBoolean)
  {
    if ((d) && (e != paramBoolean))
    {
      ViewGroup localViewGroup = c;
      if (localViewGroup != null)
      {
        e = paramBoolean;
        s.a(localViewGroup, paramBoolean);
      }
    }
  }
  
  public void b(h paramh)
  {
    a(false);
  }
  
  public void c(h paramh)
  {
    a(true);
  }
  
  public void d(h paramh)
  {
    a();
    paramh.b(this);
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    f = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a();
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    if (!f) {
      v.a(a, b);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationResume(Animator paramAnimator)
  {
    if (!f) {
      v.a(a, 0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}

/* Location:
 * Qualified Name:     d.x.b0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */