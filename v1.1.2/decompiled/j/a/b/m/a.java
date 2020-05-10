package j.a.b.m;

import j.a.b.g;
import j.a.b.i;

public class a
  implements n<Object>
{
  public <E> void a(E paramE, Appendable paramAppendable, g paramg)
  {
    if (paramg != null)
    {
      paramAppendable.append('[');
      paramE = (Object[])paramE;
      int i = paramE.length;
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j >= i)
        {
          paramAppendable.append(']');
          return;
        }
        Object localObject = paramE[j];
        if (k != 0) {
          paramAppendable.append(',');
        } else {
          k = 1;
        }
        i.a(localObject, paramAppendable, paramg);
        j++;
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     j.a.b.m.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */