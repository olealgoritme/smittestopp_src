package k.b.i.b.g;

import java.io.Serializable;

public class c
  implements Serializable, Cloneable
{
  public int A;
  public boolean B;
  public boolean C;
  public u x;
  public final int y;
  public int z;
  
  public c(int paramInt)
  {
    y = paramInt;
    B = false;
    C = false;
  }
  
  public int a()
  {
    if ((B) && (!C)) {
      return z;
    }
    return Integer.MAX_VALUE;
  }
  
  public c clone()
  {
    c localc = new c(y);
    x = x;
    z = z;
    A = A;
    B = B;
    C = C;
    return localc;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */