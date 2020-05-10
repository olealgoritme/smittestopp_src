package j.a.b.m;

import j.a.b.g;

public class j
  implements n<double[]>
{
  public j(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (double[])paramObject;
    if (paramg != null)
    {
      paramAppendable.append('[');
      int i = paramObject.length;
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j >= i)
        {
          paramAppendable.append(']');
          return;
        }
        double d = paramObject[j];
        if (k != 0) {
          paramAppendable.append(',');
        } else {
          k = 1;
        }
        paramAppendable.append(Double.toString(d));
        j++;
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     j.a.b.m.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */