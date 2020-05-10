package l.b.c.c;

public abstract class b
  implements l.b.c.a
{
  public static final long[] o = { 4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L };
  public byte[] a = new byte[8];
  public int b = 0;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long[] m = new long[80];
  public int n;
  
  public b()
  {
    f();
  }
  
  public final long a(long paramLong)
  {
    return (paramLong >>> 39 | paramLong << 25) ^ (paramLong << 36 | paramLong >>> 28) ^ (paramLong << 30 | paramLong >>> 34);
  }
  
  public final long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 ^ paramLong2 & paramLong1;
  }
  
  public void a(byte paramByte)
  {
    byte[] arrayOfByte = a;
    int i1 = b;
    int i2 = i1 + 1;
    b = i2;
    arrayOfByte[i1] = ((byte)paramByte);
    if (i2 == arrayOfByte.length)
    {
      b(arrayOfByte, 0);
      b = 0;
    }
    c += 1L;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    int i2 = paramInt1;
    for (;;)
    {
      paramInt2 = i2;
      paramInt1 = i1;
      if (b == 0) {
        break;
      }
      paramInt2 = i2;
      paramInt1 = i1;
      if (i1 <= 0) {
        break;
      }
      a(paramArrayOfByte[i2]);
      i2++;
      i1--;
    }
    for (;;)
    {
      i2 = paramInt2;
      i1 = paramInt1;
      if (paramInt1 <= a.length) {
        break;
      }
      b(paramArrayOfByte, paramInt2);
      byte[] arrayOfByte = a;
      paramInt2 += arrayOfByte.length;
      paramInt1 -= arrayOfByte.length;
      c += arrayOfByte.length;
    }
    while (i1 > 0)
    {
      a(paramArrayOfByte[i2]);
      i2++;
      i1--;
    }
  }
  
  public final long b(long paramLong)
  {
    return (paramLong >>> 41 | paramLong << 23) ^ (paramLong << 50 | paramLong >>> 14) ^ (paramLong << 46 | paramLong >>> 18);
  }
  
  public final long b(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 ^ paramLong1 & paramLong2 ^ paramLong2 & paramLong3;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    long[] arrayOfLong = m;
    int i1 = n;
    int i2 = l.b.c.e.a.b(paramArrayOfByte, paramInt);
    paramInt = l.b.c.e.a.b(paramArrayOfByte, paramInt + 4);
    long l1 = i2;
    arrayOfLong[i1] = (paramInt & 0xFFFFFFFF | (l1 & 0xFFFFFFFF) << 32);
    paramInt = n + 1;
    n = paramInt;
    if (paramInt == 16) {
      e();
    }
  }
  
  public final void c()
  {
    long l1 = c;
    if (l1 > 2305843009213693951L)
    {
      d += (l1 >>> 61);
      c = (l1 & 0x1FFFFFFFFFFFFFFF);
    }
  }
  
  public void d()
  {
    c();
    long l1 = c;
    long l2 = d;
    byte b1 = Byte.MIN_VALUE;
    for (byte b2 = b1;; b2 = b1)
    {
      a(b2);
      if (b == 0) {
        break;
      }
      b1 = 0;
    }
    if (n > 14) {
      e();
    }
    long[] arrayOfLong = m;
    arrayOfLong[14] = l2;
    arrayOfLong[15] = (l1 << 3);
    e();
  }
  
  public void e()
  {
    c();
    long[] arrayOfLong;
    for (int i1 = 16; i1 <= 79; i1++)
    {
      arrayOfLong = m;
      l1 = arrayOfLong[(i1 - 2)];
      l2 = arrayOfLong[(i1 - 7)];
      l3 = arrayOfLong[(i1 - 15)];
      arrayOfLong[i1] = ((l1 >>> 6 ^ (l1 << 45 | l1 >>> 19) ^ (l1 << 3 | l1 >>> 61)) + l2 + (l3 >>> 7 ^ (l3 << 63 | l3 >>> 1) ^ (l3 << 56 | l3 >>> 8)) + arrayOfLong[(i1 - 16)]);
    }
    long l2 = e;
    long l3 = f;
    long l4 = g;
    long l5 = h;
    long l1 = i;
    long l6 = j;
    long l7 = k;
    long l8 = l;
    int i2 = 0;
    i1 = 0;
    while (i1 < 10)
    {
      long l9 = b(l1);
      long l10 = a(l1, l6, l7);
      long l11 = o[i2];
      arrayOfLong = m;
      int i3 = i2 + 1;
      l10 = l9 + l10 + l11 + arrayOfLong[i2] + l8;
      l8 = l5 + l10;
      l5 = a(l2) + b(l2, l3, l4) + l10;
      l10 = b(l8);
      l11 = a(l8, l1, l6);
      l9 = o[i3];
      arrayOfLong = m;
      int i4 = i3 + 1;
      l10 = l10 + l11 + l9 + arrayOfLong[i3] + l7;
      l7 = l4 + l10;
      l4 = a(l5) + b(l5, l2, l3) + l10;
      l9 = b(l7);
      l11 = a(l7, l8, l1);
      l10 = o[i4];
      arrayOfLong = m;
      i2 = i4 + 1;
      l6 = l9 + l11 + l10 + arrayOfLong[i4] + l6;
      l3 += l6;
      l6 = a(l4) + b(l4, l5, l2) + l6;
      l9 = b(l3);
      l10 = a(l3, l7, l8);
      l11 = o[i2];
      arrayOfLong = m;
      i3 = i2 + 1;
      l10 = l9 + l10 + l11 + arrayOfLong[i2] + l1;
      l1 = l2 + l10;
      l2 = a(l6) + b(l6, l4, l5) + l10;
      l10 = b(l1);
      l11 = a(l1, l3, l7);
      l9 = o[i3];
      arrayOfLong = m;
      i2 = i3 + 1;
      l10 = l10 + l11 + l9 + arrayOfLong[i3] + l8;
      l8 = l5 + l10;
      l5 = a(l2) + b(l2, l6, l4) + l10;
      l11 = b(l8);
      l10 = a(l8, l1, l3);
      l9 = o[i2];
      arrayOfLong = m;
      i3 = i2 + 1;
      l10 = l11 + l10 + l9 + arrayOfLong[i2] + l7;
      l7 = l4 + l10;
      l4 = a(l5) + b(l5, l2, l6) + l10;
      l11 = b(l7);
      l10 = a(l7, l8, l1);
      l9 = o[i3];
      arrayOfLong = m;
      i2 = i3 + 1;
      l3 = l11 + l10 + l9 + arrayOfLong[i3] + l3;
      l6 += l3;
      l3 = a(l4) + b(l4, l5, l2) + l3;
      l11 = b(l6) + a(l6, l7, l8) + o[i2] + m[i2] + l1;
      l10 = a(l3);
      l9 = b(l3, l4, l5);
      i1++;
      i2++;
      l1 = l2 + l11;
      l2 = l10 + l9 + l11;
    }
    e += l2;
    f += l3;
    g += l4;
    h += l5;
    i += l1;
    j += l6;
    k += l7;
    l += l8;
    n = 0;
    for (i1 = 0; i1 < 16; i1++) {
      m[i1] = 0L;
    }
  }
  
  public void f()
  {
    c = 0L;
    d = 0L;
    int i1 = 0;
    b = 0;
    Object localObject;
    for (int i2 = 0;; i2++)
    {
      localObject = a;
      if (i2 >= localObject.length) {
        break;
      }
      localObject[i2] = ((byte)0);
    }
    n = 0;
    for (i2 = i1;; i2++)
    {
      localObject = m;
      if (i2 == localObject.length) {
        break;
      }
      localObject[i2] = 0L;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.c.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */