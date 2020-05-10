package d.b.d.i;

public class d<T>
{
  public final T a;
  
  public d(T paramT)
  {
    if (paramT != null)
    {
      a = paramT;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */