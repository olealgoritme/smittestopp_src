package e.c.a.a.g;

import e.c.a.a.b.i.k.b0;
import java.util.concurrent.Executor;

public final class d<TResult, TContinuationResult>
  implements f<TResult>
{
  public final Executor a;
  public final b0<TResult, TContinuationResult> b;
  public final h<TContinuationResult> c;
  
  public d(Executor paramExecutor, b0<TResult, TContinuationResult> paramb0, h<TContinuationResult> paramh)
  {
    a = paramExecutor;
    b = paramb0;
    c = paramh;
  }
  
  public final void a(h<TResult> paramh)
  {
    a.execute(new e(this, paramh));
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.g.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */