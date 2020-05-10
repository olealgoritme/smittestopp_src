package k.b.a;

import e.a.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class i0
  implements q
{
  public z x;
  
  public i0(z paramz)
  {
    x = paramz;
  }
  
  public t a()
  {
    InputStream localInputStream = b();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = localInputStream.read(arrayOfByte, 0, 4096);
      if (i < 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return new h0(localByteArrayOutputStream.toByteArray());
  }
  
  public InputStream b()
  {
    return new p0(x);
  }
  
  public t c()
  {
    try
    {
      localObject = a();
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
 * Qualified Name:     base.k.b.a.i0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */