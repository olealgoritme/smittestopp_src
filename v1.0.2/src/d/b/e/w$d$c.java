package d.b.e;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;

public class w$d$c
  implements PopupWindow.OnDismissListener
{
  public w$d$c(w.d paramd, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public void onDismiss()
  {
    ViewTreeObserver localViewTreeObserver = y.g0.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(x);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w.d.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */