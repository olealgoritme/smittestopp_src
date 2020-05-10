package k.a.a.a.b;

public class a
  extends c
{
  public static final byte[] j = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
  public static final byte[] k = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55 };
  public static final byte[] l = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 };
  public static final byte[] m = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86 };
  public final byte[] f = j;
  public final int g = 8;
  public final byte[] h = k;
  public final byte[] i = null;
  
  public a()
  {
    super(5, 8, 0, 0, (byte)61);
    if (!a((byte)61)) {
      return;
    }
    throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, c.a parama)
  {
    if (f) {
      return;
    }
    int n;
    byte[] arrayOfByte1;
    long l1;
    int i1;
    if (paramInt2 < 0)
    {
      f = true;
      if ((h == 0) && (d == 0)) {
        return;
      }
      paramArrayOfByte = a(g, parama);
      paramInt1 = d;
      paramInt2 = h;
      if (paramInt2 != 0) {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 != 3)
            {
              if (paramInt2 == 4)
              {
                n = paramInt1 + 1;
                d = n;
                arrayOfByte1 = h;
                l1 = b;
                paramArrayOfByte[paramInt1] = ((byte)arrayOfByte1[((int)(l1 >> 27) & 0x1F)]);
                paramInt2 = n + 1;
                d = paramInt2;
                paramArrayOfByte[n] = ((byte)arrayOfByte1[((int)(l1 >> 22) & 0x1F)]);
                n = paramInt2 + 1;
                d = n;
                paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 >> 17) & 0x1F)]);
                paramInt2 = n + 1;
                d = paramInt2;
                paramArrayOfByte[n] = ((byte)arrayOfByte1[((int)(l1 >> 12) & 0x1F)]);
                n = paramInt2 + 1;
                d = n;
                paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 >> 7) & 0x1F)]);
                paramInt2 = n + 1;
                d = paramInt2;
                paramArrayOfByte[n] = ((byte)arrayOfByte1[((int)(l1 >> 2) & 0x1F)]);
                n = paramInt2 + 1;
                d = n;
                paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 << 3) & 0x1F)]);
                d = (n + 1);
                paramArrayOfByte[n] = ((byte)a);
              }
              else
              {
                paramArrayOfByte = e.a.a.a.a.a("Impossible modulus ");
                paramArrayOfByte.append(h);
                throw new IllegalStateException(paramArrayOfByte.toString());
              }
            }
            else
            {
              n = paramInt1 + 1;
              d = n;
              arrayOfByte1 = h;
              l1 = b;
              paramArrayOfByte[paramInt1] = ((byte)arrayOfByte1[((int)(l1 >> 19) & 0x1F)]);
              paramInt2 = n + 1;
              d = paramInt2;
              paramArrayOfByte[n] = ((byte)arrayOfByte1[((int)(l1 >> 14) & 0x1F)]);
              n = paramInt2 + 1;
              d = n;
              paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 >> 9) & 0x1F)]);
              paramInt2 = n + 1;
              d = paramInt2;
              paramArrayOfByte[n] = ((byte)arrayOfByte1[((int)(l1 >> 4) & 0x1F)]);
              n = paramInt2 + 1;
              d = n;
              paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 << 1) & 0x1F)]);
              i1 = n + 1;
              d = i1;
              paramInt2 = a;
              paramArrayOfByte[n] = ((byte)paramInt2);
              n = i1 + 1;
              d = n;
              paramArrayOfByte[i1] = ((byte)paramInt2);
              d = (n + 1);
              paramArrayOfByte[n] = ((byte)paramInt2);
            }
          }
          else
          {
            paramInt2 = paramInt1 + 1;
            d = paramInt2;
            arrayOfByte1 = h;
            l1 = b;
            paramArrayOfByte[paramInt1] = ((byte)arrayOfByte1[((int)(l1 >> 11) & 0x1F)]);
            n = paramInt2 + 1;
            d = n;
            paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 >> 6) & 0x1F)]);
            paramInt2 = n + 1;
            d = paramInt2;
            paramArrayOfByte[n] = ((byte)arrayOfByte1[((int)(l1 >> 1) & 0x1F)]);
            n = paramInt2 + 1;
            d = n;
            paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 << 4) & 0x1F)]);
            i1 = n + 1;
            d = i1;
            paramInt2 = a;
            paramArrayOfByte[n] = ((byte)paramInt2);
            n = i1 + 1;
            d = n;
            paramArrayOfByte[i1] = ((byte)paramInt2);
            i1 = n + 1;
            d = i1;
            paramArrayOfByte[n] = ((byte)paramInt2);
            d = (i1 + 1);
            paramArrayOfByte[i1] = ((byte)paramInt2);
          }
        }
        else
        {
          paramInt2 = paramInt1 + 1;
          d = paramInt2;
          arrayOfByte1 = h;
          l1 = b;
          paramArrayOfByte[paramInt1] = ((byte)arrayOfByte1[((int)(l1 >> 3) & 0x1F)]);
          i1 = paramInt2 + 1;
          d = i1;
          paramArrayOfByte[paramInt2] = ((byte)arrayOfByte1[((int)(l1 << 2) & 0x1F)]);
          n = i1 + 1;
          d = n;
          paramInt2 = a;
          paramArrayOfByte[i1] = ((byte)paramInt2);
          i1 = n + 1;
          d = i1;
          paramArrayOfByte[n] = ((byte)paramInt2);
          n = i1 + 1;
          d = n;
          paramArrayOfByte[i1] = ((byte)paramInt2);
          i1 = n + 1;
          d = i1;
          paramArrayOfByte[n] = ((byte)paramInt2);
          n = i1 + 1;
          d = n;
          paramArrayOfByte[i1] = ((byte)paramInt2);
          d = (n + 1);
          paramArrayOfByte[n] = ((byte)paramInt2);
        }
      }
      n = g;
      paramInt2 = d;
      paramInt1 = paramInt2 - paramInt1 + n;
      g = paramInt1;
      if ((d > 0) && (paramInt1 > 0))
      {
        arrayOfByte1 = i;
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt2, arrayOfByte1.length);
        d += i.length;
      }
    }
    else
    {
      n = 0;
      while (n < paramInt2)
      {
        arrayOfByte1 = a(g, parama);
        h = ((h + 1) % 5);
        int i2 = paramArrayOfByte[paramInt1];
        i1 = i2;
        if (i2 < 0) {
          i1 = i2 + 256;
        }
        l1 = (b << 8) + i1;
        b = l1;
        if (h == 0)
        {
          i2 = d;
          i1 = i2 + 1;
          d = i1;
          byte[] arrayOfByte2 = h;
          arrayOfByte1[i2] = ((byte)arrayOfByte2[((int)(l1 >> 35) & 0x1F)]);
          i2 = i1 + 1;
          d = i2;
          arrayOfByte1[i1] = ((byte)arrayOfByte2[((int)(l1 >> 30) & 0x1F)]);
          i1 = i2 + 1;
          d = i1;
          arrayOfByte1[i2] = ((byte)arrayOfByte2[((int)(l1 >> 25) & 0x1F)]);
          i2 = i1 + 1;
          d = i2;
          arrayOfByte1[i1] = ((byte)arrayOfByte2[((int)(l1 >> 20) & 0x1F)]);
          i1 = i2 + 1;
          d = i1;
          arrayOfByte1[i2] = ((byte)arrayOfByte2[((int)(l1 >> 15) & 0x1F)]);
          int i3 = i1 + 1;
          d = i3;
          arrayOfByte1[i1] = ((byte)arrayOfByte2[((int)(l1 >> 10) & 0x1F)]);
          i2 = i3 + 1;
          d = i2;
          arrayOfByte1[i3] = ((byte)arrayOfByte2[((int)(l1 >> 5) & 0x1F)]);
          i1 = i2 + 1;
          d = i1;
          arrayOfByte1[i2] = ((byte)arrayOfByte2[((int)l1 & 0x1F)]);
          i3 = g + 8;
          g = i3;
          i2 = d;
          if ((i2 > 0) && (i2 <= i3))
          {
            arrayOfByte2 = i;
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i1, arrayOfByte2.length);
            d += i.length;
            g = 0;
          }
        }
        n++;
        paramInt1++;
      }
    }
  }
  
  public boolean a(byte paramByte)
  {
    if (paramByte >= 0)
    {
      byte[] arrayOfByte = f;
      if ((paramByte < arrayOfByte.length) && (arrayOfByte[paramByte] != -1)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.k.a.a.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */