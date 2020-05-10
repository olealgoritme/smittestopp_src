package d.b.d.i;

import android.view.MenuItem;

public class j$e
  implements MenuItem.OnMenuItemClickListener
{
  public final MenuItem.OnMenuItemClickListener a;
  
  public j$e(j paramj, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a = paramOnMenuItemClickListener;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return a.onMenuItemClick(b.a(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.j.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */