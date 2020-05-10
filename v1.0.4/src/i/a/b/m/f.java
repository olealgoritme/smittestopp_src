package i.a.b.m;

import i.a.b.g;

public class f
  implements n<int[]>
{
  public f(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (int[])paramObject;
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
        int m = paramObject[j];
        if (k != 0) {
          paramAppendable.append(',');
        } else {
          k = 1;
        }
        paramAppendable.append(Integer.toString(m));
        j++;
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */