package l.b.a;

import java.util.Arrays;
import l.b.c.e.a;
import l.b.j.f;

public class k1
  extends t
  implements a0
{
  public final byte[] x;
  
  public k1(byte[] paramArrayOfByte)
  {
    x = a.a(paramArrayOfByte);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 21, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof k1)) {
      return false;
    }
    paramt = (k1)paramt;
    return Arrays.equals(x, x);
  }
  
  public String c()
  {
    return f.a(x);
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
 * Qualified Name:     l.b.a.k1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */