package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import d.b.a.s;
import d.i.g.a;
import d.i.g.a.a;
import d.i.j.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class y
  extends TextView
  implements b
{
  public final e x;
  public final x y;
  public Future<a> z;
  
  public y(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public y(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new e(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    paramContext = new x(this);
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
      ((x)localObject).a();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (b.a) {
      return super.getAutoSizeMaxTextSize();
    }
    x localx = y;
    if (localx != null) {
      return Math.round(h.e);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (b.a) {
      return super.getAutoSizeMinTextSize();
    }
    x localx = y;
    if (localx != null) {
      return Math.round(h.d);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (b.a) {
      return super.getAutoSizeStepGranularity();
    }
    x localx = y;
    if (localx != null) {
      return Math.round(h.c);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (b.a) {
      return super.getAutoSizeTextAvailableSizes();
    }
    x localx = y;
    if (localx != null) {
      return h.f;
    }
    return new int[0];
  }
  
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
    x localx = y;
    if (localx != null) {
      return h.a;
    }
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return getPaddingTop() - getPaintgetFontMetricsInttop;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return getPaddingBottom() + getPaintgetFontMetricsIntbottom;
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
  
  public CharSequence getText()
  {
    Future localFuture = z;
    if (localFuture != null) {}
    try
    {
      z = null;
      s.a(this, (a)localFuture.get());
      return super.getText();
    }
    catch (InterruptedException|ExecutionException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public a.a getTextMetricsParamsCompat()
  {
    return s.a(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    s.a(localInputConnection, paramEditorInfo, this);
    return localInputConnection;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    x localx = y;
    if ((localx != null) && (!b.a)) {
      h.a();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Future localFuture = z;
    if (localFuture != null) {}
    try
    {
      z = null;
      s.a(this, (a)localFuture.get());
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (InterruptedException|ExecutionException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence = y;
    if ((paramCharSequence != null) && (!b.a) && (paramCharSequence.b())) {
      y.h.a();
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
      x localx = y;
      if (localx != null) {
        localx.a(paramInt1, paramInt2, paramInt3, paramInt4);
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
      x localx = y;
      if (localx != null) {
        localx.a(paramArrayOfInt, paramInt);
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
      x localx = y;
      if (localx != null) {
        localx.a(paramInt);
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
    super.setCustomSelectionActionModeCallback(s.a(this, paramCallback));
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setFirstBaselineToTopHeight(paramInt);
    } else {
      s.a(this, paramInt);
    }
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setLastBaselineToBottomHeight(paramInt);
    } else {
      s.b(this, paramInt);
    }
  }
  
  public void setLineHeight(int paramInt)
  {
    s.c(this, paramInt);
  }
  
  public void setPrecomputedText(a parama)
  {
    s.a(this, parama);
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
    x localx = y;
    if (localx != null) {
      localx.a(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future<a> paramFuture)
  {
    z = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(a.a parama)
  {
    TextDirectionHeuristic localTextDirectionHeuristic1 = b;
    TextDirectionHeuristic localTextDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
    int i = 1;
    if ((localTextDirectionHeuristic1 != localTextDirectionHeuristic2) && (localTextDirectionHeuristic1 != TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
      if (localTextDirectionHeuristic1 == TextDirectionHeuristics.ANYRTL_LTR) {
        i = 2;
      } else if (localTextDirectionHeuristic1 == TextDirectionHeuristics.LTR) {
        i = 3;
      } else if (localTextDirectionHeuristic1 == TextDirectionHeuristics.RTL) {
        i = 4;
      } else if (localTextDirectionHeuristic1 == TextDirectionHeuristics.LOCALE) {
        i = 5;
      } else if (localTextDirectionHeuristic1 == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
        i = 6;
      } else if (localTextDirectionHeuristic1 == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
        i = 7;
      }
    }
    setTextDirection(i);
    if (Build.VERSION.SDK_INT < 23)
    {
      float f = a.getTextScaleX();
      getPaint().set(a);
      if (f == getTextScaleX()) {
        setTextScaleX(f / 2.0F + 1.0F);
      }
      setTextScaleX(f);
    }
    else
    {
      getPaint().set(a);
      setBreakStrategy(c);
      setHyphenationFrequency(d);
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
      x localx = y;
      if ((localx != null) && (!bool) && (!localx.b())) {
        h.a(paramInt, paramFloat);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */