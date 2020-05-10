package k.a.b.a.c;

import java.util.HashMap;
import java.util.Map;
import k.a.b.a.b.i;

public abstract class b<T, M>
  implements a<T>
{
  public final r a;
  public final x b;
  public final Map<r0<M>, r0<T>> c = new HashMap();
  
  public b(x paramx)
  {
    b = paramx;
    a = b;
  }
  
  public r0<T> a(T paramT)
  {
    paramT = d(paramT);
    r0 localr01 = b.a(paramT).a(paramT);
    r0 localr02 = (r0)c.get(localr01);
    paramT = localr02;
    if (localr02 == null)
    {
      paramT = new b.a(this, localr01);
      c.put(localr01, paramT);
    }
    return paramT;
  }
  
  public abstract i b();
  
  public void c(T paramT)
  {
    r0 localr0 = a(paramT);
    localr0.c();
    localr0.a(paramT);
  }
  
  public abstract M d(T paramT);
  
  public r0<T> f()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */