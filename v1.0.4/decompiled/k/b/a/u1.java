package k.b.a;

import java.io.IOException;

public class u1
  implements y
{
  public z x;
  
  public u1(z paramz)
  {
    x = paramz;
  }
  
  public t a()
  {
    return new t1(x.b());
  }
  
  public t c()
  {
    try
    {
      t1 localt1 = new t1(x.b());
      return localt1;
    }
    catch (IOException localIOException)
    {
      throw new s(localIOException.getMessage(), localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.u1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */