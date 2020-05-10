package l.b.a.m2;

import java.math.BigInteger;
import l.b.a.a1;
import l.b.a.n;
import l.b.a.t;
import l.b.f.a.c;

public class d
  extends n
{
  public c x;
  
  public d(c paramc)
  {
    x = paramc;
  }
  
  public t b()
  {
    int i = (x.b() + 7) / 8;
    byte[] arrayOfByte1 = x.h().toByteArray();
    byte[] arrayOfByte2;
    if (i < arrayOfByte1.length)
    {
      arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, arrayOfByte1.length - i, arrayOfByte2, 0, i);
    }
    for (;;)
    {
      break;
      arrayOfByte2 = arrayOfByte1;
      if (i <= arrayOfByte1.length) {
        break;
      }
      arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i - arrayOfByte1.length, arrayOfByte1.length);
    }
    return new a1(arrayOfByte2);
  }
}

/* Location:
 * Qualified Name:     l.b.a.m2.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */