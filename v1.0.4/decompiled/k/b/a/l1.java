package k.b.a;

import java.util.Arrays;
import k.b.c.e.a;
import k.b.j.f;

public class l1
  extends t
  implements a0
{
  public final byte[] x;
  
  public l1(byte[] paramArrayOfByte)
  {
    x = paramArrayOfByte;
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 26, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof l1)) {
      return false;
    }
    return Arrays.equals(x, x);
  }
  
  public String d()
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
    return d();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */