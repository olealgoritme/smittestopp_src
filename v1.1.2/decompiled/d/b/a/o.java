package d.b.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import d.i.i.n;
import d.i.i.s;
import d.i.i.t;
import d.i.i.u;
import java.lang.ref.WeakReference;

public class o
  implements Runnable
{
  public o(k paramk) {}
  
  public void run()
  {
    Object localObject1 = x;
    K.showAtLocation(J, 55, 0, 0);
    x.d();
    if (x.j())
    {
      x.J.setAlpha(0.0F);
      Object localObject2 = x;
      localObject1 = n.a(J);
      ((s)localObject1).a(1.0F);
      M = ((s)localObject1);
      s locals = x.M;
      localObject2 = new a();
      localObject1 = (View)a.get();
      if (localObject1 != null) {
        locals.a((View)localObject1, (t)localObject2);
      }
    }
    else
    {
      x.J.setAlpha(1.0F);
      x.J.setVisibility(0);
    }
  }
  
  public class a
    extends u
  {
    public a() {}
    
    public void b(View paramView)
    {
      x.J.setAlpha(1.0F);
      x.M.a(null);
      x.M = null;
    }
    
    public void c(View paramView)
    {
      x.J.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */