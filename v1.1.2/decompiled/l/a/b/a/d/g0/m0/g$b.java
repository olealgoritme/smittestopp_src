package l.a.b.a.d.g0.m0;

import java.nio.ByteBuffer;
import l.a.b.a.d.d0;
import l.a.b.a.d.g0.b0;
import l.a.b.a.d.g0.f0;

public class g$b
  implements h
{
  public final b0 a;
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
    catch (d0 locald0)
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
    throw new d0(d.f);
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
    throw new d0(d.f);
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

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.m0.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */