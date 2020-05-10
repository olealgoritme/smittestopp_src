package k.b.a;

import java.io.IOException;

public class k0
  implements v
{
  public z x;
  
  public k0(z paramz)
  {
    x = paramz;
  }
  
  public t a()
  {
    return new j0(x.b());
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
      throw new IllegalStateException(localIOException.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.k0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */