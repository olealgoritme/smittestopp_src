package d.b.e;

import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import d.b.a.a.c;

public class q0$a
  extends LinearLayout
{
  public a.c x;
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
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

/* Location:
 * Qualified Name:     base.d.b.e.q0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */