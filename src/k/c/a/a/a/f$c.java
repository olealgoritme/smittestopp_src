package k.c.a.a.a;

import java.util.TimerTask;
import k.c.a.a.a.t.b;

public class f$c
  extends TimerTask
{
  public void run()
  {
    x.x.b(f.I, "ReconnectTask.run", "506");
    f localf = x;
    x.b(f.I, "attemptReconnect", "500", new Object[] { y });
    try
    {
      i locali = D;
      Object localObject = E;
      f.a locala = new k/c/a/a/a/f$a;
      locala.<init>(localf, "attemptReconnect");
      localf.a(locali, localObject, locala);
    }
    catch (k localk)
    {
      x.a(f.I, "attemptReconnect", "804", null, localk);
    }
    catch (p localp)
    {
      x.a(f.I, "attemptReconnect", "804", null, localp);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */