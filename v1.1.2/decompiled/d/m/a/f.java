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
  public f(ViewGroup paramViewGroup, View paramView, Fragment paramFragment, e0.a parama, a parama1) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a.endViewTransition(b);
    paramAnimator = c.getAnimator();
    c.setAnimator(null);
    if ((paramAnimator != null) && (a.indexOfChild(b) < 0))
    {
      paramAnimator = d;
      Fragment localFragment = c;
      a locala = e;
      ((p.b)paramAnimator).a(localFragment, locala);
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */