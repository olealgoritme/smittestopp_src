package l.b.a;

import java.util.Arrays;
import l.b.j.g.f;

public abstract class a
  extends t
{
  public final boolean x;
  public final int y;
  public final byte[] z;
  
  public a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    x = paramBoolean;
    y = paramInt;
    z = l.b.c.e.a.a(paramArrayOfByte);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    int i;
    if (x) {
      i = 96;
    } else {
      i = 64;
    }
    paramr.a(paramBoolean, i, y, z);
  }
  
  public boolean a(t paramt)
  {
    boolean bool1 = paramt instanceof a;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramt = (a)paramt;
    bool1 = bool2;
    if (x == x)
    {
      bool1 = bool2;
      if (y == y)
      {
        bool1 = bool2;
        if (Arrays.equals(z, z)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int f()
  {
    int i = d2.b(y);
    return d2.a(z.length) + i + z.length;
  }
  
  public boolean g()
  {
    return x;
  }
  
  public int hashCode()
  {
    return x ^ y ^ l.b.c.e.a.d(z);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[");
    if (x) {
      localStringBuffer.append("CONSTRUCTED ");
    }
    localStringBuffer.append("APPLICATION ");
    localStringBuffer.append(Integer.toString(y));
    localStringBuffer.append("]");
    String str;
    if (z != null)
    {
      localStringBuffer.append(" #");
      str = f.b(z);
    }
    else
    {
      str = " #null";
    }
    localStringBuffer.append(str);
    localStringBuffer.append(" ");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     l.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */