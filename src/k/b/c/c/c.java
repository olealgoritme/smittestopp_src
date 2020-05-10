package k.b.c.c;

public class c
  extends a
{
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int[] i = new int[80];
  public int j;
  
  public c()
  {
    e();
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    c();
    k.b.c.e.a.b(d, paramArrayOfByte, paramInt);
    k.b.c.e.a.b(e, paramArrayOfByte, paramInt + 4);
    k.b.c.e.a.b(f, paramArrayOfByte, paramInt + 8);
    k.b.c.e.a.b(g, paramArrayOfByte, paramInt + 12);
    k.b.c.e.a.b(h, paramArrayOfByte, paramInt + 16);
    e();
    return 20;
  }
  
  public String a()
  {
    return "SHA-1";
  }
  
  public void a(long paramLong)
  {
    if (j > 14) {
      d();
    }
    int[] arrayOfInt = i;
    arrayOfInt[14] = ((int)(paramLong >>> 32));
    arrayOfInt[15] = ((int)paramLong);
  }
  
  public int b()
  {
    return 20;
  }
  
  public final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramArrayOfByte[paramInt];
    int m = paramInt + 1;
    paramInt = paramArrayOfByte[m];
    int n = m + 1;
    m = paramArrayOfByte[n];
    n = paramArrayOfByte[(n + 1)];
    paramArrayOfByte = i;
    int i1 = j;
    paramArrayOfByte[i1] = (n & 0xFF | k << 24 | (paramInt & 0xFF) << 16 | (m & 0xFF) << 8);
    paramInt = i1 + 1;
    j = paramInt;
    if (paramInt == 16) {
      d();
    }
  }
  
  public void d()
  {
    int[] arrayOfInt;
    for (int k = 16; k < 80; k++)
    {
      arrayOfInt = i;
      m = arrayOfInt[(k - 3)] ^ arrayOfInt[(k - 8)] ^ arrayOfInt[(k - 14)] ^ arrayOfInt[(k - 16)];
      arrayOfInt[k] = (m >>> 31 | m << 1);
    }
    int m = d;
    int n = e;
    k = f;
    int i1 = g;
    int i2 = h;
    int i3 = 0;
    int i5;
    for (int i4 = 0; i3 < 4; i4++)
    {
      i5 = a(n, k, i1);
      arrayOfInt = i;
      i6 = i4 + 1;
      i2 = e.a.a.a.a.a(i5 + (m << 5 | m >>> 27), arrayOfInt[i4], 1518500249, i2);
      n = n >>> 2 | n << 30;
      i5 = a(m, n, k);
      arrayOfInt = i;
      i4 = i6 + 1;
      i1 = e.a.a.a.a.a(i5 + (i2 << 5 | i2 >>> 27), arrayOfInt[i6], 1518500249, i1);
      m = m >>> 2 | m << 30;
      i5 = a(i2, m, n);
      arrayOfInt = i;
      i6 = i4 + 1;
      k = e.a.a.a.a.a(i5 + (i1 << 5 | i1 >>> 27), arrayOfInt[i4], 1518500249, k);
      i2 = i2 >>> 2 | i2 << 30;
      i5 = a(i1, i2, m);
      arrayOfInt = i;
      i4 = i6 + 1;
      n = e.a.a.a.a.a(i5 + (k << 5 | k >>> 27), arrayOfInt[i6], 1518500249, n);
      i1 = i1 >>> 2 | i1 << 30;
      m = e.a.a.a.a.a(a(k, i1, i2) + (n << 5 | n >>> 27), i[i4], 1518500249, m);
      k = k >>> 2 | k << 30;
      i3++;
    }
    i3 = 0;
    while (i3 < 4)
    {
      arrayOfInt = i;
      i6 = i4 + 1;
      i2 = e.a.a.a.a.a((m << 5 | m >>> 27) + (n ^ k ^ i1), arrayOfInt[i4], 1859775393, i2);
      n = n >>> 2 | n << 30;
      i4 = i6 + 1;
      i1 = e.a.a.a.a.a((i2 << 5 | i2 >>> 27) + (m ^ n ^ k), arrayOfInt[i6], 1859775393, i1);
      m = m >>> 2 | m << 30;
      i6 = i4 + 1;
      k = e.a.a.a.a.a((i1 << 5 | i1 >>> 27) + (i2 ^ m ^ n), arrayOfInt[i4], 1859775393, k);
      i2 = i2 >>> 2 | i2 << 30;
      i4 = i6 + 1;
      n = e.a.a.a.a.a((k << 5 | k >>> 27) + (i1 ^ i2 ^ m), arrayOfInt[i6], 1859775393, n);
      i1 = i1 >>> 2 | i1 << 30;
      m = e.a.a.a.a.a((n << 5 | n >>> 27) + (k ^ i1 ^ i2), arrayOfInt[i4], 1859775393, m);
      k = k >>> 2 | k << 30;
      i3++;
      i4++;
    }
    i3 = 0;
    while (i3 < 4)
    {
      i5 = b(n, k, i1);
      arrayOfInt = i;
      i6 = i4 + 1;
      i2 = e.a.a.a.a.a(i5 + (m << 5 | m >>> 27), arrayOfInt[i4], -1894007588, i2);
      n = n >>> 2 | n << 30;
      i5 = b(m, n, k);
      arrayOfInt = i;
      i4 = i6 + 1;
      i1 = e.a.a.a.a.a(i5 + (i2 << 5 | i2 >>> 27), arrayOfInt[i6], -1894007588, i1);
      m = m >>> 2 | m << 30;
      i5 = b(i2, m, n);
      arrayOfInt = i;
      i6 = i4 + 1;
      k = e.a.a.a.a.a(i5 + (i1 << 5 | i1 >>> 27), arrayOfInt[i4], -1894007588, k);
      i2 = i2 >>> 2 | i2 << 30;
      i5 = b(i1, i2, m);
      arrayOfInt = i;
      i4 = i6 + 1;
      n = e.a.a.a.a.a(i5 + (k << 5 | k >>> 27), arrayOfInt[i6], -1894007588, n);
      i1 = i1 >>> 2 | i1 << 30;
      m = e.a.a.a.a.a(b(k, i1, i2) + (n << 5 | n >>> 27), i[i4], -1894007588, m);
      k = k >>> 2 | k << 30;
      i3++;
      i4++;
    }
    int i6 = 0;
    i3 = i4;
    i4 = i6;
    while (i4 <= 3)
    {
      arrayOfInt = i;
      i6 = i3 + 1;
      i2 = e.a.a.a.a.a((m << 5 | m >>> 27) + (n ^ k ^ i1), arrayOfInt[i3], -899497514, i2);
      n = n >>> 2 | n << 30;
      i3 = i6 + 1;
      i1 = e.a.a.a.a.a((i2 << 5 | i2 >>> 27) + (m ^ n ^ k), arrayOfInt[i6], -899497514, i1);
      m = m >>> 2 | m << 30;
      i6 = i3 + 1;
      k = e.a.a.a.a.a((i1 << 5 | i1 >>> 27) + (i2 ^ m ^ n), arrayOfInt[i3], -899497514, k);
      i2 = i2 >>> 2 | i2 << 30;
      i3 = i6 + 1;
      n = e.a.a.a.a.a((k << 5 | k >>> 27) + (i1 ^ i2 ^ m), arrayOfInt[i6], -899497514, n);
      i1 = i1 >>> 2 | i1 << 30;
      m = e.a.a.a.a.a((n << 5 | n >>> 27) + (k ^ i1 ^ i2), arrayOfInt[i3], -899497514, m);
      k = k >>> 2 | k << 30;
      i4++;
      i3++;
    }
    d += m;
    e += n;
    f += k;
    g += i1;
    h += i2;
    j = 0;
    for (k = 0; k < 16; k++) {
      i[k] = 0;
    }
  }
  
  public void e()
  {
    super.e();
    d = 1732584193;
    e = -271733879;
    f = -1732584194;
    g = 271733878;
    h = -1009589776;
    j = 0;
    for (int k = 0;; k++)
    {
      int[] arrayOfInt = i;
      if (k == arrayOfInt.length) {
        break;
      }
      arrayOfInt[k] = 0;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.c.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */