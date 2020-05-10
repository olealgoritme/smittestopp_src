package d.t.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.w;
import java.util.ArrayList;
import java.util.Iterator;

public class c
  implements Runnable
{
  public c(k paramk, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = x.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (k.b)localIterator.next();
      k localk = y;
      RecyclerView.w localw = a;
      int i = b;
      int j = c;
      int k = d;
      int m = e;
      if (localk != null)
      {
        localObject = a;
        k -= i;
        m -= j;
        if (k != 0) {
          ((View)localObject).animate().translationX(0.0F);
        }
        if (m != 0) {
          ((View)localObject).animate().translationY(0.0F);
        }
        ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
        p.add(localw);
        localViewPropertyAnimator.setDuration(e).setListener(new h(localk, localw, k, (View)localObject, m, localViewPropertyAnimator)).start();
      }
      else
      {
        throw null;
      }
    }
    x.clear();
    y.m.remove(x);
  }
}

/* Location:
 * Qualified Name:     d.t.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */