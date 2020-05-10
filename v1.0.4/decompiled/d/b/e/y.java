package d.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.appcompat.R.styleable;

import java.util.Arrays;
import java.util.Locale;

import d.b.a.r;
import d.i.j.e;

public class y
{
  public final TextView a;
  public v0 b;
  public v0 c;
  public v0 d;
  public v0 e;
  public v0 f;
  public v0 g;
  public v0 h;
  public final a0 i;
  public int j = 0;
  public int k = -1;
  public Typeface l;
  public boolean m;
  
  public y(TextView paramTextView)
  {
    a = paramTextView;
    i = new a0(a);
  }
  
  public static v0 a(Context paramContext, j paramj, int paramInt)
  {
    paramj = paramj.b(paramContext, paramInt);
    if (paramj != null)
    {
      paramContext = new v0();
      d = true;
      a = paramj;
      return paramContext;
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
    a0 locala0 = i;
    if (locala0.d()) {
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          DisplayMetrics localDisplayMetrics = j.getResources().getDisplayMetrics();
          locala0.a(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
          if (locala0.b()) {
            locala0.a();
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
    a0 locala0 = i;
    if (locala0.d())
    {
      DisplayMetrics localDisplayMetrics = j.getResources().getDisplayMetrics();
      locala0.a(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (locala0.b()) {
        locala0.a();
      }
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    x0 localx0 = new x0(paramContext, paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance));
    if (localx0.f(R.styleable.TextAppearance_textAllCaps))
    {
      boolean bool = localx0.a(R.styleable.TextAppearance_textAllCaps, false);
      a.setAllCaps(bool);
    }
    if ((Build.VERSION.SDK_INT < 23) && (localx0.f(R.styleable.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localx0.a(R.styleable.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        a.setTextColor(localColorStateList);
      }
    }
    if ((localx0.f(R.styleable.TextAppearance_android_textSize)) && (localx0.b(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      a.setTextSize(0, 0.0F);
    }
    a(paramContext, localx0);
    if ((Build.VERSION.SDK_INT >= 26) && (localx0.f(R.styleable.TextAppearance_fontVariationSettings)))
    {
      paramContext = localx0.d(R.styleable.TextAppearance_fontVariationSettings);
      if (paramContext != null) {
        a.setFontVariationSettings(paramContext);
      }
    }
    b.recycle();
    paramContext = l;
    if (paramContext != null) {
      a.setTypeface(paramContext, j);
    }
  }
  
  public final void a(Context paramContext, x0 paramx0)
  {
    j = paramx0.c(R.styleable.TextAppearance_android_textStyle, j);
    int n = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    if (n >= 28)
    {
      n = paramx0.c(R.styleable.TextAppearance_android_textFontWeight, -1);
      k = n;
      if (n != -1) {
        j = (j & 0x2 | 0x0);
      }
    }
    if ((!paramx0.f(R.styleable.TextAppearance_android_fontFamily)) && (!paramx0.f(R.styleable.TextAppearance_fontFamily)))
    {
      if (paramx0.f(R.styleable.TextAppearance_android_typeface))
      {
        m = false;
        n = paramx0.c(R.styleable.TextAppearance_android_typeface, 1);
        if (n != 1)
        {
          if (n != 2)
          {
            if (n == 3) {
              l = Typeface.MONOSPACE;
            }
          }
          else {
            l = Typeface.SERIF;
          }
        }
        else {
          l = Typeface.SANS_SERIF;
        }
      }
      return;
    }
    l = null;
    if (paramx0.f(R.styleable.TextAppearance_fontFamily)) {
      n = R.styleable.TextAppearance_fontFamily;
    } else {
      n = R.styleable.TextAppearance_android_fontFamily;
    }
    int i1 = k;
    int i2 = j;
    boolean bool2;
    if (!paramContext.isRestricted())
    {
      paramContext = new y.a(this, i1, i2);
      try
      {
        paramContext = paramx0.a(n, j, paramContext);
        if (paramContext != null) {
          if ((Build.VERSION.SDK_INT >= 28) && (k != -1))
          {
            paramContext = Typeface.create(paramContext, 0);
            i1 = k;
            if ((j & 0x2) != 0) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            l = Typeface.create(paramContext, i1, bool2);
          }
          else
          {
            l = paramContext;
          }
        }
        if (l == null) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        m = bool2;
      }
      catch (UnsupportedOperationException|Resources.NotFoundException paramContext) {}
    }
    if (l == null)
    {
      paramContext = paramx0.d(n);
      if (paramContext != null) {
        if ((Build.VERSION.SDK_INT >= 28) && (k != -1))
        {
          paramContext = Typeface.create(paramContext, 0);
          n = k;
          bool2 = bool1;
          if ((j & 0x2) != 0) {
            bool2 = true;
          }
          l = Typeface.create(paramContext, n, bool2);
        }
        else
        {
          l = Typeface.create(paramContext, j);
        }
      }
    }
  }
  
  public final void a(Drawable paramDrawable, v0 paramv0)
  {
    if ((paramDrawable != null) && (paramv0 != null)) {
      j.a(paramDrawable, paramv0, a.getDrawableState());
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = a.getContext();
    j localj = j.a();
    Object localObject1 = x0.a(localContext, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int n = ((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
      b = a(localContext, localj, ((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableTop)) {
      c = a(localContext, localj, ((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableRight)) {
      d = a(localContext, localj, ((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
      e = a(localContext, localj, ((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    }
    if (((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableStart)) {
      f = a(localContext, localj, ((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
    }
    if (((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
      g = a(localContext, localj, ((x0)localObject1).f(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
    }
    b.recycle();
    boolean bool1 = a.getTransformationMethod() instanceof PasswordTransformationMethod;
    Object localObject2;
    boolean bool2;
    if (n != -1)
    {
      localObject2 = new x0(localContext, localContext.obtainStyledAttributes(n, R.styleable.TextAppearance));
      if ((!bool1) && (((x0)localObject2).f(R.styleable.TextAppearance_textAllCaps)))
      {
        bool2 = ((x0)localObject2).a(R.styleable.TextAppearance_textAllCaps, false);
        n = 1;
      }
      else
      {
        bool2 = false;
        n = 0;
      }
      a(localContext, (x0)localObject2);
      if (Build.VERSION.SDK_INT < 23)
      {
        if (((x0)localObject2).f(R.styleable.TextAppearance_android_textColor)) {
          localObject3 = ((x0)localObject2).a(R.styleable.TextAppearance_android_textColor);
        } else {
          localObject3 = null;
        }
        if (((x0)localObject2).f(R.styleable.TextAppearance_android_textColorHint)) {
          localObject4 = ((x0)localObject2).a(R.styleable.TextAppearance_android_textColorHint);
        } else {
          localObject4 = null;
        }
        if (((x0)localObject2).f(R.styleable.TextAppearance_android_textColorLink)) {
          localObject1 = ((x0)localObject2).a(R.styleable.TextAppearance_android_textColorLink);
        } else {
          localObject1 = null;
        }
      }
      else
      {
        localObject1 = null;
        localObject4 = null;
        localObject3 = null;
      }
      if (((x0)localObject2).f(R.styleable.TextAppearance_textLocale)) {
        localObject5 = ((x0)localObject2).d(R.styleable.TextAppearance_textLocale);
      } else {
        localObject5 = null;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (((x0)localObject2).f(R.styleable.TextAppearance_fontVariationSettings))) {
        localObject6 = ((x0)localObject2).d(R.styleable.TextAppearance_fontVariationSettings);
      } else {
        localObject6 = null;
      }
      b.recycle();
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    else
    {
      bool2 = false;
      localObject5 = null;
      localObject6 = null;
      localObject2 = null;
      localObject1 = null;
      n = 0;
      localObject3 = null;
    }
    x0 localx0 = new x0(localContext, localContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextAppearance, paramInt, 0));
    boolean bool3 = bool2;
    int i1 = n;
    if (!bool1)
    {
      bool3 = bool2;
      i1 = n;
      if (localx0.f(R.styleable.TextAppearance_textAllCaps))
      {
        bool3 = localx0.a(R.styleable.TextAppearance_textAllCaps, false);
        i1 = 1;
      }
    }
    Object localObject7 = localObject2;
    Object localObject8 = localObject1;
    Object localObject4 = localObject3;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localx0.f(R.styleable.TextAppearance_android_textColor)) {
        localObject3 = localx0.a(R.styleable.TextAppearance_android_textColor);
      }
      if (localx0.f(R.styleable.TextAppearance_android_textColorHint)) {
        localObject1 = localx0.a(R.styleable.TextAppearance_android_textColorHint);
      }
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject4 = localObject3;
      if (localx0.f(R.styleable.TextAppearance_android_textColorLink))
      {
        localObject7 = localx0.a(R.styleable.TextAppearance_android_textColorLink);
        localObject4 = localObject3;
        localObject8 = localObject1;
      }
    }
    if (localx0.f(R.styleable.TextAppearance_textLocale)) {
      localObject5 = localx0.d(R.styleable.TextAppearance_textLocale);
    }
    Object localObject3 = localObject6;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject3 = localObject6;
      if (localx0.f(R.styleable.TextAppearance_fontVariationSettings)) {
        localObject3 = localx0.d(R.styleable.TextAppearance_fontVariationSettings);
      }
    }
    if ((Build.VERSION.SDK_INT >= 28) && (localx0.f(R.styleable.TextAppearance_android_textSize)) && (localx0.b(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      a.setTextSize(0, 0.0F);
    }
    localObject1 = localj;
    a(localContext, localx0);
    b.recycle();
    if (localObject4 != null) {
      a.setTextColor((ColorStateList)localObject4);
    }
    if (localObject8 != null) {
      a.setHintTextColor((ColorStateList)localObject8);
    }
    if (localObject7 != null) {
      a.setLinkTextColor((ColorStateList)localObject7);
    }
    if ((!bool1) && (i1 != 0)) {
      a.setAllCaps(bool3);
    }
    Object localObject6 = l;
    if (localObject6 != null) {
      if (k == -1) {
        a.setTypeface((Typeface)localObject6, j);
      } else {
        a.setTypeface((Typeface)localObject6);
      }
    }
    if (localObject3 != null) {
      a.setFontVariationSettings((String)localObject3);
    }
    if (localObject5 != null) {
      if (Build.VERSION.SDK_INT >= 24)
      {
        a.setTextLocales(LocaleList.forLanguageTags((String)localObject5));
      }
      else
      {
        localObject3 = ((String)localObject5).substring(0, ((String)localObject5).indexOf(','));
        a.setTextLocale(Locale.forLanguageTag((String)localObject3));
      }
    }
    localObject3 = i;
    Object localObject5 = j.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    if (((TypedArray)localObject5).hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
      a = ((TypedArray)localObject5).getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    }
    float f1;
    if (((TypedArray)localObject5).hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = ((TypedArray)localObject5).getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    }
    float f2;
    if (((TypedArray)localObject5).hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = ((TypedArray)localObject5).getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    }
    float f3;
    if (((TypedArray)localObject5).hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = ((TypedArray)localObject5).getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    }
    if (((TypedArray)localObject5).hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes))
    {
      paramInt = ((TypedArray)localObject5).getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
      if (paramInt > 0)
      {
        localObject6 = ((TypedArray)localObject5).getResources().obtainTypedArray(paramInt);
        n = ((TypedArray)localObject6).length();
        localObject2 = new int[n];
        if (n > 0)
        {
          for (paramInt = 0; paramInt < n; paramInt++) {
            localObject2[paramInt] = ((TypedArray)localObject6).getDimensionPixelSize(paramInt, -1);
          }
          f = ((a0)localObject3).a((int[])localObject2);
          ((a0)localObject3).c();
        }
        ((TypedArray)localObject6).recycle();
      }
    }
    ((TypedArray)localObject5).recycle();
    if (((a0)localObject3).d())
    {
      if (a == 1)
      {
        if (!g)
        {
          localObject6 = j.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject6);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject6);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          ((a0)localObject3).a(f4, f2, f3);
        }
        ((a0)localObject3).b();
      }
    }
    else {
      a = 0;
    }
    if (b.a)
    {
      localObject3 = i;
      if (a != 0)
      {
        localObject3 = f;
        if (localObject3.length > 0) {
          if (a.getAutoSizeStepGranularity() != -1.0F) {
            a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(i.d), Math.round(i.e), Math.round(i.c), 0);
          } else {
            a.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject3, 0);
          }
        }
      }
    }
    localObject4 = new x0(localContext, localContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView));
    paramInt = ((x0)localObject4).f(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
    if (paramInt != -1) {
      localObject3 = ((j)localObject1).a(localContext, paramInt);
    } else {
      localObject3 = null;
    }
    localObject5 = localObject1;
    paramInt = ((x0)localObject4).f(R.styleable.AppCompatTextView_drawableTopCompat, -1);
    if (paramInt != -1) {
      localObject1 = ((j)localObject5).a(localContext, paramInt);
    } else {
      localObject1 = null;
    }
    paramInt = ((x0)localObject4).f(R.styleable.AppCompatTextView_drawableRightCompat, -1);
    if (paramInt != -1) {
      localObject6 = ((j)localObject5).a(localContext, paramInt);
    } else {
      localObject6 = null;
    }
    paramInt = ((x0)localObject4).f(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
    if (paramInt != -1) {
      paramAttributeSet = ((j)localObject5).a(localContext, paramInt);
    } else {
      paramAttributeSet = null;
    }
    paramInt = ((x0)localObject4).f(R.styleable.AppCompatTextView_drawableStartCompat, -1);
    if (paramInt != -1) {
      localObject2 = ((j)localObject5).a(localContext, paramInt);
    } else {
      localObject2 = null;
    }
    paramInt = ((x0)localObject4).f(R.styleable.AppCompatTextView_drawableEndCompat, -1);
    if (paramInt != -1) {
      localObject5 = ((j)localObject5).a(localContext, paramInt);
    } else {
      localObject5 = null;
    }
    if ((localObject2 == null) && (localObject5 == null))
    {
      if ((localObject3 != null) || (localObject1 != null) || (localObject6 != null) || (paramAttributeSet != null))
      {
        localObject5 = a.getCompoundDrawablesRelative();
        if ((localObject5[0] == null) && (localObject5[2] == null))
        {
          localObject2 = a.getCompoundDrawables();
          localObject5 = a;
          if (localObject3 == null) {
            localObject3 = localObject2[0];
          }
          if (localObject1 == null) {
            localObject1 = localObject2[1];
          }
          if (localObject6 == null) {
            localObject6 = localObject2[2];
          }
          if (paramAttributeSet == null) {
            paramAttributeSet = localObject2[3];
          }
          ((TextView)localObject5).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject3, (Drawable)localObject1, (Drawable)localObject6, paramAttributeSet);
        }
        else
        {
          localObject3 = a;
          localObject6 = localObject5[0];
          if (localObject1 == null) {
            localObject1 = localObject5[1];
          }
          localObject2 = localObject5[2];
          if (paramAttributeSet == null) {
            paramAttributeSet = localObject5[3];
          }
          ((TextView)localObject3).setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)localObject6, (Drawable)localObject1, (Drawable)localObject2, paramAttributeSet);
        }
      }
    }
    else
    {
      localObject6 = a.getCompoundDrawablesRelative();
      localObject3 = a;
      if (localObject2 == null) {
        localObject2 = localObject6[0];
      }
      if (localObject1 == null) {
        localObject1 = localObject6[1];
      }
      if (localObject5 == null) {
        localObject5 = localObject6[2];
      }
      if (paramAttributeSet == null) {
        paramAttributeSet = localObject6[3];
      }
      ((TextView)localObject3).setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)localObject2, (Drawable)localObject1, (Drawable)localObject5, paramAttributeSet);
    }
    if (((x0)localObject4).f(R.styleable.AppCompatTextView_drawableTint))
    {
      paramAttributeSet = ((x0)localObject4).a(R.styleable.AppCompatTextView_drawableTint);
      localObject1 = a;
      if (localObject1 != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          ((TextView)localObject1).setCompoundDrawableTintList(paramAttributeSet);
        } else if ((localObject1 instanceof e)) {
          ((e)localObject1).setSupportCompoundDrawablesTintList(paramAttributeSet);
        }
      }
      else {
        throw null;
      }
    }
    if (((x0)localObject4).f(R.styleable.AppCompatTextView_drawableTintMode))
    {
      paramAttributeSet = e0.a(((x0)localObject4).c(R.styleable.AppCompatTextView_drawableTintMode, -1), null);
      localObject1 = a;
      if (localObject1 != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          ((TextView)localObject1).setCompoundDrawableTintMode(paramAttributeSet);
        } else if ((localObject1 instanceof e)) {
          ((e)localObject1).setSupportCompoundDrawablesTintMode(paramAttributeSet);
        }
      }
      else {
        throw null;
      }
    }
    paramInt = ((x0)localObject4).b(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
    n = ((x0)localObject4).b(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
    i1 = ((x0)localObject4).b(R.styleable.AppCompatTextView_lineHeight, -1);
    b.recycle();
    if (paramInt != -1) {
      r.a(a, paramInt);
    }
    if (n != -1) {
      r.b(a, n);
    }
    if (i1 != -1) {
      r.c(a, i1);
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    a0 locala0 = i;
    if (locala0.d())
    {
      int n = paramArrayOfInt.length;
      int i1 = 0;
      if (n > 0)
      {
        int[] arrayOfInt = new int[n];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, n);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = j.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (i1 >= n) {
              break;
            }
            arrayOfInt[i1] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i1], localDisplayMetrics));
            i1++;
          }
        }
        f = locala0.a((int[])localObject);
        if (!locala0.c())
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
      if (locala0.b()) {
        locala0.a();
      }
    }
  }
  
  public boolean b()
  {
    a0 locala0 = i;
    boolean bool;
    if ((locala0.d()) && (a != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */