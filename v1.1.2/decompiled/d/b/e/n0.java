package d.b.e;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.bool;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.styleable;
import d.b.a.a.c;

public class n0
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  public int A;
  public int B;
  public int C;
  public Runnable x;
  public boolean y;
  public int z;
  
  static
  {
    new DecelerateInterpolator();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = x;
    if (localRunnable != null) {
      post(localRunnable);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Context localContext = getContext();
    paramConfiguration = localContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    int i = paramConfiguration.getLayoutDimension(R.styleable.ActionBar_height, 0);
    Resources localResources = localContext.getResources();
    int j = i;
    if (!localContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs)) {
      j = Math.min(i, localResources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    }
    paramConfiguration.recycle();
    setContentHeight(j);
    A = localContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Runnable localRunnable = x;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    x.a();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    throw null;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    y = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    B = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    C = paramInt;
    throw null;
  }
  
  public class a
    extends LinearLayout
  {
    public a.c x;
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(a.c.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(a.c.class.getName());
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (y.z > 0)
      {
        paramInt1 = getMeasuredWidth();
        int i = y.z;
        if (paramInt1 > i) {
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), paramInt2);
        }
      }
    }
    
    public void setSelected(boolean paramBoolean)
    {
      int i;
      if (isSelected() != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.n0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */