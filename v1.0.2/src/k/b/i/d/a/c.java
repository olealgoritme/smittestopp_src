package k.b.i.d.a;

import java.math.BigInteger;

public final class c
{
  static
  {
    BigInteger.valueOf(0L);
    BigInteger.valueOf(1L);
    BigInteger.valueOf(2L);
    BigInteger.valueOf(4L);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = -paramInt;
    }
    paramInt = 0;
    while (i > 0)
    {
      paramInt++;
      i >>>= 8;
    }
    return paramInt;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.d.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */