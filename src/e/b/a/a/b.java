package e.b.a.a;

import java.util.Arrays;

public final class b
{
  public static final a a;
  public static final a b;
  
  static
  {
    Object localObject1 = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    a = (a)localObject1;
    b = new a((a)localObject1, "MIME-NO-LINEFEEDS", B, C, Integer.MAX_VALUE);
    Object localObject2 = a;
    localObject1 = new int[''];
    Object localObject3 = new char[64];
    Object localObject4 = new byte[64];
    byte[] arrayOfByte = z;
    int i = arrayOfByte.length;
    int j = 0;
    System.arraycopy(arrayOfByte, 0, localObject4, 0, i);
    localObject4 = y;
    System.arraycopy(localObject4, 0, localObject3, 0, localObject4.length);
    localObject3 = x;
    System.arraycopy(localObject3, 0, localObject1, 0, localObject3.length);
    localObject1 = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    ((StringBuilder)localObject1).setCharAt(((StringBuilder)localObject1).indexOf("+"), '-');
    ((StringBuilder)localObject1).setCharAt(((StringBuilder)localObject1).indexOf("/"), '_');
    localObject4 = ((StringBuilder)localObject1).toString();
    localObject2 = new int[''];
    localObject3 = new char[64];
    localObject1 = new byte[64];
    i = ((String)localObject4).length();
    if (i == 64)
    {
      ((String)localObject4).getChars(0, i, (char[])localObject3, 0);
      Arrays.fill((int[])localObject2, -1);
      while (j < i)
      {
        int k = localObject3[j];
        localObject1[j] = ((byte)(byte)k);
        localObject2[k] = j;
        j++;
      }
      return;
    }
    throw new IllegalArgumentException(e.a.a.a.a.b("Base64Alphabet length must be exactly 64 (was ", i, ")"));
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */