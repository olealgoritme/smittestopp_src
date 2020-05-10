package d.i.h;

public class c<T>
  extends b<T>
{
  public final Object c = new Object();
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public T a()
  {
    synchronized (c)
    {
      Object localObject2 = super.a();
      return (T)localObject2;
    }
  }
  
  public boolean a(T paramT)
  {
    synchronized (c)
    {
      boolean bool = super.a(paramT);
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     d.i.h.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */