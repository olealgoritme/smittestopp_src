package k.b.i.b.d;

public class a
{
  public int a;
  public int b;
  public int c;
  public short[][][] d;
  public short[][][] e;
  public short[][] f;
  public short[] g;
  
  public a(byte paramByte1, byte paramByte2, short[][][] paramArrayOfShort1, short[][][] paramArrayOfShort2, short[][] paramArrayOfShort, short[] paramArrayOfShort3)
  {
    paramByte1 &= 0xFF;
    a = paramByte1;
    paramByte2 &= 0xFF;
    b = paramByte2;
    c = (paramByte2 - paramByte1);
    d = paramArrayOfShort1;
    e = paramArrayOfShort2;
    f = paramArrayOfShort;
    g = paramArrayOfShort3;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((a == a) && (b == b) && (c == c) && (k.b.c.e.a.a(d, d)) && (k.b.c.e.a.a(e, e)) && (k.b.c.e.a.a(f, f)) && (k.b.c.e.a.a(g, g))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public int hashCode()
  {
    int i = a;
    int j = b;
    int k = c;
    int m = k.b.c.e.a.b(d);
    int n = k.b.c.e.a.b(e);
    int i1 = k.b.c.e.a.b(f);
    return k.b.c.e.a.c(g) + (i1 + (n + (m + ((i * 37 + j) * 37 + k) * 37) * 37) * 37) * 37;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */