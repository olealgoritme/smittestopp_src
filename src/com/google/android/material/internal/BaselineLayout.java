package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout
  extends ViewGroup
{
  public int x = -1;
  
  public BaselineLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    return x;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = getPaddingTop();
    for (paramInt2 = 0; paramInt2 < i; paramInt2++)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        int i2 = (paramInt3 - paramInt1 - k - j - n) / 2 + j;
        if ((x != -1) && (localView.getBaseline() != -1)) {
          paramInt4 = x + m - localView.getBaseline();
        } else {
          paramInt4 = m;
        }
        localView.layout(i2, paramInt4, n + i2, i1 + paramInt4);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = -1;
    int i2 = -1;
    while (j < i)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        int i3 = localView.getBaseline();
        int i4 = i1;
        i5 = i2;
        if (i3 != -1)
        {
          i4 = Math.max(i1, i3);
          i5 = Math.max(i2, localView.getMeasuredHeight() - i3);
        }
        m = Math.max(m, localView.getMeasuredWidth());
        k = Math.max(k, localView.getMeasuredHeight());
        n = View.combineMeasuredStates(n, localView.getMeasuredState());
        i2 = i5;
        i1 = i4;
      }
      j++;
    }
    int i5 = k;
    if (i1 != -1)
    {
      i5 = Math.max(k, Math.max(i2, getPaddingBottom()) + i1);
      x = i1;
    }
    i2 = Math.max(i5, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(m, getSuggestedMinimumWidth()), paramInt1, n), View.resolveSizeAndState(i2, paramInt2, n << 16));
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.internal.BaselineLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */