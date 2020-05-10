package k.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.k.q;

public final class z$b
  extends AbstractList
{
  public final q x;
  
  public Object get(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return x.b;
      }
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    }
    return x.a;
  }
  
  public int size()
  {
    q localq = x;
    int i;
    if (b != null) {
      i = 2;
    } else if (a != null) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.z.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */