package e.e.a.s.b;

import e.e.a.l;
import java.util.Collections;
import java.util.Set;

public abstract class a
{
  public final Set<l> a;
  public final e.e.a.t.a b = new e.e.a.t.a();
  
  public a(Set<l> paramSet)
  {
    if (paramSet != null)
    {
      a = Collections.unmodifiableSet(paramSet);
      return;
    }
    throw new IllegalArgumentException("The supported JWS algorithm set must not be null");
  }
}

/* Location:
 * Qualified Name:     e.e.a.s.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */