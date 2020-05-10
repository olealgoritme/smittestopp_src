package k.a.b.a.g;

import k.a.b.a.b.n.q;
import k.a.b.a.b.n.r;
import k.a.b.a.d.a;
import k.a.b.a.d.f;
import k.a.b.a.d.h;
import k.a.b.a.d.n;

public class c
  extends a
{
  public final void a(f paramf)
  {
    if (paramf.J() != k.a.b.a.d.g.CLOSED) {
      paramf.close();
    }
  }
  
  public final void b(f paramf)
  {
    if (paramf.J() == k.a.b.a.d.g.UNINITIALIZED) {
      paramf.open();
    }
  }
  
  public void onConnectionRemoteClose(h paramh)
  {
    a(((k.a.b.a.d.g0.g)paramh).U());
  }
  
  public void onConnectionRemoteOpen(h paramh)
  {
    b(((k.a.b.a.d.g0.g)paramh).U());
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    a(((k.a.b.a.d.g0.g)paramh).G());
  }
  
  public void onLinkRemoteOpen(h paramh)
  {
    paramh = ((k.a.b.a.d.g0.g)paramh).G();
    if (paramh.J() == k.a.b.a.d.g.UNINITIALIZED)
    {
      if (paramh.z() != null) {
        paramh.a(paramh.z().a());
      }
      if (paramh.r() != null) {
        paramh.a(paramh.r().a());
      }
    }
    b(paramh);
  }
  
  public void onSessionRemoteClose(h paramh)
  {
    a(((k.a.b.a.d.g0.g)paramh).T());
  }
  
  public void onSessionRemoteOpen(h paramh)
  {
    b(((k.a.b.a.d.g0.g)paramh).T());
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */