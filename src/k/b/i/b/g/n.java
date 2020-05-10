package k.b.i.b.g;

import k.b.c.e.a;

public final class n
{
  public final byte[][] a;
  
  public n(m paramm, byte[][] paramArrayOfByte)
  {
    if (paramm != null)
    {
      if (paramArrayOfByte != null)
      {
        if (!a.c(paramArrayOfByte))
        {
          if (paramArrayOfByte.length == d)
          {
            int i = 0;
            while (i < paramArrayOfByte.length) {
              if (paramArrayOfByte[i].length == b) {
                i++;
              } else {
                throw new IllegalArgumentException("wrong publicKey format");
              }
            }
            a = a.a(paramArrayOfByte);
            return;
          }
          throw new IllegalArgumentException("wrong publicKey size");
        }
        throw new NullPointerException("publicKey byte array == null");
      }
      throw new NullPointerException("publicKey == null");
    }
    throw new NullPointerException("params == null");
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */