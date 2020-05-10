package k.c.a.a.a;

import java.util.Timer;
import java.util.TimerTask;
import k.c.a.a.a.s.p;
import k.c.a.a.a.t.b;

public class f$a
  implements a
{
  public final String a;
  
  public f$a(f paramf, String paramString)
  {
    a = paramString;
  }
  
  public final void a(int paramInt)
  {
    ??? = new StringBuilder(String.valueOf(a));
    ((StringBuilder)???).append(":rescheduleReconnectCycle");
    Object localObject2 = ((StringBuilder)???).toString();
    ??? = b;
    x.b(f.I, (String)localObject2, "505", new Object[] { y, String.valueOf(f.J) });
    synchronized (f.K)
    {
      if (b.D.o) {
        if (b.F != null)
        {
          Timer localTimer = b.F;
          localObject2 = new k/c/a/a/a/f$c;
          ((f.c)localObject2).<init>(b, null);
          localTimer.schedule((TimerTask)localObject2, paramInt);
        }
        else
        {
          f.J = paramInt;
          f.a(b);
        }
      }
      return;
    }
  }
  
  public void a(e parame)
  {
    b.x.b(f.I, a, "501", new Object[] { a.k).y });
    parame = b;
    if (A != null)
    {
      parame.c();
      return;
    }
    throw null;
  }
  
  public void a(e parame, Throwable paramThrowable)
  {
    b.x.b(f.I, a, "502", new Object[] { a.k).y });
    int i = f.J;
    if (i < b.D.p) {
      f.J = i * 2;
    }
    a(f.J);
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */