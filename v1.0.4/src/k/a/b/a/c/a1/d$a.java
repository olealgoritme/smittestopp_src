package k.a.b.a.c.a1;

import e.a.a.a.a;
import java.util.AbstractList;
import k.a.b.a.b.l.b;
import k.a.b.a.b.l.f;

public final class d$a
  extends AbstractList
{
  public final f x;
  
  public d$a(f paramf)
  {
    x = paramf;
  }
  
  public Object get(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return x.b;
      }
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    }
    return x.a.getValue();
  }
  
  public int size()
  {
    int i;
    if (x.b != null) {
      i = 2;
    } else {
      i = 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.a1.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */