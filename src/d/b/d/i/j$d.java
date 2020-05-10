package d.b.d.i;

import android.view.MenuItem;

public class j$d
  implements MenuItem.OnActionExpandListener
{
  public final MenuItem.OnActionExpandListener a;
  
  public j$d(j paramj, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    a = paramOnActionExpandListener;
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return a.onMenuItemActionCollapse(b.a(paramMenuItem));
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return a.onMenuItemActionExpand(b.a(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */