package k.a.b.a.d.g0.m0;

import k.a.b.a.d.a0;
import k.a.b.a.d.a0.b;
import k.a.b.a.d.g0.f0;
import k.a.b.a.d.g0.l0;
import k.a.b.a.d.z;

public class g
  implements z, k.a.b.a.d.g0.d0
{
  public h b;
  public final a0 c;
  public final c d;
  public final k.a.b.a.d.b0 e;
  public k.a.b.a.d.d0 f;
  
  public g(a0 parama0, k.a.b.a.d.b0 paramb0)
  {
    c = parama0;
    d = ((c)parama0);
    e = paramb0;
    if (a != null)
    {
      if ((paramb0 == null) && (((e)parama0).a() == a0.b.VERIFY_PEER_NAME)) {
        throw new IllegalArgumentException("Peer hostname verification is enabled, but no peer details were provided");
      }
      return;
    }
    throw new IllegalStateException("Client/server mode must be configured, SslDomain must have init called.");
  }
  
  public l0 wrap(k.a.b.a.d.g0.b0 paramb0, f0 paramf0)
  {
    if (b == null)
    {
      paramb0 = new g.b(this, paramb0, paramf0, null);
      b = paramb0;
      return paramb0;
    }
    throw new IllegalStateException("Transport already wrapped");
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.m0.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */