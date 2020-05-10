package k.b.a;

import java.io.OutputStream;

public class t1
  extends x
{
  public int z = -1;
  
  public t1() {}
  
  public t1(e parame)
  {
    super(parame);
  }
  
  public t1(f paramf)
  {
    super(paramf, false);
  }
  
  public t1(boolean paramBoolean, e[] paramArrayOfe)
  {
    super(paramBoolean, paramArrayOfe);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    if (paramBoolean) {
      a.write(49);
    }
    r localr = paramr.b();
    int i = x.length;
    int j = z;
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
        t localt = x[k].c().i();
        arrayOft[k] = localt;
        j += localt.f();
        k++;
      }
      z = j;
      paramr.a(j);
      k = m;
    }
    while (k < i)
    {
      localr.a(arrayOft[k], true);
      k++;
      continue;
      paramr.a(j());
      while (k < i)
      {
        localr.a(x[k].c(), true);
        k++;
      }
    }
  }
  
  public int f()
  {
    int i = j();
    return d2.a(i) + 1 + i;
  }
  
  public t i()
  {
    return this;
  }
  
  public final int j()
  {
    if (z < 0)
    {
      int i = x.length;
      int j = 0;
      int k = 0;
      while (j < i)
      {
        k += x[j].c().i().f();
        j++;
      }
      z = k;
    }
    return z;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.t1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */