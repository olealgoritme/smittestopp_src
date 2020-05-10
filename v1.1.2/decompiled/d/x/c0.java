package d.x;

import android.view.View;
import android.view.WindowId;

public class c0
  implements d0
{
  public final WindowId a;
  
  public c0(View paramView)
  {
    a = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof c0)) && (a.equals(a))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
}

/* Location:
 * Qualified Name:     d.x.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */