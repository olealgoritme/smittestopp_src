package d.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import d.b.a.r;
import d.i.c.c;
import d.i.g.a.a;
import d.i.j.b;

public class z
  extends TextView
  implements d.i.j.e, b
{
  public Future<d.i.g.a> A;
  public final e x;
  public final y y;
  public final x z;
  
  public z(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public z(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public z(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new e(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    paramContext = new y(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    y.a();
    z = new x(this);
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
  
  public ColorStateList getSupportCompoundDrawablesTintList()
  {
    Object localObject = y.h;
    if (localObject != null) {
      localObject = a;
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportCompoundDrawablesTintMode()
  {
    Object localObject = y.h;
    if (localObject != null) {
      localObject = b;
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public CharSequence getText()
  {
    Future localFuture = A;
    if (localFuture != null) {}
    try
    {
      A = null;
      r.a(this, (d.i.g.a)localFuture.get());
      return super.getText();
    }
    catch (InterruptedException|ExecutionException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public TextClassifier getTextClassifier()
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      x localx = z;
      if (localx != null) {
        return localx.a();
      }
    }
    return super.getTextClassifier();
  }
  
  public a.a getTextMetricsParamsCompat()
  {
    return r.a(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    r.a(localInputConnection, paramEditorInfo, this);
    return localInputConnection;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    y localy = y;
    if ((localy != null) && (!b.a)) {
      i.a();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Future localFuture = A;
    if (localFuture != null) {}
    try
    {
      A = null;
      r.a(this, (d.i.g.a)localFuture.get());
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
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = y;
    if (paramDrawable1 != null) {
      paramDrawable1.a();
    }
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = y;
    if (paramDrawable1 != null) {
      paramDrawable1.a();
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Context localContext = getContext();
    Drawable localDrawable1 = null;
    if (paramInt1 != 0) {
      localObject = d.b.b.a.a.c(localContext, paramInt1);
    } else {
      localObject = null;
    }
    Drawable localDrawable2;
    if (paramInt2 != 0) {
      localDrawable2 = d.b.b.a.a.c(localContext, paramInt2);
    } else {
      localDrawable2 = null;
    }
    Drawable localDrawable3;
    if (paramInt3 != 0) {
      localDrawable3 = d.b.b.a.a.c(localContext, paramInt3);
    } else {
      localDrawable3 = null;
    }
    if (paramInt4 != 0) {
      localDrawable1 = d.b.b.a.a.c(localContext, paramInt4);
    }
    setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)localObject, localDrawable2, localDrawable3, localDrawable1);
    Object localObject = y;
    if (localObject != null) {
      ((y)localObject).a();
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = y;
    if (paramDrawable1 != null) {
      paramDrawable1.a();
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Context localContext = getContext();
    Drawable localDrawable1 = null;
    if (paramInt1 != 0) {
      localObject = d.b.b.a.a.c(localContext, paramInt1);
    } else {
      localObject = null;
    }
    Drawable localDrawable2;
    if (paramInt2 != 0) {
      localDrawable2 = d.b.b.a.a.c(localContext, paramInt2);
    } else {
      localDrawable2 = null;
    }
    Drawable localDrawable3;
    if (paramInt3 != 0) {
      localDrawable3 = d.b.b.a.a.c(localContext, paramInt3);
    } else {
      localDrawable3 = null;
    }
    if (paramInt4 != 0) {
      localDrawable1 = d.b.b.a.a.c(localContext, paramInt4);
    }
    setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, localDrawable2, localDrawable3, localDrawable1);
    Object localObject = y;
    if (localObject != null) {
      ((y)localObject).a();
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = y;
    if (paramDrawable1 != null) {
      paramDrawable1.a();
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(r.a(this, paramCallback));
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setFirstBaselineToTopHeight(paramInt);
    } else {
      r.a(this, paramInt);
    }
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setLastBaselineToBottomHeight(paramInt);
    } else {
      r.b(this, paramInt);
    }
  }
  
  public void setLineHeight(int paramInt)
  {
    r.c(this, paramInt);
  }
  
  public void setPrecomputedText(d.i.g.a parama)
  {
    r.a(this, parama);
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
  
  public void setSupportCompoundDrawablesTintList(ColorStateList paramColorStateList)
  {
    y localy = y;
    if (h == null) {
      h = new v0();
    }
    v0 localv0 = h;
    a = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    d = bool;
    paramColorStateList = h;
    b = paramColorStateList;
    c = paramColorStateList;
    d = paramColorStateList;
    e = paramColorStateList;
    f = paramColorStateList;
    g = paramColorStateList;
    y.a();
  }
  
  public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode paramMode)
  {
    y localy = y;
    if (h == null) {
      h = new v0();
    }
    v0 localv0 = h;
    b = paramMode;
    boolean bool;
    if (paramMode != null) {
      bool = true;
    } else {
      bool = false;
    }
    c = bool;
    paramMode = h;
    b = paramMode;
    c = paramMode;
    d = paramMode;
    e = paramMode;
    f = paramMode;
    g = paramMode;
    y.a();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    y localy = y;
    if (localy != null) {
      localy.a(paramContext, paramInt);
    }
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      x localx = z;
      if (localx != null)
      {
        b = paramTextClassifier;
        return;
      }
    }
    super.setTextClassifier(paramTextClassifier);
  }
  
  public void setTextFuture(Future<d.i.g.a> paramFuture)
  {
    A = paramFuture;
    if (paramFuture != null) {
      requestLayout();
    }
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
      y localy = y;
      if ((localy != null) && (!bool) && (!localy.b())) {
        i.a(paramInt, paramFloat);
      }
    }
  }
  
  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    Typeface localTypeface;
    if ((paramTypeface != null) && (paramInt > 0)) {
      localTypeface = c.a(getContext(), paramTypeface, paramInt);
    } else {
      localTypeface = null;
    }
    if (localTypeface != null) {
      paramTypeface = localTypeface;
    }
    super.setTypeface(paramTypeface, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */