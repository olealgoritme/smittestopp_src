package e.c.a.b.i;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageButton;

public class d
  implements ViewTreeObserver.OnPreDrawListener
{
  public d(e parame) {}
  
  public boolean onPreDraw()
  {
    e locale = x;
    float f = o.getRotation();
    if (h != f) {
      h = f;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */