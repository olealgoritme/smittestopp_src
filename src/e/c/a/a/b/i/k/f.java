package e.c.a.a.b.i.k;

import android.os.Handler;
import android.os.Looper;
import d.b.a.r;

public final class f<L>
{
  public final f.c a;
  public volatile L b;
  public final f.a<L> c;
  
  public f(Looper paramLooper, L paramL, String paramString)
  {
    a = new f.c(this, paramLooper);
    r.b(paramL, "Listener must not be null");
    b = paramL;
    r.a(paramString);
    c = new f.a(paramL, paramString);
  }
  
  public final void a(f.b<? super L> paramb)
  {
    r.b(paramb, "Notifier must not be null");
    paramb = a.obtainMessage(1, paramb);
    a.sendMessage(paramb);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */