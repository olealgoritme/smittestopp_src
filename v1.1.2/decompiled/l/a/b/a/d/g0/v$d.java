package l.a.b.a.d.g0;

import java.nio.ByteBuffer;

public class v$d
  implements l0
{
  public final b0 a;
  public final f0 b;
  public b0 c;
  public f0 d;
  
  public int capacity()
  {
    return c.capacity();
  }
  
  public void close_head()
  {
    d.close_head();
  }
  
  public void close_tail()
  {
    c.close_tail();
  }
  
  public ByteBuffer head()
  {
    return d.head();
  }
  
  public int pending()
  {
    return d.pending();
  }
  
  public void pop(int paramInt)
  {
    d.pop(paramInt);
  }
  
  public int position()
  {
    return c.position();
  }
  
  public void process()
  {
    c.process();
  }
  
  public ByteBuffer tail()
  {
    return c.tail();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.v.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */