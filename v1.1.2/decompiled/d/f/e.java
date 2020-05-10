package d.f;

public class e<E>
  implements Cloneable
{
  public static final Object B = new Object();
  public int A;
  public boolean x = false;
  public long[] y;
  public Object[] z;
  
  public e()
  {
    int i = d.c(10);
    y = new long[i];
    z = new Object[i];
  }
  
  public E a(int paramInt)
  {
    if (x) {
      b();
    }
    return (E)z[paramInt];
  }
  
  public E a(long paramLong)
  {
    return (E)b(paramLong, null);
  }
  
  public void a()
  {
    int i = A;
    Object[] arrayOfObject = z;
    for (int j = 0; j < i; j++) {
      arrayOfObject[j] = null;
    }
    A = 0;
    x = false;
  }
  
  public void a(long paramLong, E paramE)
  {
    int i = A;
    if ((i != 0) && (paramLong <= y[(i - 1)]))
    {
      c(paramLong, paramE);
      return;
    }
    if ((x) && (A >= y.length)) {
      b();
    }
    i = A;
    if (i >= y.length)
    {
      int j = d.c(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = y;
      System.arraycopy(localObject, 0, arrayOfLong, 0, localObject.length);
      localObject = z;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      y = arrayOfLong;
      z = arrayOfObject;
    }
    y[i] = paramLong;
    z[i] = paramE;
    A = (i + 1);
  }
  
  public E b(long paramLong, E paramE)
  {
    int i = d.a(y, A, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = z;
      if (arrayOfObject[i] != B) {
        return (E)arrayOfObject[i];
      }
    }
    return paramE;
  }
  
  public final void b()
  {
    int i = A;
    long[] arrayOfLong = y;
    Object[] arrayOfObject = z;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      Object localObject = arrayOfObject[j];
      m = k;
      if (localObject != B)
      {
        if (j != k)
        {
          arrayOfLong[k] = arrayOfLong[j];
          arrayOfObject[k] = localObject;
          arrayOfObject[j] = null;
        }
        m = k + 1;
      }
      j++;
    }
    x = false;
    A = k;
  }
  
  public int c()
  {
    if (x) {
      b();
    }
    return A;
  }
  
  public void c(long paramLong, E paramE)
  {
    int i = d.a(y, A, paramLong);
    if (i >= 0)
    {
      z[i] = paramE;
    }
    else
    {
      int j = i;
      Object localObject1;
      if (j < A)
      {
        localObject1 = z;
        if (localObject1[j] == B)
        {
          y[j] = paramLong;
          localObject1[j] = paramE;
          return;
        }
      }
      i = j;
      if (x)
      {
        i = j;
        if (A >= y.length)
        {
          b();
          i = d.a(y, A, paramLong);
        }
      }
      j = A;
      if (j >= y.length)
      {
        j = d.c(j + 1);
        localObject1 = new long[j];
        Object[] arrayOfObject = new Object[j];
        Object localObject2 = y;
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        localObject2 = z;
        System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
        y = ((long[])localObject1);
        z = arrayOfObject;
      }
      j = A;
      if (j - i != 0)
      {
        localObject1 = y;
        int k = i + 1;
        System.arraycopy(localObject1, i, localObject1, k, j - i);
        localObject1 = z;
        System.arraycopy(localObject1, i, localObject1, k, A - i);
      }
      y[i] = paramLong;
      z[i] = paramE;
      A += 1;
    }
  }
  
  public e<E> clone()
  {
    try
    {
      e locale = (e)super.clone();
      y = ((long[])y.clone());
      z = ((Object[])z.clone());
      return locale;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public String toString()
  {
    if (c() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(A * 28);
    localStringBuilder.append('{');
    for (int i = 0; i < A; i++)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      if (x) {
        b();
      }
      localStringBuilder.append(y[i]);
      localStringBuilder.append('=');
      Object localObject = a(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     d.f.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */