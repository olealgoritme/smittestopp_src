package l.a.b.a.g.i;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import l.a.b.a.g.g;

public class k
{
  public final Selector a;
  public final HashSet<g> b = new HashSet();
  public final HashSet<g> c = new HashSet();
  public final HashSet<g> d = new HashSet();
  public final HashSet<g> e = new HashSet();
  public final HashSet<g> f = new HashSet();
  
  public k(c paramc)
  {
    if (paramc != null)
    {
      a = Selector.open();
      return;
    }
    throw null;
  }
  
  public void a(g paramg)
  {
    if (paramg.N() != null)
    {
      int i = 0;
      int j;
      if (((paramg.N() instanceof SocketChannel)) && (((SocketChannel)paramg.N()).isConnectionPending()))
      {
        j = 8;
      }
      else
      {
        if (paramg.w()) {
          if ((paramg.N() instanceof ServerSocketChannel)) {
            i = 16;
          } else {
            i = 1;
          }
        }
        j = i;
        if (paramg.C()) {
          j = i | 0x4;
        }
      }
      paramg.N().keyFor(a).interestOps(j);
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.g.i.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */