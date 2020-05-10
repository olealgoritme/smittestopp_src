package e.c.a.a.b.i.k;

import android.util.Log;
import e.c.a.a.b.a;
import e.c.a.a.b.i.a.f;
import e.c.a.a.b.j.k;
import java.util.Collections;
import java.util.Map;

public final class s
  implements Runnable
{
  public s(c.c paramc, a parama) {}
  
  public final void run()
  {
    if (x.b())
    {
      c.c localc1 = y;
      e = true;
      if (a.i())
      {
        localc1 = y;
        if (e)
        {
          k localk = c;
          if (localk != null) {
            a.a(localk, d);
          }
        }
        return;
      }
      try
      {
        y.a.a(null, Collections.emptySet());
        return;
      }
      catch (SecurityException localSecurityException)
      {
        Log.e("GoogleApiManager", "Failed to get service from broker. ", localSecurityException);
        localc2 = y;
        ((c.a)f.i.get(b)).a(new a(10));
        return;
      }
    }
    c.c localc2 = y;
    ((c.a)f.i.get(b)).a(x);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */