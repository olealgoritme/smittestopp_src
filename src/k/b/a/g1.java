package k.b.a;

import java.util.Arrays;
import k.b.c.e.a;
import k.b.j.f;

public class g1
  extends t
  implements a0
{
  public byte[] x;
  
  public g1(byte[] paramArrayOfByte)
  {
    x = a.a(paramArrayOfByte);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 20, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof g1)) {
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
 * Qualified Name:     base.k.b.a.g1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */