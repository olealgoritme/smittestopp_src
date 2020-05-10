package l.a.b.a.c;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;

public final class k0$a
  implements k0
{
  public ByteBuffer a;
  
  public k0$a(ByteBuffer paramByteBuffer)
  {
    a = paramByteBuffer;
  }
  
  public int a()
  {
    return a.limit();
  }
  
  public String a(CharsetDecoder paramCharsetDecoder)
  {
    return paramCharsetDecoder.decode(a).toString();
  }
  
  public k0 a(int paramInt)
  {
    a.position(paramInt);
    return this;
  }
  
  public k0 a(byte[] paramArrayOfByte)
  {
    a.get(paramArrayOfByte);
    return this;
  }
  
  public k0 a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.get(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public k0 b(int paramInt)
  {
    a.limit(paramInt);
    return this;
  }
  
  public boolean b()
  {
    return a.hasRemaining();
  }
  
  public int c()
  {
    return a.remaining();
  }
  
  public double d()
  {
    return a.getDouble();
  }
  
  public float e()
  {
    return a.getFloat();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof k0)) {
      return false;
    }
    k0 localk0 = (k0)paramObject;
    if (c() != localk0.c()) {
      return false;
    }
    if ((paramObject instanceof l)) {
      return paramObject.equals(this);
    }
    return a.equals(localk0.i());
  }
  
  public long f()
  {
    return a.getLong();
  }
  
  public short g()
  {
    return a.getShort();
  }
  
  public byte get()
  {
    return a.get();
  }
  
  public byte get(int paramInt)
  {
    return a.get(paramInt);
  }
  
  public int h()
  {
    return a.getInt();
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public ByteBuffer i()
  {
    return a;
  }
  
  public k0 j()
  {
    return new a(a.duplicate());
  }
  
  public int k()
  {
    return a.arrayOffset();
  }
  
  public k0 l()
  {
    return new a(a.slice());
  }
  
  public byte[] m()
  {
    return a.array();
  }
  
  public k0 n()
  {
    return this;
  }
  
  public boolean o()
  {
    return a.hasArray();
  }
  
  public int position()
  {
    return a.position();
  }
  
  public String toString()
  {
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.k0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */