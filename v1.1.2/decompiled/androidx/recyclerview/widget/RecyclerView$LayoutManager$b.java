package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import d.t.a.w.b;

public class RecyclerView$LayoutManager$b
  implements w.b
{
  public RecyclerView$LayoutManager$b(RecyclerView.LayoutManager paramLayoutManager) {}
  
  public int a()
  {
    RecyclerView.LayoutManager localLayoutManager = a;
    return p - localLayoutManager.f();
  }
  
  public int a(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getTop() - getLayoutParamsb.top - topMargin;
    }
    throw null;
  }
  
  public View a(int paramInt)
  {
    return a.a(paramInt);
  }
  
  public int b()
  {
    return a.i();
  }
  
  public int b(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getBottom() + getLayoutParamsb.bottom + bottomMargin;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutManager.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */