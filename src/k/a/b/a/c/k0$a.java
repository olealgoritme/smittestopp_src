package k.a.b.a.c;

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
  
  public int d()
  {
    return a.getInt();
  }
  
  public ByteBuffer e()
  {
    return a;
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
    return a.equals(localk0.e());
  }
  
  public double f()
  {
    return a.getDouble();
  }
  
  public k0 g()
  {
    return new a(a.duplicate());
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
    return a.arrayOffset();
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public k0 i()
  {
    return new a(a.slice());
  }
  
  public byte[] j()
  {
    return a.array();
  }
  
  public float k()
  {
    return a.getFloat();
  }
  
  public long l()
  {
    return a.getLong();
  }
  
  public short m()
  {
    return a.getShort();
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
 * Qualified Name:     base.k.a.b.a.c.k0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */