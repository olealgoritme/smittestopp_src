package k.b.f.a;

import java.math.BigInteger;

public class e
  implements Cloneable
{
  public static final short[] y = { 0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845 };
  public static final byte[] z = { 0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
  public long[] x;
  
  public e(int paramInt)
  {
    x = new long[paramInt];
  }
  
  public e(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0))
    {
      if (paramBigInteger.signum() == 0)
      {
        x = new long[] { 0L };
        return;
      }
      paramBigInteger = paramBigInteger.toByteArray();
      int i = paramBigInteger.length;
      int j;
      if (paramBigInteger[0] == 0)
      {
        i--;
        j = 1;
      }
      else
      {
        j = 0;
      }
      int k = (i + 7) / 8;
      x = new long[k];
      int m = k - 1;
      int n = i % 8 + j;
      k = j;
      i = m;
      long l;
      if (j < n)
      {
        l = 0L;
        while (j < n)
        {
          l = l << 8 | paramBigInteger[j] & 0xFF;
          j++;
        }
        x[m] = l;
        i = m - 1;
        k = j;
      }
      while (i >= 0)
      {
        l = 0L;
        j = 0;
        while (j < 8)
        {
          l = l << 8 | paramBigInteger[k] & 0xFF;
          j++;
          k++;
        }
        x[i] = l;
        i--;
      }
      return;
    }
    throw new IllegalArgumentException("invalid F2m field value");
  }
  
  public e(long[] paramArrayOfLong)
  {
    x = paramArrayOfLong;
  }
  
  public e(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfLong.length))
    {
      x = paramArrayOfLong;
    }
    else
    {
      long[] arrayOfLong = new long[paramInt2];
      x = arrayOfLong;
      System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, 0, paramInt2);
    }
  }
  
  public static int a(long paramLong)
  {
    int i = 32;
    int j = (int)(paramLong >>> 32);
    int k = j;
    if (j == 0)
    {
      k = (int)paramLong;
      i = 0;
    }
    j = k >>> 16;
    if (j == 0)
    {
      j = k >>> 8;
      if (j == 0) {
        k = z[k];
      } else {
        k = z[j] + 8;
      }
    }
    else
    {
      k = j >>> 8;
      if (k == 0) {
        k = z[j] + 16;
      } else {
        k = z[k] + 24;
      }
    }
    return i + k;
  }
  
  public static long a(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    for (int i = 0; i < paramInt3; i++)
    {
      long l2 = paramArrayOfLong2[(paramInt2 + i)];
      int j = paramInt1 + i;
      paramArrayOfLong1[j] = ((l1 | l2 << paramInt4) ^ paramArrayOfLong1[j]);
      l1 = l2 >>> 64 - paramInt4;
    }
    return l1;
  }
  
  public static void a(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    paramInt1 += (paramInt2 >>> 6);
    paramArrayOfLong[paramInt1] ^= 1L << (paramInt2 & 0x3F);
  }
  
  public static void a(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    a(paramArrayOfLong, paramInt1, paramInt2);
    paramInt3 = paramInt2 - paramInt3;
    paramInt2 = paramArrayOfInt.length;
    for (;;)
    {
      paramInt2--;
      if (paramInt2 < 0) {
        break;
      }
      a(paramArrayOfLong, paramInt1, paramArrayOfInt[paramInt2] + paramInt3);
    }
    a(paramArrayOfLong, paramInt1, paramInt3);
  }
  
  public static void a(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    paramInt1 += (paramInt2 >>> 6);
    paramInt2 &= 0x3F;
    if (paramInt2 == 0)
    {
      paramArrayOfLong[paramInt1] ^= paramLong;
    }
    else
    {
      paramArrayOfLong[paramInt1] ^= paramLong << paramInt2;
      paramLong >>>= 64 - paramInt2;
      if (paramLong != 0L)
      {
        paramInt1++;
        paramArrayOfLong[paramInt1] = (paramLong ^ paramArrayOfLong[paramInt1]);
      }
    }
  }
  
  public static void a(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3)
  {
    for (int i = 0; i < paramInt3; i++)
    {
      int j = paramInt1 + i;
      paramArrayOfLong1[j] ^= paramArrayOfLong2[(paramInt2 + i)];
    }
  }
  
  public static int b(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    int i = paramInt3 + 63 >>> 6;
    if (paramInt2 < i) {
      return paramInt2;
    }
    int j = paramInt2 << 6;
    int k = Math.min(j, (paramInt3 << 1) - 1);
    j -= k;
    while (j >= 64)
    {
      paramInt2--;
      j -= 64;
    }
    int m = paramArrayOfInt.length;
    int n = paramArrayOfInt[(m - 1)];
    if (m > 1) {
      m = paramArrayOfInt[(m - 2)];
    } else {
      m = 0;
    }
    n = Math.max(paramInt3, n + 64);
    int i1 = Math.min(k - n, paramInt3 - m) + j >> 6;
    m = k;
    j = paramInt2;
    if (i1 > 1)
    {
      j = paramInt2 - i1;
      k = j << 6;
      i1 = k - paramInt3;
      m = paramArrayOfInt.length;
      for (;;)
      {
        m--;
        if (m < 0) {
          break;
        }
        b(paramArrayOfLong, paramInt1, paramArrayOfLong, paramInt1 + j, paramInt2 - j, i1 + paramArrayOfInt[m]);
      }
      b(paramArrayOfLong, paramInt1, paramArrayOfLong, paramInt1 + j, paramInt2 - j, i1);
      while (paramInt2 > j)
      {
        paramInt2--;
        paramArrayOfLong[(paramInt1 + paramInt2)] = 0L;
      }
      m = k;
      j = paramInt2;
    }
    if (m > n)
    {
      k = n >>> 6;
      for (;;)
      {
        m = j - 1;
        if (m <= k) {
          break;
        }
        paramInt2 = paramInt1 + m;
        l = paramArrayOfLong[paramInt2];
        j = m;
        if (l != 0L)
        {
          paramArrayOfLong[paramInt2] = 0L;
          j = (m << 6) - paramInt3;
          paramInt2 = paramArrayOfInt.length;
          for (;;)
          {
            paramInt2--;
            if (paramInt2 < 0) {
              break;
            }
            a(paramArrayOfLong, paramInt1, paramArrayOfInt[paramInt2] + j, l);
          }
          a(paramArrayOfLong, paramInt1, j, l);
          j = m;
        }
      }
      j = n & 0x3F;
      m = k + paramInt1;
      long l = paramArrayOfLong[m] >>> j;
      paramInt2 = n;
      if (l != 0L)
      {
        paramArrayOfLong[m] ^= l << j;
        j = n - paramInt3;
        paramInt2 = paramArrayOfInt.length;
        for (;;)
        {
          paramInt2--;
          if (paramInt2 < 0) {
            break;
          }
          a(paramArrayOfLong, paramInt1, paramArrayOfInt[paramInt2] + j, l);
        }
        a(paramArrayOfLong, paramInt1, j, l);
        paramInt2 = n;
      }
    }
    else
    {
      paramInt2 = m;
    }
    if (paramInt2 > paramInt3)
    {
      j = paramInt2;
      for (;;)
      {
        m = j - 1;
        if (m < paramInt3) {
          break;
        }
        if ((paramArrayOfLong[((m >>> 6) + paramInt1)] & 1L << (m & 0x3F)) != 0L) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
        j = m;
        if (paramInt2 != 0)
        {
          a(paramArrayOfLong, paramInt1, m, paramInt3, paramArrayOfInt);
          j = m;
        }
      }
    }
    return i;
  }
  
  public static long b(int paramInt)
  {
    short[] arrayOfShort = y;
    int i = arrayOfShort[(paramInt & 0xFF)];
    int j = arrayOfShort[(paramInt >>> 8 & 0xFF)];
    int k = arrayOfShort[(paramInt >>> 16 & 0xFF)];
    long l = arrayOfShort[(paramInt >>> 24)] << 16 | k;
    return (i | j << 16) & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 32;
  }
  
  public static void b(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 += (paramInt4 >>> 6);
    paramInt4 &= 0x3F;
    if (paramInt4 == 0)
    {
      a(paramArrayOfLong1, paramInt1, paramArrayOfLong2, paramInt2, paramInt3);
    }
    else
    {
      paramInt4 = 64 - paramInt4;
      long l2;
      for (long l1 = 0L;; l1 = l2 << 64 - paramInt4)
      {
        paramInt3--;
        if (paramInt3 < 0) {
          break;
        }
        l2 = paramArrayOfLong2[(paramInt2 + paramInt3)];
        int i = paramInt1 + 1 + paramInt3;
        paramArrayOfLong1[i] = ((l1 | l2 >>> paramInt4) ^ paramArrayOfLong1[i]);
      }
      paramArrayOfLong1[paramInt1] ^= l1;
    }
  }
  
  public static long c(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    for (int i = 0; i < paramInt3; i++)
    {
      long l2 = paramArrayOfLong1[(paramInt1 + i)];
      paramArrayOfLong2[(paramInt2 + i)] = (l1 | l2 << paramInt4);
      l1 = l2 >>> 64 - paramInt4;
    }
    return l1;
  }
  
  public int a()
  {
    int i = x.length;
    int j;
    long l;
    do
    {
      if (i == 0) {
        return 0;
      }
      long[] arrayOfLong = x;
      j = i - 1;
      l = arrayOfLong[j];
      i = j;
    } while (l == 0L);
    return a(l) + (j << 6);
  }
  
  public final int a(int paramInt)
  {
    paramInt = paramInt + 62 >>> 6;
    int i;
    long l;
    do
    {
      if (paramInt == 0) {
        return 0;
      }
      long[] arrayOfLong = x;
      i = paramInt - 1;
      l = arrayOfLong[i];
      paramInt = i;
    } while (l == 0L);
    return a(l) + (i << 6);
  }
  
  public final void a(e parame, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 63 >>> 6;
    paramInt1 = paramInt2 >>> 6;
    paramInt2 &= 0x3F;
    if (paramInt2 == 0)
    {
      a(x, paramInt1, x, 0, i);
      return;
    }
    long l = a(x, paramInt1, x, 0, i, paramInt2);
    if (l != 0L)
    {
      parame = x;
      paramInt1 = i + paramInt1;
      parame[paramInt1] = (l ^ parame[paramInt1]);
    }
  }
  
  public int b()
  {
    long[] arrayOfLong = x;
    int i = Math.min(arrayOfLong.length, arrayOfLong.length);
    int j = 0;
    int k;
    if (i < 1)
    {
      k = j;
    }
    else
    {
      k = i;
      if (arrayOfLong[0] != 0L)
      {
        k = i;
        do
        {
          k--;
          i = k;
        } while (arrayOfLong[k] == 0L);
        k = i + 1;
      }
      else
      {
        do
        {
          i = k - 1;
          if (arrayOfLong[i] != 0L) {
            break;
          }
          k = i;
        } while (i > 0);
        k = j;
      }
    }
    return k;
  }
  
  public Object clone()
  {
    long[] arrayOfLong = x;
    if (arrayOfLong == null) {
      arrayOfLong = null;
    } else {
      arrayOfLong = (long[])arrayOfLong.clone();
    }
    return new e(arrayOfLong);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e)) {
      return false;
    }
    paramObject = (e)paramObject;
    int i = b();
    if (((e)paramObject).b() != i) {
      return false;
    }
    for (int j = 0; j < i; j++) {
      if (x[j] != x[j]) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = b();
    int j = 1;
    for (int k = 0; k < i; k++)
    {
      long l = x[k];
      j = (j * 31 ^ (int)l) * 31 ^ (int)(l >>> 32);
    }
    return j;
  }
  
  public String toString()
  {
    int i = b();
    if (i == 0) {
      return "0";
    }
    Object localObject = x;
    i--;
    localObject = new StringBuffer(Long.toBinaryString(localObject[i]));
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      String str = Long.toBinaryString(x[i]);
      int j = str.length();
      if (j < 64) {
        ((StringBuffer)localObject).append("0000000000000000000000000000000000000000000000000000000000000000".substring(j));
      }
      ((StringBuffer)localObject).append(str);
    }
    return ((StringBuffer)localObject).toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */