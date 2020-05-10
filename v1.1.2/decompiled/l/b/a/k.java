package l.b.a;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class k
  extends FilterInputStream
{
  public final int x;
  public final boolean y;
  public final byte[][] z;
  
  public k(InputStream paramInputStream)
  {
    super(paramInputStream);
    x = i;
    y = false;
    z = new byte[11][];
  }
  
  public k(InputStream paramInputStream, boolean paramBoolean)
  {
    super(paramInputStream);
    x = i;
    y = paramBoolean;
    z = new byte[11][];
  }
  
  public k(byte[] paramArrayOfByte)
  {
    super(localByteArrayInputStream);
    x = i;
    y = false;
    z = new byte[11][];
  }
  
  public k(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(localByteArrayInputStream);
    x = i;
    y = paramBoolean;
    z = new byte[11][];
  }
  
  public static int a(InputStream paramInputStream, int paramInt)
  {
    int i = paramInt & 0x1F;
    paramInt = i;
    if (i == 31)
    {
      i = 0;
      paramInt = paramInputStream.read();
      if ((paramInt & 0x7F) != 0)
      {
        while ((paramInt >= 0) && ((paramInt & 0x80) != 0))
        {
          i = (i | paramInt & 0x7F) << 7;
          paramInt = paramInputStream.read();
        }
        if (paramInt >= 0) {
          paramInt = i | paramInt & 0x7F;
        } else {
          throw new EOFException("EOF found inside tag value.");
        }
      }
      else
      {
        throw new IOException("corrupted stream - invalid high tag number found");
      }
    }
    return paramInt;
  }
  
  public static int a(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    int i = paramInputStream.read();
    if (i >= 0)
    {
      if (i == 128) {
        return -1;
      }
      int j = i;
      if (i > 127)
      {
        int k = i & 0x7F;
        if (k <= 4)
        {
          j = 0;
          i = 0;
          while (i < k)
          {
            int m = paramInputStream.read();
            if (m >= 0)
            {
              j = (j << 8) + m;
              i++;
            }
            else
            {
              throw new EOFException("EOF found reading length");
            }
          }
          if (j >= 0)
          {
            if ((j >= paramInt) && (!paramBoolean))
            {
              paramInputStream = new StringBuilder();
              paramInputStream.append("corrupted stream - out of bounds length found: ");
              paramInputStream.append(j);
              paramInputStream.append(" >= ");
              paramInputStream.append(paramInt);
              throw new IOException(paramInputStream.toString());
            }
          }
          else {
            throw new IOException("corrupted stream - negative length found");
          }
        }
        else
        {
          throw new IOException(e.a.a.a.a.a("DER length more than 4 bytes: ", k));
        }
      }
      return j;
    }
    throw new EOFException("EOF found when length expected");
  }
  
  public static t a(int paramInt, w1 paramw1, byte[][] paramArrayOfByte)
  {
    int i = 0;
    label268:
    Object localObject;
    if (paramInt != 10)
    {
      if (paramInt != 12)
      {
        if (paramInt != 30)
        {
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              throw new IOException(e.a.a.a.a.b("unknown tag ", paramInt, " encountered"));
            }
          case 6: 
            return o.b(a(paramw1, paramArrayOfByte));
          case 5: 
            return y0.x;
          case 4: 
            return new a1(paramw1.a());
          case 3: 
            j = A;
            if (j >= 1)
            {
              paramInt = paramw1.read();
              j--;
              paramArrayOfByte = new byte[j];
              if (j != 0) {
                if (l.b.j.h.a.a(paramw1, paramArrayOfByte, 0, j) == j)
                {
                  if ((paramInt > 0) && (paramInt < 8))
                  {
                    j--;
                    if (paramArrayOfByte[j] != (byte)(paramArrayOfByte[j] & 255 << paramInt))
                    {
                      paramw1 = new n1(paramArrayOfByte, paramInt);
                      break label268;
                    }
                  }
                }
                else {
                  throw new EOFException("EOF encountered in middle of BIT STRING");
                }
              }
              paramw1 = new r0(paramArrayOfByte, paramInt);
              return paramw1;
            }
            throw new IllegalArgumentException("truncated BIT STRING detected");
          case 2: 
            return new l(paramw1.a(), false);
          }
          return c.b(a(paramw1, paramArrayOfByte));
          return new j1(paramw1.a());
          return new u0(paramw1.a());
          return new l1(paramw1.a());
          return new w0(paramw1.a());
          return new j(paramw1.a());
          return new d0(paramw1.a());
          return new x0(paramw1.a());
          return new k1(paramw1.a());
          return new g1(paramw1.a());
          return new d1(paramw1.a());
          return new z0(paramw1.a());
        }
        int j = A;
        if ((j & 0x1) == 0)
        {
          int k = j / 2;
          localObject = new char[k];
          paramArrayOfByte = new byte[8];
          paramInt = 0;
          while (j >= 8) {
            if (l.b.j.h.a.a(paramw1, paramArrayOfByte, 0, 8) == 8)
            {
              localObject[paramInt] = ((char)(char)(paramArrayOfByte[0] << 8 | paramArrayOfByte[1] & 0xFF));
              localObject[(paramInt + 1)] = ((char)(char)(paramArrayOfByte[2] << 8 | paramArrayOfByte[3] & 0xFF));
              localObject[(paramInt + 2)] = ((char)(char)(paramArrayOfByte[4] << 8 | paramArrayOfByte[5] & 0xFF));
              localObject[(paramInt + 3)] = ((char)(char)(paramArrayOfByte[6] << 8 | paramArrayOfByte[7] & 0xFF));
              paramInt += 4;
              j -= 8;
            }
            else
            {
              throw new EOFException("EOF encountered in middle of BMPString");
            }
          }
          int m = paramInt;
          if (j > 0)
          {
            if (l.b.j.h.a.a(paramw1, paramArrayOfByte, 0, j) == j) {
              for (m = i;; m = i)
              {
                int n = m + 1;
                int i1 = paramArrayOfByte[m];
                i = n + 1;
                n = paramArrayOfByte[n];
                m = paramInt + 1;
                localObject[paramInt] = ((char)(char)(i1 << 8 | n & 0xFF));
                if (i >= j) {
                  break;
                }
                paramInt = m;
              }
            }
            throw new EOFException("EOF encountered in middle of BMPString");
          }
          if ((A == 0) && (k == m)) {
            return new q0((char[])localObject);
          }
          throw new IllegalStateException();
        }
        throw new IOException("malformed BMPString encoding encountered");
      }
      return new i1(paramw1.a());
    }
    byte[] arrayOfByte = a(paramw1, paramArrayOfByte);
    if (arrayOfByte.length > 1)
    {
      paramw1 = new g(arrayOfByte);
    }
    else
    {
      if (arrayOfByte.length == 0) {
        break label840;
      }
      paramInt = arrayOfByte[0] & 0xFF;
      localObject = g.y;
      if (paramInt >= localObject.length)
      {
        paramw1 = new g(arrayOfByte);
      }
      else
      {
        paramArrayOfByte = localObject[paramInt];
        paramw1 = paramArrayOfByte;
        if (paramArrayOfByte == null)
        {
          paramw1 = new g(arrayOfByte);
          localObject[paramInt] = paramw1;
        }
      }
    }
    return paramw1;
    label840:
    throw new IllegalArgumentException("ENUMERATED has zero length");
  }
  
  public static byte[] a(w1 paramw1, byte[][] paramArrayOfByte)
  {
    int i = A;
    if (i < paramArrayOfByte.length)
    {
      byte[] arrayOfByte1 = paramArrayOfByte[i];
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null)
      {
        arrayOfByte2 = new byte[i];
        paramArrayOfByte[i] = arrayOfByte2;
      }
      l.b.j.h.a.a(paramw1, arrayOfByte2, 0, arrayOfByte2.length);
      return arrayOfByte2;
    }
    return paramw1.a();
  }
  
  public f a(w1 paramw1)
  {
    if (A < 1) {
      return new f(0);
    }
    k localk = new k(paramw1);
    paramw1 = new f(10);
    for (;;)
    {
      t localt = localk.readObject();
      if (localt == null) {
        break;
      }
      paramw1.a(localt);
    }
    return paramw1;
  }
  
  public t a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    boolean bool;
    if ((paramInt1 & 0x20) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1 = new w1(this, paramInt3, x);
    if ((paramInt1 & 0x40) != 0) {
      return new m1(bool, paramInt2, ((w1)localObject1).a());
    }
    if ((paramInt1 & 0x80) != 0) {
      return new z((InputStream)localObject1).a(bool, paramInt2);
    }
    if (bool)
    {
      if (paramInt2 != 4)
      {
        if (paramInt2 != 8)
        {
          if (paramInt2 != 16)
          {
            if (paramInt2 == 17) {
              return p1.b(a((w1)localObject1));
            }
            throw new IOException(e.a.a.a.a.b("unknown tag ", paramInt2, " encountered"));
          }
          if (y) {
            return new a2(((w1)localObject1).a());
          }
          return p1.a(a((w1)localObject1));
        }
        return new o1(a((w1)localObject1));
      }
      Object localObject2 = a((w1)localObject1);
      paramInt2 = b;
      p[] arrayOfp = new p[paramInt2];
      paramInt1 = i;
      while (paramInt1 != paramInt2)
      {
        localObject1 = ((f)localObject2).a(paramInt1);
        if ((localObject1 instanceof p))
        {
          arrayOfp[paramInt1] = ((p)localObject1);
          paramInt1++;
        }
        else
        {
          localObject2 = e.a.a.a.a.a("unknown object encountered in constructed OCTET STRING: ");
          ((StringBuilder)localObject2).append(localObject1.getClass());
          throw new h(((StringBuilder)localObject2).toString());
        }
      }
      return new h0(arrayOfp);
    }
    return a(paramInt2, (w1)localObject1, z);
  }
  
  public t readObject()
  {
    int i = read();
    if (i <= 0)
    {
      if (i != 0) {
        return null;
      }
      throw new IOException("unexpected end-of-contents marker");
    }
    int j = a(this, i);
    int k;
    if ((i & 0x20) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m = a(this, x, false);
    if (m < 0)
    {
      if (k != 0)
      {
        Object localObject = new z(new y1(this, x), x);
        if ((i & 0x40) != 0) {
          return new e0(j, ((z)localObject).b());
        }
        if ((i & 0x80) != 0) {
          return ((z)localObject).a(true, j);
        }
        if (j != 4)
        {
          if (j != 8)
          {
            if (j != 16)
            {
              if (j == 17) {
                return new l0(((z)localObject).b());
              }
              throw new IOException("unknown BER object encountered");
            }
            return new j0(((z)localObject).b());
          }
          try
          {
            localObject = new o1(((z)localObject).b());
            return (t)localObject;
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            throw new h(localIllegalArgumentException1.getMessage(), localIllegalArgumentException1);
          }
        }
        return new i0(localIllegalArgumentException1).d();
      }
      throw new IOException("indefinite-length primitive encoding encountered");
    }
    try
    {
      t localt = a(i, j, m);
      return localt;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      throw new h("corrupted stream detected", localIllegalArgumentException2);
    }
  }
}

/* Location:
 * Qualified Name:     l.b.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */