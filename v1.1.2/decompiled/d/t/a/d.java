package d.t.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.w;
import java.util.ArrayList;
import java.util.Iterator;

public class d
  implements Runnable
{
  public d(k paramk, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = x.iterator();
    while (localIterator.hasNext())
    {
      k.a locala = (k.a)localIterator.next();
      k localk = y;
      View localView = null;
      if (localk != null)
      {
        Object localObject1 = a;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = a;
        }
        Object localObject2 = b;
        if (localObject2 != null) {
          localView = a;
        }
        if (localObject1 != null)
        {
          localObject2 = ((View)localObject1).animate().setDuration(f);
          r.add(a);
          ((ViewPropertyAnimator)localObject2).translationX(e - c);
          ((ViewPropertyAnimator)localObject2).translationY(f - d);
          ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new i(localk, locala, (ViewPropertyAnimator)localObject2, (View)localObject1)).start();
        }
        if (localView != null)
        {
          localObject1 = localView.animate();
          r.add(b);
          ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(f).alpha(1.0F).setListener(new j(localk, locala, (ViewPropertyAnimator)localObject1, localView)).start();
        }
      }
      else
      {
        throw null;
      }
    }
    x.clear();
    y.n.remove(x);
  }
}

/* Location:
 * Qualified Name:     d.t.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */