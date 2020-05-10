package d.m.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.fragment.app.Fragment;
import d.i.e.a;

public final class e
  implements Animation.AnimationListener
{
  public e(ViewGroup paramViewGroup, Fragment paramFragment, f0.a parama, a parama1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    a.post(new e.a(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     base.d.m.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */