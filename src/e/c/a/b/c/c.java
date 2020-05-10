package e.c.a.b.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

public class c
  extends AnimatorListenerAdapter
{
  public boolean a;
  
  public c(BottomAppBar paramBottomAppBar, ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!a) {
      BottomAppBar.a(e, b, c, d);
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */