package l.b.a;

import e.a.a.a.a;
import java.io.IOException;
import java.io.InputStream;

public class b1
  implements q
{
  public w1 x;
  
  public b1(w1 paramw1)
  {
    x = paramw1;
  }
  
  public InputStream a()
  {
    return x;
  }
  
  public t b()
  {
    try
    {
      a1 locala1 = new a1(x.a());
      return locala1;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = a.a("IOException converting stream to byte array: ");
      localStringBuilder.append(localIOException.getMessage());
      throw new s(localStringBuilder.toString(), localIOException);
    }
  }
  
  public t d()
  {
    return new a1(x.a());
  }
}

/* Location:
 * Qualified Name:     l.b.a.b1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */