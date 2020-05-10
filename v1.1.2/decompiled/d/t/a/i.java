package d.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.w;
import java.util.ArrayList;

public class i
  extends AnimatorListenerAdapter
{
  public i(k paramk, k.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    b.setListener(null);
    c.setAlpha(1.0F);
    c.setTranslationX(0.0F);
    c.setTranslationY(0.0F);
    d.a(a.a);
    d.r.remove(a.a);
    d.d();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = d;
    RecyclerView.w localw = a.a;
    if (paramAnimator != null) {
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.t.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */