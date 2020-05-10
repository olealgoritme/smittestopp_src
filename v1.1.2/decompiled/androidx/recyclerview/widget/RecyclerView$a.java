package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import d.i.i.n;
import d.t.a.c;
import d.t.a.d;
import d.t.a.e;
import d.t.a.f;
import d.t.a.k;
import d.t.a.k.a;
import d.t.a.k.b;
import java.util.ArrayList;
import java.util.Iterator;

public class RecyclerView$a
  implements Runnable
{
  public RecyclerView$a(RecyclerView paramRecyclerView) {}
  
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
        Object localObject2 = h.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          RecyclerView.w localw = (RecyclerView.w)((Iterator)localObject2).next();
          View localView = a;
          localObject3 = localView.animate();
          q.add(localw);
          ((ViewPropertyAnimator)localObject3).setDuration(d).alpha(0.0F).setListener(new f((k)localObject1, localw, (ViewPropertyAnimator)localObject3, localView)).start();
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
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).addAll(k);
          n.add(localObject3);
          k.clear();
          localObject2 = new d((k)localObject1, (ArrayList)localObject3);
          if (bool1) {
            n.a(get0a.a, (Runnable)localObject2, d);
          } else {
            ((d)localObject2).run();
          }
        }
        if (bool4)
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).addAll(i);
          l.add(localObject2);
          i.clear();
          localObject3 = new e((k)localObject1, (ArrayList)localObject2);
          if ((!bool1) && (!bool2) && (!bool3))
          {
            ((e)localObject3).run();
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
            n.a(get0a, (Runnable)localObject3, l3 + l2);
          }
        }
      }
    }
    x.I0 = false;
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */