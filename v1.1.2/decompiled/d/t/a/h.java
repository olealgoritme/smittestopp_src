package d.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.w;
import java.util.ArrayList;

public class h
  extends AnimatorListenerAdapter
{
  public h(k paramk, RecyclerView.w paramw, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (b != 0) {
      c.setTranslationX(0.0F);
    }
    if (d != 0) {
      c.setTranslationY(0.0F);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    e.setListener(null);
    f.a(a);
    f.p.remove(a);
    f.d();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (f != null) {
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.t.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */