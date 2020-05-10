package l.b.c.c;

public class d
  extends a
{
  public static final int[] n = { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int[] l = new int[64];
  public int m;
  
  public d()
  {
    e();
  }
  
  public final int a(int paramInt)
  {
    return (paramInt << 10 | paramInt >>> 22) ^ (paramInt >>> 2 | paramInt << 30) ^ (paramInt >>> 13 | paramInt << 19);
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 ^ paramInt2 & paramInt1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    c();
    l.b.c.e.a.b(d, paramArrayOfByte, paramInt);
    l.b.c.e.a.b(e, paramArrayOfByte, paramInt + 4);
    l.b.c.e.a.b(f, paramArrayOfByte, paramInt + 8);
    l.b.c.e.a.b(g, paramArrayOfByte, paramInt + 12);
    l.b.c.e.a.b(h, paramArrayOfByte, paramInt + 16);
    l.b.c.e.a.b(i, paramArrayOfByte, paramInt + 20);
    l.b.c.e.a.b(j, paramArrayOfByte, paramInt + 24);
    e();
    return 28;
  }
  
  public String a()
  {
    return "SHA-224";
  }
  
  public void a(long paramLong)
  {
    if (m > 14) {
      d();
    }
    int[] arrayOfInt = l;
    arrayOfInt[14] = ((int)(paramLong >>> 32));
    arrayOfInt[15] = ((int)(paramLong & 0xFFFFFFFFFFFFFFFF));
  }
  
  public int b()
  {
    return 28;
  }
  
  public final int b(int paramInt)
  {
    return (paramInt << 7 | paramInt >>> 25) ^ (paramInt >>> 6 | paramInt << 26) ^ (paramInt >>> 11 | paramInt << 21);
  }
  
  public final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 ^ paramInt1 & paramInt2 ^ paramInt2 & paramInt3;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramArrayOfByte[paramInt];
    int i2 = paramInt + 1;
    paramInt = paramArrayOfByte[i2];
    int i3 = i2 + 1;
    i2 = paramArrayOfByte[i3];
    i3 = paramArrayOfByte[(i3 + 1)];
    paramArrayOfByte = l;
    int i4 = m;
    paramArrayOfByte[i4] = (i3 & 0xFF | i1 << 24 | (paramInt & 0xFF) << 16 | (i2 & 0xFF) << 8);
    paramInt = i4 + 1;
    m = paramInt;
    if (paramInt == 16) {
      d();
    }
  }
  
  public void d()
  {
    for (int i1 = 16; i1 <= 63; i1++)
    {
      int[] arrayOfInt = l;
      i2 = arrayOfInt[(i1 - 2)];
      i3 = arrayOfInt[(i1 - 7)];
      i4 = arrayOfInt[(i1 - 15)];
      arrayOfInt[i1] = ((i2 >>> 10 ^ (i2 >>> 17 | i2 << 15) ^ (i2 >>> 19 | i2 << 13)) + i3 + (i4 >>> 3 ^ (i4 >>> 7 | i4 << 25) ^ (i4 >>> 18 | i4 << 14)) + arrayOfInt[(i1 - 16)]);
    }
    int i3 = d;
    int i4 = e;
    int i5 = f;
    int i6 = g;
    int i2 = h;
    int i7 = i;
    int i8 = j;
    int i9 = k;
    i1 = 0;
    int i10 = 0;
    while (i1 < 8)
    {
      int i11 = b(i2);
      i9 = a(i2, i7, i8) + i11 + n[i10] + l[i10] + i9;
      i6 += i9;
      i11 = a(i3);
      i9 = b(i3, i4, i5) + i11 + i9;
      i10++;
      i11 = b(i6);
      i8 = a(i6, i2, i7) + i11 + n[i10] + l[i10] + i8;
      i5 += i8;
      i11 = a(i9);
      i8 = b(i9, i3, i4) + i11 + i8;
      i10++;
      i11 = b(i5);
      i7 = a(i5, i6, i2) + i11 + n[i10] + l[i10] + i7;
      i4 += i7;
      i11 = a(i8);
      i7 = b(i8, i9, i3) + i11 + i7;
      i10++;
      i11 = b(i4);
      i11 = a(i4, i5, i6) + i11 + n[i10] + l[i10] + i2;
      i2 = i3 + i11;
      i3 = a(i7);
      i3 = b(i7, i8, i9) + i3 + i11;
      i10++;
      i11 = b(i2);
      i6 = a(i2, i4, i5) + i11 + n[i10] + l[i10] + i6;
      i9 += i6;
      i11 = a(i3);
      i6 = b(i3, i7, i8) + i11 + i6;
      i10++;
      i11 = b(i9);
      i5 = a(i9, i2, i4) + i11 + n[i10] + l[i10] + i5;
      i8 += i5;
      i11 = a(i6);
      i5 = b(i6, i3, i7) + i11 + i5;
      i10++;
      i11 = b(i8);
      i4 = a(i8, i9, i2) + i11 + n[i10] + l[i10] + i4;
      i7 += i4;
      i11 = a(i5);
      i4 = b(i5, i6, i3) + i11 + i4;
      i10++;
      i11 = b(i7);
      int i12 = a(i7, i8, i9) + i11 + n[i10] + l[i10] + i2;
      int i13 = a(i4);
      i11 = b(i4, i5, i6);
      i10++;
      i1++;
      i2 = i3 + i12;
      i3 = i11 + i13 + i12;
    }
    d += i3;
    e += i4;
    f += i5;
    g += i6;
    h += i2;
    i += i7;
    j += i8;
    k += i9;
    m = 0;
    for (i1 = 0; i1 < 16; i1++) {
      l[i1] = 0;
    }
  }
  
  public void e()
  {
    super.e();
    d = -1056596264;
    e = 914150663;
    f = 812702999;
    g = -150054599;
    h = -4191439;
    i = 1750603025;
    j = 1694076839;
    k = -1090891868;
    m = 0;
    for (int i1 = 0;; i1++)
    {
      int[] arrayOfInt = l;
      if (i1 == arrayOfInt.length) {
        break;
      }
      arrayOfInt[i1] = 0;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.c.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */