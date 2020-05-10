package e.b.a.a.s;

public class a
{
  public static final int[] c = { 8000, 8000, 2000, 2000 };
  public static final int[] d = { 4000, 4000, 200, 200 };
  public final byte[][] a = new byte[4][];
  public final char[][] b = new char[4][];
  
  public final byte[] a(int paramInt)
  {
    int i = c[paramInt];
    if (i <= 0) {
      i = 0;
    }
    byte[][] arrayOfByte = a;
    byte[] arrayOfByte1 = arrayOfByte[paramInt];
    if ((arrayOfByte1 != null) && (arrayOfByte1.length >= i)) {
      arrayOfByte[paramInt] = null;
    } else {
      arrayOfByte1 = new byte[i];
    }
    return arrayOfByte1;
  }
  
  public char[] a(int paramInt1, int paramInt2)
  {
    int i = d[paramInt1];
    int j = paramInt2;
    if (paramInt2 < i) {
      j = i;
    }
    char[][] arrayOfChar = b;
    char[] arrayOfChar1 = arrayOfChar[paramInt1];
    if ((arrayOfChar1 != null) && (arrayOfChar1.length >= j)) {
      arrayOfChar[paramInt1] = null;
    } else {
      arrayOfChar1 = new char[j];
    }
    return arrayOfChar1;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */