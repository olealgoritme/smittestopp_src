package k.a.a.a.a.a;

import e.a.a.a.a;

public final class k$b
{
  public int a = 0;
  public int b = 1;
  public long c = 0L;
  public int d = 1;
  public int e = 3;
  public boolean f = true;
  public int g = 255;
  public boolean h = true;
  public boolean i = true;
  public boolean j = true;
  public long k = 10000L;
  public long l = 10000L;
  public long m = 0L;
  public long n = 0L;
  
  public b a(int paramInt)
  {
    if ((paramInt >= -1) && (paramInt <= 2))
    {
      a = paramInt;
      return this;
    }
    throw new IllegalArgumentException(a.a("invalid scan mode ", paramInt));
  }
  
  public k a()
  {
    if ((m == 0L) && (n == 0L))
    {
      int i1 = a;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          n = 500L;
          m = 4500L;
        }
        else
        {
          n = 0L;
          m = 0L;
        }
      }
      else
      {
        n = 2000L;
        m = 3000L;
      }
    }
    return new k(a, b, c, d, e, f, g, h, i, j, k, l, n, m, null);
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.k.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */