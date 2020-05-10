package l.b.a;

import java.io.IOException;
import java.util.Arrays;
import l.b.c.e.a;

public class j1
  extends t
  implements a0
{
  public static final char[] y = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public final byte[] x;
  
  public j1(byte[] paramArrayOfByte)
  {
    x = a.a(paramArrayOfByte);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 28, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof j1)) {
      return false;
    }
    return Arrays.equals(x, x);
  }
  
  public String c()
  {
    StringBuffer localStringBuffer = new StringBuffer("#");
    try
    {
      byte[] arrayOfByte = e();
      for (int i = 0; i != arrayOfByte.length; i++)
      {
        localStringBuffer.append(y[(arrayOfByte[i] >>> 4 & 0xF)]);
        localStringBuffer.append(y[(arrayOfByte[i] & 0xF)]);
      }
      return localStringBuffer.toString();
    }
    catch (IOException localIOException)
    {
      throw new s("internal error encoding UniversalString");
    }
  }
  
  public int f()
  {
    return d2.a(x.length) + 1 + x.length;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public int hashCode()
  {
    return a.d(x);
  }
  
  public String toString()
  {
    return c();
  }
}

/* Location:
 * Qualified Name:     l.b.a.j1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */