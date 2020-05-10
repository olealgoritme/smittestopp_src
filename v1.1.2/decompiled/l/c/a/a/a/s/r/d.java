package l.c.a.a.a.s.r;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class d
{
  public byte a;
  public boolean b;
  public byte[] c;
  public boolean d = false;
  
  public d(byte paramByte, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    a = ((byte)paramByte);
    b = paramBoolean;
    if (paramArrayOfByte != null) {
      c = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public static void a(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      int i;
      if (paramBoolean) {
        i = -128;
      } else {
        i = 0;
      }
      if (paramInt > 65535)
      {
        paramByteBuffer.put((byte)(i | 0x7F));
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)(paramInt >> 24 & 0xFF));
        paramByteBuffer.put((byte)(paramInt >> 16 & 0xFF));
        paramByteBuffer.put((byte)(paramInt >> 8 & 0xFF));
        paramByteBuffer.put((byte)(paramInt & 0xFF));
      }
      else if (paramInt >= 126)
      {
        paramByteBuffer.put((byte)(i | 0x7E));
        paramByteBuffer.put((byte)(paramInt >> 8));
        paramByteBuffer.put((byte)(paramInt & 0xFF));
      }
      else
      {
        paramByteBuffer.put((byte)(paramInt | i));
      }
      return;
    }
    throw new IllegalArgumentException("Length cannot be negative");
  }
  
  public byte[] a()
  {
    Object localObject1 = c;
    int i = localObject1.length + 6;
    if (localObject1.length > 65535)
    {
      j = i + 8;
    }
    else
    {
      j = i;
      if (localObject1.length >= 126) {
        j = i + 2;
      }
    }
    localObject1 = ByteBuffer.allocate(j);
    int k = a;
    boolean bool = b;
    i = 0;
    if (bool) {
      j = (byte)'';
    } else {
      j = 0;
    }
    ((ByteBuffer)localObject1).put((byte)(k & 0xF | j));
    Object localObject2 = new SecureRandom();
    k = ((SecureRandom)localObject2).nextInt(255);
    int m = ((SecureRandom)localObject2).nextInt(255);
    int n = ((SecureRandom)localObject2).nextInt(255);
    int j = ((SecureRandom)localObject2).nextInt(255);
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = ((byte)(byte)k);
    arrayOfByte[1] = ((byte)(byte)m);
    arrayOfByte[2] = ((byte)(byte)n);
    arrayOfByte[3] = ((byte)(byte)j);
    a((ByteBuffer)localObject1, c.length, true);
    ((ByteBuffer)localObject1).put(arrayOfByte);
    for (j = i;; j++)
    {
      localObject2 = c;
      if (j >= localObject2.length)
      {
        ((ByteBuffer)localObject1).flip();
        return ((ByteBuffer)localObject1).array();
      }
      byte b1 = (byte)(localObject2[j] ^ arrayOfByte[(j % 4)]);
      localObject2[j] = b1;
      ((ByteBuffer)localObject1).put(b1);
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.r.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */