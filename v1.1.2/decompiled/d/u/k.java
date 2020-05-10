package d.u;

import d.w.a.f;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class k
{
  public final AtomicBoolean a = new AtomicBoolean(false);
  public final g b;
  public volatile f c;
  
  public k(g paramg)
  {
    b = paramg;
  }
  
  public f a()
  {
    b.a();
    Object localObject;
    if (a.compareAndSet(false, true))
    {
      if (c == null)
      {
        localObject = b();
        c = b.a((String)localObject);
      }
      localObject = c;
    }
    else
    {
      localObject = b();
      localObject = b.a((String)localObject);
    }
    return (f)localObject;
  }
  
  public void a(f paramf)
  {
    if (paramf == c) {
      a.set(false);
    }
  }
  
  public abstract String b();
}

/* Location:
 * Qualified Name:     d.u.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */