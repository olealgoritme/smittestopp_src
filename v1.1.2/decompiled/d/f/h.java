package d.f;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class h<K, V>
{
  public static Object[] A;
  public static int B;
  public static Object[] C;
  public static int D;
  public int[] x;
  public Object[] y;
  public int z;
  
  public h()
  {
    x = d.a;
    y = d.c;
    z = 0;
  }
  
  public h(int paramInt)
  {
    if (paramInt == 0)
    {
      x = d.a;
      y = d.c;
    }
    else
    {
      a(paramInt);
    }
    z = 0;
  }
  
  public static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (D < 10)
        {
          paramArrayOfObject[0] = C;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (paramInt = (paramInt << 1) - 1; paramInt >= 2; paramInt--) {
            paramArrayOfObject[paramInt] = null;
          }
          C = paramArrayOfObject;
          D += 1;
        }
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {
      try
      {
        if (B < 10)
        {
          paramArrayOfObject[0] = A;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (paramInt = (paramInt << 1) - 1; paramInt >= 2; paramInt--) {
            paramArrayOfObject[paramInt] = null;
          }
          A = paramArrayOfObject;
          B += 1;
        }
      }
      finally {}
    }
  }
  
  public int a()
  {
    int i = z;
    if (i == 0) {
      return -1;
    }
    int[] arrayOfInt = x;
    try
    {
      int j = d.a(arrayOfInt, i, 0);
      if (j < 0) {
        return j;
      }
      if (y[(j << 1)] == null) {
        return j;
      }
      for (int k = j + 1; (k < i) && (x[k] == 0); k++) {
        if (y[(k << 1)] == null) {
          return k;
        }
      }
      for (i = j - 1; (i >= 0) && (x[i] == 0); i--) {
        if (y[(i << 1)] == null) {
          return i;
        }
      }
      return k;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new ConcurrentModificationException();
    }
  }
  
  public int a(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = a();
    } else {
      i = a(paramObject, paramObject.hashCode());
    }
    return i;
  }
  
  public int a(Object paramObject, int paramInt)
  {
    int i = z;
    if (i == 0) {
      return -1;
    }
    int[] arrayOfInt = x;
    try
    {
      int j = d.a(arrayOfInt, i, paramInt);
      if (j < 0) {
        return j;
      }
      if (paramObject.equals(y[(j << 1)])) {
        return j;
      }
      for (int k = j + 1; (k < i) && (x[k] == paramInt); k++) {
        if (paramObject.equals(y[(k << 1)])) {
          return k;
        }
      }
      j--;
      while ((j >= 0) && (x[j] == paramInt))
      {
        if (paramObject.equals(y[(j << 1)])) {
          return j;
        }
        j--;
      }
      return k;
    }
    catch (ArrayIndexOutOfBoundsException paramObject)
    {
      throw new ConcurrentModificationException();
    }
  }
  
  public V a(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object[] arrayOfObject = y;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramV;
    return (V)localObject;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (C != null)
        {
          Object[] arrayOfObject1 = C;
          y = arrayOfObject1;
          C = (Object[])arrayOfObject1[0];
          x = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          D -= 1;
          return;
        }
      }
      finally {}
    }
    if (paramInt == 4) {
      try
      {
        if (A != null)
        {
          Object[] arrayOfObject2 = A;
          y = arrayOfObject2;
          A = (Object[])arrayOfObject2[0];
          x = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          B -= 1;
          return;
        }
      }
      finally {}
    }
    x = new int[paramInt];
    y = new Object[paramInt << 1];
  }
  
  public int b(Object paramObject)
  {
    int i = z * 2;
    Object[] arrayOfObject = y;
    if (paramObject == null) {
      for (j = 1; j < i; j += 2) {
        if (arrayOfObject[j] == null) {
          return j >> 1;
        }
      }
    }
    for (int j = 1; j < i; j += 2) {
      if (paramObject.equals(arrayOfObject[j])) {
        return j >> 1;
      }
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    int i = z;
    int[] arrayOfInt = x;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = y;
      a(paramInt);
      if (z > 0)
      {
        System.arraycopy(arrayOfInt, 0, x, 0, i);
        System.arraycopy(arrayOfObject, 0, y, 0, i << 1);
      }
      a(arrayOfInt, arrayOfObject, i);
    }
    if (z == i) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public K c(int paramInt)
  {
    return (K)y[(paramInt << 1)];
  }
  
  public void clear()
  {
    int i = z;
    if (i > 0)
    {
      int[] arrayOfInt = x;
      Object[] arrayOfObject = y;
      x = d.a;
      y = d.c;
      z = 0;
      a(arrayOfInt, arrayOfObject, i);
    }
    if (z <= 0) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(Object paramObject)
  {
    boolean bool;
    if (a(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(Object paramObject)
  {
    boolean bool;
    if (b(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public V d(int paramInt)
  {
    Object localObject = y;
    int i = paramInt << 1;
    V ? = localObject[(i + 1)];
    int j = z;
    int k = 0;
    if (j <= 1)
    {
      a(x, (Object[])localObject, j);
      x = d.a;
      y = d.c;
      paramInt = k;
    }
    else
    {
      int m = j - 1;
      localObject = x;
      int n = localObject.length;
      k = 8;
      if ((n > 8) && (j < localObject.length / 3))
      {
        if (j > 8) {
          k = j + (j >> 1);
        }
        int[] arrayOfInt1 = x;
        localObject = y;
        a(k);
        if (j == z)
        {
          if (paramInt > 0)
          {
            System.arraycopy(arrayOfInt1, 0, x, 0, paramInt);
            System.arraycopy(localObject, 0, y, 0, i);
          }
          if (paramInt < m)
          {
            k = paramInt + 1;
            int[] arrayOfInt2 = x;
            n = m - paramInt;
            System.arraycopy(arrayOfInt1, k, arrayOfInt2, paramInt, n);
            System.arraycopy(localObject, k << 1, y, i, n << 1);
          }
        }
        else
        {
          throw new ConcurrentModificationException();
        }
      }
      else
      {
        if (paramInt < m)
        {
          localObject = x;
          n = paramInt + 1;
          k = m - paramInt;
          System.arraycopy(localObject, n, localObject, paramInt, k);
          localObject = y;
          System.arraycopy(localObject, n << 1, localObject, i, k << 1);
        }
        localObject = y;
        paramInt = m << 1;
        localObject[paramInt] = null;
        localObject[(paramInt + 1)] = null;
      }
      paramInt = m;
    }
    if (j == z)
    {
      z = paramInt;
      return ?;
    }
    throw new ConcurrentModificationException();
  }
  
  public V e(int paramInt)
  {
    return (V)y[((paramInt << 1) + 1)];
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if ((paramObject instanceof h))
    {
      localObject1 = (h)paramObject;
      if (z != z) {
        return false;
      }
      i = 0;
      try
      {
        while (i < z)
        {
          paramObject = c(i);
          localObject2 = e(i);
          localObject3 = ((h)localObject1).get(paramObject);
          if (localObject2 == null)
          {
            if ((localObject3 != null) || (!((h)localObject1).containsKey(paramObject))) {
              return false;
            }
          }
          else
          {
            bool = localObject2.equals(localObject3);
            if (!bool) {
              return false;
            }
          }
          i++;
        }
        return true;
      }
      catch (NullPointerException|ClassCastException paramObject)
      {
        return false;
      }
    }
    if ((paramObject instanceof Map))
    {
      localObject2 = (Map)paramObject;
      if (z != ((Map)localObject2).size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < z)
      {
        paramObject = c(i);
        localObject3 = e(i);
        localObject1 = ((Map)localObject2).get(paramObject);
        if (localObject3 == null)
        {
          if ((localObject1 != null) || (!((Map)localObject2).containsKey(paramObject))) {
            return false;
          }
        }
        else
        {
          bool = localObject3.equals(localObject1);
          if (!bool) {
            return false;
          }
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
  
  public V get(Object paramObject)
  {
    return (V)getOrDefault(paramObject, null);
  }
  
  public V getOrDefault(Object paramObject, V paramV)
  {
    int i = a(paramObject);
    if (i >= 0) {
      paramV = y[((i << 1) + 1)];
    }
    return paramV;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = x;
    Object[] arrayOfObject = y;
    int i = z;
    int j = 1;
    int k = 0;
    int m = 0;
    while (k < i)
    {
      Object localObject = arrayOfObject[j];
      int n = arrayOfInt[k];
      int i1;
      if (localObject == null) {
        i1 = 0;
      } else {
        i1 = localObject.hashCode();
      }
      m += (i1 ^ n);
      k++;
      j += 2;
    }
    return m;
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
  
  public V put(K paramK, V paramV)
  {
    int i = z;
    int k;
    if (paramK == null)
    {
      j = a();
      k = 0;
    }
    else
    {
      k = paramK.hashCode();
      j = a(paramK, k);
    }
    Object localObject;
    if (j >= 0)
    {
      j = (j << 1) + 1;
      paramK = y;
      localObject = paramK[j];
      paramK[j] = paramV;
      return (V)localObject;
    }
    int m = j;
    if (i >= x.length)
    {
      j = 4;
      if (i >= 8) {
        j = (i >> 1) + i;
      } else if (i >= 4) {
        j = 8;
      }
      localObject = x;
      Object[] arrayOfObject = y;
      a(j);
      if (i == z)
      {
        int[] arrayOfInt = x;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, y, 0, arrayOfObject.length);
        }
        a((int[])localObject, arrayOfObject, i);
      }
      else
      {
        throw new ConcurrentModificationException();
      }
    }
    if (m < i)
    {
      localObject = x;
      j = m + 1;
      System.arraycopy(localObject, m, localObject, j, i - m);
      localObject = y;
      System.arraycopy(localObject, m << 1, localObject, j << 1, z - m << 1);
    }
    int j = z;
    if (i == j)
    {
      localObject = x;
      if (m < localObject.length)
      {
        localObject[m] = k;
        localObject = y;
        k = m << 1;
        localObject[k] = paramK;
        localObject[(k + 1)] = paramV;
        z = (j + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    Object localObject1 = getOrDefault(paramK, null);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = put(paramK, paramV);
    }
    return (V)localObject2;
  }
  
  public V remove(Object paramObject)
  {
    int i = a(paramObject);
    if (i >= 0) {
      return (V)d(i);
    }
    return null;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    int i = a(paramObject1);
    if (i >= 0)
    {
      paramObject1 = e(i);
      if ((paramObject2 == paramObject1) || ((paramObject2 != null) && (paramObject2.equals(paramObject1))))
      {
        d(i);
        return true;
      }
    }
    return false;
  }
  
  public V replace(K paramK, V paramV)
  {
    int i = a(paramK);
    if (i >= 0) {
      return (V)a(i, paramV);
    }
    return null;
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    int i = a(paramK);
    if (i >= 0)
    {
      paramK = e(i);
      if ((paramK == paramV1) || ((paramV1 != null) && (paramV1.equals(paramK))))
      {
        a(i, paramV2);
        return true;
      }
    }
    return false;
  }
  
  public int size()
  {
    return z;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(z * 28);
    localStringBuilder.append('{');
    for (int i = 0; i < z; i++)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = c(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = e(i);
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
 * Qualified Name:     d.f.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */