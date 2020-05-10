package k.a.b.a.c;

import e.a.a.a.a;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Collections;

public class l
  implements k0
{
  public static final ByteBuffer j = ByteBuffer.wrap(new byte[0]);
  public static final l k = new l(false);
  public static int l = -1;
  public ArrayList<byte[]> a;
  public int b = -1;
  public byte[] c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h = -1;
  public boolean i = true;
  
  static
  {
    Collections.unmodifiableList(new ArrayList());
  }
  
  public l() {}
  
  public l(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public l(byte[] paramArrayOfByte, int paramInt)
  {
    c = paramArrayOfByte;
    d = paramInt;
    if (paramArrayOfByte != null) {
      g = paramArrayOfByte.length;
    }
    f = g;
  }
  
  public int a()
  {
    return f;
  }
  
  public String a(CharsetDecoder paramCharsetDecoder)
  {
    if (!b()) {
      return "";
    }
    if (o())
    {
      paramCharsetDecoder = paramCharsetDecoder.decode(ByteBuffer.wrap(c, d, c()));
    }
    else
    {
      float f1 = c();
      int m = (int)(paramCharsetDecoder.averageCharsPerByte() * f1);
      Object localObject1 = CharBuffer.allocate(m);
      int n = b;
      int i1 = f - e;
      int i2 = Math.min(c.length - d, i1);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(c, d, i2);
      Object localObject2 = CoderResult.OVERFLOW;
      CoderResult localCoderResult;
      do
      {
        boolean bool;
        if (i2 == i1) {
          bool = true;
        } else {
          bool = false;
        }
        localCoderResult = paramCharsetDecoder.decode(localByteBuffer, (CharBuffer)localObject1, bool);
        if ((localCoderResult.isUnderflow()) && (bool))
        {
          paramCharsetDecoder = paramCharsetDecoder.flush((CharBuffer)localObject1);
          break;
        }
        if (localCoderResult.isOverflow())
        {
          m = m * 2 + 1;
          localObject2 = CharBuffer.allocate(m);
          ((CharBuffer)localObject1).flip();
          ((CharBuffer)localObject2).put((CharBuffer)localObject1);
        }
        else
        {
          localObject2 = a;
          n++;
          localObject2 = (byte[])((ArrayList)localObject2).get(n);
          int i3 = Math.min(localObject2.length, i1 - i2);
          localByteBuffer = ByteBuffer.wrap((byte[])localObject2, 0, i3);
          i2 += i3;
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
      } while (!localCoderResult.isError());
      paramCharsetDecoder = localCoderResult;
      localObject1 = localObject2;
      if (paramCharsetDecoder.isError()) {
        paramCharsetDecoder.throwException();
      }
      paramCharsetDecoder = (CharBuffer)((CharBuffer)localObject1).flip();
    }
    return paramCharsetDecoder.toString();
  }
  
  public k0 a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return this;
  }
  
  public l a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= f))
    {
      int m = paramInt - e;
      Object localObject;
      int n;
      int i1;
      if (m >= 0) {
        while (m > 0)
        {
          localObject = c;
          n = localObject.length;
          i1 = d;
          if (m < n - i1)
          {
            d = (i1 + m);
            break;
          }
          m -= localObject.length - i1;
          i1 = b;
          if ((i1 != -1) && (i1 < a.size() - 1))
          {
            localObject = a;
            i1 = b + 1;
            b = i1;
            c = ((byte[])((ArrayList)localObject).get(i1));
            d = 0;
          }
          else
          {
            d = c.length;
          }
        }
      }
      m = Math.abs(m);
      while (m > 0)
      {
        n = d;
        i1 = n - m;
        if (i1 >= 0)
        {
          d = i1;
          break;
        }
        m -= n;
        localObject = a;
        i1 = b - 1;
        b = i1;
        localObject = (byte[])((ArrayList)localObject).get(i1);
        c = ((byte[])localObject);
        d = localObject.length;
      }
      e = paramInt;
      if (h > paramInt) {
        h = l;
      }
      return this;
    }
    throw new IllegalArgumentException("position must be non-negative and no greater than the limit");
  }
  
  public l a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = paramArrayOfByte.length;
    if ((paramInt1 | paramInt2) >= 0)
    {
      if (paramInt1 + paramInt2 <= m)
      {
        if (paramInt2 <= c())
        {
          m = 0;
          while (paramInt2 > 0)
          {
            int n = Math.min(c.length - d, paramInt2);
            System.arraycopy(c, d, paramArrayOfByte, paramInt1 + m, n);
            d += n;
            paramInt2 -= n;
            m += n;
            p();
          }
          e += m;
          return this;
        }
        throw new BufferUnderflowException();
      }
      throw new IndexOutOfBoundsException("target is to small for specified read size");
    }
    throw new IndexOutOfBoundsException("offset and legnth must be non-negative");
  }
  
  public k0 b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= g))
    {
      if (h > paramInt) {
        h = l;
      }
      if (e > paramInt) {
        a(paramInt);
      }
      f = paramInt;
      return this;
    }
    throw new IllegalArgumentException("limit must be non-negative and no greater than the capacity");
  }
  
  public l b(byte[] paramArrayOfByte)
  {
    if (i)
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        if (c == null)
        {
          c = paramArrayOfByte;
          d = 0;
        }
        else
        {
          ArrayList localArrayList = a;
          if (localArrayList == null)
          {
            localArrayList = new ArrayList();
            a = localArrayList;
            localArrayList.add(c);
            a.add(paramArrayOfByte);
            b = 0;
            p();
          }
          else
          {
            localArrayList.add(paramArrayOfByte);
            p();
          }
        }
        int m = g + paramArrayOfByte.length;
        g = m;
        f = m;
        return this;
      }
      throw new IllegalArgumentException("Array must not be empty or null");
    }
    throw new IllegalStateException();
  }
  
  public boolean b()
  {
    boolean bool;
    if (c() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int c()
  {
    return f - e;
  }
  
  public int d()
  {
    if (c() >= 4)
    {
      byte[] arrayOfByte = c;
      int m = arrayOfByte.length;
      int n = d;
      int i1 = 0;
      if (m - n >= 4)
      {
        m = n + 1;
        d = m;
        i1 = arrayOfByte[n];
        n = m + 1;
        d = n;
        m = arrayOfByte[m];
        int i2 = n + 1;
        d = i2;
        n = arrayOfByte[n];
        d = (i2 + 1);
        i1 = (arrayOfByte[i2] & 0xFF) << 0 | (m & 0xFF) << 16 | (i1 & 0xFF) << 24 | (n & 0xFF) << 8;
        p();
      }
      else
      {
        for (m = 3; m >= 0; m--)
        {
          arrayOfByte = c;
          n = d;
          d = (n + 1);
          i1 |= (arrayOfByte[n] & 0xFF) << m * 8;
          p();
        }
      }
      e += 4;
      return i1;
    }
    throw new BufferUnderflowException();
  }
  
  public ByteBuffer e()
  {
    int m = f - e;
    Object localObject1;
    if (m == 0)
    {
      localObject1 = j;
    }
    else
    {
      Object localObject2 = c;
      int n = localObject2.length;
      int i1 = d;
      if (m <= n - i1)
      {
        localObject1 = ByteBuffer.wrap((byte[])localObject2, i1, m);
      }
      else
      {
        localObject1 = new byte[m];
        n = b;
        System.arraycopy(localObject2, i1, localObject1, 0, localObject2.length - i1);
        i1 = c.length - d;
        while (i1 < m)
        {
          localObject2 = a;
          n++;
          localObject2 = (byte[])((ArrayList)localObject2).get(n);
          int i2 = Math.min(m - i1, localObject2.length);
          System.arraycopy(localObject2, 0, localObject1, i1, i2);
          i1 += i2;
        }
        localObject1 = ByteBuffer.wrap((byte[])localObject1);
      }
    }
    return ((ByteBuffer)localObject1).asReadOnlyBuffer();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof k0)) {
      return false;
    }
    paramObject = (k0)paramObject;
    int m = c();
    if (m != ((k0)paramObject).c()) {
      return false;
    }
    if (m == 0) {
      return true;
    }
    if ((!o()) && (m > c.length - d))
    {
      n = position();
      try
      {
        for (i1 = ((k0)paramObject).position(); b(); i1++)
        {
          i2 = get();
          m = ((k0)paramObject).get(i1);
          if (i2 == m) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i2 == 0)
          {
            a(n);
            bool2 = false;
            break label169;
          }
        }
        label169:
        return bool2;
      }
      finally
      {
        a(n);
      }
    }
    byte[] arrayOfByte = c;
    int i2 = d;
    int n = ((k0)paramObject).position();
    for (int i1 = 0;; i1++)
    {
      bool2 = bool1;
      if (i1 >= m) {
        break;
      }
      if (arrayOfByte[(i2 + i1)] != ((k0)paramObject).get(n + i1))
      {
        bool2 = false;
        break;
      }
    }
    return bool2;
  }
  
  public double f()
  {
    return Double.longBitsToDouble(l());
  }
  
  public k0 g()
  {
    l locall = new l(c, d);
    if (a != null) {
      a = new ArrayList(a);
    }
    g = g;
    b = b;
    f = f;
    e = e;
    h = h;
    i = i;
    return locall;
  }
  
  public byte get()
  {
    int m = e;
    if (m != f)
    {
      byte[] arrayOfByte = c;
      int n = d;
      d = (n + 1);
      byte b1 = arrayOfByte[n];
      e = (m + 1);
      p();
      return b1;
    }
    throw new BufferUnderflowException();
  }
  
  public byte get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < f))
    {
      int m = e;
      int n;
      if (paramInt == m)
      {
        paramInt = c[d];
        n = paramInt;
      }
      else
      {
        if (paramInt < m)
        {
          i1 = b;
          i2 = d;
          localObject = c;
          i3 = m - paramInt;
          paramInt = i1;
          i1 = i3;
          while (i1 >= 0)
          {
            i3 = i2 - i1;
            if (i3 >= 0)
            {
              paramInt = localObject[i3];
              n = paramInt;
              break label229;
            }
            i1 -= i2;
            localObject = a;
            paramInt--;
            localObject = (byte[])((ArrayList)localObject).get(paramInt);
            i2 = localObject.length;
          }
        }
        int i1 = b;
        int i3 = d;
        Object localObject = c;
        int i2 = paramInt - m;
        for (paramInt = i3; i2 >= 0; paramInt = 0)
        {
          if (i2 < localObject.length - paramInt)
          {
            paramInt = localObject[(paramInt + i2)];
            n = paramInt;
            break label229;
          }
          i2 -= localObject.length - paramInt;
          localObject = a;
          i1++;
          localObject = (byte[])((ArrayList)localObject).get(i1);
        }
        paramInt = 0;
        n = paramInt;
      }
      label229:
      return n;
    }
    throw new IndexOutOfBoundsException(a.a("The given index is not valid: ", paramInt));
  }
  
  public int h()
  {
    if (o()) {
      return d - e;
    }
    throw new UnsupportedOperationException("Buffer not backed by a single array");
  }
  
  public int hashCode()
  {
    int m = c();
    int n = b;
    int i1 = 1;
    int i2 = 1;
    int i3 = m;
    int i4 = i1;
    Object localObject1;
    int i5;
    if (n >= 0)
    {
      localObject1 = c;
      i4 = localObject1.length;
      i5 = d;
      if (m <= i4 - i5)
      {
        i3 = m;
        i4 = i1;
      }
      else
      {
        i1 = c();
        int i6 = i1;
        i3 = n;
        int i7;
        Object localObject2;
        for (;;)
        {
          m = i1;
          i7 = i3;
          i4 = i2;
          localObject2 = localObject1;
          n = i5;
          if (i6 <= 0) {
            break;
          }
          if (i6 <= localObject1.length - i5)
          {
            n = i5 + i6;
            m = i1;
            i7 = i3;
            i4 = i2;
            localObject2 = localObject1;
            break;
          }
          i6 -= localObject1.length - i5;
          localObject1 = a;
          i3++;
          localObject1 = (byte[])((ArrayList)localObject1).get(i3);
          i5 = 0;
        }
        for (;;)
        {
          i5 = i4;
          if (m <= 0) {
            break;
          }
          i5 = n - 1;
          i3 = i4 * 31 + localObject2[i5];
          i4 = i7;
          localObject1 = localObject2;
          n = i5;
          if (i5 == 0)
          {
            i4 = i7;
            localObject1 = localObject2;
            n = i5;
            if (i7 > 0)
            {
              localObject1 = a;
              i4 = i7 - 1;
              localObject1 = (byte[])((ArrayList)localObject1).get(i4);
              n = localObject1.length;
            }
          }
          m--;
          i7 = i4;
          i4 = i3;
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      i5 = i4;
      if (i3 <= 0) {
        break;
      }
      localObject1 = c;
      i5 = d;
      i3--;
      i4 = i4 * 31 + localObject1[(i5 + i3)];
    }
    return i5;
  }
  
  public k0 i()
  {
    int m = f - e;
    l locall;
    if (m == 0)
    {
      locall = k;
    }
    else
    {
      locall = new l(c, d);
      a = a;
      b = b;
      g = m;
      f = m;
      e = 0;
      i = false;
    }
    return locall;
  }
  
  public byte[] j()
  {
    if (o()) {
      return c;
    }
    throw new UnsupportedOperationException("Buffer not backed by a single array");
  }
  
  public float k()
  {
    return Float.intBitsToFloat(d());
  }
  
  public long l()
  {
    if (c() >= 8)
    {
      long l1 = 0L;
      byte[] arrayOfByte = c;
      int m = arrayOfByte.length;
      int n = d;
      long l4;
      if (m - n >= 8)
      {
        m = n + 1;
        d = m;
        long l2 = arrayOfByte[n] & 0xFF;
        n = m + 1;
        d = n;
        long l3 = arrayOfByte[m] & 0xFF;
        m = n + 1;
        d = m;
        l4 = arrayOfByte[n] & 0xFF;
        n = m + 1;
        d = n;
        long l5 = arrayOfByte[m] & 0xFF;
        m = n + 1;
        d = m;
        long l6 = arrayOfByte[n] & 0xFF;
        n = m + 1;
        d = n;
        l1 = arrayOfByte[m] & 0xFF;
        m = n + 1;
        d = m;
        long l7 = arrayOfByte[n] & 0xFF;
        d = (m + 1);
        l4 = l2 << 56 | l3 << 48 | l4 << 40 | l5 << 32 | l6 << 24 | l1 << 16 | l7 << 8 | (arrayOfByte[m] & 0xFF) << 0;
        p();
      }
      else
      {
        for (n = 7;; n--)
        {
          l4 = l1;
          if (n < 0) {
            break;
          }
          arrayOfByte = c;
          m = d;
          d = (m + 1);
          l1 |= (arrayOfByte[m] & 0xFF) << n * 8;
          p();
        }
      }
      e += 8;
      return l4;
    }
    throw new BufferUnderflowException();
  }
  
  public short m()
  {
    if (c() >= 2)
    {
      int m = 0;
      int n = 1;
      for (int i1 = m; n >= 0; i1 = m)
      {
        byte[] arrayOfByte = c;
        m = d;
        d = (m + 1);
        m = (short)(i1 | (arrayOfByte[m] & 0xFF) << n * 8);
        p();
        n--;
      }
      e += 2;
      return i1;
    }
    throw new BufferUnderflowException();
  }
  
  public l n()
  {
    if ((i) && ((c != null) || (a != null)))
    {
      int m = 0;
      int n = 0;
      int i1;
      for (;;)
      {
        i1 = b;
        if (m >= i1) {
          break;
        }
        n += ((byte[])a.remove(0)).length;
        m++;
      }
      i1 -= m;
      b = i1;
      byte[] arrayOfByte = c;
      m = n;
      if (arrayOfByte.length == d)
      {
        m = n + arrayOfByte.length;
        if (i1 == 0)
        {
          a.clear();
          a = null;
        }
        c = null;
        b = -1;
        d = 0;
      }
      e -= m;
      n = g - m;
      g = n;
      f = n;
      n = h;
      if (n != l) {
        h = (n - m);
      }
    }
    return this;
  }
  
  public boolean o()
  {
    Object localObject = c;
    boolean bool1 = true;
    if (localObject != null)
    {
      localObject = a;
      bool2 = bool1;
      if (localObject == null) {
        return bool2;
      }
      if (((ArrayList)localObject).size() == 1) {
        return bool1;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  public final void p()
  {
    if (c.length == d)
    {
      int m = b;
      if ((m >= 0) && (m < a.size() - 1))
      {
        ArrayList localArrayList = a;
        m = b + 1;
        b = m;
        c = ((byte[])localArrayList.get(m));
        d = 0;
      }
    }
  }
  
  public int position()
  {
    return e;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CompositeReadableBuffer");
    localStringBuffer.append("{ pos=");
    localStringBuffer.append(e);
    localStringBuffer.append(" limit=");
    localStringBuffer.append(f);
    localStringBuffer.append(" capacity=");
    localStringBuffer.append(g);
    localStringBuffer.append(" }");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */