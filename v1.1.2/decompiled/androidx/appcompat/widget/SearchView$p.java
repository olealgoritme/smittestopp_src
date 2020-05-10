package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

public class SearchView$p
  extends TouchDelegate
{
  public final View a;
  public final Rect b;
  public final Rect c;
  public final Rect d;
  public final int e;
  public boolean f;
  
  public SearchView$p(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    b = new Rect();
    d = new Rect();
    c = new Rect();
    a(paramRect1, paramRect2);
    a = paramView;
  }
  
  public void a(Rect paramRect1, Rect paramRect2)
  {
    b.set(paramRect1);
    d.set(paramRect1);
    paramRect1 = d;
    int i = e;
    paramRect1.inset(-i, -i);
    c.set(paramRect2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    boolean bool1 = true;
    boolean bool2 = false;
    if (k != 0) {
      if ((k != 1) && (k != 2))
      {
        if (k != 3) {
          break label131;
        }
        bool1 = f;
        f = false;
      }
      else
      {
        bool3 = f;
        bool1 = bool3;
        if (bool3)
        {
          bool1 = bool3;
          if (!d.contains(i, j))
          {
            bool1 = bool3;
            k = 0;
            break label137;
          }
        }
      }
    }
    for (;;)
    {
      k = 1;
      break label137;
      if (!b.contains(i, j)) {
        break;
      }
      f = true;
    }
    label131:
    k = 1;
    bool1 = false;
    label137:
    boolean bool3 = bool2;
    if (bool1)
    {
      if ((k != 0) && (!c.contains(i, j)))
      {
        paramMotionEvent.setLocation(a.getWidth() / 2, a.getHeight() / 2);
      }
      else
      {
        Rect localRect = c;
        paramMotionEvent.setLocation(i - left, j - top);
      }
      bool3 = a.dispatchTouchEvent(paramMotionEvent);
    }
    return bool3;
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.SearchView.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */