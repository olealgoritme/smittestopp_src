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
      CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localObject;
      int i = localCoordinatorLayout.getChildCount();
      if (paramBoolean1) {
        g = new HashMap(i);
      }
      for (int j = 0; j < i; j++)
      {
        localObject = localCoordinatorLayout.getChildAt(j);
        int k;
        if (((((View)localObject).getLayoutParams() instanceof CoordinatorLayout.f)) && ((getLayoutParamsa instanceof FabTransformationScrimBehavior))) {
          k = 1;
        } else {
          k = 0;
        }
        if ((localObject != paramView2) && (k == 0)) {
          if (!paramBoolean1)
          {
            Map localMap = g;
            if ((localMap != null) && (localMap.containsKey(localObject))) {
              n.e((View)localObject, ((Integer)g.get(localObject)).intValue());
            }
          }
          else
          {
            g.put(localObject, Integer.valueOf(((View)localObject).getImportantForAccessibility()));
            n.e((View)localObject, 4);
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
 * Qualified Name:     com.google.android.material.transformation.FabTransformationSheetBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */