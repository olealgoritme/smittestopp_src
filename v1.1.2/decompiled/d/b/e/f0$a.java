package d.b.e;

import android.view.View;
import android.view.ViewParent;

public class f0$a
  implements Runnable
{
  public f0$a(f0 paramf0) {}
  
  public void run()
  {
    ViewParent localViewParent = x.A.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.f0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */