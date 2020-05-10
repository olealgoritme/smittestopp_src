package d.t.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.k;

public final class p
  extends r
{
  public p(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, null);
  }
  
  public int a()
  {
    RecyclerView.LayoutManager localLayoutManager = a;
    return o - localLayoutManager.h();
  }
  
  public int a(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getRight() + getLayoutParamsb.right + rightMargin;
    }
    throw null;
  }
  
  public int b()
  {
    return a.g();
  }
  
  public int b(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getLeft() - getLayoutParamsb.left - leftMargin;
    }
    throw null;
  }
  
  public int c()
  {
    RecyclerView.LayoutManager localLayoutManager = a;
    return o - localLayoutManager.g() - a.h();
  }
}

/* Location:
 * Qualified Name:     d.t.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */