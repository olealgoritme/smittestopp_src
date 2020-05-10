package androidx.core.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import d.i.i.a;
import d.i.i.x.d;
import d.i.i.x.d.a;

public class NestedScrollView$a
  extends a
{
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    boolean bool;
    if (paramView.getScrollRange() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityEvent.setScrollable(bool);
    paramAccessibilityEvent.setScrollX(paramView.getScrollX());
    paramAccessibilityEvent.setScrollY(paramView.getScrollY());
    paramAccessibilityEvent.setMaxScrollX(paramView.getScrollX());
    paramAccessibilityEvent.setMaxScrollY(paramView.getScrollRange());
  }
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    NestedScrollView localNestedScrollView = (NestedScrollView)paramView;
    paramView = ScrollView.class.getName();
    a.setClassName(paramView);
    if (localNestedScrollView.isEnabled())
    {
      int i = localNestedScrollView.getScrollRange();
      if (i > 0)
      {
        a.setScrollable(true);
        if (localNestedScrollView.getScrollY() > 0)
        {
          paramd.a(d.a.e);
          paramd.a(d.a.f);
        }
        if (localNestedScrollView.getScrollY() < i)
        {
          paramd.a(d.a.d);
          paramd.a(d.a.g);
        }
      }
    }
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    paramView = (NestedScrollView)paramView;
    if (!paramView.isEnabled()) {
      return false;
    }
    if (paramInt != 4096) {
      if ((paramInt != 8192) && (paramInt != 16908344))
      {
        if (paramInt != 16908346) {
          return false;
        }
      }
      else
      {
        i = paramView.getHeight();
        paramInt = paramView.getPaddingBottom();
        j = paramView.getPaddingTop();
        paramInt = Math.max(paramView.getScrollY() - (i - paramInt - j), 0);
        if (paramInt != paramView.getScrollY())
        {
          paramView.a(0 - paramView.getScrollX(), paramInt - paramView.getScrollY(), true);
          return true;
        }
        return false;
      }
    }
    int i = paramView.getHeight();
    int j = paramView.getPaddingBottom();
    paramInt = paramView.getPaddingTop();
    paramInt = Math.min(paramView.getScrollY() + (i - j - paramInt), paramView.getScrollRange());
    if (paramInt != paramView.getScrollY())
    {
      paramView.a(0 - paramView.getScrollX(), paramInt - paramView.getScrollY(), true);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.androidx.core.widget.NestedScrollView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */