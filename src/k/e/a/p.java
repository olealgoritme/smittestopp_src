package k.e.a;

public final class p
{
  public final q a;
  public final q b;
  public final q c;
  public final int d;
  public final String e;
  public p f;
  
  public p(p paramp, q paramq1, q paramq2)
  {
    a = paramq1;
    b = paramq2;
    c = localq;
    d = i;
    e = str;
    f = f;
  }
  
  public p(q paramq1, q paramq2, q paramq3, int paramInt, String paramString)
  {
    a = paramq1;
    b = paramq2;
    c = paramq3;
    d = paramInt;
    e = paramString;
  }
  
  public static p a(p paramp, q paramq1, q paramq2)
  {
    if (paramp == null) {
      return null;
    }
    f = a(f, paramq1, paramq2);
    int i = a.d;
    int j = b.d;
    int k = d;
    int m;
    if (paramq2 == null) {
      m = Integer.MAX_VALUE;
    } else {
      m = d;
    }
    if ((k < j) && (m > i))
    {
      if (k <= i)
      {
        if (m >= j) {
          return f;
        }
        return new p(paramp, paramq2, b);
      }
      if (m >= j) {
        return new p(paramp, a, paramq1);
      }
      f = new p(paramp, paramq2, b);
      return new p(paramp, a, paramq1);
    }
    return paramp;
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */