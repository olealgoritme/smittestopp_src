package e.c.a.a.g;

import e.c.a.a.b.i.k.b0;

public final class e
  implements Runnable
{
  public e(d paramd, h paramh) {}
  
  public final void run()
  {
    if (x.d)
    {
      y.c.b();
      return;
    }
    try
    {
      y.b.a(x);
      y.c.a(null);
      return;
    }
    catch (Exception localException)
    {
      y.c.a(localException);
      return;
    }
    catch (a locala)
    {
      if ((locala.getCause() instanceof Exception))
      {
        y.c.a((Exception)locala.getCause());
        return;
      }
      y.c.a(locala);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.g.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */