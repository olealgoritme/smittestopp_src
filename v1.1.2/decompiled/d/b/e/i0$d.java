package d.b.e;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

public class i0$d
  implements View.OnTouchListener
{
  public i0$d(i0 parami0) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      paramView = x.Y;
      if ((paramView != null) && (paramView.isShowing()) && (j >= 0) && (j < x.Y.getWidth()) && (k >= 0) && (k < x.Y.getHeight()))
      {
        paramView = x;
        U.postDelayed(Q, 250L);
        break label126;
      }
    }
    if (i == 1)
    {
      paramView = x;
      U.removeCallbacks(Q);
    }
    label126:
    return false;
  }
}

/* Location:
 * Qualified Name:     d.b.e.i0.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */