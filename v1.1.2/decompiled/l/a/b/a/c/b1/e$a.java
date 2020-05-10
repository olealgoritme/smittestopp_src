package l.a.b.a.c.b1;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.m.f;

public class e$a
  extends AbstractList
{
  public f x;
  
  public e$a(f paramf)
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
    return x.a;
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
 * Qualified Name:     l.a.b.a.c.b1.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */