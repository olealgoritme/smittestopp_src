package d.b.e;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class h0$b
  implements Runnable
{
  public h0$b(h0 paramh0) {}
  
  public void run()
  {
    h0 localh0 = x;
    localh0.a();
    View localView = A;
    if ((localView.isEnabled()) && (!localView.isLongClickable()) && (localh0.c()))
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
 * Qualified Name:     base.d.b.e.h0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */