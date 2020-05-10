package androidx.lifecycle;

import d.o.b;
import d.o.b.a;
import d.o.g.a;
import d.o.j;
import d.o.l;
import java.util.List;
import java.util.Map;

public class ReflectiveGenericLifecycleObserver
  implements j
{
  public final Object x;
  public final b.a y;
  
  public ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    x = paramObject;
    y = b.c.a(paramObject.getClass());
  }
  
  public void a(l paraml, g.a parama)
  {
    b.a locala = y;
    Object localObject = x;
    b.a.a((List)a.get(parama), paraml, parama, localObject);
    b.a.a((List)a.get(g.a.ON_ANY), paraml, parama, localObject);
  }
}

/* Location:
 * Qualified Name:     base.androidx.lifecycle.ReflectiveGenericLifecycleObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */