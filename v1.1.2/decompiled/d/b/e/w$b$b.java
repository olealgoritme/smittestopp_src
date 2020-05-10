package d.b.e;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import d.i.i.n;

public class w$b$b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public w$b$b(w.b paramb) {}
  
  public void onGlobalLayout()
  {
    w.b localb = x;
    w localw = f0;
    if (localb != null)
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
        x.d();
        w.b.a(x);
      }
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.b.e.w.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */