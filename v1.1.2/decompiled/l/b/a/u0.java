package l.b.a;

import java.util.Arrays;
import l.b.c.e.a;
import l.b.j.f;

public class u0
  extends t
  implements a0
{
  public final byte[] x;
  
  public u0(byte[] paramArrayOfByte)
  {
    x = paramArrayOfByte;
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 27, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof u0)) {
      return false;
    }
    paramt = (u0)paramt;
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
  
  public String toString()
  {
    return c();
  }
}

/* Location:
 * Qualified Name:     l.b.a.u0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */