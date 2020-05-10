package l.b.a;

import java.util.Arrays;
import l.b.j.f;

public class x0
  extends t
  implements a0
{
  public final byte[] x;
  
  public x0(byte[] paramArrayOfByte)
  {
    x = paramArrayOfByte;
  }
  
  public static x0 a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof x0)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (x0)t.a((byte[])paramObject);
          return (x0)paramObject;
        }
        catch (Exception paramObject)
        {
          throw new IllegalArgumentException(e.a.a.a.a.a((Exception)paramObject, e.a.a.a.a.a("encoding error in getInstance: ")));
        }
      }
      throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("illegal object in getInstance: ")));
    }
    return (x0)paramObject;
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 22, x);
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof x0)) {
      return false;
    }
    paramt = (x0)paramt;
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
    return l.b.c.e.a.d(x);
  }
  
  public String toString()
  {
    return c();
  }
}

/* Location:
 * Qualified Name:     l.b.a.x0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */