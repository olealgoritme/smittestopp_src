package d.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.h;
import java.util.ArrayList;

public class j
  extends AnimatorListenerAdapter
{
  public j(k paramk, k.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    b.setListener(null);
    c.setAlpha(1.0F);
    c.setTranslationX(0.0F);
    c.setTranslationY(0.0F);
    d.a(a.b);
    d.r.remove(a.b);
    d.d();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    k localk = d;
    paramAnimator = a.b;
    if (localk != null) {
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.t.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */