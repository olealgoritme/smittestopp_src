package l.b.a;

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
  
  public t b()
  {
    try
    {
      t localt = d();
      return localt;
    }
    catch (IOException localIOException)
    {
      throw new s(localIOException.getMessage());
    }
  }
  
  public t d()
  {
    return z.a(x, y);
  }
}

/* Location:
 * Qualified Name:     l.b.a.o0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */