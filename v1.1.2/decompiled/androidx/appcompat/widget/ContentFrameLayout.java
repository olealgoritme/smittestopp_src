package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import d.b.a.k;
import d.b.a.k.h;
import d.b.a.n;
import d.b.d.i.h;
import d.b.e.a0;

public class ContentFrameLayout
  extends FrameLayout
{
  public TypedValue A;
  public TypedValue B;
  public TypedValue C;
  public final Rect D = new Rect();
  public a E;
  public TypedValue x;
  public TypedValue y;
  public TypedValue z;
  
  public ContentFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    if (B == null) {
      B = new TypedValue();
    }
    return B;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (C == null) {
      C = new TypedValue();
    }
    return C;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (z == null) {
      z = new TypedValue();
    }
    return z;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (A == null) {
      A = new TypedValue();
    }
    return A;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (x == null) {
      x = new TypedValue();
    }
    return x;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (y == null) {
      y = new TypedValue();
    }
    return y;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a locala = E;
    if ((locala != null) && ((n)locala == null)) {
      throw null;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = E;
    if (localObject != null)
    {
      localObject = a;
      a0 locala0 = F;
      if (locala0 != null) {
        locala0.g();
      }
      if (K != null)
      {
        y.getDecorView().removeCallbacks(L);
        if (!K.isShowing()) {}
      }
    }
    try
    {
      K.dismiss();
      K = null;
      ((k)localObject).d();
      localObject = ((k)localObject).d(0);
      if (localObject != null)
      {
        localObject = j;
        if (localObject != null) {
          ((h)localObject).a(true);
        }
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int i = widthPixels;
    int j = heightPixels;
    int k = 1;
    if (i < j) {
      j = 1;
    } else {
      j = 0;
    }
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    Object localObject;
    float f;
    if (m == Integer.MIN_VALUE)
    {
      if (j != 0) {
        localObject = A;
      } else {
        localObject = z;
      }
      if (localObject != null)
      {
        i = type;
        if (i != 0)
        {
          if (i == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(i, i))
          {
            i = (int)f;
            break label152;
            if (i != 6) {
              break;
            }
            i = widthPixels;
          }
          i = 0;
          label152:
          if (i > 0)
          {
            localObject = D;
            i1 = View.MeasureSpec.makeMeasureSpec(Math.min(i - (left + right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
            paramInt1 = 1;
            break label205;
          }
        }
      }
    }
    i = 0;
    int i1 = paramInt1;
    paramInt1 = i;
    label205:
    i = paramInt2;
    if (n == Integer.MIN_VALUE)
    {
      if (j != 0) {
        localObject = B;
      } else {
        localObject = C;
      }
      i = paramInt2;
      if (localObject != null)
      {
        n = type;
        i = paramInt2;
        if (n != 0)
        {
          if (n == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(i, i))
          {
            n = (int)f;
            break label312;
            if (n != 6) {
              break;
            }
            i = heightPixels;
          }
          n = 0;
          label312:
          i = paramInt2;
          if (n > 0)
          {
            localObject = D;
            i = View.MeasureSpec.makeMeasureSpec(Math.min(n - (top + bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
        }
      }
    }
    super.onMeasure(i1, i);
    n = getMeasuredWidth();
    i1 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
    if ((paramInt1 == 0) && (m == Integer.MIN_VALUE))
    {
      if (j != 0) {
        localObject = y;
      } else {
        localObject = x;
      }
      if (localObject != null)
      {
        paramInt1 = type;
        if (paramInt1 != 0)
        {
          if (paramInt1 == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(paramInt1, paramInt1))
          {
            paramInt1 = (int)f;
            break label470;
            if (paramInt1 != 6) {
              break;
            }
            paramInt1 = widthPixels;
          }
          paramInt1 = 0;
          label470:
          paramInt2 = paramInt1;
          if (paramInt1 > 0)
          {
            localObject = D;
            paramInt2 = paramInt1 - (left + right);
          }
          if (n < paramInt2)
          {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            paramInt2 = k;
            break label520;
          }
        }
      }
    }
    paramInt2 = 0;
    paramInt1 = i1;
    label520:
    if (paramInt2 != 0) {
      super.onMeasure(paramInt1, i);
    }
  }
  
  public void setAttachListener(a parama)
  {
    E = parama;
  }
  
  public static abstract interface a {}
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.ContentFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */