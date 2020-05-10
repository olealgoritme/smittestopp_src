package d.m.a;

import d.o.g;
import d.o.l;
import d.o.m;

public class l0
  implements l
{
  public m x = null;
  
  public g getLifecycle()
  {
    if (x == null) {
      x = new m(this);
    }
    return x;
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.l0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */