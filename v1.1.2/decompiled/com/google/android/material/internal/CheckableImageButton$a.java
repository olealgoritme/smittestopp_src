package com.google.android.material.internal;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import d.i.i.a;
import d.i.i.x.d;

public class CheckableImageButton$a
  extends a
{
  public CheckableImageButton$a(CheckableImageButton paramCheckableImageButton) {}
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setChecked(d.z);
  }
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    a.setCheckable(true);
    boolean bool = d.z;
    a.setChecked(bool);
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */