package i.a.b.m;

import i.a.b.g;

public class e
  implements n<Float>
{
  public e(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (Float)paramObject;
    if (((Float)paramObject).isInfinite()) {
      paramAppendable.append("null");
    } else {
      paramAppendable.append(((Float)paramObject).toString());
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */