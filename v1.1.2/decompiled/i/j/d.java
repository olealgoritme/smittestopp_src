package i.j;

import i.k.a.p;

public abstract interface d
{
  public abstract <R> R fold(R paramR, p<? super R, ? super a, ? extends R> paramp);
  
  public abstract <E extends a> E get(b<E> paramb);
  
  public abstract d minusKey(b<?> paramb);
  
  public static abstract interface a
    extends d
  {
    public abstract <E extends a> E get(d.b<E> paramb);
    
    public abstract d.b<?> getKey();
  }
  
  public static abstract interface b<E extends d.a> {}
}

/* Location:
 * Qualified Name:     i.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */