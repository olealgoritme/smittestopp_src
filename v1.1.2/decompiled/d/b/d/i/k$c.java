package d.b.d.i;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

public class k$c
  extends d<MenuItem.OnActionExpandListener>
  implements MenuItem.OnActionExpandListener
{
  public k$c(k paramk, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)a).onMenuItemActionCollapse(b.a(paramMenuItem));
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)a).onMenuItemActionExpand(b.a(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.k.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */