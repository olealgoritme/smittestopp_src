package k.b.a;

import java.io.OutputStream;

public class e1
  extends u
{
  public int y = -1;
  
  public e1() {}
  
  public e1(f paramf)
  {
    super(paramf);
  }
  
  public e1(e[] paramArrayOfe)
  {
    super(paramArrayOfe);
  }
  
  public e1(e[] paramArrayOfe, boolean paramBoolean)
  {
    super(paramArrayOfe, paramBoolean);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    if (paramBoolean) {
      a.write(48);
    }
    c1 localc1 = paramr.a();
    int i = x.length;
    int j = y;
    int k = 0;
    int m = 0;
    t[] arrayOft;
    if ((j < 0) && (i <= 16))
    {
      arrayOft = new t[i];
      k = 0;
      j = 0;
      while (k < i)
      {
        t localt = x[k].c().h();
        arrayOft[k] = localt;
        j += localt.f();
        k++;
      }
      y = j;
      paramr.a(j);
      k = m;
    }
    while (k < i)
    {
      arrayOft[k].a(localc1, true);
      k++;
      continue;
      paramr.a(l());
      while (k < i)
      {
        x[k].c().h().a(localc1, true);
        k++;
      }
    }
  }
  
  public int f()
  {
    int i = l();
    return d2.a(i) + 1 + i;
  }
  
  public t h()
  {
    return this;
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
        k += x[j].c().h().f();
        j++;
      }
      y = k;
    }
    return y;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.e1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */