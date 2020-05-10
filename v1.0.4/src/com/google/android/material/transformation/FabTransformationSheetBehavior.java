package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import d.i.i.n;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  public Map<View, Integer> g;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramView2.getParent();
    if ((localObject instanceof CoordinatorLayout))
    {
      localObject = (CoordinatorLayout)localObject;
      int i = ((ViewGroup)localObject).getChildCount();
      if (paramBoolean1) {
        g = new HashMap(i);
      }
      for (int j = 0; j < i; j++)
      {
        View localView = ((ViewGroup)localObject).getChildAt(j);
        int k;
        if (((localView.getLayoutParams() instanceof CoordinatorLayout.f)) && ((getLayoutParamsa instanceof FabTransformationScrimBehavior))) {
          k = 1;
        } else {
          k = 0;
        }
        if ((localView != paramView2) && (k == 0)) {
          if (!paramBoolean1)
          {
            Map localMap = g;
            if ((localMap != null) && (localMap.containsKey(localView))) {
              n.e(localView, ((Integer)g.get(localView)).intValue());
            }
          }
          else
          {
            g.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
            n.e(localView, 4);
          }
        }
      }
      if (!paramBoolean1) {
        g = null;
      }
    }
    super.a(paramView1, paramView2, paramBoolean1, paramBoolean2);
    return true;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.transformation.FabTransformationSheetBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */