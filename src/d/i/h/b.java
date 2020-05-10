package d.i.h;

public class b<T>
  implements b<T>
{
  public final Object[] a;
  public int b;
  
  public b(int paramInt)
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
    for (int i = 0; i < b; i++) {
      if (a[i] == paramT)
      {
        i = 1;
        break label33;
      }
    }
    i = 0;
    label33:
    if (i == 0)
    {
      i = b;
      Object[] arrayOfObject = a;
      if (i < arrayOfObject.length)
      {
        arrayOfObject[i] = paramT;
        b = (i + 1);
        return true;
      }
      return false;
    }
    throw new IllegalStateException("Already in the pool!");
  }
}

/* Location:
 * Qualified Name:     base.d.i.h.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */