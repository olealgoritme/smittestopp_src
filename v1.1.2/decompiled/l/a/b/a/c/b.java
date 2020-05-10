package l.a.b.a.c;

import java.util.HashMap;
import java.util.Map;
import l.a.b.a.b.i;

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
  
  public abstract i a();
  
  public r0<T> a(T paramT)
  {
    paramT = d(paramT);
    r0 localr01 = b.a(paramT).a(paramT);
    r0 localr02 = (r0)c.get(localr01);
    paramT = localr02;
    if (localr02 == null)
    {
      paramT = new a(localr01);
      c.put(localr01, paramT);
    }
    return paramT;
  }
  
  public void c(T paramT)
  {
    r0 localr0 = a(paramT);
    localr0.c();
    localr0.b(paramT);
  }
  
  public abstract M d(T paramT);
  
  public r0<T> e()
  {
    return null;
  }
  
  public class a
    implements r0<T>
  {
    public final r0<M> a;
    public final r0<i> b;
    public final int c;
    
    public a()
    {
      a = localr0;
      r0 localr0 = b.a(a()).a(a());
      b = localr0;
      int i = localr0.d();
      int j = b.a(a());
      c = (a.d() + (j + (i + 1)));
    }
    
    public int a(T paramT)
    {
      return a.a(d(paramT));
    }
    
    public boolean a(r0<T> paramr0)
    {
      boolean bool;
      if ((b.this == paramr0.getType()) && (a.a(a))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(T paramT)
    {
      a.b(d(paramT));
    }
    
    public void c()
    {
      b.a.a((byte)0);
      b.c();
      b.b(a());
      a.c();
    }
    
    public int d()
    {
      return c;
    }
    
    public boolean e()
    {
      return a.e();
    }
    
    public a<T> getType()
    {
      return b.this;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */