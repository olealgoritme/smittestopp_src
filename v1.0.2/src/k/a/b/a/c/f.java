package k.a.b.a.c;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class f
  extends c<BigInteger>
{
  public static final BigInteger c = BigInteger.valueOf(-128L);
  public static final BigInteger d = BigInteger.valueOf(127L);
  public static final BigInteger e = BigInteger.valueOf(Long.MIN_VALUE);
  public static final BigInteger f = BigInteger.valueOf(Long.MAX_VALUE);
  public f.b a;
  public f.b b;
  
  public f(x paramx, r paramr)
  {
    a = new f.a(this, paramx, paramr);
    b = new f.c(this, paramx, paramr);
    c.put(BigInteger.class, this);
  }
  
  public Class<BigInteger> a()
  {
    return BigInteger.class;
  }
  
  public f.b a(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.compareTo(c) >= 0) && (paramBigInteger.compareTo(d) <= 0)) {
      paramBigInteger = b;
    } else {
      paramBigInteger = a;
    }
    return paramBigInteger;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<f.b> i()
  {
    return Arrays.asList(new f.b[] { b, a });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */