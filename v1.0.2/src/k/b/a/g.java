package k.b.a;

import java.util.Arrays;
import k.b.c.e.a;

public class g
  extends t
{
  public static g[] y = new g[12];
  public final byte[] x;
  
  public g(byte[] paramArrayOfByte)
  {
    if (!l.b(paramArrayOfByte))
    {
      if ((paramArrayOfByte[0] & 0x80) == 0)
      {
        x = a.a(paramArrayOfByte);
        l.c(paramArrayOfByte);
        return;
      }
      throw new IllegalArgumentException("enumerated must be non-negative");
    }
    throw new IllegalArgumentException("malformed enumerated");
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 10, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof g)) {
      return false;
    }
    paramt = (g)paramt;
    return Arrays.equals(x, x);
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
}

/* Location:
 * Qualified Name:     base.k.b.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */