package d.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class q
  extends AnimatorListenerAdapter
{
  public q(p paramp, ViewGroup paramViewGroup, View paramView, Fragment paramFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a.endViewTransition(b);
    paramAnimator.removeListener(this);
    paramAnimator = c;
    View localView = mView;
    if ((localView != null) && (mHidden)) {
      localView.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */