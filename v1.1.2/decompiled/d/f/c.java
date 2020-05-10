package d.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c<E>
  implements Collection<E>, Set<E>
{
  public static final int[] B = new int[0];
  public static final Object[] C = new Object[0];
  public static Object[] D;
  public static int E;
  public static Object[] F;
  public static int G;
  public g<E, E> A;
  public int[] x = B;
  public Object[] y = C;
  public int z = 0;
  
  public static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (G < 10)
        {
          paramArrayOfObject[0] = F;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt--;
          while (paramInt >= 2)
          {
            paramArrayOfObject[paramInt] = null;
            paramInt--;
          }
          F = paramArrayOfObject;
          G += 1;
        }
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {
      try
      {
        if (E < 10)
        {
          paramArrayOfObject[0] = D;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt--;
          while (paramInt >= 2)
          {
            paramArrayOfObject[paramInt] = null;
            paramInt--;
          }
          D = paramArrayOfObject;
          E += 1;
        }
      }
      finally {}
    }
  }
  
  public final int a()
  {
    int i = z;
    if (i == 0) {
      return -1;
    }
    int j = d.a(x, i, 0);
    if (j < 0) {
      return j;
    }
    if (y[j] == null) {
      return j;
    }
    for (int k = j + 1; (k < i) && (x[k] == 0); k++) {
      if (y[k] == null) {
        return k;
      }
    }
    j--;
    while ((j >= 0) && (x[j] == 0))
    {
      if (y[j] == null) {
        return j;
      }
      j--;
    }
    return k;
  }
  
  public final int a(Object paramObject, int paramInt)
  {
    int i = z;
    if (i == 0) {
      return -1;
    }
    int j = d.a(x, i, paramInt);
    if (j < 0) {
      return j;
    }
    if (paramObject.equals(y[j])) {
      return j;
    }
    for (int k = j + 1; (k < i) && (x[k] == paramInt); k++) {
      if (paramObject.equals(y[k])) {
        return k;
      }
    }
    for (i = j - 1; (i >= 0) && (x[i] == paramInt); i--) {
      if (paramObject.equals(y[i])) {
        return i;
      }
    }
    return k;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (F != null)
        {
          Object[] arrayOfObject1 = F;
          y = arrayOfObject1;
          F = (Object[])arrayOfObject1[0];
          x = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          G -= 1;
          return;
        }
      }
      finally {}
    }
    if (paramInt == 4) {
      try
      {
        if (D != null)
        {
          Object[] arrayOfObject2 = D;
          y = arrayOfObject2;
          D = (Object[])arrayOfObject2[0];
          x = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          E -= 1;
          return;
        }
      }
      finally {}
    }
    x = new int[paramInt];
    y = new Object[paramInt];
  }
  
  public boolean add(E paramE)
  {
    int j;
    if (paramE == null)
    {
      i = a();
      j = 0;
    }
    else
    {
      j = paramE.hashCode();
      i = a(paramE, j);
    }
    if (i >= 0) {
      return false;
    }
    int k = i;
    int m = z;
    Object localObject;
    if (m >= x.length)
    {
      i = 4;
      if (m >= 8) {
        i = (m >> 1) + m;
      } else if (m >= 4) {
        i = 8;
      }
      int[] arrayOfInt = x;
      Object[] arrayOfObject = y;
      a(i);
      localObject = x;
      if (localObject.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, localObject, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, y, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, z);
    }
    int i = z;
    if (k < i)
    {
      localObject = x;
      m = k + 1;
      System.arraycopy(localObject, k, localObject, m, i - k);
      localObject = y;
      System.arraycopy(localObject, k, localObject, m, z - k);
    }
    x[k] = j;
    y[k] = paramE;
    z += 1;
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    int i = z;
    i = paramCollection.size() + i;
    int[] arrayOfInt = x;
    int j = arrayOfInt.length;
    boolean bool = false;
    if (j < i)
    {
      Object[] arrayOfObject = y;
      a(i);
      i = z;
      if (i > 0)
      {
        System.arraycopy(arrayOfInt, 0, x, 0, i);
        System.arraycopy(arrayOfObject, 0, y, 0, z);
      }
      a(arrayOfInt, arrayOfObject, z);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public E b(int paramInt)
  {
    Object localObject = y;
    E ? = localObject[paramInt];
    int i = z;
    if (i <= 1)
    {
      a(x, (Object[])localObject, i);
      x = B;
      y = C;
      z = 0;
    }
    else
    {
      localObject = x;
      int j = localObject.length;
      int k = 8;
      if ((j > 8) && (i < localObject.length / 3))
      {
        if (i > 8) {
          k = i + (i >> 1);
        }
        int[] arrayOfInt = x;
        localObject = y;
        a(k);
        z -= 1;
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, x, 0, paramInt);
          System.arraycopy(localObject, 0, y, 0, paramInt);
        }
        i = z;
        if (paramInt < i)
        {
          k = paramInt + 1;
          System.arraycopy(arrayOfInt, k, x, paramInt, i - paramInt);
          System.arraycopy(localObject, k, y, paramInt, z - paramInt);
        }
      }
      else
      {
        i = z - 1;
        z = i;
        if (paramInt < i)
        {
          localObject = x;
          k = paramInt + 1;
          System.arraycopy(localObject, k, localObject, paramInt, i - paramInt);
          localObject = y;
          System.arraycopy(localObject, k, localObject, paramInt, z - paramInt);
        }
        y[z] = null;
      }
    }
    return ?;
  }
  
  public void clear()
  {
    int i = z;
    if (i != 0)
    {
      a(x, y, i);
      x = B;
      y = C;
      z = 0;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool;
    if (indexOf(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      if (z != ((Set)paramObject).size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < z)
      {
        boolean bool = ((Set)paramObject).contains(y[i]);
        if (!bool) {
          return false;
        }
        i++;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      for (;;) {}
    }
    return false;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = x;
    int i = z;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfInt[j];
      j++;
    }
    return k;
  }
  
  public int indexOf(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = a();
    } else {
      i = a(paramObject, paramObject.hashCode());
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (z <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<E> iterator()
  {
    if (A == null) {
      A = new b(this);
    }
    g localg = A;
    if (b == null) {
      b = new g.c(localg);
    }
    return b.iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      b(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int i = z - 1;
    boolean bool = false;
    while (i >= 0)
    {
      if (!paramCollection.contains(y[i]))
      {
        b(i);
        bool = true;
      }
      i--;
    }
    return bool;
  }
  
  public int size()
  {
    return z;
  }
  
  public Object[] toArray()
  {
    int i = z;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(y, 0, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < z) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), z);
    }
    System.arraycopy(y, 0, localObject, 0, z);
    int i = localObject.length;
    int j = z;
    if (i > j) {
      localObject[j] = null;
    }
    return (T[])localObject;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(z * 14);
    localStringBuilder.append('{');
    for (int i = 0; i < z; i++)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = y[i];
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Set)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     d.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */