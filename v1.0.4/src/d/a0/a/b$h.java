package d.a0.a;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import d.i.i.x.d;
import no.simula.corona.ui.onboarding.OnboardingActivity.b;

public class b$h
  extends d.i.i.a
{
  public b$h(b paramb) {}
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(b.class.getName());
    paramAccessibilityEvent.setScrollable(a());
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      paramView = d.B;
      if (paramView != null) {
        if ((OnboardingActivity.b)paramView != null)
        {
          paramAccessibilityEvent.setItemCount(4);
          paramAccessibilityEvent.setFromIndex(d.C);
          paramAccessibilityEvent.setToIndex(d.C);
        }
        else
        {
          throw null;
        }
      }
    }
  }
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    paramView = b.class.getName();
    a.setClassName(paramView);
    boolean bool = a();
    a.setScrollable(bool);
    if (d.canScrollHorizontally(1)) {
      a.addAction(4096);
    }
    if (d.canScrollHorizontally(-1)) {
      a.addAction(8192);
    }
  }
  
  public final boolean a()
  {
    a locala = d.B;
    boolean bool;
    if (locala != null)
    {
      if ((OnboardingActivity.b)locala != null) {
        bool = true;
      } else {
        throw null;
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    if (paramInt != 4096)
    {
      if (paramInt != 8192) {
        return false;
      }
      if (d.canScrollHorizontally(-1))
      {
        paramView = d;
        paramView.setCurrentItem(C - 1);
        return true;
      }
      return false;
    }
    if (d.canScrollHorizontally(1))
    {
      paramView = d;
      paramView.setCurrentItem(C + 1);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.a0.a.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */