package no.simula.corona.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import d.a0.a.b;
import h.k.b.g;

public final class NonSlidingViewPager
  extends b
{
  public NonSlidingViewPager(Context paramContext) {}
  
  public NonSlidingViewPager(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      return false;
    }
    g.a("event");
    throw null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      return false;
    }
    g.a("event");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.widgets.NonSlidingViewPager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */