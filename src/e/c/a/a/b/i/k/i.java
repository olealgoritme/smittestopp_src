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
        localObject2 = ((HashMap)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (Map.Entry)((Iterator)localObject2).next();
          if ((paramBoolean) || (((Boolean)((Map.Entry)???).getValue()).booleanValue())) {
            ((BasePendingResult)((Map.Entry)???).getKey()).b(paramStatus);
          }
        }
        ??? = ((HashMap)???).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          ??? = (Map.Entry)((Iterator)???).next();
          if ((paramBoolean) || (((Boolean)((Map.Entry)???).getValue()).booleanValue()))
          {
            localObject2 = (e.c.a.a.g.b)((Map.Entry)???).getKey();
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
 * Qualified Name:     base.e.c.a.a.b.i.k.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */