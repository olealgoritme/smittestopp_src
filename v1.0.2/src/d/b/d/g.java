package d.b.d;

import android.view.View;
import android.view.animation.Interpolator;

import java.util.ArrayList;
import java.util.Iterator;

import d.i.i.s;
import d.i.i.t;
import d.i.i.u;

public class g
{
  public final ArrayList<s> a = new ArrayList();
  public long b = -1L;
  public Interpolator c;
  public t d;
  public boolean e;
  public final u f = new g.a(this);
  
  public void a()
  {
    if (!e) {
      return;
    }
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).a();
    }
    e = false;
  }
  
  public void b()
  {
    if (e) {
      return;
    }
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      long l = b;
      if (l >= 0L) {
        locals.a(l);
      }
      Interpolator localInterpolator = c;
      if (localInterpolator != null)
      {
        localView = (View)a.get();
        if (localView != null) {
          localView.animate().setInterpolator(localInterpolator);
        }
      }
      if (d != null) {
        locals.a(f);
      }
      View localView = (View)a.get();
      if (localView != null) {
        localView.animate().start();
      }
    }
    e = true;
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */