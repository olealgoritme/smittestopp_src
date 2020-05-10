package l.b.a;

import java.io.IOException;

public class k0
  implements v
{
  public z x;
  
  public k0(z paramz)
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
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException.getMessage());
    }
  }
  
  public t d()
  {
    return new j0(x.b());
  }
}

/* Location:
 * Qualified Name:     l.b.a.k0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */