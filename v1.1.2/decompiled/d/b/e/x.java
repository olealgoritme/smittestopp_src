package d.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R.styleable;
import d.b.a.s;
import d.i.b.b.g;
import d.i.j.b;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class x
{
  public final TextView a;
  public s0 b;
  public s0 c;
  public s0 d;
  public s0 e;
  public s0 f;
  public s0 g;
  public final z h;
  public int i = 0;
  public Typeface j;
  public boolean k;
  
  public x(TextView paramTextView)
  {
    a = paramTextView;
    h = new z(a);
  }
  
  public static s0 a(Context paramContext, j paramj, int paramInt)
  {
    paramContext = paramj.d(paramContext, paramInt);
    if (paramContext != null)
    {
      paramj = new s0();
      d = true;
      a = paramContext;
      return paramj;
    }
    return null;
  }
  
  public void a()
  {
    Drawable[] arrayOfDrawable;
    if ((b != null) || (c != null) || (d != null) || (e != null))
    {
      arrayOfDrawable = a.getCompoundDrawables();
      a(arrayOfDrawable[0], b);
      a(arrayOfDrawable[1], c);
      a(arrayOfDrawable[2], d);
      a(arrayOfDrawable[3], e);
    }
    if ((f != null) || (g != null))
    {
      arrayOfDrawable = a.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], f);
      a(arrayOfDrawable[2], g);
    }
  }
  
  public void a(int paramInt)
  {
    z localz = h;
    if (localz.d()) {
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          DisplayMetrics localDisplayMetrics = j.getResources().getDisplayMetrics();
          localz.a(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
          if (localz.b()) {
            localz.a();
          }
        }
        else
        {
          throw new IllegalArgumentException(a.a("Unknown auto-size text type: ", paramInt));
        }
      }
      else
      {
        a = 0;
        d = -1.0F;
        e = -1.0F;
        c = -1.0F;
        f = new int[0];
        b = false;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    z localz = h;
    if (localz.d())
    {
      DisplayMetrics localDisplayMetrics = j.getResources().getDisplayMetrics();
      localz.a(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (localz.b()) {
        localz.a();
      }
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    u0 localu0 = new u0(paramContext, paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance));
    if (localu0.e(R.styleable.TextAppearance_textAllCaps))
    {
      boolean bool = localu0.a(R.styleable.TextAppearance_textAllCaps, false);
      a.setAllCaps(bool);
    }
    if ((Build.VERSION.SDK_INT < 23) && (localu0.e(R.styleable.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localu0.a(R.styleable.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        a.setTextColor(localColorStateList);
      }
    }
    if ((localu0.e(R.styleable.TextAppearance_android_textSize)) && (localu0.c(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      a.setTextSize(0, 0.0F);
    }
    a(paramContext, localu0);
    b.recycle();
    paramContext = j;
    if (paramContext != null) {
      a.setTypeface(paramContext, i);
    }
  }
  
  public final void a(Context paramContext, u0 paramu0)
  {
    i = paramu0.d(R.styleable.TextAppearance_android_textStyle, i);
    boolean bool1 = paramu0.e(R.styleable.TextAppearance_android_fontFamily);
    boolean bool2 = true;
    int m;
    if ((!bool1) && (!paramu0.e(R.styleable.TextAppearance_fontFamily)))
    {
      if (paramu0.e(R.styleable.TextAppearance_android_typeface))
      {
        k = false;
        m = paramu0.d(R.styleable.TextAppearance_android_typeface, 1);
        if (m != 1)
        {
          if (m != 2)
          {
            if (m == 3) {
              j = Typeface.MONOSPACE;
            }
          }
          else {
            j = Typeface.SERIF;
          }
        }
        else {
          j = Typeface.SANS_SERIF;
        }
      }
      return;
    }
    j = null;
    if (paramu0.e(R.styleable.TextAppearance_fontFamily)) {
      m = R.styleable.TextAppearance_fontFamily;
    } else {
      m = R.styleable.TextAppearance_android_fontFamily;
    }
    if (!paramContext.isRestricted())
    {
      paramContext = new a(new WeakReference(a));
      try
      {
        paramContext = paramu0.a(m, i, paramContext);
        j = paramContext;
        if (paramContext != null) {
          bool2 = false;
        }
        k = bool2;
      }
      catch (UnsupportedOperationException|Resources.NotFoundException paramContext) {}
    }
    if (j == null)
    {
      paramContext = b.getString(m);
      if (paramContext != null) {
        j = Typeface.create(paramContext, i);
      }
    }
  }
  
  public final void a(Drawable paramDrawable, s0 params0)
  {
    if ((paramDrawable != null) && (params0 != null)) {
      j.a(paramDrawable, params0, a.getDrawableState());
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = a.getContext();
    Object localObject1 = j.a();
    Object localObject2 = u0.a(localContext, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int m = ((u0)localObject2).g(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (((u0)localObject2).e(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
      b = a(localContext, (j)localObject1, ((u0)localObject2).g(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((u0)localObject2).e(R.styleable.AppCompatTextHelper_android_drawableTop)) {
      c = a(localContext, (j)localObject1, ((u0)localObject2).g(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((u0)localObject2).e(R.styleable.AppCompatTextHelper_android_drawableRight)) {
      d = a(localContext, (j)localObject1, ((u0)localObject2).g(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((u0)localObject2).e(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
      e = a(localContext, (j)localObject1, ((u0)localObject2).g(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    }
    if (((u0)localObject2).e(R.styleable.AppCompatTextHelper_android_drawableStart)) {
      f = a(localContext, (j)localObject1, ((u0)localObject2).g(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
    }
    if (((u0)localObject2).e(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
      g = a(localContext, (j)localObject1, ((u0)localObject2).g(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
    }
    b.recycle();
    boolean bool1 = a.getTransformationMethod() instanceof PasswordTransformationMethod;
    localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    boolean bool2;
    if (m != -1)
    {
      localObject3 = new u0(localContext, localContext.obtainStyledAttributes(m, R.styleable.TextAppearance));
      if ((!bool1) && (((u0)localObject3).e(R.styleable.TextAppearance_textAllCaps)))
      {
        bool2 = ((u0)localObject3).a(R.styleable.TextAppearance_textAllCaps, false);
        m = 1;
      }
      else
      {
        bool2 = false;
        m = 0;
      }
      a(localContext, (u0)localObject3);
      if (Build.VERSION.SDK_INT < 23)
      {
        if (((u0)localObject3).e(R.styleable.TextAppearance_android_textColor)) {
          localObject2 = ((u0)localObject3).a(R.styleable.TextAppearance_android_textColor);
        } else {
          localObject2 = null;
        }
        if (((u0)localObject3).e(R.styleable.TextAppearance_android_textColorHint)) {
          localObject1 = ((u0)localObject3).a(R.styleable.TextAppearance_android_textColorHint);
        } else {
          localObject1 = null;
        }
        if (((u0)localObject3).e(R.styleable.TextAppearance_android_textColorLink)) {
          localObject4 = ((u0)localObject3).a(R.styleable.TextAppearance_android_textColorLink);
        }
      }
      else
      {
        localObject4 = null;
        localObject1 = localObject4;
      }
      b.recycle();
    }
    else
    {
      localObject4 = null;
      localObject1 = localObject4;
      bool2 = false;
      m = 0;
      localObject2 = localObject3;
    }
    u0 localu0 = new u0(localContext, localContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextAppearance, paramInt, 0));
    boolean bool3 = bool2;
    int n = m;
    if (!bool1)
    {
      bool3 = bool2;
      n = m;
      if (localu0.e(R.styleable.TextAppearance_textAllCaps))
      {
        bool3 = localu0.a(R.styleable.TextAppearance_textAllCaps, false);
        n = 1;
      }
    }
    Object localObject5 = localObject2;
    Object localObject6 = localObject4;
    localObject3 = localObject1;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localu0.e(R.styleable.TextAppearance_android_textColor)) {
        localObject2 = localu0.a(R.styleable.TextAppearance_android_textColor);
      }
      if (localu0.e(R.styleable.TextAppearance_android_textColorHint)) {
        localObject1 = localu0.a(R.styleable.TextAppearance_android_textColorHint);
      }
      localObject5 = localObject2;
      localObject6 = localObject4;
      localObject3 = localObject1;
      if (localu0.e(R.styleable.TextAppearance_android_textColorLink))
      {
        localObject6 = localu0.a(R.styleable.TextAppearance_android_textColorLink);
        localObject3 = localObject1;
        localObject5 = localObject2;
      }
    }
    if ((Build.VERSION.SDK_INT >= 28) && (localu0.e(R.styleable.TextAppearance_android_textSize)) && (localu0.c(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      a.setTextSize(0, 0.0F);
    }
    a(localContext, localu0);
    b.recycle();
    if (localObject5 != null) {
      a.setTextColor((ColorStateList)localObject5);
    }
    if (localObject3 != null) {
      a.setHintTextColor((ColorStateList)localObject3);
    }
    if (localObject6 != null) {
      a.setLinkTextColor((ColorStateList)localObject6);
    }
    if ((!bool1) && (n != 0)) {
      a.setAllCaps(bool3);
    }
    localObject1 = j;
    if (localObject1 != null) {
      a.setTypeface((Typeface)localObject1, i);
    }
    localObject1 = h;
    localObject4 = j.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    if (((TypedArray)localObject4).hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
      a = ((TypedArray)localObject4).getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    }
    float f1;
    if (((TypedArray)localObject4).hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = ((TypedArray)localObject4).getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    }
    float f2;
    if (((TypedArray)localObject4).hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = ((TypedArray)localObject4).getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    }
    float f3;
    if (((TypedArray)localObject4).hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = ((TypedArray)localObject4).getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    }
    if (((TypedArray)localObject4).hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes))
    {
      paramInt = ((TypedArray)localObject4).getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
      if (paramInt > 0)
      {
        localObject3 = ((TypedArray)localObject4).getResources().obtainTypedArray(paramInt);
        m = ((TypedArray)localObject3).length();
        localObject2 = new int[m];
        if (m > 0)
        {
          for (paramInt = 0; paramInt < m; paramInt++) {
            localObject2[paramInt] = ((TypedArray)localObject3).getDimensionPixelSize(paramInt, -1);
          }
          f = ((z)localObject1).a((int[])localObject2);
          ((z)localObject1).c();
        }
        ((TypedArray)localObject3).recycle();
      }
    }
    ((TypedArray)localObject4).recycle();
    if (((z)localObject1).d())
    {
      if (a == 1)
      {
        if (!g)
        {
          localObject2 = j.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject2);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject2);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          ((z)localObject1).a(f4, f2, f3);
        }
        ((z)localObject1).b();
      }
    }
    else {
      a = 0;
    }
    if (b.a)
    {
      localObject1 = h;
      if (a != 0)
      {
        localObject1 = f;
        if (localObject1.length > 0) {
          if (a.getAutoSizeStepGranularity() != -1.0F) {
            a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(h.d), Math.round(h.e), Math.round(h.c), 0);
          } else {
            a.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
          }
        }
      }
    }
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView);
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
    n = paramAttributeSet.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
    m = paramAttributeSet.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
    paramAttributeSet.recycle();
    if (paramInt != -1) {
      s.a(a, paramInt);
    }
    if (n != -1) {
      s.b(a, n);
    }
    if (m != -1) {
      s.c(a, m);
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    z localz = h;
    if (localz.d())
    {
      int m = paramArrayOfInt.length;
      int n = 0;
      if (m > 0)
      {
        int[] arrayOfInt = new int[m];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, m);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = j.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (n >= m) {
              break;
            }
            arrayOfInt[n] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[n], localDisplayMetrics));
            n++;
          }
        }
        f = localz.a((int[])localObject);
        if (!localz.c())
        {
          localObject = a.a("None of the preset sizes is valid: ");
          ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        g = false;
      }
      if (localz.b()) {
        localz.a();
      }
    }
  }
  
  public boolean b()
  {
    z localz = h;
    boolean bool;
    if ((localz.d()) && (a != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public class a
    extends g
  {
    public a(WeakReference paramWeakReference) {}
    
    public void a(Typeface paramTypeface)
    {
      x localx = x.this;
      Object localObject = a;
      if (k)
      {
        j = paramTypeface;
        localObject = (TextView)((WeakReference)localObject).get();
        if (localObject != null) {
          ((TextView)localObject).setTypeface(paramTypeface, i);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */