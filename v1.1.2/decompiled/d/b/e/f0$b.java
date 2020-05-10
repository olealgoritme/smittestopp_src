package d.b.e;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class f0$b
  implements Runnable
{
  public f0$b(f0 paramf0) {}
  
  public void run()
  {
    f0 localf0 = x;
    localf0.a();
    View localView = A;
    if ((localView.isEnabled()) && (!localView.isLongClickable()) && (localf0.c()))
    {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      D = true;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.f0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */