package e.b.a.a.q;

import e.b.a.a.p.b;
import java.io.CharConversionException;
import java.io.InputStream;

public final class a
{
  public final b a;
  public final InputStream b;
  public final byte[] c;
  public int d;
  public int e;
  public final boolean f;
  public boolean g = true;
  public int h;
  
  public a(b paramb, InputStream paramInputStream)
  {
    a = paramb;
    b = paramInputStream;
    paramb.a(e);
    paramInputStream = d.a(0);
    e = paramInputStream;
    c = paramInputStream;
    d = 0;
    e = 0;
    f = true;
  }
  
  public final void a(String paramString)
  {
    throw new CharConversionException(e.a.a.a.a.a("Unsupported UCS-4 endianness (", paramString, ") detected"));
  }
  
  public final boolean a(int paramInt)
  {
    if ((0xFF00 & paramInt) == 0)
    {
      g = true;
    }
    else
    {
      if ((paramInt & 0xFF) != 0) {
        break label35;
      }
      g = false;
    }
    h = 2;
    return true;
    label35:
    return false;
  }
  
  public boolean b(int paramInt)
  {
    int i = e - d;
    while (i < paramInt)
    {
      InputStream localInputStream = b;
      int j;
      if (localInputStream == null)
      {
        j = -1;
      }
      else
      {
        byte[] arrayOfByte = c;
        j = e;
        j = localInputStream.read(arrayOfByte, j, arrayOfByte.length - j);
      }
      if (j < 1) {
        return false;
      }
      e += j;
      i += j;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.q.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */