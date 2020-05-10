package l.b.c.c;

import java.util.Arrays;
import l.b.c.b;

public class h
  implements b, l.b.c.a
{
  public static long[] g = { 1L, 32898L, -9223372036854742902L, -9223372034707259392L, 32907L, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138L, 136L, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778L, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L };
  public long[] a = new long[25];
  public byte[] b = new byte['À'];
  public int c;
  public int d;
  public int e;
  public boolean f;
  
  public h(int paramInt)
  {
    a(paramInt);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = e / 8;
    doFinal(paramArrayOfByte, paramInt, i);
    return i;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SHAKE");
    localStringBuilder.append(e);
    return localStringBuilder.toString();
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt != 128) && (paramInt != 224) && (paramInt != 256) && (paramInt != 288) && (paramInt != 384) && (paramInt != 512)) {
      throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }
    b(1600 - (paramInt << 1));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = d;
    if (i % 8 == 0)
    {
      if (!f)
      {
        int j = i >> 3;
        int k = c >> 3;
        i = 0;
        while (i < paramInt2)
        {
          if (j == 0)
          {
            m = paramInt2 - k;
            if (i <= m)
            {
              n = i;
              do
              {
                b(paramArrayOfByte, paramInt1 + n);
                i = n + k;
                n = i;
              } while (i <= m);
              continue;
            }
          }
          int n = Math.min(k - j, paramInt2 - i);
          System.arraycopy(paramArrayOfByte, paramInt1 + i, b, j, n);
          int m = j + n;
          n = i + n;
          j = m;
          i = n;
          if (m == k)
          {
            b(b, 0);
            j = 0;
            i = n;
          }
        }
        d = (j << 3);
        return;
      }
      throw new IllegalStateException("attempt to absorb while squeezing");
    }
    throw new IllegalStateException("attempt to absorb with odd length queue");
  }
  
  public int b()
  {
    return e / 8;
  }
  
  public final void b(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 1600) && (paramInt % 64 == 0))
    {
      c = paramInt;
      for (int i = 0;; i++)
      {
        long[] arrayOfLong = a;
        if (i >= arrayOfLong.length) {
          break;
        }
        arrayOfLong[i] = 0L;
      }
      Arrays.fill(b, (byte)0);
      d = 0;
      f = false;
      e = ((1600 - paramInt) / 2);
      return;
    }
    throw new IllegalStateException("invalid rate value");
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = c;
    for (int j = 0; j < i >> 6; j++)
    {
      long[] arrayOfLong = a;
      arrayOfLong[j] ^= l.b.c.e.a.d(paramArrayOfByte, paramInt);
      paramInt += 8;
    }
    d();
  }
  
  public final void c()
  {
    long[] arrayOfLong = a;
    int i = c;
    byte[] arrayOfByte = b;
    int j = 0;
    int k = 0;
    while (j < i >> 6)
    {
      long l = arrayOfLong[(0 + j)];
      l.b.c.e.a.c((int)(0xFFFFFFFF & l), arrayOfByte, k);
      l.b.c.e.a.c((int)(l >>> 32), arrayOfByte, k + 4);
      k += 8;
      j++;
    }
  }
  
  public final void d()
  {
    long[] arrayOfLong = a;
    int i = 0;
    long l1 = arrayOfLong[0];
    long l2 = arrayOfLong[1];
    long l3 = arrayOfLong[2];
    long l4 = arrayOfLong[3];
    long l5 = arrayOfLong[4];
    long l6 = arrayOfLong[5];
    long l7 = arrayOfLong[6];
    long l8 = arrayOfLong[7];
    long l9 = arrayOfLong[8];
    long l10 = arrayOfLong[9];
    long l11 = arrayOfLong[10];
    long l12 = arrayOfLong[11];
    long l13 = arrayOfLong[12];
    long l14 = arrayOfLong[13];
    long l15 = arrayOfLong[14];
    long l16 = arrayOfLong[15];
    long l17 = arrayOfLong[16];
    long l18 = arrayOfLong[17];
    long l19 = arrayOfLong[18];
    long l20 = arrayOfLong[19];
    long l21 = arrayOfLong[20];
    long l22 = arrayOfLong[21];
    long l23 = arrayOfLong[22];
    long l24 = arrayOfLong[23];
    long l25 = arrayOfLong[24];
    while (i < 24)
    {
      long l26 = l1 ^ l6 ^ l11 ^ l16 ^ l21;
      long l27 = l2 ^ l7 ^ l12 ^ l17 ^ l22;
      long l28 = l3 ^ l8 ^ l13 ^ l18 ^ l23;
      long l29 = l4 ^ l9 ^ l14 ^ l19 ^ l24;
      long l30 = l5 ^ l10 ^ l15 ^ l20 ^ l25;
      long l31 = (l27 << 1 | l27 >>> -1) ^ l30;
      long l32 = (l28 << 1 | l28 >>> -1) ^ l26;
      l27 = (l29 << 1 | l29 >>> -1) ^ l27;
      l30 = (l30 << 1 | l30 >>> -1) ^ l28;
      l29 = (l26 << 1 | l26 >>> -1) ^ l29;
      l26 = l1 ^ l31;
      l6 ^= l31;
      l11 ^= l31;
      l16 ^= l31;
      l21 ^= l31;
      l1 = l2 ^ l32;
      l7 ^= l32;
      l12 ^= l32;
      l17 ^= l32;
      l22 ^= l32;
      l2 = l3 ^ l27;
      l3 = l8 ^ l27;
      l13 ^= l27;
      l18 ^= l27;
      l8 = l23 ^ l27;
      l23 = l4 ^ l30;
      l9 ^= l30;
      l14 ^= l30;
      l19 ^= l30;
      l32 = l24 ^ l30;
      l27 = l5 ^ l29;
      l24 = l10 ^ l29;
      l5 = l15 ^ l29;
      l10 = l20 ^ l29;
      l20 = l25 ^ l29;
      l15 = l1 << 1 | l1 >>> 63;
      l4 = l7 << 44 | l7 >>> 20;
      l7 = l24 << 20 | l24 >>> 44;
      l8 = l8 << 61 | l8 >>> 3;
      l25 = l5 << 39 | l5 >>> 25;
      l29 = l21 << 18 | l21 >>> 46;
      l1 = l2 << 62 | l2 >>> 2;
      l30 = l13 << 43 | l13 >>> 21;
      l24 = l14 << 25 | l14 >>> 39;
      l5 = l10 << 8 | l10 >>> 56;
      l10 = l32 << 56 | l32 >>> 8;
      l31 = l16 << 41 | l16 >>> 23;
      long l33 = l27 << 27 | l27 >>> 37;
      l32 = l20 << 14 | l20 >>> 50;
      l28 = l22 << 2 | l22 >>> 62;
      long l34 = l9 << 55 | l9 >>> 9;
      l27 = l17 << 45 | l17 >>> 19;
      l17 = l6 << 36 | l6 >>> 28;
      l22 = l23 << 28 | l23 >>> 36;
      long l35 = l19 << 21 | l19 >>> 43;
      l23 = l18 << 15 | l18 >>> 49;
      long l36 = l12 << 10 | l12 >>> 54;
      long l37 = l3 << 6 | l3 >>> 58;
      long l38 = l11 << 3 | l11 >>> 61;
      l3 = l35 & l32 ^ l30;
      l11 = l15 ^ l37 & l24;
      l20 = l33 & l17 ^ l10;
      long l39 = g[i];
      i++;
      l6 = l7 & l38 ^ l22;
      l13 = l5 & l29 ^ l24;
      l12 = l24 & l5 ^ l37;
      l21 = l1 ^ l34 & l25;
      l24 = l28 & l1 ^ l31;
      l14 = l5 ^ l29 & l15;
      l9 = l27 ^ l8 & l22;
      l5 = l26 & l4 ^ l32;
      l18 = l36 ^ l23 & l10;
      l16 = l33 ^ l17 & l36;
      l2 = l30 & l35 ^ l4;
      l19 = l10 & l33 ^ l23;
      l17 = l36 & l23 ^ l17;
      l23 = l25 ^ l31 & l28;
      l10 = l22 & l7 ^ l8;
      l22 = l25 & l31 ^ l34;
      l25 = l1 & l34 ^ l28;
      l1 = l4 & l30 ^ l26 ^ l39;
      l4 = l32 & l26 ^ l35;
      l15 = l15 & l37 ^ l29;
      l8 = l27 & l8 ^ l38;
      l7 = l38 & l27 ^ l7;
    }
    arrayOfLong[0] = l1;
    arrayOfLong[1] = l2;
    arrayOfLong[2] = l3;
    arrayOfLong[3] = l4;
    arrayOfLong[4] = l5;
    arrayOfLong[5] = l6;
    arrayOfLong[6] = l7;
    arrayOfLong[7] = l8;
    arrayOfLong[8] = l9;
    arrayOfLong[9] = l10;
    arrayOfLong[10] = l11;
    arrayOfLong[11] = l12;
    arrayOfLong[12] = l13;
    arrayOfLong[13] = l14;
    arrayOfLong[14] = l15;
    arrayOfLong[15] = l16;
    arrayOfLong[16] = l17;
    arrayOfLong[17] = l18;
    arrayOfLong[18] = l19;
    arrayOfLong[19] = l20;
    arrayOfLong[20] = l21;
    arrayOfLong[21] = l22;
    arrayOfLong[22] = l23;
    arrayOfLong[23] = l24;
    arrayOfLong[24] = l25;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = f;
    int i;
    if (!bool)
    {
      i = d;
      if (i % 8 == 0)
      {
        if (!bool)
        {
          b[(i >> 3)] = ((byte)(byte)15);
          d = (i + 4);
        }
        else
        {
          throw new IllegalStateException("attempt to absorb while squeezing");
        }
      }
      else {
        throw new IllegalStateException("attempt to absorb with odd length queue");
      }
    }
    long l1 = paramInt2 * 8L;
    if (!f) {
      e();
    }
    long l2 = 0L;
    if (l1 % 8L == 0L)
    {
      while (l2 < l1)
      {
        if (d == 0)
        {
          d();
          c();
          d = c;
        }
        i = (int)Math.min(d, l1 - l2);
        System.arraycopy(b, (c - d) / 8, paramArrayOfByte, (int)(l2 / 8L) + paramInt1, i / 8);
        d -= i;
        l2 += i;
      }
      a(e);
      return paramInt2;
    }
    throw new IllegalStateException("outputLength not a multiple of 8");
  }
  
  public final void e()
  {
    Object localObject = b;
    int i = d;
    int j = i >> 3;
    localObject[j] = ((byte)(byte)(localObject[j] | (byte)(int)(1L << (i & 0x7))));
    j = i + 1;
    d = j;
    int k = c;
    i = 0;
    if (j == k)
    {
      b((byte[])localObject, 0);
      d = 0;
    }
    j = d;
    k = j >> 6;
    int m = j & 0x3F;
    j = 0;
    while (i < k)
    {
      localObject = a;
      localObject[i] ^= l.b.c.e.a.d(b, j);
      j += 8;
      i++;
    }
    if (m > 0)
    {
      localObject = a;
      localObject[k] ^= l.b.c.e.a.d(b, j) & (1L << m) - 1L;
    }
    localObject = a;
    i = c - 1 >> 6;
    localObject[i] ^= 0x8000000000000000;
    d();
    c();
    d = c;
    f = true;
  }
}

/* Location:
 * Qualified Name:     l.b.c.c.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */