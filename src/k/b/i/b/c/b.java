package k.b.i.b.c;

public final class b
  extends k.b.c.d.a
{
  public int a;
  public byte[] b;
  
  public b(int paramInt, byte[] paramArrayOfByte)
  {
    super(false);
    int i = paramArrayOfByte.length;
    int j;
    if (paramInt != 5)
    {
      if (paramInt == 6) {
        j = 38432;
      } else {
        throw new IllegalArgumentException(e.a.a.a.a.a("unknown security category: ", paramInt));
      }
    }
    else {
      j = 14880;
    }
    if (i == j)
    {
      a = paramInt;
      b = k.b.c.e.a.a(paramArrayOfByte);
      return;
    }
    throw new IllegalArgumentException("invalid key size for security category");
  }
  
  public byte[] a()
  {
    return k.b.c.e.a.a(b);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */