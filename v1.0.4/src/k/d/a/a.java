package k.d.a;

import java.util.concurrent.ExecutorService;

public class a
  implements Runnable, l
{
  public final k x;
  public final c y;
  
  public a(c paramc)
  {
    y = paramc;
    x = new k();
  }
  
  public void a(q paramq, Object paramObject)
  {
    paramq = j.a(paramq, paramObject);
    x.a(paramq);
    y.j.execute(this);
  }
  
  public void run()
  {
    j localj = x.a();
    if (localj != null)
    {
      y.a(localj);
      return;
    }
    throw new IllegalStateException("No pending post available");
  }
}

/* Location:
 * Qualified Name:     base.k.d.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */