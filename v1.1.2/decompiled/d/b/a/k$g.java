package d.b.a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ContentFrameLayout;
import d.b.b.a.a;

public class k$g
  extends ContentFrameLayout
{
  public k$g(k paramk, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((!F.a(paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((i >= -5) && (j >= -5) && (i <= getWidth() + 5) && (j <= getHeight() + 5)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        paramMotionEvent = F;
        paramMotionEvent.a(paramMotionEvent.d(0), true);
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    setBackgroundDrawable(a.c(getContext(), paramInt));
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */