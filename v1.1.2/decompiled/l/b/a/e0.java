package l.b.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class e0
  extends a
{
  public e0(int paramInt, f paramf)
  {
    super(true, paramInt, localIOException.toByteArray());
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    if (x) {
      i = 96;
    } else {
      i = 64;
    }
    int j = y;
    byte[] arrayOfByte = z;
    paramr.a(paramBoolean, i, j);
    a.write(128);
    int i = arrayOfByte.length;
    a.write(arrayOfByte, 0, i);
    a.write(0);
    a.write(0);
  }
}

/* Location:
 * Qualified Name:     l.b.a.e0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */