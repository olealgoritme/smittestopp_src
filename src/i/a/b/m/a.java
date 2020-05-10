package i.a.b.m;

import i.a.b.g;
import i.a.b.i;

public class a
  implements n<Object>
{
  public <E> void a(E paramE, Appendable paramAppendable, g paramg)
  {
    if (paramg != null)
    {
      paramAppendable.append('[');
      Object[] arrayOfObject = (Object[])paramE;
      int i = arrayOfObject.length;
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j >= i)
        {
          paramAppendable.append(']');
          return;
        }
        paramE = arrayOfObject[j];
        if (k != 0) {
          paramAppendable.append(',');
        } else {
          k = 1;
        }
        i.a(paramE, paramAppendable, paramg);
        j++;
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */