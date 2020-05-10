package l.b.i.b.g;

import l.b.c.a;

public final class r
{
  public final v a;
  public final w b;
  public final int c;
  public final int d;
  
  public r(int paramInt1, int paramInt2, a parama)
  {
    c = paramInt1;
    d = paramInt2;
    if (paramInt1 >= 2)
    {
      if (paramInt1 % paramInt2 == 0)
      {
        paramInt1 /= paramInt2;
        if (paramInt1 != 1)
        {
          parama = new w(paramInt1, parama);
          b = parama;
          a = d.b(f, g, e, h.d, c, paramInt2);
          return;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
      }
      throw new IllegalArgumentException("layers must divide totalHeight without remainder");
    }
    throw new IllegalArgumentException("totalHeight must be > 1");
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */