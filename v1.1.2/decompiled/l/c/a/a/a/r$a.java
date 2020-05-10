package l.c.a.a.a;

import java.util.TimerTask;
import l.c.a.a.a.s.a;

public class r$a
  extends TimerTask
{
  public void run()
  {
    x.a.b("l.c.a.a.a.r", "PingTask.run", "660", new Object[] { Long.valueOf(System.nanoTime()) });
    a locala = x.b;
    if (locala != null)
    {
      try
      {
        i.a(null);
      }
      catch (Exception localException)
      {
        locala.a(localException);
      }
      catch (k localk)
      {
        locala.a(localk);
      }
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.r.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */