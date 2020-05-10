package com.google.android.material.internal;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import d.i.i.a;
import d.i.i.x.d;

public class NavigationMenuItemView$a
  extends a
{
  public NavigationMenuItemView$a(NavigationMenuItemView paramNavigationMenuItemView) {}
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    boolean bool = d.U;
    a.setCheckable(bool);
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.internal.NavigationMenuItemView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */