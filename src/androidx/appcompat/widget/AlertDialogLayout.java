package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.R.id;
import d.b.e.i0;
import d.b.e.i0.a;
import d.i.i.n;

public class AlertDialogLayout
  extends i0
{
  public AlertDialogLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(View paramView)
  {
    int i = n.j(paramView);
    if (i > 0) {
      return i;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getChildCount() == 1) {
        return a(paramView.getChildAt(0));
      }
    }
    return 0;
  }
  
  private void b(int paramInt1, int paramInt2)
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    paramInt1 = getMeasuredHeight();
    int n = getChildCount();
    int i1 = getGravity();
    paramInt3 = i1 & 0x70;
    if (paramInt3 != 16)
    {
      if (paramInt3 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - paramInt1;
      }
    }
    else
    {
      paramInt3 = getPaddingTop();
      paramInt1 = (paramInt4 - paramInt2 - paramInt1) / 2 + paramInt3;
    }
    Object localObject = getDividerDrawable();
    paramInt3 = 0;
    if (localObject == null) {
      paramInt2 = 0;
    } else {
      paramInt2 = ((Drawable)localObject).getIntrinsicHeight();
    }
    while (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      paramInt4 = paramInt1;
      if (localView != null)
      {
        paramInt4 = paramInt1;
        if (localView.getVisibility() != 8)
        {
          int i2 = localView.getMeasuredWidth();
          int i3 = localView.getMeasuredHeight();
          localObject = (i0.a)localView.getLayoutParams();
          int i4 = b;
          paramInt4 = i4;
          if (i4 < 0) {
            paramInt4 = i1 & 0x800007;
          }
          paramInt4 = Gravity.getAbsoluteGravity(paramInt4, n.i(this)) & 0x7;
          if (paramInt4 != 1)
          {
            if (paramInt4 != 5)
            {
              paramInt4 = leftMargin + i;
              break label308;
            }
            paramInt4 = j - k - i2;
            i4 = rightMargin;
          }
          else
          {
            paramInt4 = (j - i - m - i2) / 2 + i + leftMargin;
            i4 = rightMargin;
          }
          paramInt4 -= i4;
          label308:
          i4 = paramInt1;
          if (a(paramInt3)) {
            i4 = paramInt1 + paramInt2;
          }
          paramInt1 = i4 + topMargin;
          localView.layout(paramInt4, paramInt1, i2 + paramInt4, i3 + paramInt1);
          paramInt4 = i3 + bottomMargin + paramInt1;
        }
      }
      paramInt3++;
      paramInt1 = paramInt4;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    Object localObject1 = null;
    int j = 0;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    View localView;
    for (int k = 0; k < i; k++)
    {
      localView = getChildAt(k);
      if (localView.getVisibility() != 8)
      {
        m = localView.getId();
        if (m == R.id.topPanel)
        {
          localObject1 = localView;
        }
        else if (m == R.id.buttonPanel)
        {
          localObject2 = localView;
        }
        else
        {
          if (m != R.id.contentPanel)
          {
            n = j;
            if (m != R.id.customPanel) {
              break label606;
            }
          }
          if (localObject3 != null)
          {
            n = j;
            break label606;
          }
          localObject3 = localView;
        }
      }
    }
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int n = getPaddingTop();
    j = getPaddingBottom() + n;
    if (localObject1 != null)
    {
      ((View)localObject1).measure(paramInt1, 0);
      j += ((View)localObject1).getMeasuredHeight();
      k = View.combineMeasuredStates(0, ((View)localObject1).getMeasuredState());
    }
    else
    {
      k = 0;
    }
    int i4;
    if (localObject2 != null)
    {
      ((View)localObject2).measure(paramInt1, 0);
      n = a((View)localObject2);
      i4 = ((View)localObject2).getMeasuredHeight() - n;
      j += n;
      k = View.combineMeasuredStates(k, ((View)localObject2).getMeasuredState());
    }
    else
    {
      n = 0;
      i4 = 0;
    }
    int i5;
    if (localObject3 != null)
    {
      if (i1 == 0) {
        m = 0;
      } else {
        m = View.MeasureSpec.makeMeasureSpec(Math.max(0, i2 - j), i1);
      }
      ((View)localObject3).measure(paramInt1, m);
      i5 = ((View)localObject3).getMeasuredHeight();
      j += i5;
      k = View.combineMeasuredStates(k, ((View)localObject3).getMeasuredState());
    }
    else
    {
      i5 = 0;
    }
    int i6 = i2 - j;
    i2 = k;
    int i7 = i6;
    int m = j;
    if (localObject2 != null)
    {
      i4 = Math.min(i6, i4);
      i2 = i6;
      m = n;
      if (i4 > 0)
      {
        i2 = i6 - i4;
        m = n + i4;
      }
      ((View)localObject2).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(m, 1073741824));
      m = j - n + ((View)localObject2).getMeasuredHeight();
      n = View.combineMeasuredStates(k, ((View)localObject2).getMeasuredState());
      i7 = i2;
      i2 = n;
    }
    k = i2;
    n = m;
    if (localObject3 != null)
    {
      k = i2;
      n = m;
      if (i7 > 0)
      {
        ((View)localObject3).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i5 + i7, i1));
        n = m - i5 + ((View)localObject3).getMeasuredHeight();
        k = View.combineMeasuredStates(i2, ((View)localObject3).getMeasuredState());
      }
    }
    m = 0;
    for (j = 0; m < i; j = i2)
    {
      localView = getChildAt(m);
      i2 = j;
      if (localView.getVisibility() != 8) {
        i2 = Math.max(j, localView.getMeasuredWidth());
      }
      m++;
    }
    m = getPaddingLeft();
    setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + m + j, paramInt1, k), View.resolveSizeAndState(n, paramInt2, 0));
    if (i3 != 1073741824) {
      b(i, paramInt2);
    }
    n = 1;
    label606:
    if (n == 0) {
      super.onMeasure(paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.AlertDialogLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */