package d.t.a;

import android.view.View;
import android.view.ViewGroup;

public class t
  implements b.b
{
  public t(s params) {}
  
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
        s.b(localView);
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
 * Qualified Name:     base.d.t.a.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */