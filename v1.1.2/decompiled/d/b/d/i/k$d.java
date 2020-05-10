package d.b.d.i;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public class k$d
  extends d<MenuItem.OnMenuItemClickListener>
  implements MenuItem.OnMenuItemClickListener
{
  public k$d(k paramk, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)a).onMenuItemClick(b.a(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.k.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */