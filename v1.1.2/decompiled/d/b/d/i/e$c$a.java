package d.b.d.i;

import android.view.MenuItem;

public class e$c$a
  implements Runnable
{
  public e$c$a(e.c paramc, e.d paramd, MenuItem paramMenuItem, h paramh) {}
  
  public void run()
  {
    e.d locald = x;
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
 * Qualified Name:     d.b.d.i.e.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */