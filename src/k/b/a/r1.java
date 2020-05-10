package k.b.a;

import java.io.OutputStream;

public class r1
  extends u
{
  public int y = -1;
  
  public r1() {}
  
  public r1(e parame)
  {
    super(parame);
  }
  
  public r1(f paramf)
  {
    super(paramf);
  }
  
  public r1(e[] paramArrayOfe, boolean paramBoolean)
  {
    super(paramArrayOfe, paramBoolean);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    if (paramBoolean) {
      a.write(48);
    }
    r localr = paramr.b();
    int i = x.length;
    int j = y;
    int k = 0;
    int m = 0;
    t[] arrayOft;
    if ((j < 0) && (i <= 16))
    {
      arrayOft = new t[i];
      j = 0;
      k = 0;
      while (j < i)
      {
        t localt = x[j].c().i();
        arrayOft[j] = localt;
        k += localt.f();
        j++;
      }
      y = k;
      paramr.a(k);
      k = m;
    }
    while (k < i)
    {
      localr.a(arrayOft[k], true);
      k++;
      continue;
      paramr.a(l());
      while (k < i)
      {
        localr.a(x[k].c(), true);
        k++;
      }
    }
  }
  
  public int f()
  {
    int i = l();
    return d2.a(i) + 1 + i;
  }
  
  public t i()
  {
    return this;
  }
  
  public final int l()
  {
    if (y < 0)
    {
      int i = x.length;
      int j = 0;
      int k = 0;
      while (j < i)
      {
        k += x[j].c().i().f();
        j++;
      }
      y = k;
    }
    return y;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.r1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */