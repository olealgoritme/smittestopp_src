package k.a.b.a.d.g0;

import java.nio.ByteBuffer;
import k.a.b.a.c.y0;

public class k
  implements y0
{
  public byte[] a = new byte['Ѐ'];
  public int b;
  
  public int a()
  {
    return Integer.MAX_VALUE;
  }
  
  public void a(byte paramByte)
  {
    c(1);
    byte[] arrayOfByte = a;
    int i = b;
    b = (i + 1);
    arrayOfByte[i] = ((byte)paramByte);
  }
  
  public void a(double paramDouble)
  {
    a(Double.doubleToRawLongBits(paramDouble));
  }
  
  public void a(float paramFloat)
  {
    b(Float.floatToRawIntBits(paramFloat));
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      byte[] arrayOfByte = a;
      if (paramInt > arrayOfByte.length) {
        c(paramInt - arrayOfByte.length);
      }
      b = paramInt;
      return;
    }
    throw new IllegalArgumentException("Requested new buffer position cannot be negative");
  }
  
  public void a(long paramLong)
  {
    c(8);
    byte[] arrayOfByte = a;
    int i = b;
    int j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 56));
    i = j + 1;
    b = i;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 48));
    j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 40));
    i = j + 1;
    b = i;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 32));
    j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 24));
    i = j + 1;
    b = i;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 16));
    j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 8));
    b = (j + 1);
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 0));
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    c(i);
    if (paramByteBuffer.hasArray())
    {
      byte[] arrayOfByte = paramByteBuffer.array();
      int j = paramByteBuffer.arrayOffset();
      System.arraycopy(arrayOfByte, paramByteBuffer.position() + j, a, b, i);
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    else
    {
      paramByteBuffer.get(a, b, i);
    }
    b += i;
  }
  
  public void a(short paramShort)
  {
    c(2);
    byte[] arrayOfByte = a;
    int i = b;
    int j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(byte)(paramShort >>> 8));
    b = (j + 1);
    arrayOfByte[j] = ((byte)(byte)(paramShort >>> 0));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    c(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, a, b, paramInt2);
    b += paramInt2;
  }
  
  public void b(int paramInt)
  {
    c(4);
    byte[] arrayOfByte = a;
    int i = b;
    int j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 24));
    i = j + 1;
    b = i;
    arrayOfByte[j] = ((byte)(byte)(paramInt >>> 16));
    j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 8));
    b = (j + 1);
    arrayOfByte[j] = ((byte)(byte)(paramInt >>> 0));
  }
  
  public boolean b()
  {
    boolean bool;
    if (b < Integer.MAX_VALUE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int c()
  {
    return Integer.MAX_VALUE - b;
  }
  
  public void c(int paramInt)
  {
    byte[] arrayOfByte1 = a;
    int i = arrayOfByte1.length;
    int j = b;
    if (paramInt > i - j)
    {
      arrayOfByte1 = new byte[Math.max(arrayOfByte1.length << 1, paramInt + j)];
      byte[] arrayOfByte2 = a;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
      a = arrayOfByte1;
    }
  }
  
  public int position()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */