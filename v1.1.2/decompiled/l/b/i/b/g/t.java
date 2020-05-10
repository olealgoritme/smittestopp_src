package l.b.i.b.g;

import l.b.c.e.a;

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
  
  public static class b
  {
    public final r a;
    public byte[] b = null;
    public byte[] c = null;
    public byte[] d = null;
    
    public b(r paramr)
    {
      a = paramr;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */