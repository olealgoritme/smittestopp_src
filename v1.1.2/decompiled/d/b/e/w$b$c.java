package d.b.e;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;

public class w$b$c
  implements PopupWindow.OnDismissListener
{
  public w$b$c(w.b paramb, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public void onDismiss()
  {
    ViewTreeObserver localViewTreeObserver = y.f0.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(x);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.w.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */