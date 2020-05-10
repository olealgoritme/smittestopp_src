package k.b.a;

import java.io.IOException;

public class o0
  implements c0
{
  public boolean x;
  public int y;
  public z z;
  
  public o0(boolean paramBoolean, int paramInt, z paramz)
  {
    x = paramBoolean;
    y = paramInt;
    z = paramz;
  }
  
  public t a()
  {
    return z.a(x, y);
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
      throw new s(localIOException.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.o0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */