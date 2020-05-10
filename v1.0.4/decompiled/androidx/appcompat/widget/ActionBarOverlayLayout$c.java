package androidx.appcompat.widget;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;

public class ActionBarOverlayLayout$c
  implements Runnable
{
  public ActionBarOverlayLayout$c(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void run()
  {
    x.h();
    ActionBarOverlayLayout localActionBarOverlayLayout = x;
    T = A.animate().translationY(-x.A.getHeight()).setListener(x.U);
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.ActionBarOverlayLayout.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */