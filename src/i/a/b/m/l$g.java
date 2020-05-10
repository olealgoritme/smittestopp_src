package i.a.b.m;

import i.a.b.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l$g
  implements n<Map<String, ? extends Object>>
{
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (Map)paramObject;
    if (paramg != null)
    {
      paramAppendable.append('{');
      Iterator localIterator = ((Map)paramObject).entrySet().iterator();
      int i = 1;
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          paramAppendable.append('}');
          return;
        }
        paramObject = (Map.Entry)localIterator.next();
        Object localObject = ((Map.Entry)paramObject).getValue();
        if ((localObject != null) || (!d))
        {
          if (i != 0) {
            i = 0;
          } else {
            paramAppendable.append(',');
          }
          l.a(((Map.Entry)paramObject).getKey().toString(), localObject, paramAppendable, paramg);
        }
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.l.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */