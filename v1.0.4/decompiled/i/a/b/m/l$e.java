package i.a.b.m;

import i.a.b.g;
import i.a.b.i;
import java.util.Iterator;

public class l$e
  implements n<Iterable<? extends Object>>
{
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (Iterable)paramObject;
    if (paramg != null)
    {
      paramAppendable.append('[');
      paramObject = ((Iterable)paramObject).iterator();
      int i = 1;
      for (;;)
      {
        if (!((Iterator)paramObject).hasNext())
        {
          paramAppendable.append(']');
          return;
        }
        Object localObject = ((Iterator)paramObject).next();
        if (i != 0) {
          i = 0;
        } else {
          paramAppendable.append(',');
        }
        if (localObject == null) {
          paramAppendable.append("null");
        } else {
          i.a(localObject, paramAppendable, paramg);
        }
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.l.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */