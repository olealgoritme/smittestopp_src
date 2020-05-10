package j.a.b.m;

import j.a.b.g;

public class h
  implements n<long[]>
{
  public h(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (long[])paramObject;
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
        long l = paramObject[j];
        if (k != 0) {
          paramAppendable.append(',');
        } else {
          k = 1;
        }
        paramAppendable.append(Long.toString(l));
        j++;
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     j.a.b.m.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */