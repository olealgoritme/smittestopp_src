package d.b.e;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import d.i.i.n;

public class w$d$b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public w$d$b(w.d paramd) {}
  
  public void onGlobalLayout()
  {
    w.d locald = x;
    w localw = g0;
    if (locald != null)
    {
      int i;
      if ((n.s(localw)) && (localw.getGlobalVisibleRect(e0))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        x.dismiss();
      }
      else
      {
        x.h();
        w.d.a(x);
      }
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w.d.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */