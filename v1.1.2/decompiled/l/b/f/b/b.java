package l.b.f.b;

import java.math.BigInteger;

public abstract class b
{
  public static final a a = new f(BigInteger.valueOf(2L));
  public static final a b = new f(BigInteger.valueOf(3L));
  
  public static a a(BigInteger paramBigInteger)
  {
    int i = paramBigInteger.bitLength();
    if ((paramBigInteger.signum() > 0) && (i >= 2))
    {
      if (i < 3)
      {
        i = paramBigInteger.intValue();
        if (i != 2)
        {
          if (i == 3) {
            return b;
          }
        }
        else {
          return a;
        }
      }
      return new f(paramBigInteger);
    }
    throw new IllegalArgumentException("'characteristic' must be >= 2");
  }
  
  public static e a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] == 0)
    {
      int i = 1;
      while (i < paramArrayOfInt.length) {
        if (paramArrayOfInt[i] > paramArrayOfInt[(i - 1)]) {
          i++;
        } else {
          throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
        }
      }
      return new d(a, new c(paramArrayOfInt));
    }
    throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
  }
}

/* Location:
 * Qualified Name:     l.b.f.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */