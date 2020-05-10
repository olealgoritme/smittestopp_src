package d.b.a;

import android.view.View;

import d.i.i.n;
import d.i.i.s;
import d.i.i.t;

public class o
  implements Runnable
{
  public o(k paramk) {}
  
  public void run()
  {
    Object localObject1 = x;
    M.showAtLocation(L, 55, 0, 0);
    x.e();
    if (x.l())
    {
      x.L.setAlpha(0.0F);
      localObject1 = x;
      Object localObject2 = n.a(L);
      ((s)localObject2).a(1.0F);
      O = ((s)localObject2);
      s locals = x.O;
      localObject2 = new o.a(this);
      localObject1 = (View)a.get();
      if (localObject1 != null) {
        locals.a((View)localObject1, (t)localObject2);
      }
    }
    else
    {
      x.L.setAlpha(1.0F);
      x.L.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */