package e.e.a.u;

import e.e.a.v.c;
import java.io.Serializable;
import java.security.spec.RSAOtherPrimeInfo;

public class k$a
  implements Serializable
{
  public final c x;
  public final c y;
  public final c z;
  
  public k$a(c paramc1, c paramc2, c paramc3)
  {
    if (paramc1 != null)
    {
      x = paramc1;
      if (paramc2 != null)
      {
        y = paramc2;
        if (paramc3 != null)
        {
          z = paramc3;
          return;
        }
        throw new IllegalArgumentException("The factor CRT coefficient must not be null");
      }
      throw new IllegalArgumentException("The factor CRT exponent must not be null");
    }
    throw new IllegalArgumentException("The prime factor must not be null");
  }
  
  public k$a(RSAOtherPrimeInfo paramRSAOtherPrimeInfo)
  {
    x = c.a(paramRSAOtherPrimeInfo.getPrime());
    y = c.a(paramRSAOtherPrimeInfo.getExponent());
    z = c.a(paramRSAOtherPrimeInfo.getCrtCoefficient());
  }
}

/* Location:
 * Qualified Name:     e.e.a.u.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */