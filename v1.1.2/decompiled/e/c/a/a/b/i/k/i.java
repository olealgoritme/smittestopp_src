package e.c.a.a.b.i.k;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e.c.a.a.g.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class i
{
  public final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap());
  public final Map<e.c.a.a.g.b<?>, Boolean> b = Collections.synchronizedMap(new WeakHashMap());
  
  public final void a(boolean paramBoolean, Status paramStatus)
  {
    synchronized (a)
    {
      Object localObject2 = new java/util/HashMap;
      ((HashMap)localObject2).<init>(a);
      synchronized (b)
      {
        ??? = new java/util/HashMap;
        ((HashMap)???).<init>(b);
        ??? = ((HashMap)localObject2).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          if ((paramBoolean) || (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {
            ((BasePendingResult)((Map.Entry)localObject2).getKey()).b(paramStatus);
          }
        }
        ??? = ((HashMap)???).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          if ((paramBoolean) || (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()))
          {
            localObject2 = (e.c.a.a.g.b)((Map.Entry)localObject2).getKey();
            ??? = new e.c.a.a.b.i.b(paramStatus);
            a.b((Exception)???);
          }
        }
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */