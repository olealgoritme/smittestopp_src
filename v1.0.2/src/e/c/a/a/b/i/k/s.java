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
      Object localObject = y;
      e = true;
      if (a.g())
      {
        c.c localc2 = y;
        if (e)
        {
          localObject = c;
          if (localObject != null) {
            a.a((k)localObject, d);
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
        localc1 = y;
        ((c.a)f.i.get(b)).a(new a(10));
        return;
      }
    }
    c.c localc1 = y;
    ((c.a)f.i.get(b)).a(x);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */