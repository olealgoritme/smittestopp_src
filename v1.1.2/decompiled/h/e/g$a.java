package h.e;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public final class g$a
  implements ReadableByteChannel, WritableByteChannel
{
  public final i x;
  
  public g$a(i parami)
  {
    x = parami;
  }
  
  public void close()
  {
    x.close();
  }
  
  public boolean isOpen()
  {
    return x.isOpen();
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    return x.read(paramByteBuffer);
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    return x.write(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     h.e.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */