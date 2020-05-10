package j.a.b.m;

import j.a.b.g;

public class k
  implements n<boolean[]>
{
  public k(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (boolean[])paramObject;
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
        paramAppendable.append(Boolean.toString(m));
        j++;
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     j.a.b.m.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */