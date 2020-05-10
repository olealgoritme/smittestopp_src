package g.b.a;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectionKey;

public class a
  extends AbstractSelectionKey
{
  public final b a;
  public final g b;
  public int c = 0;
  public int d = 0;
  
  public a(b paramb, g paramg, int paramInt)
  {
    a = paramb;
    b = paramg;
    c = paramInt;
  }
  
  public int a()
  {
    return b.getFD();
  }
  
  public SelectableChannel channel()
  {
    return (SelectableChannel)b;
  }
  
  public int interestOps()
  {
    return c;
  }
  
  public SelectionKey interestOps(int paramInt)
  {
    c = paramInt;
    a.a(this);
    return this;
  }
  
  public int readyOps()
  {
    return d;
  }
  
  public Selector selector()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     base.g.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */