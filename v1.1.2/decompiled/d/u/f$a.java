package d.u;

import java.util.concurrent.Executor;

public class f$a
  extends c.a
{
  public f$a(f paramf) {}
  
  public void a(final String[] paramArrayOfString)
  {
    a.g.execute(new a(paramArrayOfString));
  }
  
  public class a
    implements Runnable
  {
    public a(String[] paramArrayOfString) {}
    
    public void run()
    {
      a.d.a(paramArrayOfString);
    }
  }
}

/* Location:
 * Qualified Name:     d.u.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */