package i.a.b.m;

import i.a.b.g;

public class c
  implements n<Double>
{
  public c(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (Double)paramObject;
    if (((Double)paramObject).isInfinite()) {
      paramAppendable.append("null");
    } else {
      paramAppendable.append(((Double)paramObject).toString());
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */