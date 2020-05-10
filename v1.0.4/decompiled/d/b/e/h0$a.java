package d.b.e;

import android.view.View;
import android.view.ViewParent;

public class h0$a
  implements Runnable
{
  public h0$a(h0 paramh0) {}
  
  public void run()
  {
    ViewParent localViewParent = x.A.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.h0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */