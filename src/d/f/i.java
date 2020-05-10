package d.f;

public class i<E>
  implements Cloneable
{
  public static final Object B = new Object();
  public int A;
  public boolean x = false;
  public int[] y;
  public Object[] z;
  
  public i()
  {
    this(10);
  }
  
  public i(int paramInt)
  {
    if (paramInt == 0)
    {
      y = d.a;
      z = d.c;
    }
    else
    {
      paramInt = d.b(paramInt);
      y = new int[paramInt];
      z = new Object[paramInt];
    }
  }
  
  public E a(int paramInt)
  {
    return (E)b(paramInt, null);
  }
  
  public final void a()
  {
    int i = A;
    int[] arrayOfInt = y;
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
          arrayOfInt[k] = arrayOfInt[j];
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
  
  public void a(int paramInt, E paramE)
  {
    int i = A;
    if ((i != 0) && (paramInt <= y[(i - 1)]))
    {
      c(paramInt, paramE);
      return;
    }
    if ((x) && (A >= y.length)) {
      a();
    }
    i = A;
    if (i >= y.length)
    {
      int j = d.b(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = y;
      System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
      localObject = z;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      y = arrayOfInt;
      z = arrayOfObject;
    }
    y[i] = paramInt;
    z[i] = paramE;
    A = (i + 1);
  }
  
  public int b()
  {
    if (x) {
      a();
    }
    return A;
  }
  
  public int b(int paramInt)
  {
    if (x) {
      a();
    }
    return y[paramInt];
  }
  
  public E b(int paramInt, E paramE)
  {
    paramInt = d.a(y, A, paramInt);
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = z;
      if (arrayOfObject[paramInt] != B) {
        return (E)arrayOfObject[paramInt];
      }
    }
    return paramE;
  }
  
  public void c(int paramInt)
  {
    paramInt = d.a(y, A, paramInt);
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = z;
      Object localObject1 = arrayOfObject[paramInt];
      Object localObject2 = B;
      if (localObject1 != localObject2)
      {
        arrayOfObject[paramInt] = localObject2;
        x = true;
      }
    }
  }
  
  public void c(int paramInt, E paramE)
  {
    int i = d.a(y, A, paramInt);
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
          y[j] = paramInt;
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
          a();
          i = d.a(y, A, paramInt);
        }
      }
      j = A;
      if (j >= y.length)
      {
        j = d.b(j + 1);
        localObject1 = new int[j];
        Object[] arrayOfObject = new Object[j];
        Object localObject2 = y;
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        localObject2 = z;
        System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
        y = ((int[])localObject1);
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
      y[i] = paramInt;
      z[i] = paramE;
      A += 1;
    }
  }
  
  public i<E> clone()
  {
    try
    {
      i locali = (i)super.clone();
      y = ((int[])y.clone());
      z = ((Object[])z.clone());
      return locali;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public E d(int paramInt)
  {
    if (x) {
      a();
    }
    return (E)z[paramInt];
  }
  
  public String toString()
  {
    if (b() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(A * 28);
    localStringBuilder.append('{');
    for (int i = 0; i < A; i++)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(b(i));
      localStringBuilder.append('=');
      Object localObject = d(i);
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
 * Qualified Name:     base.d.f.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */