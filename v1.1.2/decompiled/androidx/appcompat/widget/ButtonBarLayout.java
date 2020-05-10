package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import d.i.i.n;

public class ButtonBarLayout
  extends LinearLayout
{
  public boolean x;
  public int y = -1;
  public int z = 0;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ButtonBarLayout);
    x = paramContext.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
    paramContext.recycle();
  }
  
  private void setStacked(boolean paramBoolean)
  {
    setOrientation(paramBoolean);
    int i;
    if (paramBoolean) {
      i = 5;
    } else {
      i = 80;
    }
    setGravity(i);
    View localView = findViewById(R.id.spacer);
    if (localView != null)
    {
      if (paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = true;
      }
      localView.setVisibility(paramBoolean);
    }
    for (paramBoolean = getChildCount() - 2; !paramBoolean; paramBoolean--) {
      bringChildToFront(getChildAt(paramBoolean));
    }
  }
  
  public final int a(int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      if (getChildAt(paramInt).getVisibility() == 0) {
        return paramInt;
      }
      paramInt++;
    }
    return -1;
  }
  
  public final boolean a()
  {
    int i = getOrientation();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public int getMinimumHeight()
  {
    return Math.max(z, super.getMinimumHeight());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    boolean bool = x;
    int j = 0;
    if (bool)
    {
      if ((i > y) && (a())) {
        setStacked(false);
      }
      y = i;
    }
    int k;
    if ((!a()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      k = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
      i = 1;
    }
    else
    {
      k = paramInt1;
      i = 0;
    }
    super.onMeasure(k, paramInt2);
    int m = i;
    if (x)
    {
      m = i;
      if (!a())
      {
        if ((getMeasuredWidthAndState() & 0xFF000000) == 16777216) {
          k = 1;
        } else {
          k = 0;
        }
        m = i;
        if (k != 0)
        {
          setStacked(true);
          m = 1;
        }
      }
    }
    if (m != 0) {
      super.onMeasure(paramInt1, paramInt2);
    }
    paramInt2 = a(0);
    paramInt1 = j;
    if (paramInt2 >= 0)
    {
      View localView = getChildAt(paramInt2);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      paramInt1 = getPaddingTop();
      paramInt1 = localView.getMeasuredHeight() + paramInt1 + topMargin + bottomMargin + 0;
      if (a())
      {
        paramInt2 = a(paramInt2 + 1);
        if (paramInt2 >= 0) {
          paramInt1 = getChildAt(paramInt2).getPaddingTop() + (int)(getResourcesgetDisplayMetricsdensity * 16.0F) + paramInt1;
        }
      }
      else
      {
        paramInt1 = getPaddingBottom() + paramInt1;
      }
    }
    if (n.j(this) != paramInt1) {
      setMinimumHeight(paramInt1);
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    if (x != paramBoolean)
    {
      x = paramBoolean;
      if ((!paramBoolean) && (getOrientation() == 1)) {
        setStacked(false);
      }
      requestLayout();
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.ButtonBarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */