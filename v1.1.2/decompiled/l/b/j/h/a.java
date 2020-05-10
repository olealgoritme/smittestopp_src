package l.b.j.h;

import java.io.InputStream;

public final class a
{
  public static int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j < 0) {
        break;
      }
      i += j;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.b.j.h.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */