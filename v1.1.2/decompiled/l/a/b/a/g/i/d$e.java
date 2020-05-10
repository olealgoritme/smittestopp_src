package l.a.b.a.g.i;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SourceChannel;
import l.a.b.a.g.g;
import l.a.b.a.g.g.a;

public class d$e
  implements g.a
{
  public void a(g paramg)
  {
    try
    {
      a.J.source().read(ByteBuffer.allocate(64));
      d.a(a, paramg);
      return;
    }
    catch (IOException paramg)
    {
      throw new RuntimeException(paramg);
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.g.i.d.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */