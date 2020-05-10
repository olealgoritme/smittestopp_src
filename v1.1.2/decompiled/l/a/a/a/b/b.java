package l.a.a.a.b;

public class b
  extends c
{
  public static final byte[] j = { 13, 10 };
  public static final byte[] k = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  public static final byte[] l = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  public static final byte[] m = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  public final byte[] f;
  public final byte[] g = m;
  public final byte[] h;
  public final int i;
  
  public b(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(3, 4, paramInt, n, (byte)61);
    if (paramArrayOfByte != null)
    {
      if (!a(paramArrayOfByte))
      {
        if (paramInt > 0)
        {
          i = (paramArrayOfByte.length + 4);
          byte[] arrayOfByte = new byte[paramArrayOfByte.length];
          h = arrayOfByte;
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        }
        else
        {
          i = 4;
          h = null;
        }
      }
      else {
        throw new IllegalArgumentException(e.a.a.a.a.a("lineSeparator must not contain base64 characters: [", new String(paramArrayOfByte, l.a.a.a.a.a), "]"));
      }
    }
    else
    {
      i = 4;
      h = null;
    }
    if (paramBoolean) {
      paramArrayOfByte = l;
    } else {
      paramArrayOfByte = k;
    }
    f = paramArrayOfByte;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, c.a parama)
  {
    if (f) {
      return;
    }
    int n;
    byte[] arrayOfByte1;
    int i1;
    if (paramInt2 < 0)
    {
      f = true;
      if ((h == 0) && (d == 0)) {
        return;
      }
      paramArrayOfByte = a(i, parama);
      paramInt1 = d;
      paramInt2 = h;
      if (paramInt2 != 0) {
        if (paramInt2 != 1)
        {
          if (paramInt2 == 2)
          {
            n = paramInt1 + 1;
            d = n;
            arrayOfByte1 = f;
            paramInt2 = a;
            paramArrayOfByte[paramInt1] = ((byte)arrayOfByte1[(paramInt2 >> 10 & 0x3F)]);
            i1 = n + 1;
            d = i1;
            paramArrayOfByte[n] = ((byte)arrayOfByte1[(paramInt2 >> 4 & 0x3F)]);
            n = i1 + 1;
            d = n;
            paramArrayOfByte[i1] = ((byte)arrayOfByte1[(paramInt2 << 2 & 0x3F)]);
            if (arrayOfByte1 == k)
            {
              d = (n + 1);
              paramArrayOfByte[n] = ((byte)a);
            }
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
          arrayOfByte1 = f;
          i1 = a;
          paramArrayOfByte[paramInt1] = ((byte)arrayOfByte1[(i1 >> 2 & 0x3F)]);
          paramInt2 = n + 1;
          d = paramInt2;
          paramArrayOfByte[n] = ((byte)arrayOfByte1[(i1 << 4 & 0x3F)]);
          if (arrayOfByte1 == k)
          {
            i1 = paramInt2 + 1;
            d = i1;
            n = a;
            paramArrayOfByte[paramInt2] = ((byte)n);
            d = (i1 + 1);
            paramArrayOfByte[i1] = ((byte)n);
          }
        }
      }
      i1 = g;
      paramInt2 = d;
      paramInt1 = paramInt2 - paramInt1 + i1;
      g = paramInt1;
      if ((d > 0) && (paramInt1 > 0))
      {
        arrayOfByte1 = h;
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt2, arrayOfByte1.length);
        d += h.length;
      }
    }
    else
    {
      i1 = 0;
      while (i1 < paramInt2)
      {
        arrayOfByte1 = a(i, parama);
        h = ((h + 1) % 3);
        int i2 = paramArrayOfByte[paramInt1];
        n = i2;
        if (i2 < 0) {
          n = i2 + 256;
        }
        n = (a << 8) + n;
        a = n;
        if (h == 0)
        {
          int i3 = d;
          i2 = i3 + 1;
          d = i2;
          byte[] arrayOfByte2 = f;
          arrayOfByte1[i3] = ((byte)arrayOfByte2[(n >> 18 & 0x3F)]);
          int i4 = i2 + 1;
          d = i4;
          arrayOfByte1[i2] = ((byte)arrayOfByte2[(n >> 12 & 0x3F)]);
          i3 = i4 + 1;
          d = i3;
          arrayOfByte1[i4] = ((byte)arrayOfByte2[(n >> 6 & 0x3F)]);
          i2 = i3 + 1;
          d = i2;
          arrayOfByte1[i3] = ((byte)arrayOfByte2[(n & 0x3F)]);
          n = g + 4;
          g = n;
          i3 = d;
          if ((i3 > 0) && (i3 <= n))
          {
            arrayOfByte2 = h;
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i2, arrayOfByte2.length);
            d += h.length;
            g = 0;
          }
        }
        i1++;
        paramInt1++;
      }
    }
  }
  
  public boolean a(byte paramByte)
  {
    if (paramByte >= 0)
    {
      byte[] arrayOfByte = g;
      if ((paramByte < arrayOfByte.length) && (arrayOfByte[paramByte] != -1)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
}

/* Location:
 * Qualified Name:     l.a.a.a.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */