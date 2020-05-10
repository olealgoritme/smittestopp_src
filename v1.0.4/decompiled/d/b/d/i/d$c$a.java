package d.b.d.i;

import android.view.MenuItem;

public class d$c$a
  implements Runnable
{
  public d$c$a(d.c paramc, d.d paramd, MenuItem paramMenuItem, g paramg) {}
  
  public void run()
  {
    d.d locald = x;
    if (locald != null)
    {
      A.x.X = true;
      b.a(false);
      A.x.X = false;
    }
    if ((y.isEnabled()) && (y.hasSubMenu())) {
      z.a(y, 4);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.d.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */