package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import e.c.a.b.m.d;

public final class Snackbar$SnackbarLayout
  extends d
{
  public Snackbar$SnackbarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public Snackbar$SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getChildCount();
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
    {
      View localView = getChildAt(paramInt1);
      if (getLayoutParamswidth == -1) {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.snackbar.Snackbar.SnackbarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */