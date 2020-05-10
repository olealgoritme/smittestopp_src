package d.t.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class s
  implements b.b
{
  public s(RecyclerView paramRecyclerView) {}
  
  public int a()
  {
    return a.getChildCount();
  }
  
  public View a(int paramInt)
  {
    return a.getChildAt(paramInt);
  }
  
  public void b(int paramInt)
  {
    View localView = a.getChildAt(paramInt);
    if (localView != null) {
      if (a != null)
      {
        RecyclerView.b(localView);
        localView.clearAnimation();
      }
      else
      {
        throw null;
      }
    }
    a.removeViewAt(paramInt);
  }
}

/* Location:
 * Qualified Name:     d.t.a.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */