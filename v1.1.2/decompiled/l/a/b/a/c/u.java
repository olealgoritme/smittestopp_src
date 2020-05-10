package l.a.b.a.c;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class u
  implements y0
{
  public int a = 0;
  
  public int a()
  {
    return Integer.MAX_VALUE;
  }
  
  public void a(byte paramByte)
  {
    a += 1;
  }
  
  public void a(double paramDouble)
  {
    a += 8;
  }
  
  public void a(float paramFloat)
  {
    a += 4;
  }
  
  public void a(int paramInt)
  {
    a = paramInt;
  }
  
  public void a(long paramLong)
  {
    a += 8;
  }
  
  public void a(String paramString)
  {
    a += paramString.getBytes(StandardCharsets.UTF_8).length;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i = a;
    a = (paramByteBuffer.remaining() + i);
    paramByteBuffer.position(paramByteBuffer.limit());
  }
  
  public void a(short paramShort)
  {
    a += 2;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a += paramInt2;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c()
  {
    return Integer.MAX_VALUE - a;
  }
  
  public void c(int paramInt)
  {
    a += 4;
  }
  
  public int position()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */