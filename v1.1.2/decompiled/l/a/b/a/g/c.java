package l.a.b.a.g;

import l.a.b.a.b.n.q;
import l.a.b.a.b.n.r;
import l.a.b.a.d.a;
import l.a.b.a.d.f;
import l.a.b.a.d.h;
import l.a.b.a.d.n;

public class c
  extends a
{
  public final void a(f paramf)
  {
    if (paramf.t() != l.a.b.a.d.g.CLOSED) {
      paramf.close();
    }
  }
  
  public final void b(f paramf)
  {
    if (paramf.t() == l.a.b.a.d.g.UNINITIALIZED) {
      paramf.open();
    }
  }
  
  public void onConnectionRemoteClose(h paramh)
  {
    a(((l.a.b.a.d.g0.g)paramh).T());
  }
  
  public void onConnectionRemoteOpen(h paramh)
  {
    b(((l.a.b.a.d.g0.g)paramh).T());
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    a(((l.a.b.a.d.g0.g)paramh).r());
  }
  
  public void onLinkRemoteOpen(h paramh)
  {
    paramh = ((l.a.b.a.d.g0.g)paramh).r();
    if (paramh.t() == l.a.b.a.d.g.UNINITIALIZED)
    {
      if (paramh.H() != null) {
        paramh.a(paramh.H().a());
      }
      if (paramh.n() != null) {
        paramh.a(paramh.n().a());
      }
    }
    b(paramh);
  }
  
  public void onSessionRemoteClose(h paramh)
  {
    a(((l.a.b.a.d.g0.g)paramh).y());
  }
  
  public void onSessionRemoteOpen(h paramh)
  {
    b(((l.a.b.a.d.g0.g)paramh).y());
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */