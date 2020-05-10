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
import d.b.a.k.j;
import d.b.a.n;
import d.b.d.i.g;
import d.b.e.c0;

public class ContentFrameLayout
  extends FrameLayout
{
  public TypedValue A;
  public TypedValue B;
  public TypedValue C;
  public final Rect D = new Rect();
  public ContentFrameLayout.a E;
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
    ContentFrameLayout.a locala = E;
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
      c0 localc0 = H;
      if (localc0 != null) {
        localc0.g();
      }
      if (M != null)
      {
        B.getDecorView().removeCallbacks(N);
        if (!M.isShowing()) {}
      }
    }
    try
    {
      M.dismiss();
      M = null;
      ((k)localObject).e();
      localObject = ((k)localObject).d(0);
      if (localObject != null)
      {
        localObject = j;
        if (localObject != null) {
          ((g)localObject).a(true);
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
      i = 1;
    } else {
      i = 0;
    }
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    Object localObject;
    float f;
    if (m == Integer.MIN_VALUE)
    {
      if (i != 0) {
        localObject = A;
      } else {
        localObject = z;
      }
      if (localObject != null)
      {
        j = type;
        if (j != 0)
        {
          if (j == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(j, j))
          {
            j = (int)f;
            break label152;
            if (j != 6) {
              break;
            }
            j = widthPixels;
          }
          j = 0;
          label152:
          if (j > 0)
          {
            localObject = D;
            i1 = View.MeasureSpec.makeMeasureSpec(Math.min(j - (left + right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
            paramInt1 = 1;
            break label205;
          }
        }
      }
    }
    j = 0;
    int i1 = paramInt1;
    paramInt1 = j;
    label205:
    j = paramInt2;
    if (n == Integer.MIN_VALUE)
    {
      if (i != 0) {
        localObject = B;
      } else {
        localObject = C;
      }
      j = paramInt2;
      if (localObject != null)
      {
        n = type;
        j = paramInt2;
        if (n != 0)
        {
          if (n == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(j, j))
          {
            n = (int)f;
            break label312;
            if (n != 6) {
              break;
            }
            j = heightPixels;
          }
          n = 0;
          label312:
          j = paramInt2;
          if (n > 0)
          {
            localObject = D;
            j = View.MeasureSpec.makeMeasureSpec(Math.min(n - (top + bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
        }
      }
    }
    super.onMeasure(i1, j);
    n = getMeasuredWidth();
    i1 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
    if ((paramInt1 == 0) && (m == Integer.MIN_VALUE))
    {
      if (i != 0) {
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
      super.onMeasure(paramInt1, j);
    }
  }
  
  public void setAttachListener(ContentFrameLayout.a parama)
  {
    E = parama;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.ContentFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */