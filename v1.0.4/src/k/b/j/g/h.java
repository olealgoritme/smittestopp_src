package k.b.j.g;

public class h
{
  public static final short[] a = new short[''];
  public static final byte[] b = new byte[112];
  
  static
  {
    byte[] arrayOfByte1 = new byte[''];
    int i = 0;
    a(arrayOfByte1, 0, 15, (byte)1);
    a(arrayOfByte1, 16, 31, (byte)2);
    a(arrayOfByte1, 32, 63, (byte)3);
    a(arrayOfByte1, 64, 65, (byte)0);
    a(arrayOfByte1, 66, 95, (byte)4);
    a(arrayOfByte1, 96, 96, (byte)5);
    a(arrayOfByte1, 97, 108, (byte)6);
    a(arrayOfByte1, 109, 109, (byte)7);
    a(arrayOfByte1, 110, 111, (byte)6);
    a(arrayOfByte1, 112, 112, (byte)8);
    a(arrayOfByte1, 113, 115, (byte)9);
    a(arrayOfByte1, 116, 116, (byte)10);
    a(arrayOfByte1, 117, 127, (byte)0);
    byte[] arrayOfByte2 = b;
    a(arrayOfByte2, 0, arrayOfByte2.length - 1, (byte)-2);
    a(b, 8, 11, (byte)-1);
    a(b, 24, 27, (byte)0);
    a(b, 40, 43, (byte)16);
    a(b, 58, 59, (byte)0);
    a(b, 72, 73, (byte)0);
    a(b, 89, 91, (byte)16);
    a(b, 104, 104, (byte)16);
    while (i < 128)
    {
      int j = arrayOfByte1[i];
      int k = new byte[] { 0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7 }[j];
      j = new byte[] { -2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96 }[j];
      a[i] = ((short)(short)(j | (k & i) << 8));
      i++;
    }
  }
  
  public static int a(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = i + 1;
      i = paramArrayOfByte[i];
      if (i >= 0)
      {
        if (j >= paramArrayOfChar.length) {
          return -1;
        }
        paramArrayOfChar[j] = ((char)(char)i);
        i = k;
        j++;
      }
      else
      {
        i = a[(i & 0x7F)];
        int m = i >>> 8;
        int n = (byte)i;
        i = k;
        k = n;
        while (k >= 0)
        {
          if (i >= paramArrayOfByte.length) {
            return -1;
          }
          n = paramArrayOfByte[i];
          m = m << 6 | n & 0x3F;
          k = b[(k + ((n & 0xFF) >>> 4))];
          i++;
        }
        if (k == -2) {
          return -1;
        }
        if (m <= 65535)
        {
          if (j >= paramArrayOfChar.length) {
            return -1;
          }
          paramArrayOfChar[j] = ((char)(char)m);
          j++;
        }
        else
        {
          if (j >= paramArrayOfChar.length - 1) {
            return -1;
          }
          k = j + 1;
          paramArrayOfChar[j] = ((char)(char)((m >>> 10) + 55232));
          j = k + 1;
          paramArrayOfChar[k] = ((char)(char)(0xDC00 | m & 0x3FF));
        }
      }
    }
    return j;
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, byte paramByte)
  {
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfByte[paramInt1] = ((byte)paramByte);
      paramInt1++;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.j.g.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */