package k.b.i.b.g;

public abstract class o$a<T extends a>
{
  public final int a;
  public int b = 0;
  public long c = 0L;
  public int d = 0;
  
  public o$a(int paramInt)
  {
    a = paramInt;
  }
  
  public abstract T a();
  
  public T a(int paramInt)
  {
    d = paramInt;
    return a();
  }
  
  public T a(long paramLong)
  {
    c = paramLong;
    return a();
  }
  
  public T b(int paramInt)
  {
    b = paramInt;
    return a();
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.o.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */