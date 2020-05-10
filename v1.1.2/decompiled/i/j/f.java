package i.j;

import i.k.a.p;
import i.k.b.g;
import java.io.Serializable;

public final class f
  implements d, Serializable
{
  public static final f x = new f();
  
  public <R> R fold(R paramR, p<? super R, ? super d.a, ? extends R> paramp)
  {
    if (paramp != null) {
      return paramR;
    }
    g.a("operation");
    throw null;
  }
  
  public <E extends d.a> E get(d.b<E> paramb)
  {
    if (paramb != null) {
      return null;
    }
    g.a("key");
    throw null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public d minusKey(d.b<?> paramb)
  {
    if (paramb != null) {
      return this;
    }
    g.a("key");
    throw null;
  }
  
  public String toString()
  {
    return "EmptyCoroutineContext";
  }
}

/* Location:
 * Qualified Name:     i.j.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */