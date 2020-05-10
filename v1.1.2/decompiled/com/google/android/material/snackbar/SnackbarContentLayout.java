package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;
import d.i.i.n;

public class SnackbarContentLayout
  extends LinearLayout
{
  public int A;
  public TextView x;
  public Button y;
  public int z;
  
  public SnackbarContentLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    z = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
    A = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getOrientation();
    boolean bool1 = true;
    boolean bool2;
    if (paramInt1 != i)
    {
      setOrientation(paramInt1);
      bool2 = true;
    }
    else
    {
      bool2 = false;
    }
    if ((x.getPaddingTop() == paramInt2) && (x.getPaddingBottom() == paramInt3)) {
      break label116;
    }
    TextView localTextView = x;
    if (n.v(localTextView))
    {
      localTextView.setPaddingRelative(localTextView.getPaddingStart(), paramInt2, localTextView.getPaddingEnd(), paramInt3);
      bool2 = bool1;
    }
    else
    {
      localTextView.setPadding(localTextView.getPaddingLeft(), paramInt2, localTextView.getPaddingRight(), paramInt3);
      bool2 = bool1;
    }
    label116:
    return bool2;
  }
  
  public Button getActionView()
  {
    return y;
  }
  
  public TextView getMessageView()
  {
    return x;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    x = ((TextView)findViewById(R.id.snackbar_text));
    y = ((Button)findViewById(R.id.snackbar_action));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (z > 0)
    {
      j = getMeasuredWidth();
      k = z;
      i = paramInt1;
      if (j > k)
      {
        i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int m = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    int k = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    paramInt1 = x.getLayout().getLineCount();
    int j = 0;
    if (paramInt1 > 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (A > 0) && (y.getMeasuredWidth() > A))
    {
      paramInt1 = j;
      if (!a(1, m, m - k)) {
        break label174;
      }
    }
    else
    {
      if (paramInt1 != 0) {
        k = m;
      }
      paramInt1 = j;
      if (!a(0, k, k)) {
        break label174;
      }
    }
    paramInt1 = 1;
    label174:
    if (paramInt1 != 0) {
      super.onMeasure(i, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.snackbar.SnackbarContentLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */