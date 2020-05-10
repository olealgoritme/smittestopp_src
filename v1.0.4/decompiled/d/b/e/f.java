package d.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

import d.b.a.r;
import d.i.j.b;

public class f
  extends Button
  implements b
{
  public final e x;
  public final y y;
  
  public f(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new e(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    paramContext = new y(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    y.a();
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = x;
    if (localObject != null) {
      ((e)localObject).a();
    }
    localObject = y;
    if (localObject != null) {
      ((y)localObject).a();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (b.a) {
      return super.getAutoSizeMaxTextSize();
    }
    y localy = y;
    if (localy != null) {
      return Math.round(i.e);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (b.a) {
      return super.getAutoSizeMinTextSize();
    }
    y localy = y;
    if (localy != null) {
      return Math.round(i.d);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (b.a) {
      return super.getAutoSizeStepGranularity();
    }
    y localy = y;
    if (localy != null) {
      return Math.round(i.c);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (b.a) {
      return super.getAutoSizeTextAvailableSizes();
    }
    y localy = y;
    if (localy != null) {
      return i.f;
    }
    return new int[0];
  }
  
  @SuppressLint({"WrongConstant"})
  public int getAutoSizeTextType()
  {
    boolean bool = b.a;
    int i = 0;
    if (bool)
    {
      if (super.getAutoSizeTextType() == 1) {
        i = 1;
      }
      return i;
    }
    y localy = y;
    if (localy != null) {
      return i.a;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).b();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).c();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    y localy = y;
    if ((localy != null) && (!b.a)) {
      i.a();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence = y;
    if ((paramCharSequence != null) && (!b.a) && (paramCharSequence.b())) {
      y.i.a();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (b.a)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    else
    {
      y localy = y;
      if (localy != null) {
        localy.a(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (b.a)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    else
    {
      y localy = y;
      if (localy != null) {
        localy.a(paramArrayOfInt, paramInt);
      }
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (b.a)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    else
    {
      y localy = y;
      if (localy != null) {
        localy.a(paramInt);
      }
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = x;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    e locale = x;
    if (locale != null) {
      locale.a(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(r.a(this, paramCallback));
  }
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    y localy = y;
    if (localy != null) {
      a.setAllCaps(paramBoolean);
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    e locale = x;
    if (locale != null) {
      locale.b(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    e locale = x;
    if (locale != null) {
      locale.a(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    y localy = y;
    if (localy != null) {
      localy.a(paramContext, paramInt);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    boolean bool = b.a;
    if (bool)
    {
      super.setTextSize(paramInt, paramFloat);
    }
    else
    {
      y localy = y;
      if ((localy != null) && (!bool) && (!localy.b())) {
        i.a(paramInt, paramFloat);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */