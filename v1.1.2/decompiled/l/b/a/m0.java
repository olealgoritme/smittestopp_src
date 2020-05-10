package l.b.a;

import java.io.IOException;

public class m0
  implements y
{
  public z x;
  
  public m0(z paramz)
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
      throw new s(localIOException.getMessage(), localIOException);
    }
  }
  
  public t d()
  {
    return new l0(x.b());
  }
}

/* Location:
 * Qualified Name:     l.b.a.m0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */