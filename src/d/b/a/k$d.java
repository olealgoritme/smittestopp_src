package d.b.a;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import d.b.d.a;
import d.b.d.a.a;
import d.i.i.n;

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
    if (M != null) {
      B.getDecorView().removeCallbacks(b.N);
    }
    parama = b;
    if (L != null)
    {
      parama.e();
      localObject = b;
      parama = n.a(L);
      parama.a(0.0F);
      O = parama;
      parama = b.O;
      k.d.a locala = new k.d.a(this);
      localObject = (View)a.get();
      if (localObject != null) {
        parama.a((View)localObject, locala);
      }
    }
    Object localObject = b;
    parama = D;
    if (parama != null) {
      parama.b(K);
    }
    b.K = null;
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
}

/* Location:
 * Qualified Name:     base.d.b.a.k.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */