package e.e.a.v;

import java.math.BigInteger;

public class c
  extends a
{
  public c(String paramString)
  {
    super(paramString);
  }
  
  public static c a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new c(paramString);
  }
  
  public static c a(BigInteger paramBigInteger)
  {
    int i = paramBigInteger.bitLength() + 7 >> 3 << 3;
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    int j = paramBigInteger.bitLength();
    int k = 1;
    if ((j % 8 != 0) && (paramBigInteger.bitLength() / 8 + 1 == i / 8))
    {
      paramBigInteger = arrayOfByte;
    }
    else
    {
      j = arrayOfByte.length;
      if (paramBigInteger.bitLength() % 8 == 0) {
        j--;
      } else {
        k = 0;
      }
      i /= 8;
      paramBigInteger = new byte[i];
      System.arraycopy(arrayOfByte, k, paramBigInteger, i - j, j);
    }
    return a(paramBigInteger);
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    return new c(b.a(paramArrayOfByte, true));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && ((paramObject instanceof c)) && (x.equals(paramObject.toString()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     e.e.a.v.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */