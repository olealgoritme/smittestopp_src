package h.b.a;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectionKey;

public class i
  extends AbstractSelectionKey
{
  public final j a;
  public final g b;
  public int c = 0;
  public int d = 0;
  public int e = -1;
  
  public i(j paramj, g paramg)
  {
    a = paramj;
    b = paramg;
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
    j localj = a;
    if (localj != null)
    {
      int i;
      if ((paramInt & 0x11) != 0) {
        i = (short)1;
      } else {
        i = 0;
      }
      int j = i;
      if ((paramInt & 0xC) != 0) {
        j = (short)(i | 0x4);
      }
      localj.a(e, j);
      return this;
    }
    throw null;
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
 * Qualified Name:     h.b.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */