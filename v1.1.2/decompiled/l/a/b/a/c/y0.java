package l.a.b.a.c;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

public abstract interface y0
{
  public abstract int a();
  
  public abstract void a(byte paramByte);
  
  public abstract void a(double paramDouble);
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong);
  
  public abstract void a(String paramString);
  
  public abstract void a(ByteBuffer paramByteBuffer);
  
  public abstract void a(short paramShort);
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void b(int paramInt);
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract void c(int paramInt);
  
  public abstract int position();
  
  public static class a
    implements y0
  {
    public final ByteBuffer a;
    
    public a(ByteBuffer paramByteBuffer)
    {
      a = paramByteBuffer;
    }
    
    public int a()
    {
      return a.limit();
    }
    
    public void a(byte paramByte)
    {
      a.put(paramByte);
    }
    
    public void a(double paramDouble)
    {
      a.putDouble(paramDouble);
    }
    
    public void a(float paramFloat)
    {
      a.putFloat(paramFloat);
    }
    
    public void a(int paramInt)
    {
      a.position(paramInt);
    }
    
    public final void a(int paramInt, byte paramByte)
    {
      if (a.hasArray()) {
        a.array()[(a.arrayOffset() + paramInt)] = paramByte;
      } else {
        a.put(paramInt, paramByte);
      }
    }
    
    public void a(long paramLong)
    {
      a.putLong(paramLong);
    }
    
    public void a(String paramString)
    {
      int i = paramString.length();
      int j = a.position();
      int k = 0;
      while (k < i)
      {
        int m = paramString.charAt(k);
        int n;
        byte b;
        if ((0xFF80 & m) == 0)
        {
          n = j + 1;
          b = (byte)m;
        }
        try
        {
          a(j, b);
          j = n;
          for (;;)
          {
            break;
            if ((0xF800 & m) == 0)
            {
              n = j + 1;
              a(j, (byte)(m >> 6 & 0x1F | 0xC0));
              j = n + 1;
              a(n, (byte)(m & 0x3F | 0x80));
            }
            else if (((m & 0xD800) == 55296) && (m <= 56319))
            {
              k++;
              if (k != i)
              {
                n = paramString.charAt(k);
                if ((n & 0xDC00) == 56320)
                {
                  n = ((m & 0x3FF) << 10) + 65536 + (n & 0x3FF);
                  m = j + 1;
                  a(j, (byte)(n >> 18 & 0x7 | 0xF0));
                  j = m + 1;
                  a(m, (byte)(n >> 12 & 0x3F | 0x80));
                  m = j + 1;
                  a(j, (byte)(n >> 6 & 0x3F | 0x80));
                  j = m + 1;
                  a(m, (byte)(n & 0x3F | 0x80));
                  break;
                }
              }
              paramString = new java/lang/IllegalArgumentException;
              paramString.<init>("String contains invalid Unicode code points");
              throw paramString;
            }
            else
            {
              int i1 = j + 1;
              a(j, (byte)(m >> 12 & 0xF | 0xE0));
              n = i1 + 1;
              a(i1, (byte)(m >> 6 & 0x3F | 0x80));
              j = n + 1;
              a(n, (byte)(m & 0x3F | 0x80));
            }
          }
          k++;
        }
        catch (IndexOutOfBoundsException paramString)
        {
          throw new BufferOverflowException();
        }
      }
      a.position(j);
    }
    
    public void a(ByteBuffer paramByteBuffer)
    {
      a.put(paramByteBuffer);
    }
    
    public void a(short paramShort)
    {
      a.putShort(paramShort);
    }
    
    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      a.put(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void b(int paramInt)
    {
      if (paramInt >= 0)
      {
        if (a.remaining() >= paramInt) {
          return;
        }
        IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException(String.format("Requested min remaining bytes(%d) exceeds remaining(%d) in underlying ByteBuffer: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(a.remaining()), a }));
        throw ((BufferOverflowException)new BufferOverflowException().initCause(localIndexOutOfBoundsException));
      }
      throw new IllegalArgumentException("Required remaining bytes cannot be negative");
    }
    
    public boolean b()
    {
      return a.hasRemaining();
    }
    
    public int c()
    {
      return a.remaining();
    }
    
    public void c(int paramInt)
    {
      a.putInt(paramInt);
    }
    
    public int position()
    {
      return a.position();
    }
    
    public String toString()
    {
      return String.format("[pos: %d, limit: %d, remaining:%d]", new Object[] { Integer.valueOf(a.position()), Integer.valueOf(a.limit()), Integer.valueOf(a.remaining()) });
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.y0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */