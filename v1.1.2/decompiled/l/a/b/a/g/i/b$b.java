package l.a.b.a.g.i;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import l.a.b.a.d.c0;
import l.a.b.a.g.d;
import l.a.b.a.g.g;
import l.a.b.a.g.g.a;

public final class b$b
  implements g.a
{
  public void a(g paramg)
  {
    d locald = paramg.b();
    c0 localc0 = J;
    int i = localc0.pending();
    if (i > 0)
    {
      Object localObject = (SocketChannel)paramg.N();
      try
      {
        int j = ((SocketChannel)localObject).write(localc0.head());
        if (j < 0) {
          localc0.close_head();
        } else {
          localc0.pop(j);
        }
      }
      catch (IOException localIOException)
      {
        localObject = new l.a.b.a.b.n.j();
        ((l.a.b.a.b.n.j)localObject).a(l.a.b.a.b.f.a("proton:io"));
        b = localIOException.getMessage();
        localc0.a((l.a.b.a.b.n.j)localObject);
        localc0.close_head();
      }
    }
    if (localc0.pending() != i)
    {
      b.c(paramg);
      locald.a(paramg);
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.g.i.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */