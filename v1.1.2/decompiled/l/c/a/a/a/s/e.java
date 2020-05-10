package l.c.a.a.a.s;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import l.c.a.a.a.k;
import l.c.a.a.a.s.s.g;
import l.c.a.a.a.s.s.u;
import l.c.a.a.a.t.c;

public class e
  implements Runnable
{
  public static final String I = e.class.getName();
  public final Object A;
  public Thread B;
  public String C;
  public Future<?> D;
  public b E;
  public g F;
  public a G;
  public f H;
  public l.c.a.a.a.t.b x = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", I);
  public a y;
  public a z;
  
  public e(a parama, b paramb, f paramf, OutputStream paramOutputStream)
  {
    a locala = a.STOPPED;
    y = locala;
    z = locala;
    A = new Object();
    B = null;
    E = null;
    G = null;
    H = null;
    F = new g(paramb, paramOutputStream);
    G = parama;
    E = paramb;
    H = paramf;
    x.a(c).y);
  }
  
  public final void a(Exception paramException)
  {
    x.a(I, "handleRunException", "804", null, paramException);
    if (!(paramException instanceof k)) {
      paramException = new k(32109, paramException);
    } else {
      paramException = (k)paramException;
    }
    synchronized (A)
    {
      z = a.STOPPED;
      G.a(null, paramException);
      return;
    }
  }
  
  public void a(String arg1, ExecutorService paramExecutorService)
  {
    C = ???;
    synchronized (A)
    {
      if ((y == a.STOPPED) && (z == a.STOPPED))
      {
        z = a.RUNNING;
        if (paramExecutorService == null)
        {
          paramExecutorService = new java/lang/Thread;
          paramExecutorService.<init>(this);
          paramExecutorService.start();
        }
        else
        {
          D = paramExecutorService.submit(this);
        }
      }
      for (;;)
      {
        if (a()) {
          return;
        }
        try
        {
          Thread.sleep(100L);
        }
        catch (Exception ???) {}
      }
    }
  }
  
  public boolean a()
  {
    synchronized (A)
    {
      boolean bool;
      if ((y == a.RUNNING) && (z == a.RUNNING)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    for (;;)
    {
      synchronized (A)
      {
        if (D != null) {
          D.cancel(true);
        }
        x.b(I, "stop", "800");
        if (a())
        {
          z = a.STOPPED;
          E.i();
        }
        if (!a())
        {
          x.b(I, "stop", "801");
          return;
        }
      }
      try
      {
        Thread.sleep(100L);
        E.i();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void run()
  {
    Object localObject1 = Thread.currentThread();
    B = ((Thread)localObject1);
    ((Thread)localObject1).setName(C);
    synchronized (A)
    {
      y = a.RUNNING;
      try
      {
        synchronized (A)
        {
          localObject1 = z;
          if (localObject1 == a.RUNNING)
          {
            localObject1 = F;
            if (localObject1 != null) {
              try
              {
                u localu = E.f();
                if (localu != null)
                {
                  x.b(I, "run", "802", new Object[] { localu.i(), localu });
                  if ((localu instanceof l.c.a.a.a.s.s.b))
                  {
                    F.a(localu);
                    F.z.flush();
                  }
                  else
                  {
                    ??? = d;
                    localObject1 = ???;
                    if (??? == null) {
                      localObject1 = H.a(localu);
                    }
                    if (localObject1 != null)
                    {
                      label205:
                      try
                      {
                        F.a(localu);
                        try
                        {
                          F.z.flush();
                        }
                        catch (IOException localIOException)
                        {
                          if (!(localu instanceof l.c.a.a.a.s.s.e)) {
                            break label205;
                          }
                        }
                        E.f(localu);
                      }
                      finally {}
                      throw localIOException;
                    }
                  }
                }
                else
                {
                  x.b(I, "run", "803");
                  synchronized (A)
                  {
                    z = a.STOPPED;
                  }
                }
                synchronized (A)
                {
                  locala = z;
                }
              }
              catch (Exception localException)
              {
                a(localException);
              }
              catch (k localk)
              {
                a(localk);
              }
            }
          }
          synchronized (A)
          {
            a locala;
            y = a.STOPPED;
            B = null;
            x.b(I, "run", "805");
            return;
          }
        }
        synchronized (A)
        {
          y = a.STOPPED;
          B = null;
          throw ((Throwable)localObject12);
        }
      }
      finally {}
    }
  }
  
  public static enum a
  {
    static
    {
      RUNNING = new a("RUNNING", 1);
      a locala = new a("STARTING", 2);
      STARTING = locala;
      ENUM$VALUES = new a[] { STOPPED, RUNNING, locala };
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */