package l.b.a.k2;

import l.b.a.e;
import l.b.a.n;
import l.b.a.t;
import l.b.a.x;

public class b
  extends n
{
  public x x;
  
  public b(x paramx)
  {
    x = paramx;
  }
  
  public t b()
  {
    return x;
  }
  
  public a f()
  {
    e[] arrayOfe = x.x;
    if (arrayOfe.length == 0) {
      return null;
    }
    return a.a(arrayOfe[0]);
  }
  
  public a[] g()
  {
    int i = x.x.length;
    a[] arrayOfa = new a[i];
    for (int j = 0; j != i; j++) {
      arrayOfa[j] = a.a(x.x[j]);
    }
    return arrayOfa;
  }
}

/* Location:
 * Qualified Name:     l.b.a.k2.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */