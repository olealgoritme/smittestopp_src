package d.t.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.k;

public final class q
  extends r
{
  public q(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, null);
  }
  
  public int a()
  {
    RecyclerView.LayoutManager localLayoutManager = a;
    return p - localLayoutManager.f();
  }
  
  public int a(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getBottom() + getLayoutParamsb.bottom + bottomMargin;
    }
    throw null;
  }
  
  public int b()
  {
    return a.i();
  }
  
  public int b(View paramView)
  {
    RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getTop() - getLayoutParamsb.top - topMargin;
    }
    throw null;
  }
  
  public int c()
  {
    RecyclerView.LayoutManager localLayoutManager = a;
    return p - localLayoutManager.i() - a.f();
  }
}

/* Location:
 * Qualified Name:     d.t.a.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */