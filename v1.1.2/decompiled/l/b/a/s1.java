package l.b.a;

import java.io.IOException;

public class s1
  implements v
{
  public z x;
  
  public s1(z paramz)
  {
    x = paramz;
  }
  
  public t b()
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
  
  public t d()
  {
    return new r1(x.b());
  }
}

/* Location:
 * Qualified Name:     l.b.a.s1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */