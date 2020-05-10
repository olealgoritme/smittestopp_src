package androidx.appcompat.widget;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;

public class ActionBarOverlayLayout$b
  implements Runnable
{
  public ActionBarOverlayLayout$b(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void run()
  {
    x.h();
    ActionBarOverlayLayout localActionBarOverlayLayout = x;
    T = A.animate().translationY(0.0F).setListener(x.U);
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.ActionBarOverlayLayout.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */