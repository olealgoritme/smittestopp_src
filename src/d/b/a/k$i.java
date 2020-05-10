package d.b.a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.appcompat.widget.ContentFrameLayout;

import d.b.b.a.a;

public class k$i
  extends ContentFrameLayout
{
  public k$i(k paramk, Context paramContext)
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
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
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
 * Qualified Name:     base.d.b.a.k.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */