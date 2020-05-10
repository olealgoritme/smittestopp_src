package d.t.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import d.i.i.n;
import java.util.ArrayList;
import java.util.Iterator;

public class s$a
  implements Runnable
{
  public s$a(s params) {}
  
  public void run()
  {
    Object localObject1 = x.k0;
    if (localObject1 != null)
    {
      localObject1 = (k)localObject1;
      boolean bool1 = h.isEmpty() ^ true;
      boolean bool2 = j.isEmpty() ^ true;
      boolean bool3 = k.isEmpty() ^ true;
      boolean bool4 = i.isEmpty() ^ true;
      if ((bool1) || (bool2) || (bool4) || (bool3))
      {
        Iterator localIterator = h.iterator();
        Object localObject2;
        Object localObject3;
        while (localIterator.hasNext())
        {
          localObject2 = (s.x)localIterator.next();
          localObject3 = a;
          ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
          q.add(localObject2);
          localViewPropertyAnimator.setDuration(d).alpha(0.0F).setListener(new f((k)localObject1, (s.x)localObject2, localViewPropertyAnimator, (View)localObject3)).start();
        }
        h.clear();
        if (bool2)
        {
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).addAll(j);
          m.add(localObject3);
          j.clear();
          localObject2 = new c((k)localObject1, (ArrayList)localObject3);
          if (bool1) {
            n.a(get0a.a, (Runnable)localObject2, d);
          } else {
            ((c)localObject2).run();
          }
        }
        if (bool3)
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).addAll(k);
          n.add(localObject2);
          k.clear();
          localObject3 = new d((k)localObject1, (ArrayList)localObject2);
          if (bool1) {
            n.a(get0a.a, (Runnable)localObject3, d);
          } else {
            ((d)localObject3).run();
          }
        }
        if (bool4)
        {
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).addAll(i);
          l.add(localObject3);
          i.clear();
          localObject2 = new e((k)localObject1, (ArrayList)localObject3);
          if ((!bool1) && (!bool2) && (!bool3))
          {
            ((e)localObject2).run();
          }
          else
          {
            long l1 = 0L;
            long l2;
            if (bool1) {
              l2 = d;
            } else {
              l2 = 0L;
            }
            if (bool2) {
              l3 = e;
            } else {
              l3 = 0L;
            }
            if (bool3) {
              l1 = f;
            }
            long l3 = Math.max(l3, l1);
            n.a(get0a, (Runnable)localObject2, l3 + l2);
          }
        }
      }
    }
    x.I0 = false;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */