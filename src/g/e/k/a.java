package g.e.k;

import g.a.d.f;
import g.b.a.d;
import g.b.a.g;
import g.b.a.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

public abstract class a
  extends SocketChannel
  implements ByteChannel, g
{
  public static final int y = f.SHUT_RD.intValue();
  public static final int z = f.SHUT_WR.intValue();
  public final b x;
  
  public a(int paramInt)
  {
    super(h.a());
    x = new b(paramInt);
  }
  
  public final int getFD()
  {
    return x.a;
  }
  
  public void implCloseSelectableChannel()
  {
    e.c.a.a.b.l.c.a(x.a);
  }
  
  public void implConfigureBlocking(boolean paramBoolean)
  {
    int i = x.a;
    int j = d.a.a(i, g.b.a.c.a, 0);
    if (paramBoolean) {
      j = g.b.a.c.c & j;
    } else {
      j = g.b.a.c.c | j;
    }
    d.a.a(i, g.b.a.c.b, j);
  }
  
  public long read(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
  {
    b localb = x;
    if (localb != null)
    {
      long l1 = 0L;
      long l2;
      for (int i = 0;; i++)
      {
        l2 = l1;
        if (i >= paramInt2) {
          break;
        }
        l2 = localb.a(paramArrayOfByteBuffer[(paramInt1 + i)]);
        if (l2 == -1L) {
          break;
        }
        l1 += l2;
      }
      return l2;
    }
    throw null;
  }
  
  public SocketChannel shutdownInput()
  {
    int i = x.a;
    int j = y;
    if (d.a.a(i, j) >= 0) {
      return this;
    }
    throw new IOException(e.c.a.a.b.l.c.b());
  }
  
  public SocketChannel shutdownOutput()
  {
    int i = x.a;
    int j = z;
    if (d.a.a(i, j) >= 0) {
      return this;
    }
    throw new IOException(e.c.a.a.b.l.c.b());
  }
}

/* Location:
 * Qualified Name:     base.g.e.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */