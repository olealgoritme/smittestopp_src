package l.a.b.a.d.g0;

import java.nio.ByteBuffer;

public class o
  implements l0
{
  public final f0 a;
  public final b0 b;
  
  public o(f0 paramf0, b0 paramb0)
  {
    a = paramf0;
    b = paramb0;
  }
  
  public int capacity()
  {
    return b.capacity();
  }
  
  public void close_head()
  {
    a.close_head();
  }
  
  public void close_tail()
  {
    b.close_tail();
  }
  
  public ByteBuffer head()
  {
    return a.head();
  }
  
  public int pending()
  {
    return a.pending();
  }
  
  public void pop(int paramInt)
  {
    a.pop(paramInt);
  }
  
  public int position()
  {
    return b.position();
  }
  
  public void process()
  {
    b.process();
  }
  
  public ByteBuffer tail()
  {
    return b.tail();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */