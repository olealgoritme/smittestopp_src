package d.l.a;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.i.i.n;
import java.util.ArrayList;
import java.util.List;

public class a
  extends ViewGroup
{
  public static final int[] N = { 16842931 };
  public boolean A;
  public boolean B;
  public int C;
  public int D;
  public int E;
  public int F;
  public a.a G;
  public List<a.a> H;
  public Drawable I;
  public Drawable J;
  public Drawable K;
  public Rect L;
  public Matrix M;
  public float x;
  public int y;
  public float z;
  
  public int a(View paramView)
  {
    if (d(paramView))
    {
      int i = getLayoutParamsa;
      int j = n.i(this);
      if (i != 3)
      {
        if (i != 5)
        {
          if (i != 8388611)
          {
            if (i == 8388613)
            {
              i = F;
              if (i != 3) {
                break label203;
              }
              if (j == 0) {
                i = D;
              } else {
                i = C;
              }
              if (i != 3) {
                break label203;
              }
            }
          }
          else
          {
            i = E;
            if (i != 3) {
              break label203;
            }
            if (j == 0) {
              i = C;
            } else {
              i = D;
            }
            if (i != 3) {
              break label203;
            }
          }
        }
        else
        {
          i = D;
          if (i != 3) {
            break label203;
          }
          if (j == 0) {
            i = F;
          } else {
            i = E;
          }
          if (i != 3) {
            break label203;
          }
        }
      }
      else
      {
        i = C;
        if (i != 3) {
          break label203;
        }
        if (j == 0) {
          i = E;
        } else {
          i = F;
        }
        if (i != 3) {
          break label203;
        }
      }
      i = 0;
      label203:
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public View a()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if ((getLayoutParamsd & 0x1) == 1) {
        return localView;
      }
    }
    return null;
  }
  
  public View a(int paramInt)
  {
    int i = Gravity.getAbsoluteGravity(paramInt, n.i(this));
    int j = getChildCount();
    for (paramInt = 0; paramInt < j; paramInt++)
    {
      View localView = getChildAt(paramInt);
      if ((b(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = Gravity.getAbsoluteGravity(paramInt2, n.i(this));
    if (paramInt2 != 3)
    {
      if (paramInt2 != 5)
      {
        if (paramInt2 != 8388611)
        {
          if (paramInt2 == 8388613) {
            F = paramInt1;
          }
        }
        else {
          E = paramInt1;
        }
      }
      else {
        D = paramInt1;
      }
    }
    else {
      C = paramInt1;
    }
    if (paramInt1 != 0) {
      throw new NullPointerException();
    }
    View localView;
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2)
      {
        localView = a(i);
        if (localView != null) {
          e(localView);
        }
      }
    }
    else
    {
      localView = a(i);
      if (localView != null)
      {
        Object localObject;
        if (d(localView))
        {
          localObject = (a.b)localView.getLayoutParams();
          if (B)
          {
            b = 0.0F;
            d = 0;
            invalidate();
          }
          else
          {
            d |= 0x4;
            if (a(localView, 3))
            {
              localView.getWidth();
              localView.getTop();
              throw null;
            }
            getWidth();
            localView.getTop();
            throw null;
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("View ");
          ((StringBuilder)localObject).append(localView);
          ((StringBuilder)localObject).append(" is not a sliding drawer");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    Object localObject = (a.b)paramView.getLayoutParams();
    if (paramFloat == b) {
      return;
    }
    b = paramFloat;
    localObject = H;
    if (localObject != null)
    {
      int i = ((List)localObject).size();
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        ((a.a)H.get(i)).a(paramView, paramFloat);
      }
    }
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (((!paramBoolean) && (!d(localView))) || ((paramBoolean) && (localView == paramView))) {
        n.e(localView, 1);
      } else {
        n.e(localView, 4);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      a.b localb = (a.b)localView.getLayoutParams();
      if ((d(localView)) && ((!paramBoolean) || (c)))
      {
        localView.getWidth();
        if (a(localView, 3))
        {
          localView.getTop();
          throw null;
        }
        getWidth();
        localView.getTop();
        throw null;
      }
    }
    throw null;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    boolean bool;
    if ((b(paramView) & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int i = getChildCount();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      View localView = getChildAt(j);
      if (d(localView))
      {
        if (d(localView))
        {
          int m;
          if ((getLayoutParamsd & 0x1) == 1) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != 0)
          {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
            k = 1;
          }
          j++;
        }
        else
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("View ");
          paramArrayList.append(localView);
          paramArrayList.append(" is not a drawer");
          throw new IllegalArgumentException(paramArrayList.toString());
        }
      }
      else {
        throw null;
      }
    }
    if (k == 0) {
      throw null;
    }
    throw null;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((a() == null) && (!d(paramView))) {
      paramView.setImportantForAccessibility(1);
    } else {
      n.e(paramView, 4);
    }
  }
  
  public int b(View paramView)
  {
    return Gravity.getAbsoluteGravity(getLayoutParamsa, n.i(this));
  }
  
  public View b()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (d(localView)) {
        if (d(localView))
        {
          int k;
          if (getLayoutParamsb > 0.0F) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {
            return localView;
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("View ");
          localStringBuilder.append(localView);
          localStringBuilder.append(" is not a drawer");
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  public boolean c(View paramView)
  {
    boolean bool;
    if (getLayoutParamsa == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof a.b)) && (super.checkLayoutParams(paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void computeScroll()
  {
    int i = getChildCount();
    float f = 0.0F;
    for (int j = 0; j < i; j++) {
      f = Math.max(f, getChildAtgetLayoutParamsb);
    }
    z = f;
    throw null;
  }
  
  public boolean d(View paramView)
  {
    int i = Gravity.getAbsoluteGravity(getLayoutParamsa, n.i(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() != 10) && (z > 0.0F))
    {
      int i = getChildCount();
      if (i != 0)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        i--;
        while (i >= 0)
        {
          View localView = getChildAt(i);
          if (L == null) {
            L = new Rect();
          }
          localView.getHitRect(L);
          if ((L.contains((int)f1, (int)f2)) && (!c(localView)))
          {
            float f3;
            float f4;
            boolean bool;
            if (!localView.getMatrix().isIdentity())
            {
              f3 = getScrollX() - localView.getLeft();
              f4 = getScrollY() - localView.getTop();
              MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.offsetLocation(f3, f4);
              Matrix localMatrix = localView.getMatrix();
              if (!localMatrix.isIdentity())
              {
                if (M == null) {
                  M = new Matrix();
                }
                localMatrix.invert(M);
                localMotionEvent.transform(M);
              }
              bool = localView.dispatchGenericMotionEvent(localMotionEvent);
              localMotionEvent.recycle();
            }
            else
            {
              f4 = getScrollX() - localView.getLeft();
              f3 = getScrollY() - localView.getTop();
              paramMotionEvent.offsetLocation(f4, f3);
              bool = localView.dispatchGenericMotionEvent(paramMotionEvent);
              paramMotionEvent.offsetLocation(-f4, -f3);
            }
            if (bool) {
              return true;
            }
          }
          i--;
        }
      }
      return false;
    }
    return super.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = getHeight();
    boolean bool1 = c(paramView);
    int j = getWidth();
    int k = paramCanvas.save();
    if (bool1)
    {
      int m = getChildCount();
      int n = 0;
      int i3;
      for (int i1 = 0; n < m; i1 = i3)
      {
        View localView = getChildAt(n);
        int i2 = j;
        i3 = i1;
        if (localView != paramView)
        {
          i2 = j;
          i3 = i1;
          if (localView.getVisibility() == 0)
          {
            Drawable localDrawable = localView.getBackground();
            int i4;
            if ((localDrawable != null) && (localDrawable.getOpacity() == -1)) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            i2 = j;
            i3 = i1;
            if (i4 != 0)
            {
              i2 = j;
              i3 = i1;
              if (d(localView)) {
                if (localView.getHeight() < i)
                {
                  i2 = j;
                  i3 = i1;
                }
                else if (a(localView, 3))
                {
                  i4 = localView.getRight();
                  i2 = j;
                  i3 = i1;
                  if (i4 > i1)
                  {
                    i3 = i4;
                    i2 = j;
                  }
                }
                else
                {
                  i4 = localView.getLeft();
                  i2 = j;
                  i3 = i1;
                  if (i4 < j)
                  {
                    i2 = i4;
                    i3 = i1;
                  }
                }
              }
            }
          }
        }
        n++;
        j = i2;
      }
      paramCanvas.clipRect(i1, 0, j, getHeight());
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(k);
    if ((z > 0.0F) && (bool1)) {
      throw null;
    }
    if ((J != null) && (a(paramView, 3)))
    {
      J.getIntrinsicWidth();
      paramView.getRight();
      throw null;
    }
    if ((K != null) && (a(paramView, 5)))
    {
      K.getIntrinsicWidth();
      paramView.getLeft();
      getWidth();
      throw null;
    }
    return bool2;
  }
  
  public void e(View paramView)
  {
    if (d(paramView))
    {
      localObject = (a.b)paramView.getLayoutParams();
      if (B)
      {
        b = 1.0F;
        d = 1;
        a(paramView, true);
        invalidate();
        return;
      }
      d |= 0x2;
      if (a(paramView, 3))
      {
        paramView.getTop();
        throw null;
      }
      getWidth();
      paramView.getWidth();
      paramView.getTop();
      throw null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new a.b(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new a.b(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof a.b)) {
      paramLayoutParams = new a.b((a.b)paramLayoutParams);
    } else if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramLayoutParams = new a.b((ViewGroup.MarginLayoutParams)paramLayoutParams);
    } else {
      paramLayoutParams = new a.b(paramLayoutParams);
    }
    return paramLayoutParams;
  }
  
  public float getDrawerElevation()
  {
    return x;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return I;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    B = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    B = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getActionMasked();
    throw null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      int i;
      if (b() != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramKeyEvent.startTracking();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = b();
      boolean bool = false;
      if ((paramKeyEvent != null) && (a(paramKeyEvent) == 0))
      {
        a(false);
        throw null;
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    A = true;
    int i = paramInt3 - paramInt1;
    int j = getChildCount();
    for (paramInt3 = 0; paramInt3 < j; paramInt3++)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        a.b localb = (a.b)localView.getLayoutParams();
        int k;
        int m;
        int n;
        if (c(localView))
        {
          k = leftMargin;
          paramInt1 = topMargin;
          m = localView.getMeasuredWidth();
          n = topMargin;
          localView.layout(k, paramInt1, m + k, localView.getMeasuredHeight() + n);
        }
        else
        {
          int i1 = localView.getMeasuredWidth();
          int i2 = localView.getMeasuredHeight();
          float f;
          if (a(localView, 3))
          {
            paramInt1 = -i1;
            f = i1;
            n = paramInt1 + (int)(b * f);
            f = (i1 + n) / f;
          }
          else
          {
            f = i1;
            n = i - (int)(b * f);
            f = (i - n) / f;
          }
          if (f != b) {
            k = 1;
          } else {
            k = 0;
          }
          paramInt1 = a & 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 80)
            {
              paramInt1 = topMargin;
              localView.layout(n, paramInt1, i1 + n, i2 + paramInt1);
            }
            else
            {
              paramInt1 = paramInt4 - paramInt2;
              localView.layout(n, paramInt1 - bottomMargin - localView.getMeasuredHeight(), i1 + n, paramInt1 - bottomMargin);
            }
          }
          else
          {
            int i3 = paramInt4 - paramInt2;
            m = (i3 - i2) / 2;
            paramInt1 = topMargin;
            if (m >= paramInt1)
            {
              int i4 = bottomMargin;
              paramInt1 = m;
              if (m + i2 > i3 - i4) {
                paramInt1 = i3 - i4 - i2;
              }
            }
            localView.layout(n, paramInt1, i1 + n, i2 + paramInt1);
          }
          if (k != 0) {
            a(localView, f);
          }
          if (b > 0.0F) {
            paramInt1 = 0;
          } else {
            paramInt1 = 4;
          }
          if (localView.getVisibility() != paramInt1) {
            localView.setVisibility(paramInt1);
          }
        }
      }
    }
    A = false;
    B = false;
  }
  
  @SuppressLint({"WrongConstant"})
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n;
    int i1;
    if (i == 1073741824)
    {
      n = k;
      i1 = m;
      if (j == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label560;
      }
      if ((i != Integer.MIN_VALUE) && (i == 0)) {
        k = 300;
      }
      if (j == Integer.MIN_VALUE)
      {
        n = k;
        i1 = m;
      }
      else
      {
        n = k;
        i1 = m;
        if (j == 0)
        {
          i1 = 300;
          n = k;
        }
      }
    }
    setMeasuredDimension(n, i1);
    n.i(this);
    int i2 = getChildCount();
    j = 0;
    m = 0;
    k = 0;
    while (j < i2)
    {
      Object localObject1 = getChildAt(j);
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (a.b)((View)localObject1).getLayoutParams();
        if (c((View)localObject1))
        {
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(n - leftMargin - rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i1 - topMargin - bottomMargin, 1073741824));
        }
        else
        {
          if (!d((View)localObject1)) {
            break label485;
          }
          float f1 = ((View)localObject1).getElevation();
          float f2 = x;
          if (f1 != f2) {
            ((View)localObject1).setElevation(f2);
          }
          int i3 = b((View)localObject1) & 0x7;
          if (i3 == 3) {
            i = 1;
          } else {
            i = 0;
          }
          if (((i != 0) && (m != 0)) || ((i == 0) && (k != 0)))
          {
            localObject2 = e.a.a.a.a.a("Child drawer has absolute gravity ");
            if ((i3 & 0x3) != 3)
            {
              if ((i3 & 0x5) == 5) {
                localObject1 = "RIGHT";
              } else {
                localObject1 = Integer.toHexString(i3);
              }
            }
            else {
              localObject1 = "LEFT";
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" but this ");
            ((StringBuilder)localObject2).append("DrawerLayout");
            ((StringBuilder)localObject2).append(" already has a ");
            ((StringBuilder)localObject2).append("drawer view along that edge");
            throw new IllegalStateException(((StringBuilder)localObject2).toString());
          }
          if (i != 0) {
            m = 1;
          } else {
            k = 1;
          }
          ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramInt1, leftMargin + 0 + rightMargin, width), ViewGroup.getChildMeasureSpec(paramInt2, topMargin + bottomMargin, height));
        }
      }
      j++;
      continue;
      label485:
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Child ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(" at index ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
      ((StringBuilder)localObject2).append("Gravity.RIGHT or Gravity.NO_GRAVITY");
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    return;
    label560:
    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof a.c))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    a.c localc = (a.c)paramParcelable;
    super.onRestoreInstanceState(x);
    int i = z;
    if (i != 0)
    {
      paramParcelable = a(i);
      if (paramParcelable != null) {
        e(paramParcelable);
      }
    }
    i = A;
    if (i != 3) {
      a(i, 3);
    }
    i = B;
    if (i != 3) {
      a(i, 5);
    }
    i = C;
    if (i != 3) {
      a(i, 8388611);
    }
    i = D;
    if (i != 3) {
      a(i, 8388613);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt) {}
  
  public Parcelable onSaveInstanceState()
  {
    a.c localc = new a.c(super.onSaveInstanceState());
    int i = getChildCount();
    int j = 0;
    while (j < i)
    {
      a.b localb = (a.b)getChildAt(j).getLayoutParams();
      int k = d;
      int m = 1;
      if (k == 1) {
        k = 1;
      } else {
        k = 0;
      }
      if (d != 2) {
        m = 0;
      }
      if ((k == 0) && (m == 0)) {
        j++;
      } else {
        z = a;
      }
    }
    A = C;
    B = D;
    C = E;
    D = F;
    return localc;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    throw null;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (!paramBoolean) {
      return;
    }
    a(true);
    throw null;
  }
  
  public void requestLayout()
  {
    if (!A) {
      super.requestLayout();
    }
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    x = paramFloat;
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (d(localView)) {
        localView.setElevation(x);
      }
    }
  }
  
  @Deprecated
  public void setDrawerListener(a.a parama)
  {
    a.a locala = G;
    if ((locala != null) && (locala != null))
    {
      List localList = H;
      if (localList != null) {
        localList.remove(locala);
      }
    }
    if (parama != null)
    {
      if (H == null) {
        H = new ArrayList();
      }
      H.add(parama);
    }
    G = parama;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    a(paramInt, 3);
    a(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    y = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = d.i.b.a.c(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    I = localDrawable;
    invalidate();
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    I = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    I = new ColorDrawable(paramInt);
    invalidate();
  }
}

/* Location:
 * Qualified Name:     base.d.l.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */