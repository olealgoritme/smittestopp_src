package d.b.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R.styleable;
import d.i.i.n;

public class i0
  extends ViewGroup
{
  public int A;
  public int B = 8388659;
  public int C;
  public float D;
  public boolean E;
  public int[] F;
  public int[] G;
  public Drawable H;
  public int I;
  public int J;
  public int K;
  public int L;
  public boolean x = true;
  public int y = -1;
  public int z = 0;
  
  public i0(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public i0(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public i0(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    paramInt = paramAttributeSet.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramAttributeSet.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramAttributeSet.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    D = paramAttributeSet.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    y = paramAttributeSet.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    E = paramAttributeSet.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    paramInt = R.styleable.LinearLayoutCompat_divider;
    if (paramAttributeSet.hasValue(paramInt))
    {
      int i = paramAttributeSet.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = d.b.b.a.a.c(paramContext, i);
        break label174;
      }
    }
    paramContext = paramAttributeSet.getDrawable(paramInt);
    label174:
    setDividerDrawable(paramContext);
    K = paramAttributeSet.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    L = paramAttributeSet.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    paramAttributeSet.recycle();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    for (int j = 0; j < paramInt1; j++)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        i0.a locala = (i0.a)localView.getLayoutParams();
        if (height == -1)
        {
          int k = width;
          width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, i, 0);
          width = k;
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    H.setBounds(getPaddingLeft() + L, paramInt, getWidth() - getPaddingRight() - L, J + paramInt);
    H.draw(paramCanvas);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramInt == 0)
    {
      if ((K & 0x1) != 0) {
        bool3 = true;
      }
      return bool3;
    }
    if (paramInt == getChildCount())
    {
      bool3 = bool1;
      if ((K & 0x4) != 0) {
        bool3 = true;
      }
      return bool3;
    }
    bool3 = bool2;
    if ((K & 0x2) != 0)
    {
      paramInt--;
      for (;;)
      {
        bool3 = bool2;
        if (paramInt < 0) {
          break;
        }
        if (getChildAt(paramInt).getVisibility() != 8)
        {
          bool3 = true;
          break;
        }
        paramInt--;
      }
    }
    return bool3;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int j = 0; j < paramInt1; j++)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        i0.a locala = (i0.a)localView.getLayoutParams();
        if (width == -1)
        {
          int k = height;
          height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, i, 0, paramInt2, 0);
          height = k;
        }
      }
    }
  }
  
  public void b(Canvas paramCanvas, int paramInt)
  {
    H.setBounds(paramInt, getPaddingTop() + L, I + paramInt, getHeight() - getPaddingBottom() - L);
    H.draw(paramCanvas);
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof i0.a;
  }
  
  public i0.a generateDefaultLayoutParams()
  {
    int i = A;
    if (i == 0) {
      return new i0.a(-2, -2);
    }
    if (i == 1) {
      return new i0.a(-1, -2);
    }
    return null;
  }
  
  public i0.a generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new i0.a(getContext(), paramAttributeSet);
  }
  
  public i0.a generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new i0.a(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (y < 0) {
      return super.getBaseline();
    }
    int i = getChildCount();
    int j = y;
    if (i > j)
    {
      View localView = getChildAt(j);
      int k = localView.getBaseline();
      if (k == -1)
      {
        if (y == 0) {
          return -1;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      }
      i = z;
      j = i;
      if (A == 1)
      {
        int m = B & 0x70;
        j = i;
        if (m != 48) {
          if (m != 16)
          {
            if (m != 80) {
              j = i;
            } else {
              j = getBottom() - getTop() - getPaddingBottom() - C;
            }
          }
          else {
            j = i + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - C) / 2;
          }
        }
      }
      return j + getLayoutParamstopMargin + k;
    }
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return y;
  }
  
  public Drawable getDividerDrawable()
  {
    return H;
  }
  
  public int getDividerPadding()
  {
    return L;
  }
  
  public int getDividerWidth()
  {
    return I;
  }
  
  public int getGravity()
  {
    return B;
  }
  
  public int getOrientation()
  {
    return A;
  }
  
  public int getShowDividers()
  {
    return K;
  }
  
  public int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return D;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (H == null) {
      return;
    }
    int i = A;
    int j = 0;
    int k = 0;
    Object localObject1;
    Object localObject2;
    if (i == 1)
    {
      j = getVirtualChildCount();
      while (k < j)
      {
        localObject1 = getChildAt(k);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8) && (a(k)))
        {
          localObject2 = (i0.a)((View)localObject1).getLayoutParams();
          a(paramCanvas, ((View)localObject1).getTop() - topMargin - J);
        }
        k++;
      }
      if (a(j))
      {
        localObject2 = getChildAt(j - 1);
        if (localObject2 == null)
        {
          k = getHeight() - getPaddingBottom() - J;
        }
        else
        {
          localObject1 = (i0.a)((View)localObject2).getLayoutParams();
          k = ((View)localObject2).getBottom() + bottomMargin;
        }
        a(paramCanvas, k);
      }
    }
    else
    {
      i = getVirtualChildCount();
      boolean bool = d1.a(this);
      for (k = j; k < i; k++)
      {
        localObject2 = getChildAt(k);
        if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8) && (a(k)))
        {
          localObject1 = (i0.a)((View)localObject2).getLayoutParams();
          if (bool) {
            j = ((View)localObject2).getRight() + rightMargin;
          } else {
            j = ((View)localObject2).getLeft() - leftMargin - I;
          }
          b(paramCanvas, j);
        }
      }
      if (a(i))
      {
        localObject1 = getChildAt(i - 1);
        if (localObject1 == null)
        {
          if (bool)
          {
            k = getPaddingLeft();
            break label398;
          }
          j = getWidth() - getPaddingRight();
          k = I;
        }
        else
        {
          localObject2 = (i0.a)((View)localObject1).getLayoutParams();
          if (!bool) {
            break label385;
          }
          j = ((View)localObject1).getLeft() - leftMargin;
          k = I;
        }
        k = j - k;
        break label398;
        label385:
        k = ((View)localObject1).getRight() + rightMargin;
        label398:
        b(paramCanvas, k);
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    int m;
    View localView;
    if (A == 1)
    {
      i = getPaddingLeft();
      j = paramInt3 - paramInt1;
      k = getPaddingRight();
      m = getPaddingRight();
      n = getVirtualChildCount();
      i1 = B;
      paramInt1 = i1 & 0x70;
      if (paramInt1 != 16)
      {
        if (paramInt1 != 80) {
          paramInt1 = getPaddingTop();
        } else {
          paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - C;
        }
      }
      else {
        paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - C) / 2;
      }
      paramInt2 = 0;
      while (paramInt2 < n)
      {
        localView = getChildAt(paramInt2);
        if (localView == null)
        {
          paramInt3 = paramInt1 + 0;
          paramInt4 = paramInt2;
        }
        else
        {
          paramInt3 = paramInt1;
          paramInt4 = paramInt2;
          if (localView.getVisibility() != 8)
          {
            i2 = localView.getMeasuredWidth();
            i3 = localView.getMeasuredHeight();
            localObject = (i0.a)localView.getLayoutParams();
            paramInt4 = b;
            paramInt3 = paramInt4;
            if (paramInt4 < 0) {
              paramInt3 = 0x800007 & i1;
            }
            paramInt3 = Gravity.getAbsoluteGravity(paramInt3, n.i(this)) & 0x7;
            if (paramInt3 != 1)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = leftMargin + i;
                break label297;
              }
              paramInt4 = j - k - i2;
              paramInt3 = rightMargin;
            }
            else
            {
              paramInt4 = (j - i - m - i2) / 2 + i + leftMargin;
              paramInt3 = rightMargin;
            }
            paramInt3 = paramInt4 - paramInt3;
            label297:
            paramInt4 = paramInt1;
            if (a(paramInt2)) {
              paramInt4 = paramInt1 + J;
            }
            paramInt1 = paramInt4 + topMargin;
            paramInt4 = paramInt1 + 0;
            localView.layout(paramInt3, paramInt4, i2 + paramInt3, i3 + paramInt4);
            paramInt3 = e.a.a.a.a.a(i3, bottomMargin, 0, paramInt1);
            paramInt4 = paramInt2 + 0;
          }
        }
        paramInt2 = paramInt4 + 1;
        paramInt1 = paramInt3;
      }
    }
    boolean bool = d1.a(this);
    int k = getPaddingTop();
    int i2 = paramInt4 - paramInt2;
    int i3 = getPaddingBottom();
    int i4 = getPaddingBottom();
    int n = getVirtualChildCount();
    paramInt2 = B;
    int i1 = paramInt2 & 0x70;
    paramBoolean = x;
    Object localObject = F;
    int[] arrayOfInt = G;
    paramInt2 = Gravity.getAbsoluteGravity(0x800007 & paramInt2, getLayoutDirection());
    if (paramInt2 != 1)
    {
      if (paramInt2 != 5) {
        paramInt2 = getPaddingLeft();
      } else {
        paramInt2 = getPaddingLeft() + paramInt3 - paramInt1 - C;
      }
    }
    else {
      paramInt2 = getPaddingLeft() + (paramInt3 - paramInt1 - C) / 2;
    }
    if (bool)
    {
      paramInt1 = n - 1;
      i = -1;
    }
    else
    {
      paramInt1 = 0;
      i = 1;
    }
    paramInt4 = 0;
    paramInt3 = i1;
    i1 = paramInt1;
    while (paramInt4 < n)
    {
      int i5 = i * paramInt4 + i1;
      localView = getChildAt(i5);
      if (localView == null)
      {
        paramInt1 = paramInt2 + 0;
      }
      else
      {
        paramInt1 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          int i6 = localView.getMeasuredWidth();
          int i7 = localView.getMeasuredHeight();
          i0.a locala = (i0.a)localView.getLayoutParams();
          if ((paramBoolean) && (height != -1)) {
            m = localView.getBaseline();
          } else {
            m = -1;
          }
          j = b;
          paramInt1 = j;
          if (j < 0) {
            paramInt1 = paramInt3;
          }
          paramInt1 &= 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 48)
            {
              if (paramInt1 != 80)
              {
                paramInt1 = k;
              }
              else
              {
                j = i2 - i3 - i7 - bottomMargin;
                paramInt1 = j;
                if (m != -1)
                {
                  paramInt1 = localView.getMeasuredHeight();
                  paramInt1 = j - (arrayOfInt[2] - (paramInt1 - m));
                }
              }
            }
            else
            {
              paramInt1 = topMargin + k;
              if (m != -1) {
                paramInt1 = localObject[1] - m + paramInt1;
              }
            }
          }
          else {
            paramInt1 = (i2 - k - i4 - i7) / 2 + k + topMargin - bottomMargin;
          }
          m = paramInt2;
          if (a(i5)) {
            m = paramInt2 + I;
          }
          m += leftMargin;
          paramInt2 = m + 0;
          localView.layout(paramInt2, paramInt1, i6 + paramInt2, i7 + paramInt1);
          paramInt2 = e.a.a.a.a.a(i6, rightMargin, 0, m);
          paramInt4 += 0;
          break label865;
        }
      }
      paramInt2 = paramInt1;
      label865:
      paramInt4++;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    int m;
    boolean bool1;
    int n;
    float f1;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    Object localObject1;
    label120:
    Object localObject2;
    float f2;
    int i9;
    int i10;
    Object localObject3;
    int i11;
    int i12;
    int i13;
    if (A == 1)
    {
      C = 0;
      i = getVirtualChildCount();
      j = View.MeasureSpec.getMode(paramInt1);
      k = View.MeasureSpec.getMode(paramInt2);
      m = y;
      bool1 = E;
      n = 0;
      f1 = 0.0F;
      i1 = 0;
      i2 = 1;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      i7 = 0;
      i8 = 0;
      while (i7 < i)
      {
        localObject1 = getChildAt(i7);
        if (localObject1 == null)
        {
          C += 0;
        }
        else
        {
          if (((View)localObject1).getVisibility() != 8) {
            break label120;
          }
          i7 += 0;
        }
        break label608;
        if (a(i7)) {
          C += J;
        }
        localObject2 = (i0.a)((View)localObject1).getLayoutParams();
        f2 = a;
        f1 += f2;
        if ((k == 1073741824) && (height == 0) && (f2 > 0.0F))
        {
          i1 = C;
          C = Math.max(i1, topMargin + i1 + bottomMargin);
          i1 = 1;
        }
        else
        {
          if ((height == 0) && (a > 0.0F))
          {
            height = -2;
            i9 = 0;
          }
          else
          {
            i9 = Integer.MIN_VALUE;
          }
          if (f1 == 0.0F) {
            i10 = C;
          } else {
            i10 = 0;
          }
          localObject3 = localObject2;
          a((View)localObject1, paramInt1, 0, paramInt2, i10);
          if (i9 != Integer.MIN_VALUE) {
            height = i9;
          }
          i10 = ((View)localObject1).getMeasuredHeight();
          i9 = C;
          C = Math.max(i9, i9 + i10 + topMargin + bottomMargin + 0);
          if (bool1) {
            i4 = Math.max(i10, i4);
          }
        }
        if ((m >= 0) && (m == i7 + 1)) {
          z = C;
        }
        if ((i7 < m) && (a > 0.0F)) {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        }
        if ((j != 1073741824) && (width == -1))
        {
          i9 = 1;
          i3 = 1;
        }
        else
        {
          i9 = 0;
        }
        i10 = leftMargin + rightMargin;
        i11 = ((View)localObject1).getMeasuredWidth() + i10;
        i12 = Math.max(i5, i11);
        i13 = View.combineMeasuredStates(i6, ((View)localObject1).getMeasuredState());
        if ((i2 != 0) && (width == -1)) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (a > 0.0F)
        {
          if (i9 == 0) {
            i10 = i11;
          }
          i5 = Math.max(i8, i10);
          i6 = n;
          n = i5;
        }
        else
        {
          if (i9 == 0) {
            i10 = i11;
          }
          i6 = Math.max(n, i10);
          n = i8;
        }
        i7 += 0;
        i5 = i6;
        i6 = i13;
        i9 = i12;
        i8 = n;
        n = i5;
        i5 = i9;
        label608:
        i7++;
      }
      if ((C > 0) && (a(i))) {
        C += J;
      }
      i9 = i;
      if (bool1)
      {
        i = k;
        if ((i == Integer.MIN_VALUE) || (i == 0))
        {
          C = 0;
          for (i = 0; i < i9; i++)
          {
            localObject2 = getChildAt(i);
            if (localObject2 == null)
            {
              C += 0;
            }
            else if (((View)localObject2).getVisibility() == 8)
            {
              i += 0;
            }
            else
            {
              localObject2 = (i0.a)((View)localObject2).getLayoutParams();
              i7 = C;
              C = Math.max(i7, i7 + i4 + topMargin + bottomMargin + 0);
            }
          }
        }
      }
      i7 = k;
      k = C;
      i = getPaddingTop();
      k = getPaddingBottom() + i + k;
      C = k;
      i10 = View.resolveSizeAndState(Math.max(k, getSuggestedMinimumHeight()), paramInt2, 0);
      k = (0xFFFFFF & i10) - C;
      if ((i1 == 0) && ((k == 0) || (f1 <= 0.0F)))
      {
        n = Math.max(n, i8);
        if ((bool1) && (i7 != 1073741824)) {
          for (k = 0; k < i9; k++)
          {
            localObject2 = getChildAt(k);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8) && (getLayoutParamsa > 0.0F)) {
              ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject2).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            }
          }
        }
        k = n;
      }
      else
      {
        f2 = D;
        if (f2 > 0.0F) {
          f1 = f2;
        }
        i = 0;
        C = 0;
        i8 = i7;
        while (i < i9)
        {
          localObject3 = getChildAt(i);
          if (((View)localObject3).getVisibility() != 8)
          {
            localObject2 = (i0.a)((View)localObject3).getLayoutParams();
            f2 = a;
            if (f2 > 0.0F)
            {
              i7 = (int)(k * f2 / f1);
              f1 -= f2;
              i4 = getPaddingLeft();
              i1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingRight() + i4 + leftMargin + rightMargin, width);
              if ((height == 0) && (i8 == 1073741824))
              {
                if (i7 > 0) {
                  i4 = i7;
                } else {
                  i4 = 0;
                }
                ((View)localObject3).measure(i1, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
              }
              else
              {
                i4 = ((View)localObject3).getMeasuredHeight() + i7;
                if (i4 < 0) {
                  i4 = 0;
                }
                ((View)localObject3).measure(i1, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
              }
              i6 = View.combineMeasuredStates(i6, ((View)localObject3).getMeasuredState() & 0xFF00);
              k -= i7;
            }
            i1 = leftMargin + rightMargin;
            i7 = ((View)localObject3).getMeasuredWidth() + i1;
            i4 = Math.max(i5, i7);
            if ((j != 1073741824) && (width == -1)) {
              i5 = 1;
            } else {
              i5 = 0;
            }
            if (i5 != 0) {
              i5 = i1;
            } else {
              i5 = i7;
            }
            n = Math.max(n, i5);
            if ((i2 != 0) && (width == -1)) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            i5 = C;
            C = Math.max(i5, ((View)localObject3).getMeasuredHeight() + i5 + topMargin + bottomMargin + 0);
            i5 = i4;
          }
          i++;
        }
        k = C;
        i4 = getPaddingTop();
        C = (getPaddingBottom() + i4 + k);
        k = n;
      }
      if ((i2 != 0) || (j == 1073741824)) {
        k = i5;
      }
      i2 = getPaddingLeft();
      setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + i2 + k, getSuggestedMinimumWidth()), paramInt1, i6), i10);
      if (i3 != 0) {
        b(i9, paramInt2);
      }
    }
    else
    {
      i9 = paramInt1;
      C = 0;
      m = getVirtualChildCount();
      int i14 = View.MeasureSpec.getMode(paramInt1);
      i12 = View.MeasureSpec.getMode(paramInt2);
      if ((F == null) || (G == null))
      {
        F = new int[4];
        G = new int[4];
      }
      int[] arrayOfInt1 = F;
      int[] arrayOfInt2 = G;
      arrayOfInt1[3] = -1;
      arrayOfInt1[2] = -1;
      arrayOfInt1[1] = -1;
      arrayOfInt1[0] = -1;
      arrayOfInt2[3] = -1;
      arrayOfInt2[2] = -1;
      arrayOfInt2[1] = -1;
      arrayOfInt2[0] = -1;
      boolean bool2 = x;
      bool1 = E;
      if (i14 == 1073741824) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      f1 = 0.0F;
      i2 = 0;
      i8 = 0;
      n = 1;
      i5 = 0;
      i3 = 0;
      k = 0;
      i = 0;
      i6 = 0;
      i4 = 0;
      while (i3 < m)
      {
        localObject3 = getChildAt(i3);
        if (localObject3 == null)
        {
          C += 0;
        }
        else
        {
          i7 = i2;
          i10 = ((View)localObject3).getVisibility();
          i7 = k;
          if (i10 != 8) {
            break label1679;
          }
          i3 += 0;
        }
        break label2306;
        label1679:
        if (a(i3)) {
          C += I;
        }
        localObject2 = (i0.a)((View)localObject3).getLayoutParams();
        f2 = a;
        f1 += f2;
        if ((i14 == 1073741824) && (width == 0) && (f2 > 0.0F))
        {
          if (i1 != 0)
          {
            i7 = C;
            C = (leftMargin + rightMargin + i7);
          }
          else
          {
            i7 = C;
            C = Math.max(i7, leftMargin + i7 + rightMargin);
          }
          if (bool2)
          {
            i7 = View.MeasureSpec.makeMeasureSpec(0, 0);
            ((View)localObject3).measure(i7, i7);
            i7 = i6;
          }
          else
          {
            i8 = 1;
            break label2030;
          }
        }
        else
        {
          if ((width == 0) && (a > 0.0F))
          {
            width = -2;
            i7 = 0;
          }
          else
          {
            i7 = Integer.MIN_VALUE;
          }
          if (f1 == 0.0F) {
            i10 = C;
          } else {
            i10 = 0;
          }
          a((View)localObject3, paramInt1, i10, paramInt2, 0);
          if (i7 != Integer.MIN_VALUE) {
            width = i7;
          }
          localObject1 = localObject2;
          i10 = ((View)localObject3).getMeasuredWidth();
          if (i1 != 0)
          {
            i7 = C;
            C = e.a.a.a.a.a(leftMargin + i10, rightMargin, 0, i7);
          }
          else
          {
            i7 = C;
            C = Math.max(i7, i7 + i10 + leftMargin + rightMargin + 0);
          }
          i7 = i6;
          if (bool1) {
            i7 = Math.max(i10, i6);
          }
        }
        i6 = i7;
        label2030:
        i7 = k;
        if ((i12 != 1073741824) && (height == -1))
        {
          i10 = 1;
          i5 = 1;
        }
        else
        {
          i10 = 0;
        }
        j = topMargin + bottomMargin;
        i11 = ((View)localObject3).getMeasuredHeight() + j;
        i13 = View.combineMeasuredStates(i, ((View)localObject3).getMeasuredState());
        if (bool2)
        {
          int i15 = ((View)localObject3).getBaseline();
          if (i15 != -1)
          {
            i = b;
            k = i;
            if (i < 0) {
              k = B;
            }
            k = ((k & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
            arrayOfInt1[k] = Math.max(arrayOfInt1[k], i15);
            arrayOfInt2[k] = Math.max(arrayOfInt2[k], i11 - i15);
          }
        }
        i = j;
        j = Math.max(i2, i11);
        if ((n != 0) && (height == -1)) {
          k = 1;
        } else {
          k = 0;
        }
        if (a > 0.0F)
        {
          if (i10 != 0) {
            i11 = i;
          }
          n = Math.max(i4, i11);
          i2 = i7;
        }
        else
        {
          if (i10 != 0) {
            i11 = i;
          }
          i2 = Math.max(i7, i11);
          n = i4;
        }
        i7 = i3 + 0;
        i3 = j;
        i = i13;
        i4 = n;
        n = k;
        k = i2;
        i2 = i3;
        i3 = i7;
        label2306:
        i3++;
      }
      i7 = k;
      if ((C > 0) && (a(m))) {
        C += I;
      }
      if ((arrayOfInt1[1] == -1) && (arrayOfInt1[0] == -1) && (arrayOfInt1[2] == -1) && (arrayOfInt1[3] == -1)) {
        break label2445;
      }
      k = Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2])));
      i2 = Math.max(i2, Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))) + k);
      label2445:
      k = i12;
      if ((bool1) && ((i14 == Integer.MIN_VALUE) || (i14 == 0)))
      {
        C = 0;
        for (i3 = 0; i3 < m; i3++)
        {
          localObject2 = getChildAt(i3);
          if (localObject2 == null)
          {
            C += 0;
          }
          else if (((View)localObject2).getVisibility() == 8)
          {
            i3 += 0;
          }
          else
          {
            localObject2 = (i0.a)((View)localObject2).getLayoutParams();
            if (i1 != 0)
            {
              i10 = C;
              C = e.a.a.a.a.a(leftMargin + i6, rightMargin, 0, i10);
            }
            else
            {
              i10 = C;
              C = Math.max(i10, i10 + i6 + leftMargin + rightMargin + 0);
            }
          }
        }
      }
      i10 = C;
      i3 = getPaddingLeft();
      i3 = getPaddingRight() + i3 + i10;
      C = i3;
      i11 = View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i9, 0);
      i3 = (0xFFFFFF & i11) - C;
      if ((i8 == 0) && ((i3 == 0) || (f1 <= 0.0F)))
      {
        i3 = Math.max(i7, i4);
        if ((bool1) && (i14 != 1073741824)) {
          for (i4 = 0; i4 < m; i4++)
          {
            localObject2 = getChildAt(i4);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8) && (getLayoutParamsa > 0.0F)) {
              ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject2).getMeasuredHeight(), 1073741824));
            }
          }
        }
        i6 = k;
        i4 = i3;
        k = i;
      }
      else
      {
        f2 = D;
        if (f2 > 0.0F) {
          f1 = f2;
        }
        arrayOfInt1[3] = -1;
        arrayOfInt1[2] = -1;
        arrayOfInt1[1] = -1;
        arrayOfInt1[0] = -1;
        arrayOfInt2[3] = -1;
        arrayOfInt2[2] = -1;
        arrayOfInt2[1] = -1;
        arrayOfInt2[0] = -1;
        C = 0;
        i4 = -1;
        i8 = 0;
        i6 = k;
        k = i;
        i2 = i3;
        i3 = i4;
        i4 = i7;
        while (i8 < m)
        {
          localObject3 = getChildAt(i8);
          if ((localObject3 != null) && (((View)localObject3).getVisibility() != 8))
          {
            localObject2 = (i0.a)((View)localObject3).getLayoutParams();
            f2 = a;
            if (f2 > 0.0F)
            {
              i7 = (int)(i2 * f2 / f1);
              j = getPaddingTop();
              i9 = getPaddingBottom();
              i12 = topMargin;
              i13 = bottomMargin;
              i10 = height;
              i = i2 - i7;
              i9 = ViewGroup.getChildMeasureSpec(paramInt2, i9 + j + i12 + i13, i10);
              if ((width == 0) && (i14 == 1073741824))
              {
                if (i7 > 0) {
                  i2 = i7;
                } else {
                  i2 = 0;
                }
                ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), i9);
              }
              else
              {
                i2 = ((View)localObject3).getMeasuredWidth() + i7;
                if (i2 < 0) {
                  i2 = 0;
                }
                ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), i9);
              }
              k = View.combineMeasuredStates(k, ((View)localObject3).getMeasuredState() & 0xFF000000);
              f1 -= f2;
              i2 = i;
            }
            if (i1 != 0)
            {
              i = C;
              C = e.a.a.a.a.a(((View)localObject3).getMeasuredWidth() + leftMargin, rightMargin, 0, i);
            }
            else
            {
              i = C;
              C = Math.max(i, ((View)localObject3).getMeasuredWidth() + i + leftMargin + rightMargin + 0);
            }
            if ((i6 != 1073741824) && (height == -1)) {
              i = 1;
            } else {
              i = 0;
            }
            i10 = topMargin + bottomMargin;
            i9 = ((View)localObject3).getMeasuredHeight() + i10;
            i7 = Math.max(i3, i9);
            if (i != 0) {
              i3 = i10;
            } else {
              i3 = i9;
            }
            i3 = Math.max(i4, i3);
            if ((n != 0) && (height == -1)) {
              n = 1;
            } else {
              n = 0;
            }
            if (bool2)
            {
              i10 = ((View)localObject3).getBaseline();
              if (i10 != -1)
              {
                i = b;
                i4 = i;
                if (i < 0) {
                  i4 = B;
                }
                i4 = ((i4 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                arrayOfInt1[i4] = Math.max(arrayOfInt1[i4], i10);
                arrayOfInt2[i4] = Math.max(arrayOfInt2[i4], i9 - i10);
              }
            }
            i4 = i3;
            i3 = i7;
          }
          i8++;
        }
        i8 = C;
        i2 = getPaddingLeft();
        C = (getPaddingRight() + i2 + i8);
        if ((arrayOfInt1[1] == -1) && (arrayOfInt1[0] == -1) && (arrayOfInt1[2] == -1) && (arrayOfInt1[3] == -1))
        {
          i2 = i3;
        }
        else
        {
          i2 = Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2])));
          i2 = Math.max(i3, Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))) + i2);
        }
      }
      if ((n != 0) || (i6 == 1073741824)) {
        i4 = i2;
      }
      i2 = getPaddingTop();
      setMeasuredDimension(0xFF000000 & k | i11, View.resolveSizeAndState(Math.max(getPaddingBottom() + i2 + i4, getSuggestedMinimumHeight()), paramInt2, k << 16));
      if (i5 != 0) {
        a(m, paramInt1);
      }
    }
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    x = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      y = paramInt;
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("base aligned child index out of range (0, ");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == H) {
      return;
    }
    H = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null)
    {
      I = paramDrawable.getIntrinsicWidth();
      J = paramDrawable.getIntrinsicHeight();
    }
    else
    {
      I = 0;
      J = 0;
    }
    if (paramDrawable == null) {
      bool = true;
    }
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt)
  {
    L = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (B != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      B = paramInt;
      requestLayout();
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    int i = paramInt & 0x800007;
    paramInt = B;
    if ((0x800007 & paramInt) != i)
    {
      B = (i | 0xFF7FFFF8 & paramInt);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    E = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (A != paramInt)
    {
      A = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != K) {
      requestLayout();
    }
    K = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    int i = B;
    if ((i & 0x70) != paramInt)
    {
      B = (paramInt | i & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    D = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.i0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */