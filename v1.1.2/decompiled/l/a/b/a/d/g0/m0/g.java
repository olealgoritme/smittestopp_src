package l.a.b.a.d.g0.m0;

import java.nio.ByteBuffer;
import l.a.b.a.d.a0;
import l.a.b.a.d.a0.b;
import l.a.b.a.d.g0.f0;
import l.a.b.a.d.g0.l0;
import l.a.b.a.d.z;

public class g
  implements z, l.a.b.a.d.g0.d0
{
  public h b;
  public final a0 c;
  public final c d;
  public final l.a.b.a.d.b0 e;
  public l.a.b.a.d.d0 f;
  
  public g(a0 parama0, l.a.b.a.d.b0 paramb0)
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
  
  public l0 wrap(l.a.b.a.d.g0.b0 paramb0, f0 paramf0)
  {
    if (b == null)
    {
      paramb0 = new b(paramb0, paramf0, null);
      b = paramb0;
      return paramb0;
    }
    throw new IllegalStateException("Transport already wrapped");
  }
  
  public class b
    implements h
  {
    public final l.a.b.a.d.g0.b0 a;
    public final f0 b;
    public h c;
    
    public final void a()
    {
      try
      {
        if ((d.f == null) && (c == null))
        {
          d locald = new l/a/b/a/d/g0/m0/d;
          locald.<init>(d.d.a(d.e), a, b);
          if ((e)d.c != null) {
            c = locald;
          } else {
            throw null;
          }
        }
      }
      catch (l.a.b.a.d.d0 locald0)
      {
        d.f = locald0;
      }
    }
    
    public int capacity()
    {
      a();
      if (d.f == null) {
        return c.capacity();
      }
      return -1;
    }
    
    public void close_head()
    {
      a();
      if (d.f == null) {
        c.close_head();
      }
    }
    
    public void close_tail()
    {
      a();
      if (d.f == null) {
        c.close_tail();
      }
    }
    
    public ByteBuffer head()
    {
      a();
      if (d.f == null) {
        return c.head();
      }
      return null;
    }
    
    public int pending()
    {
      a();
      if (d.f == null) {
        return c.pending();
      }
      throw new l.a.b.a.d.d0(d.f);
    }
    
    public void pop(int paramInt)
    {
      a();
      if (d.f == null) {
        c.pop(paramInt);
      }
    }
    
    public int position()
    {
      a();
      if (d.f == null) {
        return c.position();
      }
      return -1;
    }
    
    public void process()
    {
      a();
      if (d.f == null)
      {
        c.process();
        return;
      }
      throw new l.a.b.a.d.d0(d.f);
    }
    
    public ByteBuffer tail()
    {
      a();
      if (d.f == null) {
        return c.tail();
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.m0.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */