package d.o;

import android.os.Bundle;
import d.v.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class w$a
  implements a.b
{
  public w$a(w paramw) {}
  
  public Bundle a()
  {
    Object localObject = a.a.keySet();
    ArrayList localArrayList1 = new ArrayList(((Set)localObject).size());
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localArrayList1.add(str);
      localArrayList2.add(a.a.get(str));
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("keys", localArrayList1);
    ((Bundle)localObject).putParcelableArrayList("values", localArrayList2);
    return (Bundle)localObject;
  }
}

/* Location:
 * Qualified Name:     d.o.w.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */