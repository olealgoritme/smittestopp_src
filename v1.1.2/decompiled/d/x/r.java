package d.x;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

public class r
  implements s
{
  public final ViewGroupOverlay a;
  
  public r(ViewGroup paramViewGroup)
  {
    a = paramViewGroup.getOverlay();
  }
  
  public void a(View paramView)
  {
    a.remove(paramView);
  }
}

/* Location:
 * Qualified Name:     d.x.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */