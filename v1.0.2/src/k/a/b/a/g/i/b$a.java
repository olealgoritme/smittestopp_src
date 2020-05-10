package k.a.b.a.g.i;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import k.a.b.a.d.c0;
import k.a.b.a.d.d0;
import k.a.b.a.g.d;
import k.a.b.a.g.g;
import k.a.b.a.g.g.a;

public final class b$a
  implements g.a
{
  public void a(g paramg)
  {
    d locald = paramg.b();
    c0 localc0 = J;
    if (localc0.capacity() > 0)
    {
      SocketChannel localSocketChannel = (SocketChannel)paramg.I();
      try
      {
        if (localSocketChannel.read(localc0.tail()) == -1) {
          localc0.close_tail();
        } else {
          localc0.process();
        }
      }
      catch (d0 locald0) {}catch (IOException localIOException) {}
      k.a.b.a.b.n.j localj = new k.a.b.a.b.n.j();
      localj.a(k.a.b.a.b.f.a("proton:io"));
      b = localIOException.getMessage();
      localc0.a(localj);
      localc0.close_tail();
    }
    b.c(paramg);
    locald.a(paramg);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.g.i.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */