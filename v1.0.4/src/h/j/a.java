package h.j;

import h.k.a.p;
import h.k.b.g;

public abstract class a
  implements d.a
{
  public final d.b<?> key;
  
  public a(d.b<?> paramb) {}
  
  public <R> R fold(R paramR, p<? super R, ? super d.a, ? extends R> paramp)
  {
    if (paramp != null) {
      return (R)paramp.a(paramR, this);
    }
    g.a("operation");
    throw null;
  }
  
  public <E extends d.a> E get(d.b<E> paramb)
  {
    a locala = null;
    if (paramb != null)
    {
      if (g.a(getKey(), paramb)) {
        locala = this;
      }
      return locala;
    }
    g.a("key");
    throw null;
  }
  
  public d.b<?> getKey()
  {
    return key;
  }
  
  public d minusKey(d.b<?> paramb)
  {
    if (paramb != null)
    {
      if (g.a(getKey(), paramb)) {
        paramb = f.x;
      } else {
        paramb = this;
      }
      return paramb;
    }
    g.a("key");
    throw null;
  }
  
  public d plus(d paramd)
  {
    if (paramd != null)
    {
      if (paramd == f.x) {
        paramd = this;
      } else {
        paramd = (d)paramd.fold(this, e.x);
      }
      return paramd;
    }
    g.a("context");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.h.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */