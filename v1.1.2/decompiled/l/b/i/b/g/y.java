package l.b.i.b.g;

import l.b.c.e.a;

public final class y
  extends p
{
  public final w b;
  public final int c;
  public final byte[] d;
  public final byte[] e;
  
  public byte[] a()
  {
    int i = b.g;
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
    public final w a;
    public byte[] b = null;
    public byte[] c = null;
    public byte[] d = null;
    
    public b(w paramw)
    {
      a = paramw;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */