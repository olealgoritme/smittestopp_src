package k.b.a;

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
  
  public t a()
  {
    return new a1(x.a());
  }
  
  public InputStream b()
  {
    return x;
  }
  
  public t c()
  {
    try
    {
      localObject = new a1(x.a());
      return (t)localObject;
    }
    catch (IOException localIOException)
    {
      Object localObject = a.a("IOException converting stream to byte array: ");
      ((StringBuilder)localObject).append(localIOException.getMessage());
      throw new s(((StringBuilder)localObject).toString(), localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.b1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */