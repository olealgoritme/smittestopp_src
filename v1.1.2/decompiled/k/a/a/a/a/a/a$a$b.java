package k.a.a.a.a.a;

import android.os.Handler;
import android.os.SystemClock;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class a$a$b
  implements Runnable
{
  public a$a$b(a.a parama) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtimeNanos();
    synchronized (x.a)
    {
      Iterator localIterator = x.l.values().iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (A < l - x.g.H)
        {
          localIterator.remove();
          Handler localHandler = x.i;
          a locala = new k/a/a/a/a/a/a$a$b$a;
          locala.<init>(this, localj);
          localHandler.post(locala);
        }
      }
      if (!x.l.isEmpty()) {
        x.i.postDelayed(this, x.g.I);
      }
      return;
    }
  }
  
  public class a
    implements Runnable
  {
    public a(j paramj) {}
    
    public void run()
    {
      x.h.a(4, x);
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */