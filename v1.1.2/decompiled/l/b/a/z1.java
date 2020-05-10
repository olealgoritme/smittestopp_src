package l.b.a;

import java.io.IOException;
import java.util.Enumeration;

public class z1
  implements Enumeration
{
  public k a;
  public Object b;
  
  public z1(byte[] paramArrayOfByte)
  {
    a = new k(paramArrayOfByte, true);
    b = a();
  }
  
  public final Object a()
  {
    try
    {
      localObject = a.readObject();
      return localObject;
    }
    catch (IOException localIOException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("malformed DER construction: ");
      ((StringBuilder)localObject).append(localIOException);
      throw new s(((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  public boolean hasMoreElements()
  {
    boolean bool;
    if (b != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Object nextElement()
  {
    Object localObject = b;
    b = a();
    return localObject;
  }
}

/* Location:
 * Qualified Name:     l.b.a.z1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */