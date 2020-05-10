package l.b.a;

import java.io.IOException;

public class t0
  implements e, x1
{
  public z x;
  
  public t0(z paramz)
  {
    x = paramz;
  }
  
  public t b()
  {
    try
    {
      t localt = d();
      return localt;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new s("unable to get DER object", localIllegalArgumentException);
    }
    catch (IOException localIOException)
    {
      throw new s("unable to get DER object", localIOException);
    }
  }
  
  public t d()
  {
    try
    {
      o1 localo1 = new o1(x.b());
      return localo1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new h(localIllegalArgumentException.getMessage(), localIllegalArgumentException);
    }
  }
}

/* Location:
 * Qualified Name:     l.b.a.t0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */