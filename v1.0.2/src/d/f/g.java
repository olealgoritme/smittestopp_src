package d.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class g<K, V>
{
  public g<K, V>.b a;
  public g<K, V>.c b;
  public g<K, V>.e c;
  
  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    boolean bool;
    if (i != paramMap.size()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static <T> boolean a(Set<T> paramSet, Object paramObject)
  {
    boolean bool1 = true;
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        boolean bool2 = paramSet.containsAll((Collection)paramObject);
        if (bool2) {}
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    catch (NullPointerException|ClassCastException paramSet)
    {
      for (;;) {}
    }
    return false;
  }
  
  public abstract int a(Object paramObject);
  
  public abstract Object a(int paramInt1, int paramInt2);
  
  public abstract V a(int paramInt, V paramV);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(K paramK, V paramV);
  
  public <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int i = c();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < i) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    for (int j = 0; j < i; j++) {
      localObject[j] = a(j, paramInt);
    }
    if (localObject.length > i) {
      localObject[i] = null;
    }
    return (T[])localObject;
  }
  
  public abstract int b(Object paramObject);
  
  public abstract Map<K, V> b();
  
  public Object[] b(int paramInt)
  {
    int i = c();
    Object[] arrayOfObject = new Object[i];
    for (int j = 0; j < i; j++) {
      arrayOfObject[j] = a(j, paramInt);
    }
    return arrayOfObject;
  }
  
  public abstract int c();
}

/* Location:
 * Qualified Name:     base.d.f.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */