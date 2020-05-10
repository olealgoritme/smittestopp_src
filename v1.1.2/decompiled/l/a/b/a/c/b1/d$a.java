package l.a.b.a.c.b1;

import e.a.a.a.a;
import java.util.AbstractList;
import l.a.b.a.b.m.d;

public class d$a
  extends AbstractList
{
  public d x;
  
  public d$a(d paramd)
  {
    x = paramd;
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
 * Qualified Name:     l.a.b.a.c.b1.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */