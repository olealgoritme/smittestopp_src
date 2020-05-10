package k.b.i.b.g;

import k.b.c.e.a;

public final class t
  extends q
{
  public final r b;
  public final int c;
  public final byte[] d;
  public final byte[] e;
  
  public byte[] a()
  {
    int i = b.b.g;
    int j = 0;
    int k = c;
    byte[] arrayOfByte;
    if (k != 0)
    {
      arrayOfByte = new byte[i + 4 + i];
      a.b(k, arrayOfByte, 0);
      j = 4;
    }
    else
    {
      arrayOfByte = new byte[i + i];
    }
    a.a(arrayOfByte, d, j);
    a.a(arrayOfByte, e, j + i);
    return arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */