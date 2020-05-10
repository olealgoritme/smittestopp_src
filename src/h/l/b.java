package h.l;

import h.i.g;
import java.util.NoSuchElementException;

public final class b
  extends g
{
  public final int A;
  public final int x;
  public boolean y;
  public int z;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    A = paramInt3;
    x = paramInt2;
    boolean bool = true;
    if (paramInt3 > 0 ? paramInt1 > paramInt2 : paramInt1 < paramInt2) {
      bool = false;
    }
    y = bool;
    if (!bool) {
      paramInt1 = x;
    }
    z = paramInt1;
  }
  
  public int a()
  {
    int i = z;
    if (i == x)
    {
      if (y) {
        y = false;
      } else {
        throw new NoSuchElementException();
      }
    }
    else {
      z = (A + i);
    }
    return i;
  }
  
  public boolean hasNext()
  {
    return y;
  }
}

/* Location:
 * Qualified Name:     base.h.l.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */