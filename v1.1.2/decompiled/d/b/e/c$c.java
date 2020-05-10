package d.b.e;

import android.view.View;
import d.b.d.i.b;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.d.i.n;

public class c$c
  implements Runnable
{
  public c.e x;
  
  public c$c(c paramc, c.e parame)
  {
    x = parame;
  }
  
  public void run()
  {
    h localh = y.z;
    if (localh != null)
    {
      localObject = e;
      if (localObject != null) {
        ((h.a)localObject).a(localh);
      }
    }
    Object localObject = (View)y.E;
    if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (x.d())) {
      y.S = x;
    }
    y.U = null;
  }
}

/* Location:
 * Qualified Name:     d.b.e.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */