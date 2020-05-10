package d.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.w;
import java.util.ArrayList;

public class f
  extends AnimatorListenerAdapter
{
  public f(k paramk, RecyclerView.w paramw, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    b.setListener(null);
    c.setAlpha(1.0F);
    d.a(a);
    d.q.remove(a);
    d.d();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (d != null) {
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.t.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */