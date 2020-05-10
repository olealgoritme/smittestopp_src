package d.b.d.i;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import d.b.e.j0;
import java.util.List;

public class e$c
  implements j0
{
  public e$c(e parame) {}
  
  public void a(final h paramh, final MenuItem paramMenuItem)
  {
    Handler localHandler = x.D;
    final e.d locald = null;
    localHandler.removeCallbacksAndMessages(null);
    int i = x.F.size();
    for (int j = 0; j < i; j++) {
      if (paramh == x.F.get(j)).b) {
        break label76;
      }
    }
    j = -1;
    label76:
    if (j == -1) {
      return;
    }
    j++;
    if (j < x.F.size()) {
      locald = (e.d)x.F.get(j);
    }
    paramMenuItem = new a(locald, paramMenuItem, paramh);
    long l = SystemClock.uptimeMillis();
    x.D.postAtTime(paramMenuItem, paramh, l + 200L);
  }
  
  public void b(h paramh, MenuItem paramMenuItem)
  {
    x.D.removeCallbacksAndMessages(paramh);
  }
  
  public class a
    implements Runnable
  {
    public a(e.d paramd, MenuItem paramMenuItem, h paramh) {}
    
    public void run()
    {
      e.d locald = locald;
      if (locald != null)
      {
        x.X = true;
        b.a(false);
        x.X = false;
      }
      if ((paramMenuItem.isEnabled()) && (paramMenuItem.hasSubMenu())) {
        paramh.a(paramMenuItem, 4);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */