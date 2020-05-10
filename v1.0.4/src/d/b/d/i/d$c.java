package d.b.d.i;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;

import d.b.e.l0;

public class d$c
  implements l0
{
  public d$c(d paramd) {}
  
  public void a(g paramg, MenuItem paramMenuItem)
  {
    Handler localHandler = x.D;
    d.d locald = null;
    localHandler.removeCallbacksAndMessages(null);
    int i = x.F.size();
    for (int j = 0; j < i; j++) {
      if (paramg == x.F.get(j)).b) {
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
      locald = (d.d)x.F.get(j);
    }
    paramMenuItem = new d.c.a(this, locald, paramMenuItem, paramg);
    long l = SystemClock.uptimeMillis();
    x.D.postAtTime(paramMenuItem, paramg, l + 200L);
  }
  
  public void b(g paramg, MenuItem paramMenuItem)
  {
    x.D.removeCallbacksAndMessages(paramg);
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.d.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */