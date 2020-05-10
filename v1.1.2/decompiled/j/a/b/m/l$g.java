package j.a.b.m;

import j.a.b.g;
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
      paramObject = ((Map)paramObject).entrySet().iterator();
      int i = 1;
      for (;;)
      {
        if (!((Iterator)paramObject).hasNext())
        {
          paramAppendable.append('}');
          return;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
        Object localObject = localEntry.getValue();
        if ((localObject != null) || (!d))
        {
          if (i != 0) {
            i = 0;
          } else {
            paramAppendable.append(',');
          }
          l.a(localEntry.getKey().toString(), localObject, paramAppendable, paramg);
        }
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     j.a.b.m.l.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */