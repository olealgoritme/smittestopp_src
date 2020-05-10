package k.b.a;

import java.io.IOException;

public class m0
  implements y
{
  public z x;
  
  public m0(z paramz)
  {
    x = paramz;
  }
  
  public t a()
  {
    return new l0(x.b());
  }
  
  public t c()
  {
    try
    {
      t localt = a();
      return localt;
    }
    catch (IOException localIOException)
    {
      throw new s(localIOException.getMessage(), localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.m0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */