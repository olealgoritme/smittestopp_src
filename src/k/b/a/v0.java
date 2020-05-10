package k.b.a;

import k.b.j.f;

public class v0
  extends j
{
  public v0(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 24, n());
  }
  
  public int f()
  {
    int i = n().length;
    return d2.a(i) + 1 + i;
  }
  
  public t h()
  {
    return this;
  }
  
  public t i()
  {
    return this;
  }
  
  public final byte[] n()
  {
    byte[] arrayOfByte1 = x;
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1[(arrayOfByte1.length - 1)] == 90)
    {
      if (!l())
      {
        arrayOfByte2 = x;
        arrayOfByte1 = new byte[arrayOfByte2.length + 4];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length - 1);
        System.arraycopy(f.a("0000Z"), 0, arrayOfByte1, x.length - 1, 5);
        return arrayOfByte1;
      }
      if (!m())
      {
        arrayOfByte2 = x;
        arrayOfByte1 = new byte[arrayOfByte2.length + 2];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length - 1);
        System.arraycopy(f.a("00Z"), 0, arrayOfByte1, x.length - 1, 3);
        return arrayOfByte1;
      }
      if (k())
      {
        for (int i = x.length - 2; (i > 0) && (x[i] == 48); i--) {}
        arrayOfByte2 = x;
        if (arrayOfByte2[i] == 46)
        {
          arrayOfByte1 = new byte[i + 1];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
          arrayOfByte1[i] = ((byte)90);
          return arrayOfByte1;
        }
        arrayOfByte1 = new byte[i + 2];
        i++;
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
        arrayOfByte1[i] = ((byte)90);
        return arrayOfByte1;
      }
      arrayOfByte2 = x;
    }
    return arrayOfByte2;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.v0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */