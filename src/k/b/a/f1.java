package k.b.a;

import java.io.OutputStream;

public class f1
  extends x
{
  public int z = -1;
  
  public f1() {}
  
  public f1(boolean paramBoolean, e[] paramArrayOfe) {}
  
  public void a(r paramr, boolean paramBoolean)
  {
    if (paramBoolean) {
      a.write(49);
    }
    c1 localc1 = paramr.a();
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
        t localt = x[k].c().h();
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
      arrayOft[k].a(localc1, true);
      k++;
      continue;
      paramr.a(j());
      while (k < i)
      {
        x[k].c().h().a(localc1, true);
        k++;
      }
    }
  }
  
  public int f()
  {
    int i = j();
    return d2.a(i) + 1 + i;
  }
  
  public t h()
  {
    Object localObject;
    if (y) {
      localObject = this;
    } else {
      localObject = super.h();
    }
    return (t)localObject;
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
        k += x[j].c().h().f();
        j++;
      }
      z = k;
    }
    return z;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.f1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */