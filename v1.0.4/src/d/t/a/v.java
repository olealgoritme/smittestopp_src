package d.t.a;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import d.i.i.a;
import d.i.i.x.d;

public class v
  extends a
{
  public final s d;
  public final a e;
  
  public v(s params)
  {
    d = params;
    e = new v.a(this);
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(s.class.getName());
    if (((paramView instanceof s)) && (!a()))
    {
      paramView = (s)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().a(paramAccessibilityEvent);
      }
    }
  }
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    paramView = s.class.getName();
    a.setClassName(paramView);
    if ((!a()) && (d.getLayoutManager() != null))
    {
      paramView = d.getLayoutManager();
      s locals = b;
      s.q localq = y;
      s.u localu = C0;
      if ((locals.canScrollVertically(-1)) || (b.canScrollHorizontally(-1)))
      {
        a.addAction(8192);
        a.setScrollable(true);
      }
      if ((b.canScrollVertically(1)) || (b.canScrollHorizontally(1)))
      {
        a.addAction(4096);
        a.setScrollable(true);
      }
      paramView = AccessibilityNodeInfo.CollectionInfo.obtain(paramView.b(localq, localu), paramView.a(localq, localu), false, 0);
      a.setCollectionInfo(paramView);
    }
  }
  
  public boolean a()
  {
    return d.i();
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool1 = super.a(paramView, paramInt, paramBundle);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    if ((!a()) && (d.getLayoutManager() != null))
    {
      paramBundle = d.getLayoutManager();
      paramView = b;
      s.q localq = y;
      int j;
      if (paramInt != 4096)
      {
        if (paramInt != 8192)
        {
          i = 0;
          paramInt = 0;
          break label207;
        }
        if (paramView.canScrollVertically(-1)) {
          paramInt = -(p - paramBundle.i() - paramBundle.f());
        } else {
          paramInt = 0;
        }
        j = paramInt;
        if (b.canScrollHorizontally(-1))
        {
          i = -(o - paramBundle.g() - paramBundle.h());
          break label207;
        }
      }
      else
      {
        if (paramView.canScrollVertically(1)) {
          paramInt = p - paramBundle.i() - paramBundle.f();
        } else {
          paramInt = 0;
        }
        j = paramInt;
        if (b.canScrollHorizontally(1))
        {
          i = o - paramBundle.g() - paramBundle.h();
          break label207;
        }
      }
      int i = 0;
      paramInt = j;
      label207:
      if ((paramInt == 0) && (i == 0)) {
        bool2 = false;
      } else {
        b.c(i, paramInt);
      }
      return bool2;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */