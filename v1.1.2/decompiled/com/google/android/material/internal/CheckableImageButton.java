package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R.attr;
import d.b.e.l;
import d.i.i.a;
import d.i.i.n;
import d.i.i.x.d;

public class CheckableImageButton
  extends l
  implements Checkable
{
  public static final int[] A = { 16842912 };
  public boolean z;
  
  public CheckableImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n.a(this, new a());
  }
  
  public boolean isChecked()
  {
    return z;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (z) {
      return ImageButton.mergeDrawableStates(super.onCreateDrawableState(paramInt + A.length), A);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (z != paramBoolean)
    {
      z = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void toggle()
  {
    setChecked(z ^ true);
  }
  
  public class a
    extends a
  {
    public a() {}
    
    public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setChecked(z);
    }
    
    public void a(View paramView, d paramd)
    {
      a.onInitializeAccessibilityNodeInfo(paramView, a);
      a.setCheckable(true);
      boolean bool = z;
      a.setChecked(bool);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */