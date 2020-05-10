package d.g.a;

public class f<T>
  implements f<T>
{
  public final Object[] a;
  public int b;
  
  public f(int paramInt)
  {
    if (paramInt > 0)
    {
      a = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  public T a()
  {
    int i = b;
    if (i > 0)
    {
      int j = i - 1;
      Object[] arrayOfObject = a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      b = (i - 1);
      return (T)localObject;
    }
    return null;
  }
  
  public boolean a(T paramT)
  {
    int i = b;
    Object[] arrayOfObject = a;
    if (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramT;
      b = (i + 1);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     d.g.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */