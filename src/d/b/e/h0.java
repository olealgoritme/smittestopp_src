package d.b.e;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;
import d.b.d.i.p;

public abstract class h0
  implements View.OnTouchListener, View.OnAttachStateChangeListener
{
  public final View A;
  public Runnable B;
  public Runnable C;
  public boolean D;
  public int E;
  public final int[] F = new int[2];
  public final float x;
  public final int y;
  public final int z;
  
  public h0(View paramView)
  {
    A = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    x = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    int i = ViewConfiguration.getTapTimeout();
    y = i;
    z = ((ViewConfiguration.getLongPressTimeout() + i) / 2);
  }
  
  public final void a()
  {
    Runnable localRunnable = C;
    if (localRunnable != null) {
      A.removeCallbacks(localRunnable);
    }
    localRunnable = B;
    if (localRunnable != null) {
      A.removeCallbacks(localRunnable);
    }
  }
  
  public abstract p b();
  
  public abstract boolean c();
  
  public boolean d()
  {
    p localp = b();
    if ((localp != null) && (localp.a())) {
      localp.dismiss();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = D;
    boolean bool2 = false;
    boolean bool3;
    int i;
    if (bool1)
    {
      Object localObject = A;
      paramView = b();
      if ((paramView != null) && (paramView.a()))
      {
        paramView = (f0)paramView.g();
        if ((paramView != null) && (paramView.isShown()))
        {
          MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
          int[] arrayOfInt = F;
          ((View)localObject).getLocationOnScreen(arrayOfInt);
          localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
          localObject = F;
          paramView.getLocationOnScreen((int[])localObject);
          localMotionEvent.offsetLocation(-localObject[0], -localObject[1]);
          bool3 = paramView.a(localMotionEvent, E);
          localMotionEvent.recycle();
          i = paramMotionEvent.getActionMasked();
          if ((i != 1) && (i != 3)) {
            i = 1;
          } else {
            i = 0;
          }
          if ((bool3) && (i != 0))
          {
            i = 1;
            break label189;
          }
        }
      }
      i = 0;
      label189:
      if ((i == 0) && (d())) {
        bool3 = false;
      } else {
        bool3 = true;
      }
    }
    else
    {
      paramView = A;
      if (!paramView.isEnabled()) {}
      for (;;)
      {
        i = 0;
        break;
        i = paramMotionEvent.getActionMasked();
        if (i != 0)
        {
          if (i != 1) {
            if (i != 2)
            {
              if (i == 3) {}
            }
            else
            {
              i = paramMotionEvent.findPointerIndex(E);
              if (i < 0) {
                continue;
              }
              float f1 = paramMotionEvent.getX(i);
              float f2 = paramMotionEvent.getY(i);
              float f3 = x;
              float f4 = -f3;
              if ((f1 >= f4) && (f2 >= f4) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0) {
                continue;
              }
              a();
              paramView.getParent().requestDisallowInterceptTouchEvent(true);
              i = 1;
              break;
            }
          }
          a();
        }
        else
        {
          E = paramMotionEvent.getPointerId(0);
          if (B == null) {
            B = new h0.a(this);
          }
          paramView.postDelayed(B, y);
          if (C == null) {
            C = new h0.b(this);
          }
          paramView.postDelayed(C, z);
        }
      }
      boolean bool4;
      if ((i != 0) && (c())) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      bool3 = bool4;
      if (bool4)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        A.onTouchEvent(paramView);
        paramView.recycle();
        bool3 = bool4;
      }
    }
    D = bool3;
    if (!bool3)
    {
      bool3 = bool2;
      if (!bool1) {}
    }
    else
    {
      bool3 = true;
    }
    return bool3;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    D = false;
    E = -1;
    paramView = B;
    if (paramView != null) {
      A.removeCallbacks(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.h0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */