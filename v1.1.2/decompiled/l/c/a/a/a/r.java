package l.c.a.a.a;

import java.util.Timer;
import java.util.TimerTask;
import l.c.a.a.a.s.a;
import l.c.a.a.a.t.c;

public class r
  implements o
{
  public l.c.a.a.a.t.b a = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "l.c.a.a.a.r");
  public a b;
  public Timer c;
  public String d;
  
  public class a
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
}

/* Location:
 * Qualified Name:     l.c.a.a.a.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */