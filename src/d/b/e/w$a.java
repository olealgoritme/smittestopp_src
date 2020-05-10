package d.b.e;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Spinner;

public class w$a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public w$a(w paramw) {}
  
  public void onGlobalLayout()
  {
    if (!x.getInternalPopup().a()) {
      x.a();
    }
    ViewTreeObserver localViewTreeObserver = x.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeOnGlobalLayoutListener(this);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */