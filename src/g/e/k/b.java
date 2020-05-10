package g.e.k;

import e.c.a.a.b.l.c;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
{
  public int a = -1;
  
  public b(int paramInt)
  {
    a = paramInt;
  }
  
  public int a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    int i = c.a(a, localByteBuffer);
    localByteBuffer.flip();
    paramByteBuffer.put(localByteBuffer);
    if (i != -1)
    {
      if (i != 0) {
        return i;
      }
      return -1;
    }
    i = c.a().ordinal();
    if ((i != 34) && (i != 35)) {
      throw new IOException(c.b());
    }
    return 0;
  }
  
  public int b(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.put(paramByteBuffer);
    localByteBuffer.position(0);
    int j = c.b(a, localByteBuffer);
    if (j >= 0)
    {
      if (j < i) {
        paramByteBuffer.position(paramByteBuffer.position() - (i - j));
      }
      return j;
    }
    j = c.a().ordinal();
    if ((j != 34) && (j != 35)) {
      throw new IOException(c.b());
    }
    paramByteBuffer.position(paramByteBuffer.position() - i);
    return 0;
  }
}

/* Location:
 * Qualified Name:     base.g.e.k.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */