package d.b.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import d.i.i.s;
import d.i.i.t;
import d.i.i.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class g
{
  public final ArrayList<s> a = new ArrayList();
  public long b = -1L;
  public Interpolator c;
  public t d;
  public boolean e;
  public final u f = new a();
  
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
      Object localObject = (s)localIterator.next();
      long l = b;
      if (l >= 0L) {
        ((s)localObject).a(l);
      }
      Interpolator localInterpolator = c;
      if (localInterpolator != null)
      {
        View localView = (View)a.get();
        if (localView != null) {
          localView.animate().setInterpolator(localInterpolator);
        }
      }
      if (d != null) {
        ((s)localObject).a(f);
      }
      localObject = (View)a.get();
      if (localObject != null) {
        ((View)localObject).animate().start();
      }
    }
    e = true;
  }
  
  public class a
    extends u
  {
    public boolean a = false;
    public int b = 0;
    
    public a() {}
    
    public void b(View paramView)
    {
      int i = b + 1;
      b = i;
      if (i == a.size())
      {
        paramView = d;
        if (paramView != null) {
          paramView.b(null);
        }
        b = 0;
        a = false;
        e = false;
      }
    }
    
    public void c(View paramView)
    {
      if (a) {
        return;
      }
      a = true;
      paramView = d;
      if (paramView != null) {
        paramView.c(null);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */