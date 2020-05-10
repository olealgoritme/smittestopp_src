package androidx.coordinatorlayout.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

public class CoordinatorLayout$e
  implements ViewGroup.OnHierarchyChangeListener
{
  public CoordinatorLayout$e(CoordinatorLayout paramCoordinatorLayout) {}
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = x.M;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    x.b(2);
    ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = x.M;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.coordinatorlayout.widget.CoordinatorLayout.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */