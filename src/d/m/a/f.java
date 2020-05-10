package d.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import d.i.e.a;

public final class f
  extends AnimatorListenerAdapter
{
  public f(ViewGroup paramViewGroup, View paramView, Fragment paramFragment, f0.a parama, a parama1) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a.endViewTransition(b);
    paramAnimator = c.getAnimator();
    c.setAnimator(null);
    if ((paramAnimator != null) && (a.indexOfChild(b) < 0))
    {
      f0.a locala = d;
      paramAnimator = c;
      a locala1 = e;
      ((p.b)locala).a(paramAnimator, locala1);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */