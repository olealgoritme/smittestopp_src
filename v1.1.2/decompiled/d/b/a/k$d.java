package d.b.a;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import d.b.d.a;
import d.b.d.a.a;
import d.i.i.n;
import d.i.i.s;
import d.i.i.t;
import d.i.i.u;
import java.lang.ref.WeakReference;

public class k$d
  implements a.a
{
  public a.a a;
  
  public k$d(k paramk, a.a parama)
  {
    a = parama;
  }
  
  public void a(a parama)
  {
    a.a(parama);
    parama = b;
    if (K != null) {
      y.getDecorView().removeCallbacks(b.L);
    }
    parama = b;
    if (J != null)
    {
      parama.d();
      localObject = b;
      parama = n.a(J);
      parama.a(0.0F);
      M = parama;
      s locals = b.M;
      localObject = new a();
      parama = (View)a.get();
      if (parama != null) {
        locals.a(parama, (t)localObject);
      }
    }
    parama = b;
    Object localObject = B;
    if (localObject != null) {
      ((i)localObject).b(I);
    }
    b.I = null;
  }
  
  public boolean a(a parama, Menu paramMenu)
  {
    return a.a(parama, paramMenu);
  }
  
  public boolean a(a parama, MenuItem paramMenuItem)
  {
    return a.a(parama, paramMenuItem);
  }
  
  public boolean b(a parama, Menu paramMenu)
  {
    return a.b(parama, paramMenu);
  }
  
  public class a
    extends u
  {
    public a() {}
    
    public void b(View paramView)
    {
      b.J.setVisibility(8);
      paramView = b;
      PopupWindow localPopupWindow = K;
      if (localPopupWindow != null) {
        localPopupWindow.dismiss();
      } else if ((J.getParent() instanceof View)) {
        n.y((View)b.J.getParent());
      }
      b.J.removeAllViews();
      b.M.a(null);
      b.M = null;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */