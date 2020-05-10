package h.c;

public final class g$c
{
  public final f a;
  public e b = null;
  public g c = null;
  public int d = 0;
  public int e = 0;
  public int f = 1;
  public boolean g = false;
  public g.b h = new g.b(0);
  
  public g$c(f paramf)
  {
    a = paramf;
  }
  
  public final int a()
  {
    g localg = c;
    int i;
    if (localg == null)
    {
      i = 0;
    }
    else
    {
      i = d;
      i = a.a() + i;
    }
    return i;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    int i = h.x;
    int j = paramInt2 >> 3;
    paramInt2 = j;
    if (i > 0) {
      paramInt2 = Math.min(i, j);
    }
    if (g) {
      j = 0;
    } else {
      j = e + paramInt2 - 1 & paramInt2 - 1;
    }
    e = Math.max(e, (paramInt1 >> 3) + j);
    f = Math.max(f, paramInt2);
    return j;
  }
  
  public final void a(int paramInt)
  {
    g localg = c;
    if (localg != null)
    {
      a.a(paramInt);
    }
    else
    {
      if ((paramInt & 0x20) != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        a.b().a(b(), true);
      } else {
        a.b().a(b());
      }
      b = null;
    }
  }
  
  public final int b()
  {
    int i;
    if (h.x > 0)
    {
      i = e;
      i += (-i & f - 1);
    }
    else
    {
      i = e;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     h.c.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */