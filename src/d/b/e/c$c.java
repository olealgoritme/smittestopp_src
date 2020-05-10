package d.b.e;

import android.view.View;
import d.b.d.i.b;
import d.b.d.i.g;
import d.b.d.i.g.a;
import d.b.d.i.l;

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
    Object localObject = y.z;
    if (localObject != null)
    {
      g.a locala = e;
      if (locala != null) {
        locala.a((g)localObject);
      }
    }
    localObject = (View)y.E;
    if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (x.d())) {
      y.R = x;
    }
    y.T = null;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */