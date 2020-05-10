package l.a.b.a.c;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class m
  implements y0
{
  public final y0 a;
  public final y0 b;
  
  public m(y0 paramy01, y0 paramy02)
  {
    a = paramy01;
    b = paramy02;
  }
  
  public int a()
  {
    int i = a.a();
    return b.a() + i;
  }
  
  public void a(byte paramByte)
  {
    y0 localy0;
    if (a.b()) {
      localy0 = a;
    } else {
      localy0 = b;
    }
    localy0.a(paramByte);
  }
  
  public void a(double paramDouble)
  {
    a(Double.doubleToRawLongBits(paramDouble));
  }
  
  public void a(float paramFloat)
  {
    c(Float.floatToRawIntBits(paramFloat));
  }
  
  public void a(int paramInt)
  {
    int i = a.a();
    if (paramInt <= i)
    {
      a.a(paramInt);
      b.a(0);
    }
    else
    {
      a.a(i);
      b.a(paramInt - i);
    }
  }
  
  public void a(long paramLong)
  {
    int i = a.c();
    if (i >= 8)
    {
      a.a(paramLong);
    }
    else if (i == 0)
    {
      b.a(paramLong);
    }
    else
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[8]);
      localByteBuffer.putLong(paramLong);
      localByteBuffer.flip();
      a(localByteBuffer);
    }
  }
  
  public void a(String paramString)
  {
    if (a.b())
    {
      paramString = paramString.getBytes(StandardCharsets.UTF_8);
      a(paramString, 0, paramString.length);
    }
    else
    {
      b.a(paramString);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i = a.c();
    if (i > 0)
    {
      if (i >= paramByteBuffer.remaining())
      {
        a.a(paramByteBuffer);
        return;
      }
      int j = paramByteBuffer.limit();
      paramByteBuffer.limit(paramByteBuffer.position() + i);
      a.a(paramByteBuffer);
      paramByteBuffer.limit(j);
    }
    b.a(paramByteBuffer);
  }
  
  public void a(short paramShort)
  {
    int i = a.c();
    if (i >= 2)
    {
      a.a(paramShort);
    }
    else if (i == 0)
    {
      b.a(paramShort);
    }
    else
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[2]);
      localByteBuffer.putShort(paramShort);
      localByteBuffer.flip();
      a(localByteBuffer);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = a.c();
    if (i > 0)
    {
      if (i >= paramInt2)
      {
        a.a(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      a.a(paramArrayOfByte, paramInt1, i);
    }
    b.a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
  }
  
  public boolean b()
  {
    boolean bool;
    if ((!a.b()) && (!b.b())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int c()
  {
    int i = a.c();
    return b.c() + i;
  }
  
  public void c(int paramInt)
  {
    int i = a.c();
    if (i >= 4)
    {
      a.c(paramInt);
    }
    else if (i == 0)
    {
      b.c(paramInt);
    }
    else
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[4]);
      localByteBuffer.putInt(paramInt);
      localByteBuffer.flip();
      a(localByteBuffer);
    }
  }
  
  public int position()
  {
    int i = a.position();
    return b.position() + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.toString());
    localStringBuilder.append(" + ");
    localStringBuilder.append(b.toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */