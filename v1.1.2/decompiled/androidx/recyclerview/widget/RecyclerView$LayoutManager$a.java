package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import d.t.a.w.b;

public class RecyclerView$LayoutManager$a
  implements w.b
{
  public RecyclerView$LayoutManager$a(RecyclerView.LayoutManager paramLayoutManager) {}
  
  public int a()
  {
    RecyclerView.LayoutManager localLayoutManager = a;
    return o - localLayoutManager.h();
  }
  
  public int a(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getLeft() - getLayoutParamsb.left - leftMargin;
    }
    throw null;
  }
  
  public View a(int paramInt)
  {
    return a.a(paramInt);
  }
  
  public int b()
  {
    return a.g();
  }
  
  public int b(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getRight() + getLayoutParamsb.right + rightMargin;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutManager.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */