package e.b.a.a.p;

import java.util.Arrays;

public final class a
{
  public static final char[] a;
  public static final byte[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g;
  public static final int[] h;
  public static final int[] i;
  
  static
  {
    Object localObject = "0123456789ABCDEF".toCharArray();
    a = (char[])localObject;
    int j = localObject.length;
    b = new byte[j];
    int k = 0;
    for (int m = 0; m < j; m++) {
      b[m] = ((byte)(byte)a[m]);
    }
    int[] arrayOfInt = new int['Ā'];
    for (m = 0; m < 32; m++) {
      arrayOfInt[m] = -1;
    }
    arrayOfInt[34] = 1;
    arrayOfInt[92] = 1;
    c = arrayOfInt;
    m = arrayOfInt.length;
    localObject = new int[m];
    System.arraycopy(arrayOfInt, 0, localObject, 0, m);
    for (j = 128; j < 256; j++)
    {
      if ((j & 0xE0) == 192) {
        m = 2;
      } else if ((j & 0xF0) == 224) {
        m = 3;
      } else if ((j & 0xF8) == 240) {
        m = 4;
      } else {
        m = -1;
      }
      localObject[j] = m;
    }
    d = (int[])localObject;
    localObject = new int['Ā'];
    Arrays.fill((int[])localObject, -1);
    for (m = 33; m < 256; m++) {
      if (Character.isJavaIdentifierPart((char)m)) {
        localObject[m] = 0;
      }
    }
    localObject[64] = 0;
    localObject[35] = 0;
    localObject[42] = 0;
    localObject[45] = 0;
    localObject[43] = 0;
    e = (int[])localObject;
    arrayOfInt = new int['Ā'];
    System.arraycopy(localObject, 0, arrayOfInt, 0, 256);
    Arrays.fill(arrayOfInt, 128, 128, 0);
    f = arrayOfInt;
    localObject = new int['Ā'];
    System.arraycopy(d, 128, localObject, 128, 128);
    Arrays.fill((int[])localObject, 0, 32, -1);
    localObject[9] = 0;
    localObject[10] = 10;
    localObject[13] = 13;
    localObject[42] = 42;
    g = (int[])localObject;
    localObject = new int['Ā'];
    System.arraycopy(d, 128, localObject, 128, 128);
    Arrays.fill((int[])localObject, 0, 32, -1);
    localObject[32] = 1;
    localObject[9] = 1;
    localObject[10] = 10;
    localObject[13] = 13;
    localObject[47] = 47;
    localObject[35] = 35;
    localObject = new int[''];
    for (m = 0; m < 32; m++) {
      localObject[m] = -1;
    }
    localObject[34] = 34;
    localObject[92] = 92;
    localObject[8] = 98;
    localObject[9] = 116;
    localObject[12] = 102;
    localObject[10] = 110;
    localObject[13] = 114;
    h = (int[])localObject;
    localObject = new int[''];
    i = (int[])localObject;
    Arrays.fill((int[])localObject, -1);
    for (j = 0;; j++)
    {
      m = k;
      if (j >= 10) {
        break;
      }
      i[(j + 48)] = j;
    }
    while (m < 6)
    {
      localObject = i;
      j = m + 10;
      localObject[(m + 97)] = j;
      localObject[(m + 65)] = j;
      m++;
    }
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.p.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */