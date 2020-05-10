package k.b.a;

import java.io.IOException;

public class f0
  implements e, x1
{
  public final int x;
  public final z y;
  
  public f0(int paramInt, z paramz)
  {
    x = paramInt;
    y = paramz;
  }
  
  public t a()
  {
    return new e0(x, y.b());
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
 * Qualified Name:     base.k.b.a.f0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */