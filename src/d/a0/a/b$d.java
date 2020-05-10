package d.a0.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import d.i.i.k;
import d.i.i.n;
import d.i.i.w;

public class b$d
  implements k
{
  public final Rect a = new Rect();
  
  public b$d(b paramb) {}
  
  public w a(View paramView, w paramw)
  {
    w localw = n.a(paramView, paramw);
    if (localw.e()) {
      return localw;
    }
    Rect localRect = a;
    left = localw.b();
    top = localw.d();
    right = localw.c();
    bottom = localw.a();
    int i = 0;
    int j = b.getChildCount();
    while (i < j)
    {
      paramView = b.getChildAt(i);
      paramw = (WindowInsets)a;
      WindowInsets localWindowInsets = paramView.dispatchApplyWindowInsets(paramw);
      paramView = paramw;
      if (!localWindowInsets.equals(paramw)) {
        paramView = new WindowInsets(localWindowInsets);
      }
      paramView = w.a(paramView);
      left = Math.min(paramView.b(), left);
      top = Math.min(paramView.d(), top);
      right = Math.min(paramView.c(), right);
      bottom = Math.min(paramView.a(), bottom);
      i++;
    }
    int k = left;
    int m = top;
    j = right;
    i = bottom;
    return new w(((WindowInsets)a).replaceSystemWindowInsets(k, m, j, i));
  }
}

/* Location:
 * Qualified Name:     base.d.a0.a.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */