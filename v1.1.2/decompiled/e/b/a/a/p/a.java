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
    localObject = new int['Ā'];
    for (m = 0; m < 32; m++) {
      localObject[m] = -1;
    }
    localObject[34] = 1;
    localObject[92] = 1;
    c = (int[])localObject;
    m = localObject.length;
    int[] arrayOfInt = new int[m];
    System.arraycopy(localObject, 0, arrayOfInt, 0, m);
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
      arrayOfInt[j] = m;
    }
    d = arrayOfInt;
    arrayOfInt = new int['Ā'];
    Arrays.fill(arrayOfInt, -1);
    for (m = 33; m < 256; m++) {
      if (Character.isJavaIdentifierPart((char)m)) {
        arrayOfInt[m] = 0;
      }
    }
    arrayOfInt[64] = 0;
    arrayOfInt[35] = 0;
    arrayOfInt[42] = 0;
    arrayOfInt[45] = 0;
    arrayOfInt[43] = 0;
    e = arrayOfInt;
    localObject = new int['Ā'];
    System.arraycopy(arrayOfInt, 0, localObject, 0, 256);
    Arrays.fill((int[])localObject, 128, 128, 0);
    f = (int[])localObject;
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
 * Qualified Name:     e.b.a.a.p.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */