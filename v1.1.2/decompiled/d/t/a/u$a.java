package d.t.a;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import d.i.i.a;
import d.i.i.x.d;

public class u$a
  extends a
{
  public final u d;
  
  public u$a(u paramu)
  {
    d = paramu;
  }
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    if ((!d.a()) && (d.d.getLayoutManager() != null)) {
      d.d.getLayoutManager().a(paramView, paramd);
    }
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!d.a()) && (d.d.getLayoutManager() != null)) {
      paramView = d.d.getLayoutManager().b.y;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     d.t.a.u.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */