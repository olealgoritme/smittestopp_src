package d.t.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

public class e
  implements Runnable
{
  public e(k paramk, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = x.iterator();
    while (localIterator.hasNext())
    {
      s.x localx = (s.x)localIterator.next();
      k localk = y;
      if (localk != null)
      {
        View localView = a;
        ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
        o.add(localx);
        localViewPropertyAnimator.alpha(1.0F).setDuration(c).setListener(new g(localk, localx, localView, localViewPropertyAnimator)).start();
      }
      else
      {
        throw null;
      }
    }
    x.clear();
    y.l.remove(x);
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */