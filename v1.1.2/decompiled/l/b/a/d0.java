package l.b.a;

import java.util.Arrays;
import l.b.c.e.a;
import l.b.j.f;

public class d0
  extends t
{
  public byte[] x;
  
  public d0(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 2)
    {
      x = paramArrayOfByte;
      if ((a(0)) && (a(1))) {
        return;
      }
      throw new IllegalArgumentException("illegal characters in UTCTime string");
    }
    throw new IllegalArgumentException("UTCTime string too short");
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 23, x);
  }
  
  public final boolean a(int paramInt)
  {
    byte[] arrayOfByte = x;
    boolean bool;
    if ((arrayOfByte.length > paramInt) && (arrayOfByte[paramInt] >= 48) && (arrayOfByte[paramInt] <= 57)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof d0)) {
      return false;
    }
    return Arrays.equals(x, x);
  }
  
  public int f()
  {
    int i = x.length;
    return d2.a(i) + 1 + i;
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
    return f.a(x);
  }
}

/* Location:
 * Qualified Name:     l.b.a.d0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */