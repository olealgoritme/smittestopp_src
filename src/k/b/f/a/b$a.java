package k.b.f.a;

import java.math.BigInteger;
import k.b.f.b.e;

public abstract class b$a
  extends b
{
  public b$a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public d a(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    c localc = a(paramBigInteger1);
    paramBigInteger1 = a(paramBigInteger2);
    int i = d;
    if ((i == 5) || (i == 6)) {
      if (localc.e())
      {
        if (!paramBigInteger1.g().equals(c)) {
          throw new IllegalArgumentException();
        }
      }
      else {
        paramBigInteger1 = ((c.c)paramBigInteger1).c(localc.c()).a(localc);
      }
    }
    return new d.c((b.c)this, localc, paramBigInteger1);
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */