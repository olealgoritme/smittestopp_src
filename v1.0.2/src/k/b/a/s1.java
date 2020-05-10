package k.b.a;

import java.io.IOException;

public class s1
  implements v
{
  public z x;
  
  public s1(z paramz)
  {
    x = paramz;
  }
  
  public t a()
  {
    return new r1(x.b());
  }
  
  public t c()
  {
    try
    {
      r1 localr1 = new r1(x.b());
      return localr1;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.s1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */