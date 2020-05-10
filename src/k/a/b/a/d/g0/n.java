package k.a.b.a.d.g0;

public class n<E>
{
  public E a;
  public n<E> b;
  public n<E> c;
  
  public n(E paramE)
  {
    a = paramE;
  }
  
  public n<E> a(E paramE)
  {
    n localn = c;
    if (localn == null)
    {
      paramE = new n(paramE);
      c = paramE;
      b = this;
      return paramE;
    }
    return localn.a(paramE);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */