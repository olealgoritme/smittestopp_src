package k.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.k.r;

public final class a0$b
  extends AbstractList
{
  public final r x;
  
  public Object get(int paramInt)
  {
    if (paramInt == 0) {
      return x.a;
    }
    throw new IllegalStateException(a.a("Unknown index ", paramInt));
  }
  
  public int size()
  {
    int i;
    if (x.a != null) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.a0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */