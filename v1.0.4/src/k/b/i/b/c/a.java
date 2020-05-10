package k.b.i.b.c;

public final class a
  extends k.b.c.d.a
{
  public int a;
  public byte[] b;
  
  public a(int paramInt, byte[] paramArrayOfByte)
  {
    super(true);
    int i = paramArrayOfByte.length;
    int j;
    if (paramInt != 5)
    {
      if (paramInt == 6) {
        j = 12352;
      } else {
        throw new IllegalArgumentException(e.a.a.a.a.a("unknown security category: ", paramInt));
      }
    }
    else {
      j = 5184;
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
 * Qualified Name:     base.k.b.i.b.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */